package com.sxu.service.impl;

import com.sxu.db.MongoDBConfiguration;
import com.sxu.entity.WorkingDataTxMinuteEntity;
import com.sxu.service.WorkingDataTxMinuteService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class WorkingDataTxMinuteServiceImpl implements WorkingDataTxMinuteService {

    private static final Logger LOGGER = Logger.getLogger(WorkingDataTxMinuteServiceImpl.class);

    @Override
    public void insertWorkingDataTxMinute(List<WorkingDataTxMinuteEntity> workingDataTxMinuteEntities) throws Exception {
        MongoClient mongoClient = MongoDBConfiguration.createMongoDBClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(MongoDBConfiguration.DATABASE_NAME);
        LOGGER.debug("连接数据库" + MongoDBConfiguration.DATABASE_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(MongoDBConfiguration.COLLECTION_NAME_TX_MINUTE);
        LOGGER.debug("选择集合" + MongoDBConfiguration.COLLECTION_NAME_TX_MINUTE);
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < workingDataTxMinuteEntities.size(); i++) {
            Document document = new Document();
            document.append("publish_time", workingDataTxMinuteEntities.get(i).getPublishTime());
            document.append("industry_id", workingDataTxMinuteEntities.get(i).getIndustryId());
            document.append("industry_name", workingDataTxMinuteEntities.get(i).getIndustryName());
            document.append("company_id", workingDataTxMinuteEntities.get(i).getCompanyId());
            document.append("company_name", workingDataTxMinuteEntities.get(i).getCompanyName());
            document.append("drain_id", workingDataTxMinuteEntities.get(i).getDrainId());
            document.append("drain_name", workingDataTxMinuteEntities.get(i).getDrainName());
            document.append("facility_id", workingDataTxMinuteEntities.get(i).getFacilityId());
            document.append("facility_name", workingDataTxMinuteEntities.get(i).getFacilityName());
            document.append("operation_concentration", workingDataTxMinuteEntities.get(i).getOperationConcentration());
            document.append("operating_efficiency", workingDataTxMinuteEntities.get(i).getOperatingEfficiency());
            document.append("nh3_flow", workingDataTxMinuteEntities.get(i).getNh3Flow());
            document.append("out_nh3", workingDataTxMinuteEntities.get(i).getOutNh3());
            document.append("out_no2", workingDataTxMinuteEntities.get(i).getOutNo2());
            document.append("in_no2", workingDataTxMinuteEntities.get(i).getInNo2());
            document.append("aig_flue_flow", workingDataTxMinuteEntities.get(i).getAigFlueFlow());
            document.append("emission", workingDataTxMinuteEntities.get(i).getEmission());
            document.append("create_time", workingDataTxMinuteEntities.get(i).getCreateTime());

            documents.add(document);
        }
        collection.insertMany(documents);

        mongoClient.close();
        LOGGER.debug("关闭连接");
    }
}
