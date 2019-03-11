package com.sxu.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConfiguration {
    public static String HOST = "39.96.33.44";
    public static String PORT = "3306";
    public static String DATABASE_NAME = "received_usr_info";
    public static String USER_NAME = "root";
    public static String PASSWORD = "root";

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
        System.out.println("成功获取连接");
        return connection;
    }
}
