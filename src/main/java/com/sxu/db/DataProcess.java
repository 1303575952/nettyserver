package com.huanxin.db;

import com.huanxin.data.WorkingDataProcess;
import com.huanxin.data.WorkingDataTsMinuteProcess;
import com.huanxin.data.WorkingDataTxMinuteProcess;
import com.huanxin.data.WorkingDataTxTsProcess;
import com.huanxin.entity.WorkingDataEntity;
import com.huanxin.entity.WorkingDataTsMinuteEntity;
import com.huanxin.entity.WorkingDataTxMinuteEntity;
import com.huanxin.entity.WorkingDataTxTsEntity;
import com.huanxin.service.WorkingDataService;
import com.huanxin.service.WorkingDataTsMinuteService;
import com.huanxin.service.WorkingDataTxMinuteService;
import com.huanxin.service.WorkingDataTxTsService;
import com.huanxin.service.impl.WorkingDataServiceImpl;
import com.huanxin.service.impl.WorkingDataServiceTxTsImpl;
import com.huanxin.service.impl.WorkingDataTsMinuteServiceImpl;
import com.huanxin.service.impl.WorkingDataTxMinuteServiceImpl;
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
        //原始工况实体对应的6条脱硫脱硝实体公共部分
        List<WorkingDataTxTsEntity> workingDataTxTsEntities = WorkingDataTxTsProcess.getWorkingDataTxTsEntityFromWorkingData(workingDataEntity);
        //原始工况实体对应的每分钟4条脱硝数据
        List<WorkingDataTxMinuteEntity> workingDataTxMinuteEntities = WorkingDataTxMinuteProcess.getWorkingDataTxMinuteEntity(workingDataEntity, workingDataTxTsEntities);
        //原始工况实体对应的每分钟2条脱硫数据
        List<WorkingDataTsMinuteEntity> workingDataTsMinuteEntities = WorkingDataTsMinuteProcess.getWorkingDataTsMinuteEntity(workingDataEntity, workingDataTxTsEntities);


        //处理原始工况实体入库
        WorkingDataService workingDataService = new WorkingDataServiceImpl();
        workingDataService.insertWorkingData(workingDataEntity);

        //处理原始工况实体对应的6条脱硫脱硝实体入库
        WorkingDataTxTsService workingDataTxTsService = new WorkingDataServiceTxTsImpl();
        workingDataTxTsService.insertWorkingDataTxTs(workingDataTxTsEntities);

        //处理原始工况实体对应的每分钟4条脱硝实体入库
        WorkingDataTxMinuteService workingDataTxMinuteService = new WorkingDataTxMinuteServiceImpl();
        workingDataTxMinuteService.insertWorkingDataTxMinute(workingDataTxMinuteEntities);

        //处理原始工况实体对应的每分钟2条脱硫实体入库
        WorkingDataTsMinuteService workingDataTsMinuteService = new WorkingDataTsMinuteServiceImpl();
        workingDataTsMinuteService.insertWorkingDataTsMinute(workingDataTsMinuteEntities);
    }
}
