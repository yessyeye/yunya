package com.xuehai.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author slyart
 * @create 2019/5/6 1:58 PM
 */
public class SQLUtils {

    public static Connection getCon() {
        //数据库连接名称
        String username = "root";
        //数据库连接密码
        String password = "xuehai2018";
        String driver = "com.mysql.jdbc.Driver";
        //其中test为数据库名称
        String url = "jdbc:mysql://192.168.10.32:3306/xh_webmanage";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}