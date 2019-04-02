package com.sxu.server;

import com.sxu.common.MiddleWare;
import com.sxu.utils.DataConversion;
import com.sxu.utils.Variable;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

public class ServerHandler extends MiddleWare {
    private static final Logger LOGGER = Logger.getLogger(ServerHandler.class);

    @Override
    protected void handlerAllIdle(ChannelHandlerContext ctx) {
        super.handlerAllIdle(ctx);
        //此处需要处理所有由服务端定时发出的指令

        //暂定授时是经过6个时间粒度发送一次
        if (Variable.timeGranularityFrequency % 6 == 0) {
            sendTimeSynInstruction(ctx);
            LOGGER.debug("timeGranularityFrequency:" + Variable.timeGranularityFrequency + ", send time syn");
            //暂定心跳是经过3个时间粒度发送一次
        } else if (Variable.timeGranularityFrequency % 3 == 0) {
            sendHeartBeat2HardwareInstruction(ctx);
            LOGGER.debug("timeGranularityFrequency:" + Variable.timeGranularityFrequency + ", send heartbeat");
        }
    }

    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {

        LOGGER.debug("Server 接收数据 ： " + DataConversion.Object2HexString(msg));
    }

    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        super.handlerReaderIdle(ctx);
        LOGGER.debug(" ---- client " + ctx.channel().remoteAddress().toString() + " reader timeOut, --- close it");
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        LOGGER.error(name + "  exception" + cause.toString());
    }
}
