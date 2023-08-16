package org.example;

public class JDBCdriver {
    public static void main(String[] args) {

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
