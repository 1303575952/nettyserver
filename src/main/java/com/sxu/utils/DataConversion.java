package com.sxu.utils;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

public class DataConversion {
    private static final Logger LOGGER = Logger.getLogger(DataConversion.class);
    /**
     * 接收到的消息转为byte[]
     *
     * @param msg
     * @return
     */
    public static byte[] Object2ByteArr(Object msg) {
        ByteBuf in = (ByteBuf) msg;
        int length = in.readableBytes();
        byte[] byteArr = new byte[length];
        in.getBytes(in.readerIndex(), byteArr);
        return byteArr;
    }

    /**
     * 接收到的消息转为16进制形式的String[]
     *
     * @param msg
     * @return
     */
    public static String[] Object2HexStringArr(Object msg) {
        byte[] byteArr = Object2ByteArr(msg);
        String[] hexStringArr = new String[byteArr.length];
        for (int i = 0; i < byteArr.length; i++) {
            hexStringArr[i] = Integer.toHexString(byteArr[i] & 0xff);
            if (hexStringArr[i].length() == 1) {
                hexStringArr[i] = "0" + hexStringArr[i];
            }
        }
        return hexStringArr;
    }

    /**
     * 接收到的消息转化为16进制形式的String
     *
     * @param msg
     * @return
     */
    public static String Object2HexString(Object msg) {
        String[] hexStringArr = Object2HexStringArr(msg);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hexStringArr.length; i++) {
            sb.append(hexStringArr[i]);
        }
        return sb.toString();
    }

    /**
     * char[]转byte[]
     *
     * @param charArr
     * @return
     */
    public static byte[] charArr2ByteArr(char[] charArr) {
        byte[] byteArr = new byte[charArr.length];
        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = (byte) charArr[i];
        }
        return byteArr;
    }

    /**
     * byte[]转String[]
     *
     * @param byteArr
     * @return
     */
    public static String[] byteArr2HexStringArr(byte[] byteArr) {
        String[] hexStringArr = new String[byteArr.length];
        for (int i = 0; i < byteArr.length; i++) {
            hexStringArr[i] = Integer.toHexString(byteArr[i] & 0xff);
            if (hexStringArr[i].length() == 1) {
                hexStringArr[i] = "0" + hexStringArr[i];
            }
        }
        return hexStringArr;
    }
}
