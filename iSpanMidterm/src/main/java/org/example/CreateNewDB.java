package org.example;

import java.util.List;
import java.util.Scanner;

public class CreateNewDB {
    public static void main(String[] args) {
        iIndigenousJob ij = new IndigenousDAOimplement();
        IndigenousData indigenousData = new IndigenousData();
        List<IndigenousData> IndigenousData = ij.RearOnlineCSV();
        Scanner sc = new Scanner(System.in);
        int newTableID = 0;


        System.out.print("輸入資料表名稱: ");
        String dbname = sc.nextLine();

        while (!ij.isValidTableName(dbname)) {
            System.out.println("非法的資料表名稱! 名稱包含 / \\ : * ? \" < > |");
            System.out.print("重新輸入資料表名稱: ");
            dbname = sc.nextLine();
        }

        newTableID = ij.CREATENewDB(dbname);
        System.out.println(dbname + "的ID:" + newTableID);
        for (IndigenousData IndigData : IndigenousData) {
            ij.insertIndigenousbyDB(dbname,IndigData);
            //System.out.println(IndigData);
//            System.out.println("insert "+IndigData+" to "+dbname);
            //System.out.println(IndigData.toString());
        }
        System.out.println("建立新資料表完成");
    }
}
