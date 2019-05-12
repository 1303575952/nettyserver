package com.sxu.data;

import com.sxu.entity.WorkingDataEntity;
import com.sxu.entity.WorkingDataTxMinuteEntity;
import com.sxu.entity.WorkingDataTxTsEntity;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 脱硝分钟数据
 */
public class WorkingDataTxMinuteProcess {
    private static final Logger LOGGER = Logger.getLogger(WorkingDataTxMinuteProcess.class);

    /**
     * 从工况原始数据和工况脱硫脱硝公共数据得到工况脱硝数据
     *
     * @param workingDataEntity       工况原始数据
     * @param workingDataTxTsEntities 工况脱硫脱硝公共数据
     * @return
     */
    public static List<WorkingDataTxMinuteEntity> getWorkingDataTxMinuteEntity(WorkingDataEntity workingDataEntity, List<WorkingDataTxTsEntity> workingDataTxTsEntities) {
        List<WorkingDataTxMinuteEntity> workingDataTxMinuteEntities = new ArrayList<>();
        for (WorkingDataTxTsEntity workingDataTxTsEntity : workingDataTxTsEntities) {
            if ("N".equals(workingDataTxTsEntity.getPublishType())) {
                String publishTime = workingDataTxTsEntity.getPublishTime();
                Integer industryId = workingDataTxTsEntity.getIndustryId();
                String industryName = workingDataTxTsEntity.getIndustryName();
                Integer companyId = workingDataTxTsEntity.getCompanyId();
                String companyName = workingDataTxTsEntity.getCompanyName();
                Integer drainId = workingDataTxTsEntity.getDrainId();
                String drainName = workingDataTxTsEntity.getDrainName();
                Integer facilityId = workingDataTxTsEntity.getFacilityId();
                String facilityName = workingDataTxTsEntity.getFacilityName();
                Float operationConcentration = workingDataTxTsEntity.getOperationConcentration();
                Float operatingEfficiency = workingDataTxTsEntity.getOperatingEfficiency();

                Float nh3Flow = 0.0f;
                Float outNh3 = 0.0f;
                Float outNo2 = 0.0f;
                Float inNo2 = 0.0f;
                Float aigFlueFlow = 0.0f;
                if (facilityId == 1) {
                    nh3Flow = workingDataEntity.getAnqiliuliang_1_a();
                    outNh3 = workingDataEntity.getSCRfanyingqichukouyanqiNH3nongdu_1_a();
                    outNo2 = workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_a();
                    inNo2 = workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a();
                    aigFlueFlow = (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_a() * workingDataEntity.getRukouyanqiliang_1()) / (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_a() + workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_b());
                } else if (facilityId == 2) {
                    nh3Flow = workingDataEntity.getAnqiliuliang_1_b();
                    outNh3 = workingDataEntity.getSCRfanyingqichukouyanqiNH3nongdu_1_b();
                    outNo2 = workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_b();
                    inNo2 = workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b();
                    aigFlueFlow = (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_b() * workingDataEntity.getRukouyanqiliang_1()) / (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_a() + workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_b());
                } else if (facilityId == 4) {
                    nh3Flow = workingDataEntity.getAnqiliuliang_2_a();
                    outNh3 = workingDataEntity.getSCRfanyingqichukouyanqiNH3nongdu_2_a();
                    outNo2 = workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_a();
                    inNo2 = workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a();
                    aigFlueFlow = (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_a() * workingDataEntity.getRukouyanqiliang_2()) / (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_a() + workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_b());
                } else if (facilityId == 5) {
                    nh3Flow = workingDataEntity.getAnqiliuliang_2_b();
                    outNh3 = workingDataEntity.getSCRfanyingqichukouyanqiNH3nongdu_2_b();
                    outNo2 = workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_b();
                    inNo2 = workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b();
                    aigFlueFlow = (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_b() * workingDataEntity.getRukouyanqiliang_2()) / (workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_a() + workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_b());
                }

                Float emission = operationConcentration * aigFlueFlow;
                String createTime = workingDataTxTsEntity.getCreateTime();

                WorkingDataTxMinuteEntity workingDataTxMinuteEntity = new WorkingDataTxMinuteEntity();
                workingDataTxMinuteEntity.setPublishTime(publishTime);
                workingDataTxMinuteEntity.setIndustryId(industryId);
                workingDataTxMinuteEntity.setIndustryName(industryName);
                workingDataTxMinuteEntity.setCompanyId(companyId);
                workingDataTxMinuteEntity.setCompanyName(companyName);
                workingDataTxMinuteEntity.setDrainId(drainId);
                workingDataTxMinuteEntity.setDrainName(drainName);
                workingDataTxMinuteEntity.setFacilityId(facilityId);
                workingDataTxMinuteEntity.setFacilityName(facilityName);
                workingDataTxMinuteEntity.setOperationConcentration(operationConcentration);
                workingDataTxMinuteEntity.setOperatingEfficiency(operatingEfficiency);
                workingDataTxMinuteEntity.setNh3Flow(nh3Flow);
                workingDataTxMinuteEntity.setOutNh3(outNh3);
                workingDataTxMinuteEntity.setOutNo2(outNo2);
                workingDataTxMinuteEntity.setInNo2(inNo2);
                workingDataTxMinuteEntity.setAigFlueFlow(aigFlueFlow);
                workingDataTxMinuteEntity.setEmission(emission);
                workingDataTxMinuteEntity.setCreateTime(createTime);

                workingDataTxMinuteEntities.add(workingDataTxMinuteEntity);
            } else {
                //非脱硝，跳过
                continue;
            }
        }
        return workingDataTxMinuteEntities;
    }
}
