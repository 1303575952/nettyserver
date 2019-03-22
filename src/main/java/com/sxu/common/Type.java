package com.sxu.common;

/**
 * 服务端接收消息，根据消息头判断消息类别
 */
public interface Type {
    //工况数据指令消息头
    String WORKING_DATA_HEAD = "eb9022204420";
    //授时指令消息头
    String TIME_SYN_HEAD = "222053";
    //授时校验成功指令消息头
    String TIME_SYN_SUCCESS_HEAD = "2220440620";
    //授时校验失败指令消息头
    String TIME_SYN_FAILD_HEAD = "2220442120";
}
