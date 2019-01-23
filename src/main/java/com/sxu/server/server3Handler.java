package com.sxu.server;

import com.sxu.config.TypeData;
import com.sxu.constant.FaultConstant;
import com.sxu.data.FrameHelper;
import com.sxu.data.Middleware;
import com.sxu.entity.Model;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;

public class server3Handler extends Middleware {

    public server3Handler() {
        super("server");
    }

    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
        // TODO Auto-generated method stub
        Model model = (Model) msg;
        System.out.println("server 接收数据 ： " + model.toString());
        //添加消息处理逻辑 TODO
        /**判断allHexStr是哪种消息
         * 消息是否可识别，变量个数是否正确，校验结果是否正确
         */
        ByteBuf in = (ByteBuf) msg;
        //接收到的16进制数据
        String allHexStr = ByteBufUtil.hexDump(in);
        System.out.println("hex value:" + allHexStr);
        if (!FaultConstant.isFault) {
            String backStr = FrameHelper.checkFrame(allHexStr);
            ByteBuf out = null;
            out.writeBytes(backStr.getBytes());
            ctx.write(out);
        }

        model.setType(TypeData.CUSTOMER);
        model.setBody("---------------");
        ctx.channel().writeAndFlush(model);
        System.out.println("server 发送数据： " + model.toString());
    }

    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        // TODO Auto-generated method stub
        super.handlerReaderIdle(ctx);
        System.err
                .println(" ---- client " + ctx.channel().remoteAddress().toString() + " reader timeOut, --- close it");
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(name + "  exception" + cause.toString());
    }
}