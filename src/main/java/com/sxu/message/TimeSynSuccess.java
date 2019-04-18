package com.huanxin.message;

import com.huanxin.constant.Instruction;
import com.huanxin.utils.DataConversion;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

public class TimeSynSuccess {
    private static final Logger LOGGER = Logger.getLogger(TimeSynSuccess.class);

    public static void timeSynSuccessProcess(ChannelHandlerContext ctx, Object msg) {

        String msgStr = DataConversion.Object2HexString(msg);
        if (DataConversion.charArr2HexString(Instruction.TIME_SYN_SUCCESS_INSTRUCTION).equals(msgStr)) {
            LOGGER.debug("授时成功");
        }
    }
}
