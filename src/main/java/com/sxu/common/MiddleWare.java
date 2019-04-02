package com.sxu.common;

import com.sxu.message.TimeSynFailed;
import com.sxu.message.TimeSynSuccess;
import com.sxu.message.WorkingData;
import com.sxu.constant.Instruction;
import com.sxu.utils.DataConversion;
import com.sxu.utils.Variable;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

/**
 * @author li
 * 多数消息的处理逻辑在本类中
 */
public abstract class MiddleWare extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = Logger.getLogger(MiddleWare.class);
    protected String name;
    //记录发送同步时间指令次数
    private int timeSynCount = 0;
    //记录服务端发送心跳指令次数
    private int heartbeatCount = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String msgStr = DataConversion.Object2HexString(msg);
        if (msgStr.startsWith(Type.WORKING_DATA_HEAD)) {
            //接收到的消息为工况数据指令
            WorkingData.workingDataProcess(msg);
        } else if (msgStr.startsWith(Type.TIME_SYN_HEAD)) {
            //发送的消息为授时指令
            LOGGER.debug("time syn instruction:" + DataConversion.Object2HexString(msg));
        } else if (msgStr.startsWith(Type.TIME_SYN_SUCCESS_HEAD)) {
            //接收到的消息为授时成功指令
            TimeSynSuccess.timeSynSuccessProcess(ctx, msg);
        } else if (msgStr.startsWith(Type.TIME_SYN_FAILD_HEAD)) {
            //接收到的消息为授时失败指令
            TimeSynFailed.timeSynFailedProcess(ctx, msg);
        } else if (msgStr.startsWith(Type.HEART_BEAT_SERVER)) {
            //发送的消息为服务端发出的同步指令
            LOGGER.debug("server syn instruction:" + DataConversion.Object2HexString(msg));
        }
    }

    protected abstract void handlerData(ChannelHandlerContext ctx, Object msg);

    /**
     * 发送授时指令
     *
     * @param ctx
     */
    protected void sendTimeSynInstruction(ChannelHandlerContext ctx) {
        byte[] timeSynInstructionByteArr = DataConversion.charArr2ByteArr(Instruction.getTimeSynInstruction());
        //System.out.println("time syn instruction length:" + timeSynInstructionByteArr.length);
        ByteBuf timeSynInstructionBuf = Unpooled.buffer();
        timeSynInstructionBuf.writeBytes(timeSynInstructionByteArr);
        ctx.writeAndFlush(timeSynInstructionBuf);
        timeSynCount++;
        LOGGER.debug("send time syn msg to " + ctx.channel().remoteAddress() + "count :" + timeSynCount);
    }

    /**
     * 服务端发送心跳指令
     * @param ctx
     */
    public void sendHeartBeat2HardwareInstruction(ChannelHandlerContext ctx) {
        byte[] heartBeat2HardwareInstructionByteArr = DataConversion.charArr2ByteArr(Instruction.HEART_BEAT_SERVER);
        ByteBuf heartBeat2HardwareInstructionBuf = Unpooled.buffer();
        heartBeat2HardwareInstructionBuf.writeBytes(heartBeat2HardwareInstructionByteArr);
        ctx.writeAndFlush(heartBeat2HardwareInstructionBuf);
        LOGGER.debug("server send heart beat msg to " + ctx.channel().remoteAddress() + "count :" + heartbeatCount);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent stateEvent = (IdleStateEvent) evt;

        switch (stateEvent.state()) {
            case READER_IDLE:
                handlerReaderIdle(ctx);
                break;
            case WRITER_IDLE:
                handlerWriterIdle(ctx);
                break;
            case ALL_IDLE:
                handlerAllIdle(ctx);
                break;
            default:
                break;
        }
    }

    protected void handlerAllIdle(ChannelHandlerContext ctx) {
        Variable.timeGranularityFrequency++;
        LOGGER.debug("---ALL_IDLE---");
    }

    protected void handlerWriterIdle(ChannelHandlerContext ctx) {
        LOGGER.debug("---WRITER_IDLE---");
    }

    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        LOGGER.debug("---READER_IDLE---");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.debug("---" + ctx.channel().remoteAddress() + "----- is  action");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.debug("---" + ctx.channel().remoteAddress() + "----- is  inAction");
    }
}
