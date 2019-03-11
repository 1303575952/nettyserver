package com.sxu.utils;

public class Hex2Float {

    /**
     * @param args 对于IEEE754编码。由float转换为IEEE754编码
     * @author li
     */
    public static void main(String[] args) {
        byte[] data;
        data = floatToBytes((float) 20.5);
        for (int i = 0; i < 4; i++) {
            System.out.println(Integer.toHexString(data[i] & 0xff));
        }

        int[] data4 = {0,0,Integer.parseInt("a4",16),Integer.parseInt("41",16)};
        int[] data4 = {0, 0, Integer.parseInt("a4", 16), Integer.parseInt("41", 16)};
        System.out.println(hexToFloat(data4));
    }

    public static float hexToFloat(int[] data) {// 解析4个字节中的数据，按照IEEE754的标准
        int s = 0;// 浮点数的符号
        float f = 0;// 浮点数
        int e = 0;// 指数
        if ((data[3] & 0xff) >= 128) {// 求s
            s = -1;
        } else {
            s = 1;
        }
        int temp = 0;// 指数位的最后一位
        if ((data[2] & 0xff) >= 128) {
            temp = 1;
        } else
            temp = 0;
        e = ((data[3] & 0xff) % 128) * 2 + temp;// 求e
        // f=((data[2]&0xff)-temp*128+128)/128+(data[1]&0xff)/(128*256)+(data[0]&0xff)/(128*256*256);
        float[] data2 = new float[3];
        data2[0] = data[0] & 0xff;
        data2[1] = data[1] & 0xff;
        data2[2] = data[2] & 0xff;
        f = (data2[2] - temp * 128 + 128) / 128 + data2[1] / (128 * 256)
                + data2[0] / (128 * 256 * 256);
        float result = 0;
        if (e == 0 && f != 0) {// 次正规数
            result = (float) (s * (f - 1) * Math.pow(2, -126));
            return result;
        }
        if (e == 0 && f == 0) {// 有符号的0
            result = (float) 0.0;
            return result;
        }
        if (s == 0 && e == 255 && f == 0) {// 正无穷大
            result = (float) 1111.11;
            return result;
        }
        if (s == 1 && e == 255 && f == 0) {// 负无穷大
            result = (float) -1111.11;
            return result;
        } else {
            result = (float) (s * f * Math.pow(2, e - 127));
            return result;
        }

    }

    public static byte[] floatToBytes(float a) {
        byte[] data = new byte[4];
        if (a == 0) {
            for (int i = 0; i < 4; i++) {
                data[i] = 0x00;
            }
            return data;
        }
        Integer[] intdata = {0, 0, 0, 0};
        a = Math.abs(a);
        // 首先将浮点数转化为二进制浮点数
        float floatpart = a % 1;
        int intpart = (int) (a / 1);
        // 将整数部分化为2进制,并转化为string类型
        String intString = "";
        String floatString = "";
        String result = "";
        String subResult = "";
        int zhishu = 0;
        if (intpart == 0) {
            intString += "0";
        }
        while (intpart != 0) {
            intString = intpart % 2 + intString;
            intpart = intpart / 2;
        }
        while (floatpart != 0) {
            floatpart *= 2;
            if (floatpart >= 1) {
                floatString += "1";
                floatpart -= 1;
            } else {
                floatString += "0";
            }

        }

        result = intString + floatString;
        intpart = (int) (a / 1);
        if (intpart > 0) {// 整数部分肯定有1，且以1开头..这样的话，小数点左移
            zhishu = intString.length() - 1;
        } else {// 整数位为0，右移
            for (int i = 0; i < floatString.length(); i++) {
                zhishu--;
                if (floatString.charAt(i) == '1') {
                    break;
                }
            }
            // while(floatString.charAt(index)){}
        }
        // 对指数进行移码操作
        if (zhishu >= 0) {
            subResult = result.substring(intString.length() - zhishu);
        } else {
            subResult = floatString.substring(-zhishu);
        }
        zhishu += 127;
        if (subResult.length() <= 7) {// 若长度

            for (int i = 0; i < 7; i++) {
                if (i < subResult.length()) {
                    intdata[1] = intdata[1] * 2 + subResult.charAt(i) - '0';
                } else {
                    intdata[1] *= 2;
                }

            }

            if (zhishu % 2 == 1) {// 如果质数是奇数，则需要在这个最前面加上一个‘1’
                intdata[1] += 128;
            }
            data[1] = intdata[1].byteValue();
        } else if (subResult.length() <= 15) {// 长度在（7,15）以内
            int i = 0;
            for (i = 0; i < 7; i++) {// 计算0-7位，最后加上第一位
                intdata[1] = intdata[1] * 2 + subResult.charAt(i) - '0';
            }
            if (zhishu % 2 == 1) {// 如果质数是奇数，则需要在这个最前面加上一个‘1’
                intdata[1] += 128;
            }
            data[1] = intdata[1].byteValue();

            for (i = 7; i < 15; i++) {// 计算8-15位
                if (i < subResult.length()) {
                    intdata[2] = intdata[2] * 2 + subResult.charAt(i) - '0';
                } else {
                    intdata[2] *= 2;
                }

            }
            data[2] = intdata[2].byteValue();
        } else {// 长度大于15
            int i = 0;
            for (i = 0; i < 7; i++) {// 计算0-7位，最后加上第一位
                intdata[1] = intdata[1] * 2 + subResult.charAt(i) - '0';
            }
            if (zhishu % 2 == 1) {// 如果质数是奇数，则需要在这个最前面加上一个‘1’
                intdata[1] += 128;
            }
            data[1] = intdata[1].byteValue();

            for (i = 7; i < 15; i++) {// 计算8-15位
                intdata[2] = intdata[2] * 2 + subResult.charAt(i) - '0';
            }
            data[2] = intdata[2].byteValue();

            for (i = 15; i < 23; i++) {// 计算8-15位
                if (i < subResult.length()) {
                    intdata[3] = intdata[3] * 2 + subResult.charAt(i) - '0';
                } else {
                    intdata[3] *= 2;
                }

            }
            data[3] = intdata[3].byteValue();
        }

        intdata[0] = zhishu / 2;
        if (a < 0) {
            intdata[0] += 128;
        }
        data[0] = intdata[0].byteValue();
        byte[] data2 = new byte[4];// 将数据转移，目的是倒换顺序
        for (int i = 0; i < 4; i++) {
            data2[i] = data[3 - i];
        }
        return data2;
    }
}
