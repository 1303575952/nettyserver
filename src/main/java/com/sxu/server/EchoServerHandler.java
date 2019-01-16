package com.sxu.server;

import com.sxu.dao.ReceivedValueDao;
import com.sxu.dao.WorkingModelDao;
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
        /*String needHexStr = allHexStr.substring(12, allHexStr.length() - 14);
        System.out.println("just need:" + needHexStr);
        //接收到的16进制数据转化为文本格式
        byte[] b = null;
        try {
            b = Hex.decodeHex(needHexStr);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        String needTextStr = new String(b).trim();
        System.out.println("text value:" + needTextStr);
        //生成WorkingModel对象
        WorkingModel workingModel = WorkingModelData.getFieldsFromStr(needTextStr);
        //workingModel入库
        try {
            WorkingModelDao.insertWorkingModel(workingModel);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //接收到的16进制数据和必要部分转换后的数据（去掉空格等）入库
        /*try {
            ReceivedValueDao.insertReceivedValue(allHexStr, needTextStr);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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