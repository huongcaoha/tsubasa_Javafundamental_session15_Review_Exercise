package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/ProductManagement?createDatabaseIfNotExist=true";
    private static final String USERNAME = "root" ;
    private static final String PASSWORD = "12345678" ;

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại : " + e.getMessage());
            return null;
        }

    }
}
