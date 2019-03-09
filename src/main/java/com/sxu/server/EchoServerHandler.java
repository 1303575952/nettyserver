package com.sxu.server;

import com.sxu.constant.Instruction;
import com.sxu.data.DataProcess;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ByteProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

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
        //到此为止，array中存放硬件设备发送过来的数据（byte[]）
        for (int i = 0; i < array.length; i++) {
            arrayHex[i] = Integer.toHexString(array[i] & 0xff);
            //System.out.println(arrayHex[i]);
        }
        //到此为止，arrayHex中存放硬件设备发送过来的数据（字符串，强转int后为16进制）
        //CRC32校验
        if (DataProcess.workingDataJudgeCRC32(array, arrayHex)) {
            //拿到工况数据并入库
            DataProcess.getAndInsertWorkingData2DB(arrayHex);
            System.out.println("crc32校验无误");
            System.out.println(Instruction.JUDGE_SUCCESS_INSTRUCTION);
            ctx.writeAndFlush(Instruction.JUDGE_SUCCESS_INSTRUCTION);
        } else {
            System.out.println("crc32校验有误");
            System.out.println(Instruction.JUDGE_FAULT_INSTRUCTION);
            ctx.writeAndFlush(Instruction.JUDGE_FAULT_INSTRUCTION);
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