package com.huanxin.db;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

public class MongoDBConfiguration {
    private static final Logger LOGGER = Logger.getLogger(MongoDBConfiguration.class);
    public static final String HOST = "dds-bp1babc036f87d64-pub.mongodb.rds.aliyuncs.com";
    public static final int PORT = 3717;
    public static String USERNAME = "root";
    public static String PASSWORD = "Ws4815115!";
    public static String AUTHENTICATION_DATABASE = "admin";
    public static String DATABASE_NAME = "huanxin";
    public static String COLLECTION_NAME = "source_company_jin_neng_re_dian";
    public static ServerAddress serverAddress = new ServerAddress(HOST, PORT);

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
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);
        Document document = new Document();
        document.append("title", "this is mongodb");
        document.append("description", "database");
        document.append("feather", "so many");
        mongoCollection.insertOne(document);

        mongoClient.close();
    }
}
