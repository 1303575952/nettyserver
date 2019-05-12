package com.sxu.db;

import com.sxu.data.WorkingDataProcess;
import com.sxu.data.WorkingDataTsMinuteProcess;
import com.sxu.data.WorkingDataTxMinuteProcess;
import com.sxu.data.WorkingDataTxTsProcess;
import com.sxu.entity.WorkingDataEntity;
import com.sxu.entity.WorkingDataTsMinuteEntity;
import com.sxu.entity.WorkingDataTxMinuteEntity;
import com.sxu.entity.WorkingDataTxTsEntity;
import com.sxu.service.WorkingDataService;
import com.sxu.service.WorkingDataTsMinuteService;
import com.sxu.service.WorkingDataTxMinuteService;
import com.sxu.service.WorkingDataTxTsService;
import com.sxu.service.impl.WorkingDataServiceImpl;
import com.sxu.service.impl.WorkingDataServiceTxTsImpl;
import com.sxu.service.impl.WorkingDataTsMinuteServiceImpl;
import com.sxu.service.impl.WorkingDataTxMinuteServiceImpl;
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
        //原始工况实体
        WorkingDataEntity workingDataEntity = WorkingDataProcess.getWorkingDataEntityFromFrame(arrayHex);
        //处理原始工况实体入库
        WorkingDataService workingDataService = new WorkingDataServiceImpl();
        workingDataService.insertWorkingData(workingDataEntity);

        //原始工况实体对应的6条脱硫脱硝实体公共部分
        List<WorkingDataTxTsEntity> workingDataTxTsEntities = WorkingDataTxTsProcess.getWorkingDataTxTsEntityFromWorkingData(workingDataEntity);
        //处理原始工况实体对应的6条脱硫脱硝实体入库
        WorkingDataTxTsService workingDataTxTsService = new WorkingDataServiceTxTsImpl();
        workingDataTxTsService.insertWorkingDataTxTs(workingDataTxTsEntities);

        //原始工况实体对应的每分钟4条脱硝数据
        List<WorkingDataTxMinuteEntity> workingDataTxMinuteEntities = WorkingDataTxMinuteProcess.getWorkingDataTxMinuteEntity(workingDataEntity, workingDataTxTsEntities);
        //处理原始工况实体对应的每分钟4条脱硝实体入库
        WorkingDataTxMinuteService workingDataTxMinuteService = new WorkingDataTxMinuteServiceImpl();
        workingDataTxMinuteService.insertWorkingDataTxMinute(workingDataTxMinuteEntities);

        //原始工况实体对应的每分钟2条脱硫数据
        List<WorkingDataTsMinuteEntity> workingDataTsMinuteEntities = WorkingDataTsMinuteProcess.getWorkingDataTsMinuteEntity(workingDataEntity, workingDataTxTsEntities);
        //处理原始工况实体对应的每分钟2条脱硫实体入库
        WorkingDataTsMinuteService workingDataTsMinuteService = new WorkingDataTsMinuteServiceImpl();
        workingDataTsMinuteService.insertWorkingDataTsMinute(workingDataTsMinuteEntities);
    }
}
