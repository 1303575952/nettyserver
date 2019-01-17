package com.sxu.server;

import com.sxu.constant.FaultConstant;
import com.sxu.dao.ReceivedValueDao;
import com.sxu.dao.WorkingModelDao;
import com.sxu.data.FrameHelper;
import com.sxu.data.WorkingModelData;
import com.sxu.entity.WorkingModel;
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
        String allHexStr = ByteBufUtil.hexDump(in);
        System.out.println("hex value:" + allHexStr);

        /**判断allHexStr是哪种消息
         * 消息是否可识别，变量个数是否正确，校验结果是否正确
         */
        if (!FaultConstant.isFault) {
            String backStr = FrameHelper.checkFrame(allHexStr);
            ByteBuf out = null;
            out.writeBytes(backStr.getBytes());
            ctx.write(out);
        }
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