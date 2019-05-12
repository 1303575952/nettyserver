package com.sxu.service.impl;

import com.sxu.db.MongoDBConfiguration;
import com.sxu.entity.WorkingDataTxTsEntity;
import com.sxu.service.WorkingDataTxTsService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class WorkingDataServiceTxTsImpl implements WorkingDataTxTsService {

    private static final Logger LOGGER = Logger.getLogger(WorkingDataServiceTxTsImpl.class);

    /**
     * 脱硫脱硝入mongodb
     *
     * @param workingDataTxTsEntities
     * @throws Exception
     */
    public void insertWorkingDataTxTs(List<WorkingDataTxTsEntity> workingDataTxTsEntities) throws Exception {
        MongoClient mongoClient = MongoDBConfiguration.createMongoDBClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(MongoDBConfiguration.DATABASE_NAME);
        LOGGER.debug("连接数据库" + MongoDBConfiguration.DATABASE_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(MongoDBConfiguration.COLLECTION_NAME_TX_TS);
        LOGGER.debug("选择集合" + MongoDBConfiguration.COLLECTION_NAME_TX_TS);
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < workingDataTxTsEntities.size(); i++) {
            Document document = new Document();
            document.append("publish_time", workingDataTxTsEntities.get(i).getPublishTime());
            document.append("publish_type", workingDataTxTsEntities.get(i).getPublishType());
            document.append("region_id", workingDataTxTsEntities.get(i).getRegionId());
            document.append("industry_id", workingDataTxTsEntities.get(i).getIndustryId());
            document.append("industry_name", workingDataTxTsEntities.get(i).getIndustryName());
            document.append("company_id", workingDataTxTsEntities.get(i).getCompanyId());
            document.append("company_name", workingDataTxTsEntities.get(i).getCompanyName());
            document.append("drain_id", workingDataTxTsEntities.get(i).getDrainId());
            document.append("drain_name", workingDataTxTsEntities.get(i).getDrainName());
            document.append("facility_id", workingDataTxTsEntities.get(i).getFacilityId());
            document.append("facility_number", workingDataTxTsEntities.get(i).getFacilityName());
            document.append("operation_concentration", workingDataTxTsEntities.get(i).getOperationConcentration());
            document.append("operating_efficiency", workingDataTxTsEntities.get(i).getOperatingEfficiency());
            document.append("create_time", workingDataTxTsEntities.get(i).getCreateTime());
            documents.add(document);
        }
        collection.insertMany(documents);

        mongoClient.close();
        LOGGER.debug("关闭连接");
    }
}
