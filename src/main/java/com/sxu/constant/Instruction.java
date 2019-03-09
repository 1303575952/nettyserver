package com.sxu.constant;

public class Instruction {
    //PC端故障信息校验成功握手指令定义
    public static final int[] JUDGE_FAULT_INSTRUCTION = {0x22, 0x20, 0x53, 0x06, 0x20, 0xde, 0xdf, 0x33, 0xe0, 0x20, 0x10};
    //PC端故障信息校验失败握手指令定义
    public static final int[] JUDGE_SUCCESS_INSTRUCTION = {0x22, 0x20, 0x53, 0x21, 0x20, 0x04, 0x1a, 0x81, 0x85, 0x20, 0x10};
    
}
