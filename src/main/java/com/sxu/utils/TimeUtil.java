package com.huanxin.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理相关
 */
public class TimeUtil {
    private static final Logger LOGGER = Logger.getLogger(TimeUtil.class);

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
        String currentDateTime = TimeUtil.getCurrentDateTime();
        StringBuffer sb = new StringBuffer("");
        sb.append(currentDateTime.substring(0, 10));
        sb.append(":");
        sb.append(currentDateTime.substring(10, 12));
        sb.append(":");
        sb.append(currentDateTime.substring(12, 14));
        return sb.toString();
    }

    /**
     * 获取执行此条信息的时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentDateTimeSplitByHyphenAndColon() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(date);
        return dateTime;
    }

    /**
     * 年月日格式化
     * 20190419转化为2019-04-19
     *
     * @param nianyueri
     * @return
     */
    public static String nianyueriFormat(String nianyueri) {
        return nianyueri.substring(0, 4) + "-" + nianyueri.substring(4, 6) + "-" + nianyueri.substring(6);
    }

    public static void main(String[] args) {
        System.out.println(TimeUtil.nianyueriFormat("20190419"));
    }
}
