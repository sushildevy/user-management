package com.vastika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "rootp";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return DriverManager.getConnection(URL, USER_NAME,PASSWORD);

    }
}
