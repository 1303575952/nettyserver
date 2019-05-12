package com.sxu.service.impl;

import com.sxu.db.MongoDBConfiguration;
import com.sxu.entity.WorkingDataTsMinuteEntity;
import com.sxu.service.WorkingDataTsMinuteService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class WorkingDataTsMinuteServiceImpl implements WorkingDataTsMinuteService {
    private static final Logger LOGGER = Logger.getLogger(WorkingDataTsMinuteServiceImpl.class);

    @Override
    public void insertWorkingDataTsMinute(List<WorkingDataTsMinuteEntity> workingDataTsMinuteEntities) throws Exception {
        MongoClient mongoClient = MongoDBConfiguration.createMongoDBClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(MongoDBConfiguration.DATABASE_NAME);
        System.out.println("连接数据库" + MongoDBConfiguration.DATABASE_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(MongoDBConfiguration.COLLECTION_NAME_TS_MINUTE);
        System.out.println("选择集合" + MongoDBConfiguration.COLLECTION_NAME_TS_MINUTE);
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < workingDataTsMinuteEntities.size(); i++) {
            Document document = new Document();
            document.append("publish_time", workingDataTsMinuteEntities.get(i).getPublishTime());
            document.append("industry_id", workingDataTsMinuteEntities.get(i).getIndustryId());
            document.append("industry_name", workingDataTsMinuteEntities.get(i).getIndustryName());
            document.append("company_id", workingDataTsMinuteEntities.get(i).getCompanyId());
            document.append("company_name", workingDataTsMinuteEntities.get(i).getCompanyName());
            document.append("drain_id", workingDataTsMinuteEntities.get(i).getDrainId());
            document.append("drain_name", workingDataTsMinuteEntities.get(i).getDrainName());
            document.append("facility_id", workingDataTsMinuteEntities.get(i).getFacilityId());
            document.append("facility_name", workingDataTsMinuteEntities.get(i).getFacilityName());
            document.append("operation_concentration", workingDataTsMinuteEntities.get(i).getOperationConcentration());
            document.append("operating_efficiency", workingDataTsMinuteEntities.get(i).getOperatingEfficiency());
            document.append("calcium_sulfur_ratio", workingDataTsMinuteEntities.get(i).getCalciumSulfurRatio());
            document.append("liquid_gas_ratio", workingDataTsMinuteEntities.get(i).getLiquidGasRatio());
            document.append("pulp_supply", workingDataTsMinuteEntities.get(i).getPulpSupply());
            document.append("ph", workingDataTsMinuteEntities.get(i).getPh());
            document.append("circulating_pump1_witching_stateX", workingDataTsMinuteEntities.get(i).getCirculating_pump1_witching_state());
            document.append("circulating_pump2_witching_stateX", workingDataTsMinuteEntities.get(i).getCirculating_pump2_witching_state());
            document.append("circulating_pump3_witching_stateX", workingDataTsMinuteEntities.get(i).getCirculating_pump3_witching_state());
            document.append("circulating_pump4_witching_stateX", workingDataTsMinuteEntities.get(i).getCirculating_pump4_witching_state());
            document.append("export_smoke_dust", workingDataTsMinuteEntities.get(i).getExportSmokeDust());
            document.append("inlet_gas_volume", workingDataTsMinuteEntities.get(i).getInletGasVolume());
            document.append("emissions", workingDataTsMinuteEntities.get(i).getEmissions());
            document.append("create_time", workingDataTsMinuteEntities.get(i).getCreateTime());
            documents.add(document);
        }
        collection.insertMany(documents);

        mongoClient.close();
        LOGGER.debug("关闭连接");
    }
}
