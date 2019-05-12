package com.sxu.message;

import com.sxu.constant.Instruction;
import com.sxu.utils.DataConversion;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 * 处理授时失败
 */
public class TimeSynFailed {
    private static final Logger LOGGER = Logger.getLogger(TimeSynFailed.class);

    public static void timeSynFailedProcess(ChannelHandlerContext ctx, Object msg) {

        String msgStr = DataConversion.Object2HexString(msg);
        if (DataConversion.charArr2HexString(Instruction.TIME_SYN_FAILED_INSTRUCTION).equals(msgStr)) {
            LOGGER.debug("授时失败");
        }
    }
}
