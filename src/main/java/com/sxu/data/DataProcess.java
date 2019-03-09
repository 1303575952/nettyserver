package com.sxu.data;

import com.sxu.entity.WorkingDataEntity;
import com.sxu.service.WorkingDataService;
import com.sxu.service.impl.WorkingDataServiceImpl;

import java.util.zip.CRC32;

public class DataProcess {
    /**
     * 拿到工况数据并入库
     *
     * @param arrayHex
     */
    public static void getAndInsertWorkingData2DB(String[] arrayHex) {
        WorkingDataEntity workingDataEntity = WorkingDataProcess.getWorkingDataEntityFromFrame(arrayHex);
        WorkingDataService workingDataService = new WorkingDataServiceImpl();
        try {
            workingDataService.insertWorkingData(workingDataEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断工况数据CRC32校验是否正确
     *
     * @param arrayHex
     * @return
     */
    public static boolean workingDataJudgeCRC32(byte[] array, String[] arrayHex) {
        CRC32 crc32 = new CRC32();
        byte[] judgeArr = new byte[173];
        judgeArr[0] = array[23];
        judgeArr[1] = array[24];
        judgeArr[2] = array[25];
        for (int i = 3; i < 173; i++) {
            judgeArr[i] = array[i + 24];
        }
        crc32.update(judgeArr);
        String realCheckCRC32 = Long.toHexString(crc32.getValue());
//        System.out.println(arrayHex[198]);
//        System.out.println(arrayHex[199]);
//        System.out.println(arrayHex[200]);
//        System.out.println(arrayHex[201]);

        String checkedCRC32 = arrayHex[198] + arrayHex[199] + arrayHex[200] + arrayHex[201];
        //System.out.println(checkedCRC32);
        //System.out.println(Long.toHexString(crc32.getValue()));

        return ((realCheckCRC32.substring(0,2).equals(arrayHex[198]))||("3f".equals(arrayHex[198])))&&
                ((realCheckCRC32.substring(2,4).equals(arrayHex[199]))||("3f".equals(arrayHex[199])))&&
                ((realCheckCRC32.substring(4,6).equals(arrayHex[200]))||("3f".equals(arrayHex[200])))&&
                ((realCheckCRC32.substring(6).equals(arrayHex[201]))||("3f".equals(arrayHex[201])));
        //return checkedCRC32.equals(Long.toHexString(crc32.getValue()));
    }

    /**
     * 测试crc32
     *
     * @param args
     */
    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        byte[] arr = "2018".getBytes();
        System.out.println(arr[0]);
        crc32.update("2018".getBytes());
        System.out.println(Long.toHexString(crc32.getValue()));

    }
}
