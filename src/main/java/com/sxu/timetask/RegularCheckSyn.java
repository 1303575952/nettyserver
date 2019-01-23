package com.sxu.timetask;

import com.sxu.constant.SynConstant;

import java.util.TimerTask;

/**
 * 定期检查同步信号是否收到
 */
public class RegularCheckSyn extends TimerTask {
    @Override
    public void run() {
        //如果当前没有同步
        if(!SynConstant.isSyn){
            //60秒内，PC端（或硬件采集端）未接收到该同步信号，它们将关闭此连接
            SynConstant.isSyn = false;
        }
    }
}
