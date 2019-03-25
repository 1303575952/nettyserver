package com.sxu.server;

import com.sxu.common.MiddleWare;
import com.sxu.utils.DataConversion;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

public class ServerHandler extends MiddleWare {
    private static final Logger LOGGER = Logger.getLogger(ServerHandler.class);

    @Override
    protected void handlerAllIdle(ChannelHandlerContext ctx) {
        super.handlerAllIdle(ctx);
        sendTimeSynInstruction(ctx);
    }

    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {

        LOGGER.debug("Server 接收数据 ： " + DataConversion.Object2HexString(msg));
    }

    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        super.handlerReaderIdle(ctx);
        LOGGER.debug(" ---- client "+ ctx.channel().remoteAddress().toString() + " reader timeOut, --- close it");
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        LOGGER.error(name + "  exception" + cause.toString());
    }
}
