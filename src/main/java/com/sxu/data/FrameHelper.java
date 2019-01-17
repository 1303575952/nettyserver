package com.sxu.data;

/**
 * 判断allHexStr是哪种消息
 * 消息是否可识别，变量个数是否正确，校验结果是否正确
 */
public class FrameHelper {
    public static void checkFrame(String allHexStr){
        if(FrameCheck.isColletMessage(allHexStr)){
            //处理采集消息
            //消息入库，返回采集消息应答帧
        }else if(FrameCheck.isSynMessage(allHexStr)){
            //处理同步消息
            //同步计数器重新开始计数
        }else if(FrameCheck.isFaultMessage(allHexStr)){
            //处理故障消息
            //故障指令，无故障指令
        }else{
            //不正常消息
            if(!(allHexStr.startsWith("EB90")||allHexStr.startsWith("22"))){
                //返回请求类型无法识别
            }else{
                if(allHexStr.startsWith("EB90")){
                    if(6 != (allHexStr.length() - allHexStr.replaceAll("20", "").length()) / 2){
                        //返回变量个数不正确帧
                    }else{
                        //返回校验结果不正确帧
                    }

                }else if(allHexStr.startsWith("22")){
                    if(1 != (allHexStr.length() - allHexStr.replaceAll("20", "").length()) / 2){
                        //返回变量不正确帧
                    }else{
                        //返回校验结果不正确帧
                    }
                }
            }
        }
    }
}
