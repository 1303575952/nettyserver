package com.sxu.server;

import com.sxu.constant.Instruction;
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

            byte[] judgeSuccessArr = new byte[Instruction.JUDGE_SUCCESS_INSTRUCTION.length];
            for (int i = 0; i < judgeSuccessArr.length; i++) {
                judgeSuccessArr[i] = (byte) Instruction.JUDGE_SUCCESS_INSTRUCTION[i];
            }
            ByteBuf judgeSuccessBuf = Unpooled.buffer();
            judgeSuccessBuf.writeBytes(judgeSuccessArr);
            ctx.writeAndFlush(judgeSuccessBuf);
        } else {
            System.out.println("crc32校验有误");

            byte[] judgeFaultArr = new byte[Instruction.JUDGE_FAULT_INSTRUCTION.length];
            for (int i = 0; i < judgeFaultArr.length; i++) {
                judgeFaultArr[i] = (byte) Instruction.JUDGE_FAULT_INSTRUCTION[i];
            }
            ByteBuf judgeFaultBuf = Unpooled.buffer();
            judgeFaultBuf.writeBytes(judgeFaultArr);
            ctx.writeAndFlush(judgeFaultBuf);
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