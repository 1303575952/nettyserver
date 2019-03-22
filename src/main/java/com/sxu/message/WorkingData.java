package com.sxu.message;

import com.sxu.db.DataProcess;
import com.sxu.utils.DataConversion;
import org.apache.log4j.Logger;

import java.util.zip.CRC32;

public class WorkingData {
    private static final Logger LOGGER = Logger.getLogger(WorkingData.class);
    public static void workingDataProcess(Object msg){
        byte[] workingDataByteArr = DataConversion.Object2ByteArr(msg);
        String[] workingDataHexStringArr = DataConversion.byteArr2HexStringArr(workingDataByteArr);
        if (WorkingData.workingDataJudgeCRC32(workingDataByteArr)) {
            //拿到工况数据并入库
            DataProcess.getAndInsertWorkingData2DB(workingDataHexStringArr);
            LOGGER.debug("crc32校验无误");
        } else {
            LOGGER.debug("crc32校验有误");
        }
    }

    public static boolean workingDataJudgeCRC32(byte[] byteArr) {
        String[] hexStringArr = DataConversion.byteArr2HexStringArr(byteArr);
        CRC32 crc32 = new CRC32();

        byte[] judgeArr = new byte[198];
        for (int i = 0; i < judgeArr.length; i++) {
            judgeArr[i] = byteArr[i];
        }
        crc32.update(judgeArr);
        String realCheckCRC32 = Long.toHexString(crc32.getValue());
        if (realCheckCRC32.length() == 7) {
            realCheckCRC32 = "0" + realCheckCRC32;
        }

        String checkedCRC32 = hexStringArr[198] + hexStringArr[199] + hexStringArr[200] + hexStringArr[201];
        LOGGER.debug("接收到的校验数据：" + checkedCRC32);
        LOGGER.debug("正确的校验数据" + realCheckCRC32);

        return realCheckCRC32.substring(0, 2).equals(hexStringArr[198]) &&
                realCheckCRC32.substring(2, 4).equals(hexStringArr[199]) &&
                realCheckCRC32.substring(4, 6).equals(hexStringArr[200]) &&
                realCheckCRC32.substring(6).equals(hexStringArr[201]);
    }
}