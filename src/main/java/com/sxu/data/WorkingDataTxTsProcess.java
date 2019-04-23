package com.huanxin.data;

import com.huanxin.db.JDBCConfiguration;
import com.huanxin.entity.WorkingDataEntity;
import com.huanxin.entity.WorkingDataTxTsEntity;
import com.huanxin.utils.TimeUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkingDataTxTsProcess {
    private static final Logger LOGGER = Logger.getLogger(WorkingDataTxTsProcess.class);

    /**
     * 通过帧拿到工况数据，封装到workingDataEntity中
     *
     * @param workingDataEntity
     * @return
     */
    public static List<WorkingDataTxTsEntity> getWorkingDataTxTsEntityFromWorkingData(WorkingDataEntity workingDataEntity) {

        List<WorkingDataTxTsEntity> workingDataTxTsEntities = new ArrayList<WorkingDataTxTsEntity>();
        String qiyeID = workingDataEntity.getQiyeID();
        Integer regionId = 0;
        Integer industryId = 0;
        Integer companyId = 0;
        String companyName = "";
        Connection connection = null;
        try {
            connection = JDBCConfiguration.getConn();
            PreparedStatement queryCompany = connection.prepareStatement("select * from basic_company where license_number_simple = ?");
            queryCompany.setString(1, qiyeID);
            ResultSet queryCompanySet = queryCompany.executeQuery();
            while (queryCompanySet.next()) {
                regionId = queryCompanySet.getInt("region_id");
                industryId = queryCompanySet.getInt("industry_id");
                companyId = queryCompanySet.getInt("id");
                companyName = queryCompanySet.getString("name");
            }
            queryCompanySet.close();
            queryCompany.close();
            String industryName = "";
            PreparedStatement queryIndustry = connection.prepareStatement("select * from basic_industry where id = ?");
            queryIndustry.setInt(1, industryId);
            ResultSet queryIndustrySet = queryIndustry.executeQuery();
            while (queryIndustrySet.next()) {
                industryName = queryIndustrySet.getString("name");
            }
            queryIndustrySet.close();
            queryIndustry.close();
            Integer drainId = 1;
            String drainName = "";
            PreparedStatement queryDrain = connection.prepareStatement("select * from basic_drain where id = ?");
            queryDrain.setInt(1, drainId);
            ResultSet queryDrainSet = queryDrain.executeQuery();
            while (queryDrainSet.next()) {
                drainName = queryDrainSet.getString("name");
            }
            queryDrainSet.close();
            queryDrain.close();


            String publishTime = TimeUtil.nianyueriFormat(workingDataEntity.getNianyueri()) + " " + workingDataEntity.getShifenmiao_1();
            String createTime = workingDataEntity.getInsert_time();

            WorkingDataTxTsEntity workingDataTxTsEntity_1_a = new WorkingDataTxTsEntity();
            workingDataTxTsEntity_1_a.setPublishTime(publishTime);
            workingDataTxTsEntity_1_a.setPublishType("N");
            workingDataTxTsEntity_1_a.setRegionId(regionId);
            workingDataTxTsEntity_1_a.setIndustryId(industryId);
            workingDataTxTsEntity_1_a.setIndustryName(industryName);
            workingDataTxTsEntity_1_a.setCompanyId(companyId);
            workingDataTxTsEntity_1_a.setCompanyName(companyName);
            workingDataTxTsEntity_1_a.setDrainId(drainId);
            workingDataTxTsEntity_1_a.setDrainName(drainName);
            Integer facilityId_1_a = 1;
            workingDataTxTsEntity_1_a.setFacilityId(facilityId_1_a);
            String facilityNumber_1_a = "";
            PreparedStatement queryFacilityNumber_1_a = connection.prepareStatement("select * from basic_facility where id = ?");
            queryFacilityNumber_1_a.setInt(1, facilityId_1_a);
            ResultSet queryFacilityNumber_1_aSet = queryFacilityNumber_1_a.executeQuery();
            while (queryFacilityNumber_1_aSet.next()) {
                facilityNumber_1_a = queryFacilityNumber_1_aSet.getString("facility_number");
            }
            queryFacilityNumber_1_aSet.close();
            queryFacilityNumber_1_a.close();
            workingDataTxTsEntity_1_a.setFacilityNumber(facilityNumber_1_a);
            workingDataTxTsEntity_1_a.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_1(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_1_a(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_1_a(),
                    workingDataEntity.getAnqiliuliang_1_a()
            ));
            workingDataTxTsEntity_1_a.setOperatingEfficiency(WorkingDataModel.nEfficiency(workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a()));
            workingDataTxTsEntity_1_a.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_1_a);

            WorkingDataTxTsEntity workingDataTxTsEntity_1_b = new WorkingDataTxTsEntity();
            workingDataTxTsEntity_1_b.setPublishTime(publishTime);
            workingDataTxTsEntity_1_b.setPublishType("N");
            workingDataTxTsEntity_1_b.setRegionId(regionId);
            workingDataTxTsEntity_1_b.setIndustryId(industryId);
            workingDataTxTsEntity_1_b.setIndustryName(industryName);
            workingDataTxTsEntity_1_b.setCompanyId(companyId);
            workingDataTxTsEntity_1_b.setCompanyName(companyName);
            workingDataTxTsEntity_1_b.setDrainId(drainId);
            workingDataTxTsEntity_1_b.setDrainName(drainName);
            Integer facilityId_1_b = 2;
            workingDataTxTsEntity_1_b.setFacilityId(facilityId_1_b);
            String facilityNumber_1_b = "";
            PreparedStatement queryFacilityNumber_1_b = connection.prepareStatement("select * from basic_facility where id = ?");
            queryFacilityNumber_1_b.setInt(1, facilityId_1_b);
            ResultSet queryFacilityNumber_1_bSet = queryFacilityNumber_1_b.executeQuery();
            while (queryFacilityNumber_1_bSet.next()) {
                facilityNumber_1_b = queryFacilityNumber_1_bSet.getString("facility_number");
            }
            queryFacilityNumber_1_bSet.close();
            queryFacilityNumber_1_b.close();
            workingDataTxTsEntity_1_b.setFacilityNumber(facilityNumber_1_b);
            workingDataTxTsEntity_1_b.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_1(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_1_b(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_1_b(),
                    workingDataEntity.getAnqiliuliang_1_b()
            ));
            workingDataTxTsEntity_1_b.setOperatingEfficiency(WorkingDataModel.nEfficiency(workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b()));
            workingDataTxTsEntity_1_b.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_1_b);

            WorkingDataTxTsEntity workingDataTxTsEntity_1 = new WorkingDataTxTsEntity();
            workingDataTxTsEntity_1.setPublishTime(publishTime);
            workingDataTxTsEntity_1.setPublishType("S");
            workingDataTxTsEntity_1.setRegionId(regionId);
            workingDataTxTsEntity_1.setIndustryId(industryId);
            workingDataTxTsEntity_1.setIndustryName(industryName);
            workingDataTxTsEntity_1.setCompanyId(companyId);
            workingDataTxTsEntity_1.setCompanyName(companyName);
            workingDataTxTsEntity_1.setDrainId(drainId);
            workingDataTxTsEntity_1.setDrainName(drainName);
            Integer facilityId_1 = 3;
            workingDataTxTsEntity_1.setFacilityId(facilityId_1);
            String facilityNumber_1 = "";
            PreparedStatement queryFacilityNumber_1 = connection.prepareStatement("select * from basic_facility where id = ?");
            queryFacilityNumber_1.setInt(1, facilityId_1);
            ResultSet queryFacilityNumber_1Set = queryFacilityNumber_1.executeQuery();
            while (queryFacilityNumber_1Set.next()) {
                facilityNumber_1 = queryFacilityNumber_1Set.getString("facility_number");
            }
            queryFacilityNumber_1Set.close();
            queryFacilityNumber_1.close();
            workingDataTxTsEntity_1.setFacilityNumber(facilityNumber_1);
            workingDataTxTsEntity_1.setOperationConcentration(WorkingDataModel.sOperationConcentration(
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
            ));
            workingDataTxTsEntity_1.setOperatingEfficiency(WorkingDataModel.sEfficiency(workingDataEntity.getChukouliunongdu_1(),
                    workingDataEntity.getChukouyanqiliang_1(),
                    workingDataEntity.getRukouliunongdu_1(),
                    workingDataEntity.getRukouyanqiliang_1()));
            workingDataTxTsEntity_1.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_1);

            WorkingDataTxTsEntity workingDataTxTsEntity_2_a = new WorkingDataTxTsEntity();
            workingDataTxTsEntity_2_a.setPublishTime(publishTime);
            workingDataTxTsEntity_2_a.setPublishType("N");
            workingDataTxTsEntity_2_a.setRegionId(regionId);
            workingDataTxTsEntity_2_a.setIndustryId(industryId);
            workingDataTxTsEntity_2_a.setIndustryName(industryName);
            workingDataTxTsEntity_2_a.setCompanyId(companyId);
            workingDataTxTsEntity_2_a.setCompanyName(companyName);
            workingDataTxTsEntity_2_a.setDrainId(drainId);
            workingDataTxTsEntity_2_a.setDrainName(drainName);
            Integer facilityId_2_a = 4;
            workingDataTxTsEntity_2_a.setFacilityId(facilityId_2_a);
            String facilityNumber_2_a = "";
            PreparedStatement queryFacilityNumber_2_a = connection.prepareStatement("select * from basic_facility where id = ?");
            queryFacilityNumber_2_a.setInt(1, facilityId_2_a);
            ResultSet queryFacilityNumber_2_aSet = queryFacilityNumber_2_a.executeQuery();
            while (queryFacilityNumber_2_aSet.next()) {
                facilityNumber_2_a = queryFacilityNumber_2_aSet.getString("facility_number");
            }
            queryFacilityNumber_2_aSet.close();
            queryFacilityNumber_2_a.close();
            workingDataTxTsEntity_2_a.setFacilityNumber(facilityNumber_2_a);
            workingDataTxTsEntity_2_a.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_2(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_2_a(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_2_a(),
                    workingDataEntity.getAnqiliuliang_2_a()
            ));
            workingDataTxTsEntity_2_a.setOperatingEfficiency(WorkingDataModel.nEfficiency(workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a()));
            workingDataTxTsEntity_2_a.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_2_a);

            WorkingDataTxTsEntity workingDataTxTsEntity_2_b = new WorkingDataTxTsEntity();
            workingDataTxTsEntity_2_b.setPublishTime(publishTime);
            workingDataTxTsEntity_2_b.setPublishType("N");
            workingDataTxTsEntity_2_b.setRegionId(regionId);
            workingDataTxTsEntity_2_b.setIndustryId(industryId);
            workingDataTxTsEntity_2_b.setIndustryName(industryName);
            workingDataTxTsEntity_2_b.setCompanyId(companyId);
            workingDataTxTsEntity_2_b.setCompanyName(companyName);
            workingDataTxTsEntity_2_b.setDrainId(drainId);
            workingDataTxTsEntity_2_b.setDrainName(drainName);
            Integer facilityId_2_b = 5;
            workingDataTxTsEntity_2_b.setFacilityId(facilityId_2_b);
            String facilityNumber_2_b = "";
            PreparedStatement queryFacilityNumber_2_b = connection.prepareStatement("select * from basic_facility where id = ?");
            queryFacilityNumber_2_b.setInt(1, facilityId_2_b);
            ResultSet queryFacilityNumber_2_bSet = queryFacilityNumber_2_b.executeQuery();
            while (queryFacilityNumber_2_bSet.next()) {
                facilityNumber_2_b = queryFacilityNumber_2_bSet.getString("facility_number");
            }
            queryFacilityNumber_2_bSet.close();
            queryFacilityNumber_2_b.close();
            workingDataTxTsEntity_2_b.setFacilityNumber(facilityNumber_2_b);
            workingDataTxTsEntity_2_b.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_2(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_2_b(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_2_b(),
                    workingDataEntity.getAnqiliuliang_2_b()
            ));
            workingDataTxTsEntity_2_b.setOperatingEfficiency(WorkingDataModel.nEfficiency(
                    workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b()));
            workingDataTxTsEntity_2_b.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_2_b);

            WorkingDataTxTsEntity workingDataTxTsEntity_2 = new WorkingDataTxTsEntity();
            workingDataTxTsEntity_2.setPublishTime(publishTime);
            workingDataTxTsEntity_2.setPublishType("S");
            workingDataTxTsEntity_2.setRegionId(regionId);
            workingDataTxTsEntity_2.setIndustryId(industryId);
            workingDataTxTsEntity_2.setIndustryName(industryName);
            workingDataTxTsEntity_2.setCompanyId(companyId);
            workingDataTxTsEntity_2.setCompanyName(companyName);
            workingDataTxTsEntity_2.setDrainId(drainId);
            workingDataTxTsEntity_2.setDrainName(drainName);
            Integer facilityId_2 = 6;
            workingDataTxTsEntity_2.setFacilityId(facilityId_2);
            String facilityNumber_2 = "";
            PreparedStatement queryFacilityNumber_2 = connection.prepareStatement("select * from basic_facility where id = ?");
            queryFacilityNumber_2.setInt(1, facilityId_2);
            ResultSet queryFacilityNumber_2Set = queryFacilityNumber_2.executeQuery();
            while (queryFacilityNumber_2Set.next()) {
                facilityNumber_2 = queryFacilityNumber_2Set.getString("facility_number");
            }
            queryFacilityNumber_2Set.close();
            queryFacilityNumber_2.close();
            workingDataTxTsEntity_2.setFacilityNumber(facilityNumber_2);
            workingDataTxTsEntity_2.setOperationConcentration(WorkingDataModel.sOperationConcentration(
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
            ));
            workingDataTxTsEntity_2.setOperatingEfficiency(WorkingDataModel.sEfficiency(workingDataEntity.getChukouliunongdu_2(),
                    workingDataEntity.getChukouyanqiliang_2(),
                    workingDataEntity.getRukouliunongdu_2(),
                    workingDataEntity.getRukouyanqiliang_2()));
            workingDataTxTsEntity_2.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_2);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDataTxTsEntities;
    }
}
