package com.huanxin.client;

import com.huanxin.common.MiddleWare;
import com.huanxin.utils.DataConversion;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

public class ClientHandler extends MiddleWare {
    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class);
    private Client client;

    public ClientHandler(Client client) {
        this.client = client;
    }

    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
        LOGGER.debug("client  收到数据： " + DataConversion.Object2HexString(msg));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        char send_data[] = {0xEB, 0X90, 0X16,                 //0     //帧头
                0x33, 0x34, 0x37, 0x30,                     //3     //晋能热电的企业ID 3470  的ascll码
                0x44,                                    //7     // D
                0x31,                                    //8     //排口编号
                0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, //9     //年月日
                0x31,                                    //17    //机组编号 1
                0x30, 0x30, 0x3A, 0X30, 0X30, 0X3A, 0X30, 0X30, //18    //时:分:秒  在两个机组的数据中分别出现一次(实际值相同)
                0X33, 0X37, 0X32,                          //26    //数据长372
                0x41,                                    //29    //锅炉编号A
                0x54, 0x58,                               //30    //工艺类型脱硝 TX
                0x31,                                    //32    //治理设施编号1
                0x30, 0x30, 0x30, 0X30,//1    33        SCR反应器出口烟气O2浓度        （片段1）注：下有重复
                0x30, 0x30, 0x30, 0X30,//2    37        SCR反应器出口烟气NOX浓度
                0x30, 0x30, 0x30, 0X30,//3    41        SCR反应器出口烟气温度                               //机组1脱硝1的数据包，128字节
                0x30, 0x30, 0x30, 0X30,//4    45        SCR反应器出口烟气NH3浓度                            //1~13行为有效数据存放区
                0x30, 0x30, 0x30, 0X30,//5    49        机组锅炉负荷                                        //机组锅炉负荷的数据在脱硝1和脱硝2中分别出现一次(实际值相同)
                0x30, 0x30, 0x30, 0X30,//6    53        SCR反应器AAIG前烟道流量
                0x30, 0x30, 0x30, 0X30,//7    57        SCR反应器AAIG前烟道O2浓度
                0x30, 0x30, 0x30, 0X30,//8    61        SCR反应器AAIG前烟道烟气NOX浓度
                0x30, 0x30, 0x30, 0X30,//9    65        SCR反应器A进口烟气温度1
                0x30, 0x30, 0x30, 0X30,//10   69        201A氨气流量最高
                0x30, 0x30, 0x30, 0X30,//11   73        反应器A烟气压差1
                0x30, 0x30, 0x30, 0X30,//12   77        反应器A烟气压差2
                0x30, 0x30, 0x30, 0X30,//13   81        反应器A烟气压差3
                0x30, 0x30, 0x30, 0X30,//14   85
                0x30, 0x30, 0x30, 0X30,//15   89
                0x30, 0x30, 0x30, 0X30,//16   93
                0x30, 0x30, 0x30, 0X30,//17   97
                0x30, 0x30, 0x30, 0X30,//18   101
                0x30, 0x30, 0x30, 0X30,//19   105
                0x30, 0x30, 0x30, 0X30,//20   109
                0x30, 0x30, 0x30, 0X30,//21   113
                0x30, 0x30, 0x30, 0X30,//22   117
                0x30, 0x30, 0x30, 0X30,//23   121
                0x30, 0x30, 0x30, 0X30,//24   125
                0x30, 0x30, 0x30, 0X30,//25   129
                0x30, 0x30, 0x30, 0X30,//26   133
                0x30, 0x30, 0x30, 0X30,//27   137
                0x30, 0x30, 0x30, 0X30,//28   141
                0x30, 0x30, 0x30, 0X30,//29   145
                0x30, 0x30, 0x30, 0X30,//30   149
                0x30, 0x30, 0x30, 0X30,//31   153
                0x30, 0x30, 0x30, 0X30,//32   157
                0x42,                    //161                                                           //锅炉编号B
                0x54, 0x58,               //162                                                           //工艺类型脱硝 TX
                0x32,                    //164                                                           //治理设施编号2
                0x30, 0x30, 0x30, 0X30,//1    165       SCR反应器出口烟气O2浓度     （片段2）注：下有重复
                0x30, 0x30, 0x30, 0X30,//2    169       SCR反应器出口烟气NOX浓度
                0x30, 0x30, 0x30, 0X30,//3    173       SCR反应器出口烟气温度                               //机组1脱硝2的数据包，128字节
                0x30, 0x30, 0x30, 0X30,//4    177       SCR反应器出口烟气NH3浓度                               //1~13行为有效数据存放区
                0x30, 0x30, 0x30, 0X30,//5    181       机组锅炉负荷
                0x30, 0x30, 0x30, 0X30,//6    185       SCR反应器BAIG前烟道流量
                0x30, 0x30, 0x30, 0X30,//7    189       SCR反应器BAIG前烟道O2浓度
                0x30, 0x30, 0x30, 0X30,//8    193       SCR反应器BAIG前烟道烟气NOX浓度
                0x30, 0x30, 0x30, 0X30,//9    197       SCR反应器B进口烟气温度1
                0x30, 0x30, 0x30, 0X30,//10   201       201B氨气流量最高
                0x30, 0x30, 0x30, 0X30,//11   205       反应器B烟气压差1
                0x30, 0x30, 0x30, 0X30,//12   209       反应器B烟气压差2
                0x30, 0x30, 0x30, 0X30,//13   213       反应器B烟气压差3
                0x30, 0x30, 0x30, 0X30,//14   217
                0x30, 0x30, 0x30, 0X30,//15   221
                0x30, 0x30, 0x30, 0X30,//16   225
                0x30, 0x30, 0x30, 0X30,//17   229
                0x30, 0x30, 0x30, 0X30,//18   233
                0x30, 0x30, 0x30, 0X30,//19   237
                0x30, 0x30, 0x30, 0X30,//20   241
                0x30, 0x30, 0x30, 0X30,//21   245
                0x30, 0x30, 0x30, 0X30,//22   249
                0x30, 0x30, 0x30, 0X30,//23   253
                0x30, 0x30, 0x30, 0X30,//24   257
                0x30, 0x30, 0x30, 0X30,//25   261
                0x30, 0x30, 0x30, 0X30,//26   265
                0x30, 0x30, 0x30, 0X30,//27   269
                0x30, 0x30, 0x30, 0X30,//28   273
                0x30, 0x30, 0x30, 0X30,//29   277
                0x30, 0x30, 0x30, 0X30,//30   281
                0x30, 0x30, 0x30, 0X30,//31   285
                0x30, 0x30, 0x30, 0X30,//32   289
                0x41,                     //293                                  //锅炉编号A
                0x54, 0x53,                //294                                  //工艺类型脱硝 TS
                0x31,                    //296                                  //治理设施编号1
                0x30, 0x30, 0x30, 0X30,//1    297       入口烟气量        （片段3）注：下有重复
                0x30, 0x30, 0x30, 0X30,//2    301       入口硫浓度
                0x30, 0x30, 0x30, 0X30,//3    305       入口O2浓度                            //机组1脱硫1的数据包，128字节
                0x30, 0x30, 0x30, 0X30,//4    309       入口烟温度                            //1~31行为有效数据存放区
                0x30, 0x30, 0x30, 0X30,//5    313       入口烟气湿度
                0x30, 0x30, 0x30, 0X30,//6    317       石灰石供浆量
                0x30, 0x30, 0x30, 0X30,//7    321       石膏液密度
                0x30, 0x30, 0x30, 0X30,//8    325       PH值字节
                0x30, 0x30, 0x30, 0X30,//9    329       出口烟气量
                0x30, 0x30, 0x30, 0X30,//10   333       出口硫浓度
                0x30, 0x30, 0x30, 0X30,//11   337       出口O2浓度
                0x30, 0x30, 0x30, 0X30,//12   341       出口烟温度
                0x30, 0x30, 0x30, 0X30,//13   345       出口烟气湿度
                0x30, 0x30, 0x30, 0X30,//14   349       入口烟气压力
                0x30, 0x30, 0x30, 0X30,//15   353       出口烟气压力
                0x30, 0x30, 0x30, 0X30,//16   357       入口烟气粉尘度
                0x30, 0x30, 0x30, 0X30,//17   361       出口烟气粉尘度
                0x32,               //18   365       1#循环泵开关状态
                0x32,               //19   366       2#循环泵开关状态
                0x32,               //20   367       3#循环泵开关状态
                0x32,               //21   368       4#循环泵开关状态
                0x32,               //22   369       1#氧化风机开关状态
                0x32,               //23   370       2#氧化风机开关状态
                0x30, 0x30, 0x30, 0X30,//24   371       X机组石灰石浆液密度（计算）
                0x30, 0x30, 0x30, 0X30,//25   375       锅炉负荷
                0x30, 0x30, 0x30, 0X30,//26   379	   1机组1循环浆泵电流
                0x30, 0x30, 0x30, 0X30,//27   383       1机组2循环浆泵电流
                0x30, 0x30, 0x30, 0X30,//28   387       1机组3循环浆泵电流
                0x30, 0x30, 0x30, 0X30,//29   391       1机组4循环浆泵电流
                0x30, 0x30, 0x30, 0X30,//30   395       1机组1氧化风机电流
                0x30, 0x30, 0x30, 0X30,//31   399       1机组2氧化风机电流
                0x30, 0x30, 0x30, 0X30,//32   403
                0x30, 0x30, 0x30, 0X30,//33   407
                0x30, 0x30, 0x30, 0X30,//34   411
                0x30, 0x30, 0x30, 0X30,//35   415
                0x30, 0x30, 0x30, 0X30,//36   419
                0x31, 0x32,          //37   423
                0x32,                     //425                   //机组编号 2
                0x30, 0x30, 0x3A, 0X30, 0X30, 0X3A, 0X30, 0X30,  //426  //时:分:秒
                0X33, 0X37, 0X32,                    //434         //数据长372
                0x41,                              //437         //锅炉编号A
                0x54, 0x58,                         //438         //工艺类型脱硝 TX
                0x31,                              //440         //治理设施编号1
                0x30, 0x30, 0x30, 0X30,//1    441
                0x30, 0x30, 0x30, 0X30,//2    445       1~13行   重复片段1
                0x30, 0x30, 0x30, 0X30,//3    449                                                         //机组2脱硝1的数据包，128字节
                0x30, 0x30, 0x30, 0X30,//4    453                                                         //1~13行为有效数据存放区
                0x30, 0x30, 0x30, 0X30,//5    457
                0x30, 0x30, 0x30, 0X30,//6    461
                0x30, 0x30, 0x30, 0X30,//7    465
                0x30, 0x30, 0x30, 0X30,//8    469
                0x30, 0x30, 0x30, 0X30,//9    473
                0x30, 0x30, 0x30, 0X30,//10   477
                0x30, 0x30, 0x30, 0X30,//11   481
                0x30, 0x30, 0x30, 0X30,//12   485
                0x30, 0x30, 0x30, 0X30,//13   489
                0x30, 0x30, 0x30, 0X30,//14   493
                0x30, 0x30, 0x30, 0X30,//15   497
                0x30, 0x30, 0x30, 0X30,//16   501
                0x30, 0x30, 0x30, 0X30,//17   505
                0x30, 0x30, 0x30, 0X30,//18   509
                0x30, 0x30, 0x30, 0X30,//19   513
                0x30, 0x30, 0x30, 0X30,//20   517
                0x30, 0x30, 0x30, 0X30,//21   521
                0x30, 0x30, 0x30, 0X30,//22   525
                0x30, 0x30, 0x30, 0X30,//23   529
                0x30, 0x30, 0x30, 0X30,//24   533
                0x30, 0x30, 0x30, 0X30,//25   537
                0x30, 0x30, 0x30, 0X30,//26   541
                0x30, 0x30, 0x30, 0X30,//27   545
                0x30, 0x30, 0x30, 0X30,//28   549
                0x30, 0x30, 0x30, 0X30,//29   553
                0x30, 0x30, 0x30, 0X30,//30   557
                0x30, 0x30, 0x30, 0X30,//31   561
                0x30, 0x30, 0x30, 0X30,//32   565
                0x42,                              //569         //锅炉编号B
                0x54, 0x58,                         //570         //工艺类型脱硝 TX
                0x32,                              //572         //治理设施编号2
                0x30, 0x30, 0x30, 0X30,//1    573
                0x30, 0x30, 0x30, 0X30,//2    577       1~13行   重复片段2
                0x30, 0x30, 0x30, 0X30,//3    581                                                   //机组2脱硝2的数据包，128字节
                0x30, 0x30, 0x30, 0X30,//4    585                                                   //1~13行为有效数据存放区
                0x30, 0x30, 0x30, 0X30,//5    589
                0x30, 0x30, 0x30, 0X30,//6    593
                0x30, 0x30, 0x30, 0X30,//7    597
                0x30, 0x30, 0x30, 0X30,//8    601
                0x30, 0x30, 0x30, 0X30,//9    605
                0x30, 0x30, 0x30, 0X30,//10   609
                0x30, 0x30, 0x30, 0X30,//11   613
                0x30, 0x30, 0x30, 0X30,//12   617
                0x30, 0x30, 0x30, 0X30,//13   621
                0x30, 0x30, 0x30, 0X30,//14   625
                0x30, 0x30, 0x30, 0X30,//15   629
                0x30, 0x30, 0x30, 0X30,//16   633
                0x30, 0x30, 0x30, 0X30,//17   637
                0x30, 0x30, 0x30, 0X30,//18   641
                0x30, 0x30, 0x30, 0X30,//19   645
                0x30, 0x30, 0x30, 0X30,//20   649
                0x30, 0x30, 0x30, 0X30,//21   653
                0x30, 0x30, 0x30, 0X30,//22   657
                0x30, 0x30, 0x30, 0X30,//23   661
                0x30, 0x30, 0x30, 0X30,//24   665
                0x30, 0x30, 0x30, 0X30,//25   669
                0x30, 0x30, 0x30, 0X30,//26   673
                0x30, 0x30, 0x30, 0X30,//27   677
                0x30, 0x30, 0x30, 0X30,//28   681
                0x30, 0x30, 0x30, 0X30,//29   685
                0x30, 0x30, 0x30, 0X30,//30   689
                0x30, 0x30, 0x30, 0X30,//31   693
                0x30, 0x30, 0x30, 0X30,//32   697
                0x41,                              //701         //锅炉编号A
                0x54, 0x53,                         //702         //工艺类型脱硝 TS
                0x31,                              //704         //治理设施编号1
                0x30, 0x30, 0x30, 0X30,//1    705
                0x30, 0x30, 0x30, 0X30,//2    709      1~31行   重复片段3
                0x30, 0x30, 0x30, 0X30,//3    713                                                 //机组2脱硫1的数据包，128字节
                0x30, 0x30, 0x30, 0X30,//4    717                                                 //1~31行为有效数据存放区
                0x30, 0x30, 0x30, 0X30,//5    721
                0x30, 0x30, 0x30, 0X30,//6    725
                0x30, 0x30, 0x30, 0X30,//7    729
                0x30, 0x30, 0x30, 0X30,//8    733
                0x30, 0x30, 0x30, 0X30,//9    737
                0x30, 0x30, 0x30, 0X30,//10   741
                0x30, 0x30, 0x30, 0X30,//11   745
                0x30, 0x30, 0x30, 0X30,//12   749
                0x30, 0x30, 0x30, 0X30,//13   753
                0x30, 0x30, 0x30, 0X30,//14   757
                0x30, 0x30, 0x30, 0X30,//15   761
                0x30, 0x30, 0x30, 0X30,//16   765
                0x30, 0x30, 0x30, 0X30,//17   769
                0x32,               //18   773
                0x32,               //19   774
                0x32,               //20   775
                0x32,               //21   776
                0x32,               //22   777
                0x32,               //23   778
                0x30, 0x30, 0x30, 0X30,//24   779
                0x30, 0x30, 0x30, 0X30,//25   783
                0x30, 0x30, 0x30, 0X30,//26   787
                0x30, 0x30, 0x30, 0X30,//27   791
                0x30, 0x30, 0x30, 0X30,//28   795
                0x30, 0x30, 0x30, 0X30,//29   799
                0x30, 0x30, 0x30, 0X30,//30   803
                0x30, 0x30, 0x30, 0X30,//31   807
                0x30, 0x30, 0x30, 0X30,//32   811
                0x30, 0x30, 0x30, 0X30,//33   815
                0x30, 0x30, 0x30, 0X30,//34   819
                0x30, 0x30, 0x30, 0X30,//35   823
                0x30, 0x30, 0x30, 0X30,//36   827
                0x31, 0x32,          //37             831

                0x00, 0x01,                         //833       //数据采集发送设备（本程序烧写的设备）编号
                0x31, 0xe7, 0xfc, 0X61,               //835
                0x0A                               //839       //LF结束符
        };

        byte[] byteArr = new byte[send_data.length];
        for (int i = 0; i < send_data.length; i++) {
            byteArr[i] = (byte) send_data[i];
        }
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeBytes(byteArr);
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        client.doConnect();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error(name + "exception :" + cause.toString());
    }
}
