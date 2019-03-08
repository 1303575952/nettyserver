package com.sxu.server;

import com.sxu.data.DataProcess;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author li
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        //System.out.println("Server received:" + in.toString(CharsetUtil.US_ASCII));
        int length = in.readableBytes();
        byte[] array = new byte[length];
        String[] arrayHex = new String[length];
        in.getBytes(in.readerIndex(), array);
        for (int i = 0; i < array.length; i++) {
            arrayHex[i] = Integer.toHexString(array[i]&0xff);
            //System.out.println(arrayHex[i]);
        }
        DataProcess.getAndInsertWorkingData2DB(arrayHex);
        //测试arrayHex数组里的数能否被Hex2Float解析
        //int[] bytes = {Integer.parseInt(arrayHex[27],16),Integer.parseInt(arrayHex[28],16),Integer.parseInt(arrayHex[29],16),Integer.parseInt(arrayHex[30],16)};
        //System.out.println(Hex2Float.bytesToFloat(bytes));
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}