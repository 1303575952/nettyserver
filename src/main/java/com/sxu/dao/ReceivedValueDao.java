package com.sxu.dao;

import com.sxu.config.JDBCConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReceivedValueDao {
    public static void insertReceivedValue(String hexValue, String textValue) throws Exception {
        Connection connection = JDBCConfiguration.getConn();
        PreparedStatement insertReceivedValue = connection.prepareStatement("insert into received_value (hex_value, text_value) values (?,?)");
        insertReceivedValue.setString(1, hexValue);
        insertReceivedValue.setString(2, textValue);
        insertReceivedValue.executeUpdate();
        insertReceivedValue.close();
        connection.close();
        System.out.println("连接关闭");
    }
}
