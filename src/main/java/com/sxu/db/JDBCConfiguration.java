package com.huanxin.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConfiguration {
    private static final Logger LOGGER = Logger.getLogger(JDBCConfiguration.class);
    public static String HOST = "rm-****************.mysql.rds.aliyuncs.com";
    public static String PORT = "3306";
    public static String DATABASE_NAME = "*******";
    public static String USER_NAME = "*******";
    public static String PASSWORD = "**************";

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    static Connection connection = null;

    public synchronized static Connection getConn() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME + "?user=" + USER_NAME + "&password=" + PASSWORD + "&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT%2B8";
        connection = DriverManager.getConnection(url);
        LOGGER.debug("成功获取MySQL连接");
        return connection;
    }

    public static void main(String[] args) throws Exception {
        getConn();
    }
}
