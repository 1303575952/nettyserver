package com.sxu.data;

import com.sxu.entity.WorkingDataEntity;
import com.sxu.service.WorkingDataService;
import com.sxu.service.impl.WorkingDataServiceImpl;

public class DataProcess {
    public static void getAndInsertWorkingData2DB(String[] arrayHex){
        WorkingDataEntity workingDataEntity = WorkingDataProcess.getWorkingDataEntityFromFrame(arrayHex);
        WorkingDataService workingDataService = new WorkingDataServiceImpl();
        try {
            workingDataService.insertWorkingData(workingDataEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
