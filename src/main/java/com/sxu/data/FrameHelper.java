package com.sxu.data;

import com.sxu.constant.FaultConstant;
import com.sxu.constant.SynConstant;
import com.sxu.dao.WorkingModelDao;
import com.sxu.entity.WorkingModel;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * 判断allHexStr是哪种消息
 * 消息是否可识别，变量个数是否正确，校验结果是否正确
 */
public class FrameHelper {
    public static String checkFrame(String allHexStr) {
        if (FrameCheck.isColletMessage(allHexStr)) {
            //处理采集消息
            //消息入库，返回采集消息应答帧
            String needHexStr = allHexStr.substring(12, allHexStr.length() - 14);
            System.out.println("just need:" + needHexStr);
            //接收到的16进制数据转化为文本格式
            byte[] b = null;
            try {
                b = Hex.decodeHex(needHexStr);
            } catch (DecoderException e) {
                e.printStackTrace();
            }
            String needTextStr = new String(b).trim();
            System.out.println("text value:" + needTextStr);
            //生成WorkingModel对象
            WorkingModel workingModel = WorkingModelData.getFieldsFromStr(needTextStr);
            //workingModel入库
            try {
                WorkingModelDao.insertWorkingModel(workingModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return MessageBack.backAnswerFrame(allHexStr);
        } else if (FrameCheck.isSynMessage(allHexStr)) {
            //处理同步消息
            //同步计数器重新开始计数
            SynConstant.isSyn = true;
            return null;
        } else if (FrameCheck.isFaultMessage(allHexStr)) {
            //处理故障消息
            //故障指令，无故障指令
            if (allHexStr.startsWith("22204400")) {
                //无故障指令
                FaultConstant.isFault = false;
                return MessageBack.backFaultFrame(allHexStr);
            } else {
                FaultConstant.isFault = true;
                return MessageBack.backFaultFrame(allHexStr);
            }
        } else {
            //不正常消息
            if (!(allHexStr.startsWith("EB90") || allHexStr.startsWith("22"))) {
                //返回请求类型无法识别
                return MessageBack.backDC1Frame(allHexStr);
            } else {
                if (allHexStr.startsWith("EB90")) {
                    if (6 != (allHexStr.length() - allHexStr.replaceAll("20", "").length()) / 2) {
                        //返回变量个数不正确帧
                        return MessageBack.backDC2Frame(allHexStr);
                    } else {
                        //返回校验结果不正确帧
                        return MessageBack.backDC3Frame(allHexStr);
                    }

                } else if (allHexStr.startsWith("22")) {
                    if (1 != (allHexStr.length() - allHexStr.replaceAll("20", "").length()) / 2) {
                        //返回变量个数不正确帧
                        return MessageBack.backDC2Frame(allHexStr);
                    } else {
                        //返回校验结果不正确帧
                        return MessageBack.backDC3Frame(allHexStr);
                    }
                } else {
                    return null;
                }
            }
        }
    }
}
