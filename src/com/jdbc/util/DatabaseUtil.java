package com.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String DRIVER_PATH="com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://localhost:3306/jdbcdb";
    private static final String USERNAME ="root";
    private static final String PASSWORD="root";
    public DatabaseUtil(){
        try
        {
            Class.forName(DRIVER_PATH);
        }catch (Exception e)
        {
           throw new RuntimeException("Something went wrong"+e);
        }
    }
    public Connection getConnection() throws SQLException
    {
        System.out.println("Database Connection Successful");
       return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

    }


}
