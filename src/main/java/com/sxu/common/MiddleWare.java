package com.sxu.common;

import com.sxu.constant.Instruction;
import com.sxu.message.WorkingData;
import com.sxu.utils.DataConversion;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

public abstract class MiddleWare extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = Logger.getLogger(MiddleWare.class);
    protected String name;
    //记录次数
    private int heartbeatCount = 0;

    public MiddleWare(String name) {
        this.name = name;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String msgStr = DataConversion.Object2HexString(msg);
        if (msgStr.startsWith(Type.WORKING_DATA_HEAD)) {
            //接收到的消息为工况数据指令
            LOGGER.debug("接收到工况指令：" + DataConversion.Object2HexString(msg));
            WorkingData.workingDataProcess(msg);
        } else if (msgStr.startsWith(Type.TIME_SYN_HEAD)) {
            //接收到的消息为授时指令
            LOGGER.debug("time syn instruction:" + DataConversion.Object2HexString(msg));
        } else if (msgStr.startsWith(Type.TIME_SYN_SUCCESS_HEAD)) {
            //接收到的消息为授时成功指令
        } else if (msgStr.startsWith(Type.TIME_SYN_FAILD_HEAD)) {
            //接收到的消息为授时失败指令
        }
    }

    protected abstract void handlerData(ChannelHandlerContext ctx, Object msg);

    /**
     * 发送授时指令
     *
     * @param ctx
     */
    protected void sendTimeSynInstruction(ChannelHandlerContext ctx) {
        char[] timeSynInstructionCharArr = Instruction.getTimeSynInstruction();
        System.out.println("time syn instruction:" + DataConversion.charArr2HexString(timeSynInstructionCharArr));
        byte[] timeSynInstructionByteArr = DataConversion.charArr2ByteArr(timeSynInstructionCharArr);
        ByteBuf timeSynInstructionBuf = Unpooled.buffer();
        timeSynInstructionBuf.writeBytes(timeSynInstructionByteArr);
        ctx.writeAndFlush(timeSynInstructionBuf);
        heartbeatCount++;
        LOGGER.debug("send time syn msg to " + ctx.channel().remoteAddress() + "count :" + heartbeatCount);
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
