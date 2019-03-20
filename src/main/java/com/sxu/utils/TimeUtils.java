package com.sxu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /**
     * 获取执行此条信息的时间
     * 数据格式为20190320123456
     *
     * @return
     */
    public static String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    /**
     * 获取执行此条信息的时间
     * 数据格式为2019032012:34:56
     *
     * @return
     */
    public static String getCurrentDateTimeSplitByColon() {
        String currentDateTime = TimeUtils.getCurrentDateTime();
        StringBuffer sb = new StringBuffer("");
        sb.append(currentDateTime.substring(0, 10));
        sb.append(":");
        sb.append(currentDateTime.substring(10, 12));
        sb.append(":");
        sb.append(currentDateTime.substring(12, 14));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(TimeUtils.getCurrentDateTimeSplitByColon());
    }
}
