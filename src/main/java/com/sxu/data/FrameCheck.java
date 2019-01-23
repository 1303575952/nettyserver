package com.sxu.data;

import com.sxu.util.CRC32Utils;

public class FrameCheck {
    /**
     * 判断是否为采集信息：
     * 帧可识别，EB90
     * 变量个数，6个空格
     * 校验结果
     *
     * @param hexStr
     * @return
     */
    public static boolean isColletMessage(String hexStr) {
        //crc32，信息长度以及所有信息包相关量的校验结果
        return hexStr.startsWith("EB90") &&
                6 == (hexStr.length() - hexStr.replaceAll("20", "").length()) / 2 &&
                CRC32Utils.crc32Check((hexStr.substring(46, 52) + hexStr.substring(54, 566)), hexStr.substring(hexStr.length() - 12, hexStr.length() - 4));
    }

    /**
     * 判断是否为同步信息：
     * 帧可识别，EB90
     * 变量个数，1个空格
     *
     * @param hexStr
     * @return
     */
    public static boolean isSynMessage(String hexStr) {
        return hexStr.startsWith("EB90") &&
                1 == (hexStr.length() - hexStr.replaceAll("20", "").length()) / 2;
    }

    /**
     * 判断是否为故障信息：
     * 帧可识别，22
     * 变量个数，3个空格
     * 校验结果
     *
     * @param hexStr
     * @return
     */
    public static boolean isFaultMessage(String hexStr) {
        //将自帧头开始至校验前空格所有数据进行CRC校验
        return hexStr.startsWith("22") &&
                3 == (hexStr.length() - hexStr.replaceAll("20", "").length()) / 2 &&
                CRC32Utils.crc32Check(hexStr.substring(0, 10), hexStr.substring(hexStr.length() - 12, hexStr.length() - 4));
    }
}
