package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=iSpanMidterm;encrypt=false";
    private String username = "typhoon";
    private String password = "abc123";

    //取得連線
    public  Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //歸還連線

    public void closeConnection(Connection connection){
        try {
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
