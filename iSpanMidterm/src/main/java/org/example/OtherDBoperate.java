package org.example;

import java.util.List;
import java.util.Scanner;

public class OtherDBoperate {
    public static void main(String[] args) {
        iIndigenousJob ij = new IndigenousDAOimplement();
        IndigenousData indigenousData = new IndigenousData();
        List<tableIndex> tableIndexList = ij.tableCatalog();
        Scanner sc = new Scanner(System.in);


        System.out.println("請選擇要使用的資料庫");
        for (tableIndex tableIndex : tableIndexList) {
            System.out.print(tableIndex.getTableID() + "\t");
            System.out.println(tableIndex.getTableName());
        }
        System.out.println("請輸入要使用的tableID:");
        int dbID = sc.nextInt();
        String dbname = ij.whatMyDBName(dbID);

        //取得資料庫資料
        List<IndigenousData> IndigenousData = ij.findAllIndigenousbyDB(dbname);
        System.out.println("要使用的Table:" + dbname);
        System.out.println("請輸入要使用的功能\n" +
                "0:離開\n" +
                "1:將Table輸出成json\n" +
                "2.等於查詢(特定id查詢)\n" +
                "3:大於/小於查詢\n" +
                "4:BETWEEN查詢 \n" +
                "5:LIKE查詢\n" +
                "6:insert\n" +
                "7:update\n" +
                "8:delete\n" +
                "9:findall\n");
        int function = sc.nextInt();

        while (function != 0) {

            switch (function) {
                case 0:
                    System.out.println("離開");
                    break;

                case 1:
                    System.out.println("將Table輸出為json");
                    System.out.println("請輸入json檔名:");
                    sc.nextLine();
                    String fileName = sc.next();
                    while (!ij.isValidFileName(fileName)) {
                        System.out.println("非法檔名! 檔名包含 / \\ : * ? \" < > |");
                        System.out.print("重新輸入檔名: ");
                        fileName = sc.nextLine();
                    }


                    //將table儲存成json
                    ij.exportToJSON(fileName, dbname);
                    break;

                case 2:
                    System.out.println("依id查詢資料");
                    System.out.println("請要查詢的id:");
                    int id = sc.nextInt();
                    indigenousData = ij.findIndigenousByIDbyDB(id, dbname);
                    System.out.print(indigenousData.getSeq() + "\t");
                    System.out.print(indigenousData.getDatelisted() + "\t");
                    System.out.print(indigenousData.getYear() + "\t");
                    System.out.print(indigenousData.getType() + "\t");
                    System.out.println(indigenousData.getArea() + "\t");
                    break;

                case 3:
                    System.out.println("大於/小於查詢");
                    System.out.println("大於輸入0 小於輸入1");
                    boolean isBigger = sc.nextInt() == 0 ? true : false;
                    System.out.println("輸出資料id大/小於:");
                    int GTLT=sc.nextInt();
                    List<IndigenousData> result = ij.findByGTLT(dbname, GTLT, isBigger);

                    for(IndigenousData data : result) {
                        System.out.print(data.getSeq() + "\t");
                        System.out.print(data.getDatelisted() + "\t");
                        System.out.print(data.getYear() + "\t");
                        System.out.print(data.getType() + "\t");
                        System.out.println(data.getArea() + "\t");
                    }

                    break;


                case 4:
                    System.out.println("BETWEEN查詢");
                    System.out.println("年度(民國)小於:");
                    int beforeYear=sc.nextInt();
                    System.out.println("年度(民國)大於:");
                    int afterYear= sc.nextInt();
                    List<IndigenousData> result2 = ij.findByBetween(dbname, afterYear, beforeYear);

                    for(IndigenousData data : result2) {
                        System.out.print(data.getSeq() + "\t");
                        System.out.print(data.getDatelisted() + "\t");
                        System.out.print(data.getYear() + "\t");
                        System.out.print(data.getType() + "\t");
                        System.out.println(data.getArea() + "\t");
                    }

                    break;
                case 5:
                    System.out.println("LIKE查詢");
                    System.out.println("查詢地區:");
                    sc.nextLine();
                    String area=sc.nextLine();
                    System.out.println("area="+area);
                    List<IndigenousData> result3 = ij.findByLike(dbname, area);
                    System.out.println("area="+area);

                    for(IndigenousData data : result3) {
                        System.out.print(data.getSeq() + "\t");
                        System.out.print(data.getDatelisted() + "\t");
                        System.out.print(data.getYear() + "\t");
                        System.out.println(data.getArea() + "\t");
                    }
                    break;
                case 6:
                    System.out.println("insert");
                    indigenousData.setSeq(241);
                    indigenousData.setDatelisted("40960801");
                    indigenousData.setYear("2169");
                    indigenousData.setType("कुल");
                    indigenousData.setArea("पूर्वी प्रशांत क्षेत्र");
                    indigenousData.setTotalpercent(100);
                    indigenousData.setLegislatorsAndManagerspercent(10);
                    indigenousData.setProfessionalspercent(10);
                    indigenousData.setTechnicianAndassistantTechnicianpercent(10);
                    indigenousData.setClericalSupportWorkerpercent(10);
                    indigenousData.setServiceAndsalesWorkerpercent(10);
                    indigenousData.setPrimaryIndustrialWorkerpercent(10);
                    indigenousData.setCraftAndRelatedWorkerpercent(10);
                    indigenousData.setMachineryOperatorAndAssemblerpercent(10);
                    indigenousData.setElementaryWorkerLaborerpercent(20);
                    indigenousData.setSampleCount(2000);
                    indigenousData.setPopulationCount(200000);
                    System.out.println(ij.insertIndigenousbyDB(dbname,indigenousData));
                    System.out.println("已成功insert一筆資料到"+dbname+"!");
                    break;
                case 7:
                    System.out.println("update");
                    indigenousData.setSeq(2);
                    indigenousData.setDatelisted("20230401");
                    indigenousData.setYear("103");
                    indigenousData.setType("行政區域");
                    indigenousData.setArea("山地鄉");
                    indigenousData.setTotalpercent(100);
                    indigenousData.setLegislatorsAndManagerspercent(1.11283254623413f);
                    indigenousData.setProfessionalspercent(6.62034893035889f);
                    indigenousData.setTechnicianAndassistantTechnicianpercent(5.00412321090698f);
                    indigenousData.setClericalSupportWorkerpercent(5.06338214874268f);
                    indigenousData.setServiceAndsalesWorkerpercent(17.7972068786621f);
                    indigenousData.setPrimaryIndustrialWorkerpercent(12.9910745620728f);
                    indigenousData.setCraftAndRelatedWorkerpercent(16.9891948699951f);
                    indigenousData.setMachineryOperatorAndAssemblerpercent(13.399510383606f);
                    indigenousData.setElementaryWorkerLaborerpercent(21.0223274230957f);
                    indigenousData.setSampleCount(9266.37890625f);
                    indigenousData.setPopulationCount(72242.8515625f);
                    System.out.println(ij.updateIndigenousbyDB(dbname,indigenousData));
                    System.out.println("已成功update資料到"+dbname+"的2行");
                    break;
                case 8:
                    System.out.println("delete");
                    System.out.println("請輸入要刪除的資料行的id:");
                    int deleteID = sc.nextInt();
                    System.out.println(ij.deleteIndigenousByIDByDB(deleteID,dbname));
                    System.out.println("成功删掉"+deleteID+"行的資料");
                    break;
                case 9:
                    System.out.println("findall");
                    List<IndigenousData> IndigenousDataList = ij.findAllIndigenousbyDB(dbname);
                    for (IndigenousData ind : IndigenousDataList) {
                        System.out.print(ind.getSeq() + "\t");
                        System.out.print(ind.getDatelisted() + "\t");
                        System.out.print(ind.getYear() + "\t");
                        System.out.print(ind.getType() + "\t");
                        System.out.print(ind.getArea() + "\t");
                        System.out.print(ind.getTotalpercent() + "\t");

                        System.out.println("已找到"+dbname+"所有資料，共有"+IndigenousDataList.size()+"筆，在此列出部分");
                    }
                    break;
                default:
                    System.out.println("請重新輸入");
            }
            System.out.println("*********************");
            System.out.println("使用中Table:" + dbname);
            System.out.println("再次輸入要使用的功能\n" +
                    "0:離開\n" +
                    "1:將Table輸出成json\n" +
                    "2.等於查詢(特定id查詢)\n" +
                    "3:大於/小於查詢\n" +
                    "4:BETWEEN查詢 \n" +
                    "5:LIKE查詢\n" +
                    "6:insert\n" +
                    "7:update\n" +
                    "8:delete\n" +
                    "9:findall\n");
            function = sc.nextInt();

        }
    }
}
