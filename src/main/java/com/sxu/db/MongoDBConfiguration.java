package com.sxu.db;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

public class MongoDBConfiguration {
    private static final Logger LOGGER = Logger.getLogger(MongoDBConfiguration.class);
    private static final String HOST = "dds-***-pub.mongodb.rds.aliyuncs.com";
    private static final int PORT = 3717;
    private static String USERNAME = "root";
    private static String PASSWORD = "***!";
    private static String AUTHENTICATION_DATABASE = "admin";
    public static String DATABASE_NAME = "hx";

    public static String COLLECTION_NAME_COMPANY = "source_company_jin_neng_re_dian";
    public static String COLLECTION_NAME_TX_TS = "company_industry_monitor_common_minute";
    public static String COLLECTION_NAME_TX_MINUTE = "company_industry_monitor_nitre_minute";
    public static String COLLECTION_NAME_TS_MINUTE = "company_industry_monitor_sulfur_minute";

    private static ServerAddress serverAddress = new ServerAddress(HOST, PORT);

    public static MongoClient createMongoDBClient() {
        //mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
        String url = "mongodb://" + USERNAME + ":" + PASSWORD + "@" + serverAddress + "/" + AUTHENTICATION_DATABASE;
        System.out.println(url);
        MongoClientURI connectionString = new MongoClientURI(url);
        return new MongoClient(connectionString);
    }


    public static void main(String[] args) {
        MongoClient mongoClient = createMongoDBClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME_COMPANY);
        Document document = new Document();
        document.append("title", "this is mongodb");
        document.append("description", "database");
        document.append("feather", "so many");
        mongoCollection.insertOne(document);

        mongoClient.close();
    }
}
