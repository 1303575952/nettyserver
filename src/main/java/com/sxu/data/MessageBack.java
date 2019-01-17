package com.sxu.data;

/**
 * 构造应答帧
 */
public class MessageBack {
    /**
     * 采集消息应答帧
     *
     * @param allHexStr
     * @return
     */
    public static String backAnswerFrame(String allHexStr) {
        return allHexStr.replaceAll("EB90222044", "EB90062053");
    }

    /**
     * 向硬件发送同步帧
     *
     * @param
     * @return
     */
    public static String backSynFrame() {
        return "EB905320160A";
    }

    /**
     * 请求无法识别帧
     * @return
     */
    public static String backDC1Frame(String allHexStr){
        return allHexStr.replaceAll("EB90222044", "EB90172053");
    }

    /**
     * 返回变量个数不正确帧
     * @param allHexStr
     * @return
     */
    public static String backDC2Frame(String allHexStr){
        return allHexStr.replaceAll("EB90222044", "EB90182053");
    }

    /**
     * 返回校验结果不正确帧
     * @param allHexStr
     * @return
     */
    public static String backDC3Frame(String allHexStr){
        return allHexStr.replaceAll("EB90222044", "EB90192053");
    }
}
