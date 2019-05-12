package com.sxu.data;

import com.sxu.entity.WorkingDataEntity;
import com.sxu.entity.WorkingDataTsMinuteEntity;
import com.sxu.entity.WorkingDataTxTsEntity;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 脱硫分钟数据
 */
public class WorkingDataTsMinuteProcess {
    private static final Logger LOGGER = Logger.getLogger(WorkingDataTsMinuteProcess.class);

    /**
     * 从工况原始数据和工况脱硫脱硝公共数据得到工况脱硫数据
     *
     * @param workingDataEntity       工况原始数据
     * @param workingDataTxTsEntities 工况脱硫脱硝公共数据
     * @return
     */
    public static List<WorkingDataTsMinuteEntity> getWorkingDataTsMinuteEntity(WorkingDataEntity workingDataEntity, List<WorkingDataTxTsEntity> workingDataTxTsEntities) {
        //存放4条脱硫分钟数据
        List<WorkingDataTsMinuteEntity> workingDataTsMinuteEntities = new ArrayList<>();
        for (WorkingDataTxTsEntity workingDataTxTsEntity : workingDataTxTsEntities) {
            //工况脱硫脱硝公共数据中是关于脱硫的，则进行处理
            if ("S".equals(workingDataTxTsEntity.getPublishType())) {
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

                Float calciumSulfurRatio = 0.0f;
                Float liquidGasRatio = 0.0f;

                Float pulpSupply = 0.0f;
                Float ph = 0.0f;
                Integer circulating_pump1_witching_stateX = 0;
                Integer circulating_pump2_witching_stateX = 0;
                Integer circulating_pump3_witching_stateX = 0;
                Integer circulating_pump4_witching_stateX = 0;
                Float exportSmokeDust = 0.0f;
                Float inletGasVolume = 0.0f;
                if (facilityId == 3) {
                    calciumSulfurRatio = WorkingDataModel.calciumSulfurRatio(
                            workingDataEntity.getRukouyanqiliang_1(),
                            workingDataEntity.getRukouliunongdu_1(),
                            workingDataEntity.getRukouO2nongdu_1(),
                            workingDataEntity.getRukouyanwen_1(),
                            workingDataEntity.getShihuishigongjiangliang_1(),
                            0.95f,
                            workingDataEntity.getShihuishijiangyemidu_1(),
                            String.valueOf(workingDataEntity.getNo1xunhuanbengkaiguanzhuangtai_1() +
                                    workingDataEntity.getNo2xunhuanbengkaiguanzhuangtai_1() +
                                    workingDataEntity.getNo3xunhuanbengkaiguanzhuangtai_1() +
                                    workingDataEntity.getNo4xunhuanbengkaiguanzhuangtai_1()
                            )
                    );
                    liquidGasRatio = WorkingDataModel.liquidGasRatio(
                            workingDataEntity.getRukouyanqiliang_1(),
                            workingDataEntity.getRukouliunongdu_1(),
                            workingDataEntity.getRukouO2nongdu_1(),
                            workingDataEntity.getRukouyanwen_1(),
                            workingDataEntity.getShihuishigongjiangliang_1(),
                            0.95f,
                            workingDataEntity.getShihuishijiangyemidu_1(),
                            String.valueOf(workingDataEntity.getNo1xunhuanbengkaiguanzhuangtai_1() +
                                    workingDataEntity.getNo2xunhuanbengkaiguanzhuangtai_1() +
                                    workingDataEntity.getNo3xunhuanbengkaiguanzhuangtai_1() +
                                    workingDataEntity.getNo4xunhuanbengkaiguanzhuangtai_1()
                            )
                    );
                    pulpSupply = workingDataEntity.getShihuishijiangyemidu_1();
                    ph = workingDataEntity.getPHzhi_1();
                    circulating_pump1_witching_stateX = workingDataEntity.getNo1xunhuanbengkaiguanzhuangtai_1();
                    circulating_pump2_witching_stateX = workingDataEntity.getNo2xunhuanbengkaiguanzhuangtai_1();
                    circulating_pump3_witching_stateX = workingDataEntity.getNo3xunhuanbengkaiguanzhuangtai_1();
                    circulating_pump4_witching_stateX = workingDataEntity.getNo4xunhuanbengkaiguanzhuangtai_1();
                    exportSmokeDust = workingDataEntity.getChukouyanqifenchendu_1();
                    inletGasVolume = workingDataEntity.getChukouyanqiliang_1();
                } else if (facilityId == 6) {
                    calciumSulfurRatio = WorkingDataModel.calciumSulfurRatio(
                            workingDataEntity.getRukouyanqiliang_2(),
                            workingDataEntity.getRukouliunongdu_2(),
                            workingDataEntity.getRukouO2nongdu_2(),
                            workingDataEntity.getRukouyanwen_2(),
                            workingDataEntity.getShihuishigongjiangliang_2(),
                            0.95f,
                            workingDataEntity.getShihuishijiangyemidu_2(),
                            String.valueOf(workingDataEntity.getNo1xunhuanbengkaiguanzhuangtai_2() +
                                    workingDataEntity.getNo2xunhuanbengkaiguanzhuangtai_2() +
                                    workingDataEntity.getNo3xunhuanbengkaiguanzhuangtai_2() +
                                    workingDataEntity.getNo4xunhuanbengkaiguanzhuangtai_2()
                            )
                    );
                    liquidGasRatio = WorkingDataModel.liquidGasRatio(
                            workingDataEntity.getRukouyanqiliang_2(),
                            workingDataEntity.getRukouliunongdu_2(),
                            workingDataEntity.getRukouO2nongdu_2(),
                            workingDataEntity.getRukouyanwen_2(),
                            workingDataEntity.getShihuishigongjiangliang_2(),
                            0.95f,
                            workingDataEntity.getShihuishijiangyemidu_2(),
                            String.valueOf(workingDataEntity.getNo1xunhuanbengkaiguanzhuangtai_2() +
                                    workingDataEntity.getNo2xunhuanbengkaiguanzhuangtai_2() +
                                    workingDataEntity.getNo3xunhuanbengkaiguanzhuangtai_2() +
                                    workingDataEntity.getNo4xunhuanbengkaiguanzhuangtai_2()
                            )
                    );
                    pulpSupply = workingDataEntity.getShihuishijiangyemidu_2();
                    ph = workingDataEntity.getPHzhi_2();
                    circulating_pump1_witching_stateX = workingDataEntity.getNo1xunhuanbengkaiguanzhuangtai_2();
                    circulating_pump2_witching_stateX = workingDataEntity.getNo2xunhuanbengkaiguanzhuangtai_2();
                    circulating_pump3_witching_stateX = workingDataEntity.getNo3xunhuanbengkaiguanzhuangtai_2();
                    circulating_pump4_witching_stateX = workingDataEntity.getNo4xunhuanbengkaiguanzhuangtai_2();
                    exportSmokeDust = workingDataEntity.getChukouyanqifenchendu_2();
                    inletGasVolume = workingDataEntity.getChukouyanqiliang_2();
                }
                Float emission = operationConcentration * inletGasVolume;
                String createTime = workingDataTxTsEntity.getCreateTime();

                WorkingDataTsMinuteEntity workingDataTsMinuteEntity = new WorkingDataTsMinuteEntity();
                workingDataTsMinuteEntity.setPublishTime(publishTime);
                workingDataTsMinuteEntity.setIndustryId(industryId);
                workingDataTsMinuteEntity.setIndustryName(industryName);
                workingDataTsMinuteEntity.setCompanyId(companyId);
                workingDataTsMinuteEntity.setCompanyName(companyName);
                workingDataTsMinuteEntity.setDrainId(drainId);
                workingDataTsMinuteEntity.setDrainName(drainName);
                workingDataTsMinuteEntity.setFacilityId(facilityId);
                workingDataTsMinuteEntity.setFacilityName(facilityName);
                workingDataTsMinuteEntity.setOperationConcentration(operationConcentration);
                workingDataTsMinuteEntity.setOperatingEfficiency(operatingEfficiency);
                workingDataTsMinuteEntity.setCalciumSulfurRatio(calciumSulfurRatio);
                workingDataTsMinuteEntity.setLiquidGasRatio(liquidGasRatio);
                workingDataTsMinuteEntity.setPulpSupply(pulpSupply);
                workingDataTsMinuteEntity.setPh(ph);
                workingDataTsMinuteEntity.setCirculating_pump1_witching_state(circulating_pump1_witching_stateX);
                workingDataTsMinuteEntity.setCirculating_pump2_witching_state(circulating_pump2_witching_stateX);
                workingDataTsMinuteEntity.setCirculating_pump3_witching_state(circulating_pump3_witching_stateX);
                workingDataTsMinuteEntity.setCirculating_pump4_witching_state(circulating_pump4_witching_stateX);
                workingDataTsMinuteEntity.setExportSmokeDust(exportSmokeDust);
                workingDataTsMinuteEntity.setInletGasVolume(inletGasVolume);
                workingDataTsMinuteEntity.setEmissions(emission);
                workingDataTsMinuteEntity.setCreateTime(createTime);
                workingDataTsMinuteEntities.add(workingDataTsMinuteEntity);
            } else {
                //非脱硫，跳过
                continue;
            }
        }
        return workingDataTsMinuteEntities;
    }
}
