package com.sxu.data;

import com.sxu.db.JDBCConfiguration;
import com.sxu.entity.WorkingDataEntity;
import com.sxu.entity.WorkingDataTxTsEntity;
import com.sxu.utils.TimeUtil;
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
     * <p>
     * 查 basic_company 得到 区域编号region_id 行业编号industry_id 公司编号id 公司名称name
     * 查 basic_industry 得到 行业名称name
     * 查 basic_drain 得到 排口名称name
     * 查 basic_facility 得到 设施编号id
     *
     * @param workingDataEntity
     * @return
     */
    public static List<WorkingDataTxTsEntity> getWorkingDataTxTsEntityFromWorkingData(WorkingDataEntity workingDataEntity) {

        //脱硫脱硝数据放入workingDataTxTsEntities
        List<WorkingDataTxTsEntity> workingDataTxTsEntities = new ArrayList<WorkingDataTxTsEntity>();

        //一条完整工况数据中脱硫脱硝公共部分
        String qiyeID = workingDataEntity.getQiyeID();
        Integer regionId = 0;
        Integer industryId = 0;
        Integer companyId = 0;
        String companyName = "";
        Connection connection = null;
        try {
            connection = JDBCConfiguration.getConn();
            PreparedStatement queryCompany = connection.prepareStatement("select * from basic_company where license_number_simple = ? limit 1");
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
            Integer drainId = Integer.valueOf(workingDataEntity.getPaikoubianhao());
            String drainName = "";
            PreparedStatement queryDrain = connection.prepareStatement("select * from basic_drain where data_from_paikoubianhao = ? and company_id = ?");
            queryDrain.setInt(1, drainId);
            queryDrain.setInt(2, companyId);
            ResultSet queryDrainSet = queryDrain.executeQuery();
            while (queryDrainSet.next()) {
                drainName = queryDrainSet.getString("name");
            }
            queryDrainSet.close();
            queryDrain.close();
            String publishTime = TimeUtil.nianyueriFormat(workingDataEntity.getNianyueri()) + " " + workingDataEntity.getShifenmiao_1();
            String createTime = workingDataEntity.getInsert_time();

            /**
             * 1机组1脱硝
             */
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

            String facilityName_1_a = workingDataEntity.getGongyileixingTX_1_a() +
                    "-" +
                    workingDataEntity.getJizubianhao_1() +
                    workingDataEntity.getGuolubianhao_1() +
                    workingDataEntity.getZhilisheshibianhao_1_a();
            PreparedStatement queryFacilityName_1_a = connection.prepareStatement("select * from basic_facility where name = ? and company_id = ?");
            queryFacilityName_1_a.setString(1, facilityName_1_a);
            queryFacilityName_1_a.setInt(2, companyId);
            Integer facilityId_1_a = 0;
            ResultSet queryFacilityName_1_aSet = queryFacilityName_1_a.executeQuery();
            while (queryFacilityName_1_aSet.next()) {
                facilityId_1_a = queryFacilityName_1_aSet.getInt("id");
            }
            workingDataTxTsEntity_1_a.setFacilityId(facilityId_1_a);

            queryFacilityName_1_aSet.close();
            queryFacilityName_1_a.close();
            workingDataTxTsEntity_1_a.setFacilityName(facilityName_1_a);
            workingDataTxTsEntity_1_a.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_1(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_1_a(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_1_a(),
                    workingDataEntity.getAnqiliuliang_1_a()
            ));
            /*workingDataTxTsEntity_1_a.setOperatingEfficiency(
                    WorkingDataModel.nEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a()
                    )
            );*/
            workingDataTxTsEntity_1_a.setOperatingEfficiency(
                    WorkingDataModel.nModelEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b()
                    )
            );
            workingDataTxTsEntity_1_a.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_1_a);

            /**
             * 1机组2脱硝
             */
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

            String facilityName_1_b = workingDataEntity.getGongyileixingTX_1_b() +
                    "-" +
                    workingDataEntity.getJizubianhao_1() +
                    workingDataEntity.getGuolubianhao_1() +
                    workingDataEntity.getZhilisheshibianhao_1_b();
            PreparedStatement queryFacilityName_1_b = connection.prepareStatement("select * from basic_facility where name = ? and company_id = ?");
            queryFacilityName_1_b.setString(1, facilityName_1_b);
            queryFacilityName_1_b.setInt(2, companyId);
            Integer facilityId_1_b = 0;
            ResultSet queryFacilityName_1_bSet = queryFacilityName_1_b.executeQuery();
            while (queryFacilityName_1_bSet.next()) {
                facilityId_1_b = queryFacilityName_1_bSet.getInt("id");
            }
            workingDataTxTsEntity_1_b.setFacilityId(facilityId_1_b);

            queryFacilityName_1_bSet.close();
            queryFacilityName_1_b.close();
            workingDataTxTsEntity_1_b.setFacilityName(facilityName_1_b);
            workingDataTxTsEntity_1_b.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_1(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_1_b(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_1_b(),
                    workingDataEntity.getAnqiliuliang_1_b()
            ));
            /*workingDataTxTsEntity_1_b.setOperatingEfficiency(
                    WorkingDataModel.nEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b()
                    )
            );*/
            workingDataTxTsEntity_1_b.setOperatingEfficiency(
                    WorkingDataModel.nModelEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_1_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_1_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_1_b()
                    )
            );
            workingDataTxTsEntity_1_b.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_1_b);

            /**
             * 1机组脱硫
             */
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

            String facilityName_1 = workingDataEntity.getGongyileixingTS_1() +
                    "-" +
                    workingDataEntity.getJizubianhao_1() +
                    workingDataEntity.getGuolubianhao_1();
            PreparedStatement queryFacilityName_1 = connection.prepareStatement("select * from basic_facility where name = ? and company_id = ?");
            queryFacilityName_1.setString(1, facilityName_1);
            queryFacilityName_1.setInt(2, companyId);
            Integer facilityId_1 = 0;
            ResultSet queryFacilityName_1Set = queryFacilityName_1.executeQuery();
            while (queryFacilityName_1Set.next()) {
                facilityId_1 = queryFacilityName_1Set.getInt("id");
            }
            workingDataTxTsEntity_1.setFacilityId(facilityId_1);

            queryFacilityName_1Set.close();
            queryFacilityName_1.close();
            workingDataTxTsEntity_1.setFacilityName(facilityName_1);
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
            /*workingDataTxTsEntity_1.setOperatingEfficiency(
                    WorkingDataModel.sEfficiency(workingDataEntity.getChukouliunongdu_1(),
                    workingDataEntity.getChukouyanqiliang_1(),
                    workingDataEntity.getRukouliunongdu_1(),
                    workingDataEntity.getRukouyanqiliang_1()
                    )
            );*/
            workingDataTxTsEntity_1.setOperatingEfficiency(
                    WorkingDataModel.sModelEfficiency(
                            workingDataEntity.getRukouyanqiliang_1(),
                            workingDataEntity.getChukouyanqiliang_1(),
                            workingDataEntity.getRukouliunongdu_1(),
                            workingDataEntity.getChukouliunongdu_1()
                    )
            );
            workingDataTxTsEntity_1.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_1);

            /**
             * 2机组1脱硝
             */
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

            String facilityName_2_a = workingDataEntity.getGongyileixingTX_2_a() +
                    "-" +
                    workingDataEntity.getJizubianhao_2() +
                    workingDataEntity.getGuolubianhao_2() +
                    workingDataEntity.getZhilisheshibianhao_2_a();
            PreparedStatement queryFacilityName_2_a = connection.prepareStatement("select * from basic_facility where name = ? and company_id = ?");
            queryFacilityName_2_a.setString(1, facilityName_2_a);
            queryFacilityName_2_a.setInt(2, companyId);
            Integer facilityId_2_a = 0;
            ResultSet queryFacilityName_2_aSet = queryFacilityName_2_a.executeQuery();
            while (queryFacilityName_2_aSet.next()) {
                facilityId_2_a = queryFacilityName_2_aSet.getInt("id");
            }
            workingDataTxTsEntity_2_a.setFacilityId(facilityId_2_a);

            queryFacilityName_2_aSet.close();
            queryFacilityName_2_a.close();
            workingDataTxTsEntity_2_a.setFacilityName(facilityName_2_a);
            workingDataTxTsEntity_2_a.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_2(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_2_a(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_2_a(),
                    workingDataEntity.getAnqiliuliang_2_a()
            ));
            /*workingDataTxTsEntity_2_a.setOperatingEfficiency(
                    WorkingDataModel.nEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_a(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a()
                    )
            );*/
            workingDataTxTsEntity_2_a.setOperatingEfficiency(
                    WorkingDataModel.nModelEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b()
                    )
            );
            workingDataTxTsEntity_2_a.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_2_a);

            /**
             * 2机组2脱硝
             */
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

            String facilityName_2_b = workingDataEntity.getGongyileixingTX_2_b() +
                    "-" +
                    workingDataEntity.getJizubianhao_2() +
                    workingDataEntity.getGuolubianhao_2() +
                    workingDataEntity.getZhilisheshibianhao_2_b();
            PreparedStatement queryFacilityName_2_b = connection.prepareStatement("select * from basic_facility where name = ? and company_id = ?");
            queryFacilityName_2_b.setString(1, facilityName_2_b);
            queryFacilityName_2_b.setInt(2, companyId);
            Integer facilityId_2_b = 0;
            ResultSet queryFacilityName_2_bSet = queryFacilityName_2_b.executeQuery();
            while (queryFacilityName_2_bSet.next()) {
                facilityId_2_b = queryFacilityName_2_bSet.getInt("id");
            }
            workingDataTxTsEntity_2_b.setFacilityId(facilityId_2_b);

            queryFacilityName_2_bSet.close();
            queryFacilityName_2_b.close();
            workingDataTxTsEntity_2_b.setFacilityName(facilityName_2_b);
            workingDataTxTsEntity_2_b.setOperationConcentration(WorkingDataModel.nOperationConcentration(
                    workingDataEntity.getRukouyanqiliang_2(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b(),
                    workingDataEntity.getSCRfanyingqiXAIGqianyandaoO2nongdu_2_b(),
                    workingDataEntity.getSCRfanyingqiXjinkouyanqiwendu1_2_b(),
                    workingDataEntity.getAnqiliuliang_2_b()
            ));
            /*workingDataTxTsEntity_2_b.setOperatingEfficiency(
                    WorkingDataModel.nEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b()
                    )
            );*/
            workingDataTxTsEntity_2_b.setOperatingEfficiency(
                    WorkingDataModel.nModelEfficiency(
                            workingDataEntity.getSCRfanyingqichukouyanqiNOXnongdu_2_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_a(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoliuliang_2_b(),
                            workingDataEntity.getSCRfanyingqiXAIGqianyandaoyanqiNOXnongdu_2_b()
                    )
            );
            workingDataTxTsEntity_2_b.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_2_b);

            /**
             * 2机组脱硫
             */
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

            String facilityName_2 = workingDataEntity.getGongyileixingTS_2() +
                    "-" +
                    workingDataEntity.getJizubianhao_2() +
                    workingDataEntity.getGuolubianhao_2();
            PreparedStatement queryFacilityName_2 = connection.prepareStatement("select * from basic_facility where name = ? and company_id = ?");
            queryFacilityName_2.setString(1, facilityName_2);
            queryFacilityName_2.setInt(2, companyId);
            Integer facilityId_2 = 0;
            ResultSet queryFacilityName_2Set = queryFacilityName_2.executeQuery();
            while (queryFacilityName_2Set.next()) {
                facilityId_2 = queryFacilityName_2Set.getInt("id");
            }
            workingDataTxTsEntity_2.setFacilityId(facilityId_2);

            queryFacilityName_2Set.close();
            queryFacilityName_2.close();
            workingDataTxTsEntity_2.setFacilityName(facilityName_2);
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
            /*workingDataTxTsEntity_2.setOperatingEfficiency(
                    WorkingDataModel.sEfficiency(
                            workingDataEntity.getChukouliunongdu_2(),
                            workingDataEntity.getChukouyanqiliang_2(),
                            workingDataEntity.getRukouliunongdu_2(),
                            workingDataEntity.getRukouyanqiliang_2()
                    )
            );*/
            workingDataTxTsEntity_2.setOperatingEfficiency(
                    WorkingDataModel.sModelEfficiency(
                            workingDataEntity.getRukouyanqiliang_2(),
                            workingDataEntity.getChukouyanqiliang_2(),
                            workingDataEntity.getRukouliunongdu_2(),
                            workingDataEntity.getChukouliunongdu_2()
                    )
            );
            workingDataTxTsEntity_2.setCreateTime(createTime);
            workingDataTxTsEntities.add(workingDataTxTsEntity_2);

            connection.close();
            LOGGER.debug("关闭MySQL连接");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDataTxTsEntities;
    }
}
