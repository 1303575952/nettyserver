package com.sxu.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author li
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	char send_data[]={0xEB,0X90,0X22,
				0x20,
				0x44,
				0x20,
				0x32,0x30,0x31,0x38, 0x31,0x32, 0x30,0x36,   //年月日
				0x20,
				0x31,0x32,0x3A,0X33,0X34,0X3A,0X35,0X36, //时：分：秒
				0X32,0X35,0X36,  //256
				0x20,
				0x31,0x32,0x3A,0X33,//1  hk_data_8   27
				0x31,0x32,0x3A,0X33,//2  hk_data_10  31
				0x31,0x32,0x3A,0X33,//3  hk_data_9   35
				0x31,0x32,0x3A,0X33,//4  hk_data_14  39
				0x31,0x32,0x3A,0X33,//5  hk_data_12  43
				0x31,0x32,0x3A,0X33,//6  hk_data_16  47
				0x31,0x32,0x3A,0X33,//7  hk_data_15  51
				0x31,0x32,0x3A,0X33,//8  hk_data_17  55
				0x31,0x32,0x3A,0X33,//9  hk_data_1   59
				0x31,0x32,0x3A,0X33,//10 hk_data_3   63
				0x31,0x32,0x3A,0X33,//11 hk_data_2   67
				0x31,0x32,0x3A,0X33,//12 hk_data_7   71
				0x31,0x32,0x3A,0X33,//13 hk_data_5   75
				0x31,0x32,0x3A,0X33,//14 hk_data_13  79
				0x31,0x32,0x3A,0X33,//15 hk_data_6   83
				0x31,0x32,0x3A,0X33,//16 hk_data_11  87
				0x31,0x32,0x3A,0X33,//17 hk_data_4   91
				0x31,               //18 hk_data_18  95
				0x31,               //19 hk_data_19  96
				0x31,               //20 hk_data_20  97
				0x31,               //21 hk_data_21  98
				0x00,               //22             99
				0x00,               //23             100
				0x31,0x32,0x3A,0X33,//24 hk_data_22  101
				0x31,0x32,0x3A,0X33,//25 hk_data_23  105
				0x31,0x32,0x3A,0X33,//26 hk_data_24  109
				0x31,0x32,0x3A,0X33,//27 hk_data_25  113
				0x31,0x32,0x3A,0X33,//28 hk_data_30  117
				0x31,0x32,0x3A,0X33,//29 hk_data_26  121
				0x31,0x32,0x3A,0X33,//30 hk_data_27  125
				0x31,0x32,0x3A,0X33,//31 hk_data_28  129
				0x31,0x32,0x3A,0X33,//32 hk_data_29  133
				0x31,0x32,0x3A,0X33,//33 hk_data_31  137
				0x31,0x32,0x3A,0X33,//34 hk_data_32  141
				0x31,0x32,0x3A,0X33,//35 hk_data_33  145
				0x31,0x32,0x3A,0X33,//36 hk_data_34  149
				0x31,0x32,0x3A,0X33,//37 hk_data_35  153
				0x31,0x32,0x3A,0X33,//38 hk_data_36  157
				0x31,0x32,0x3A,0X33,//39 hk_data_37  161
				0x31,0x32,0x3A,0X33,//40 hk_data_42  165
				0x31,0x32,0x3A,0X33,//41 hk_data_38  169
				0x31,0x32,0x3A,0X33,//42 hk_data_39  173
				0x31,0x32,0x3A,0X33,//43 hk_data_40  177
				0x31,0x32,0x3A,0X33,//44 hk_data_41  181
				0x31,0x32,0x3A,0X33,//45 hk_data_43  185
				0x31,0x32,0x3A,0X33,//46 hk_data_44  189
				0x31,0x32,0x3A,0X33,//47 hk_data_45  193
				0x20,
				0x3A,0xFD,0xA3,0X4B,
				0x20,
				0x10};
    	//System.out.println(send_data);
        //ctx.writeAndFlush(Unpooled.copiedBuffer(send_data, CharsetUtil.UTF_8));
		ctx.writeAndFlush(Unpooled.copiedBuffer(send_data, CharsetUtil.US_ASCII));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
        System.out.println("Client received:" + in.toString(CharsetUtil.UTF_8));
    	//System.out.println("Client received:" + in);
    }
}