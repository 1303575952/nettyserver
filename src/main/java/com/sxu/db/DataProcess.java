package com.huanxin.db;

import com.huanxin.data.WorkingDataProcess;
import com.huanxin.data.WorkingDataTxTsProcess;
import com.huanxin.entity.WorkingDataEntity;
import com.huanxin.entity.WorkingDataTxTsEntity;
import com.huanxin.service.WorkingDataService;
import com.huanxin.service.WorkingDataTxTsService;
import com.huanxin.service.impl.WorkingDataServiceImpl;
import com.huanxin.service.impl.WorkingDataServiceTxTsImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class DataProcess {
    private static final Logger LOGGER = Logger.getLogger(DataProcess.class);

    /**
     * 拿到工况数据并入库
     *
     * @param arrayHex
     */
    public static void getAndInsertWorkingData2DB(String[] arrayHex) throws Exception {
        WorkingDataEntity workingDataEntity = WorkingDataProcess.getWorkingDataEntityFromFrame(arrayHex);
        List<WorkingDataTxTsEntity> workingDataTxTsEntities = WorkingDataTxTsProcess.getWorkingDataTxTsEntityFromWorkingData(workingDataEntity);

        WorkingDataService workingDataService = new WorkingDataServiceImpl();
        workingDataService.insertWorkingData(workingDataEntity);

        WorkingDataTxTsService workingDataTxTsService = new WorkingDataServiceTxTsImpl();
        workingDataTxTsService.insertWorkingDataTxTs(workingDataTxTsEntities);
    }
}
