package com.sxu.server;

import com.sxu.dao.ReceivedValueDao;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author lifei
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        //接收到的16进制数据
        String str = ByteBufUtil.hexDump(in);
        System.out.println("hex value:" + str);
        //接收到的16进制数据转化为文本格式
        byte[] b = null;
        try {
            b = Hex.decodeHex(str);
        } catch (DecoderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String bStr = new String(b);
        System.out.println("text value:" + bStr);
        try {
            ReceivedValueDao.insertReceivedValue(str, bStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
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