package com.sxu.db;

import com.sxu.data.WorkingDataProcess;
import com.sxu.entity.WorkingDataEntity;
import com.sxu.service.WorkingDataService;
import com.sxu.service.impl.WorkingDataServiceImpl;
import org.apache.log4j.Logger;

public class DataProcess {
    private static final Logger LOGGER = Logger.getLogger(DataProcess.class);

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
}
