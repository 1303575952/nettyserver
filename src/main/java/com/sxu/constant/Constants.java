package com.sxu.constant;

public class Constants {
    //时间粒度次数
    public static final int TIMEGRANULARITY = 5;
    //拆包后的工况数据拼装存入其中
    public static StringBuffer packingStr = new StringBuffer("");
    //工况数据是否继续拼包
    public static boolean isAssemble = false;
    //工况数据长度，840字节*2=1680，例如0xab用"ab"计算
    public static final int WORKING_DATA_LENGTH = 1680;
}
