package com.sxu.constant;

import com.sxu.utils.TimeUtil;
import org.apache.log4j.Logger;

import java.util.zip.CRC32;

public class Instruction {
    private static final Logger LOGGER = Logger.getLogger(Instruction.class);
    //PC端故障信息校验成功握手指令定义
    public static final char[] JUDGE_SUCCESS_INSTRUCTION = {0x22, 0x20, 0x53, 0x06, 0x20, 0xde, 0xdf, 0x33, 0xe0, 0x20, 0x10};
    //PC端故障信息校验失败握手指令定义
    public static final char[] JUDGE_FAULT_INSTRUCTION = {0x22, 0x20, 0x53, 0x21, 0x20, 0x04, 0x1a, 0x81, 0x85, 0x20, 0x10};
    //硬件端接受授时指令校验成功握手指令定义
    public static final char[] TIME_SYN_SUCCESS_INSTRUCTION = {0x22, 0x20, 0x44, 0x06, 0x20, 0xc7, 0xb6, 0x86, 0x15, 0x20, 0x10};
    //硬件端接受授时指令校验失败握手指令定义
    public static final char[] TIME_SYN_FAILED_INSTRUCTION = {0x22, 0x20, 0x44, 0x21, 0x20, 0x1d, 0x73, 0x34, 0x70, 0x20, 0x10};

    /**
     * 向硬件端发送的授时指令
     * @return
     */
    public static char[] getTimeSynInstruction() {
        char[] time_syn_instruction = {0x22, 0x20, 0x53,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,//年月日，日20190320
                0x20,
                0x00, 0x00,//时，例14
                0x3a,
                0x00, 0x00,//分，例43
                0x3a,
                0x00, 0x00,//秒，例53
                0x20,
                0x00, 0x00, 0x00, 0x00,//校验
                0x20, 0x10};
        String currentDateTime = TimeUtil.getCurrentDateTime();
        time_syn_instruction[3] = currentDateTime.charAt(0);
        time_syn_instruction[4] = currentDateTime.charAt(1);
        time_syn_instruction[5] = currentDateTime.charAt(2);
        time_syn_instruction[6] = currentDateTime.charAt(3);
        time_syn_instruction[7] = currentDateTime.charAt(4);
        time_syn_instruction[8] = currentDateTime.charAt(5);
        time_syn_instruction[9] = currentDateTime.charAt(6);
        time_syn_instruction[10] = currentDateTime.charAt(7);
        time_syn_instruction[12] = currentDateTime.charAt(8);
        time_syn_instruction[13] = currentDateTime.charAt(9);
        time_syn_instruction[15] = currentDateTime.charAt(10);
        time_syn_instruction[16] = currentDateTime.charAt(11);
        time_syn_instruction[18] = currentDateTime.charAt(12);
        time_syn_instruction[19] = currentDateTime.charAt(13);
        //
        byte[] tsij = new byte[21];
        for (int i = 0; i < tsij.length; i++) {
            tsij[i] = (byte) time_syn_instruction[i];
        }
        CRC32 crc32 = new CRC32();
        crc32.update(tsij);
        String tsijCRC32 = Long.toHexString(crc32.getValue());

        time_syn_instruction[21] = (char) Integer.parseInt(tsijCRC32.substring(0, 2), 16);
        time_syn_instruction[22] = (char) Integer.parseInt(tsijCRC32.substring(2, 4), 16);
        time_syn_instruction[23] = (char) Integer.parseInt(tsijCRC32.substring(4, 6), 16);
        time_syn_instruction[24] = (char) Integer.parseInt(tsijCRC32.substring(6), 16);

        return time_syn_instruction;
    }

    public static void main(String[] args) {
        char[] ins = Instruction.getTimeSynInstruction();
        for (int i = 0; i < ins.length; i++) {
            System.out.println(Integer.toHexString(ins[i] & 0xff));
        }
    }
}