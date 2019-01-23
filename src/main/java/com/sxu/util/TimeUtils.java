package com.sxu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /**
     * 获取执行此条信息的时间
     * @return
     */
    public static String getCurrentDateTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }
}
