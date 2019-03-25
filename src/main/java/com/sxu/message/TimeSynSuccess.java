package com.sxu.message;

import com.sxu.constant.Instruction;
import com.sxu.utils.DataConversion;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

public class TimeSynSuccess {
    private static final Logger LOGGER = Logger.getLogger(TimeSynSuccess.class);

    public static void timeSynSuccessProcess(ChannelHandlerContext ctx, Object msg) {

        String msgStr = DataConversion.Object2HexString(msg);
        if (DataConversion.charArr2HexString(Instruction.TIME_SYN_SUCCESS_INSTRUCTION).equals(msgStr)) {
            LOGGER.debug("time syn success");
        }
    }
}
