package org.example;

import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        iIndigenousJob ij = new IndigenousDAOimplement();
        IndigenousData indigenousData = new IndigenousData();
        List<IndigenousData> IndigenousData = ij.RearOnlineCSV();
        Scanner sc = new Scanner(System.in);




        /*列出整張表*/
//        List<IndigenousData> IndigenousData = ij.findAllIndigenous();
        for (IndigenousData typhoon : ij.findAllIndigenous()) {
            System.out.print(typhoon.getSeq()+"\t");
            System.out.print(typhoon.getDatelisted()+"\t");
            System.out.print(typhoon.getYear()+"\t");
            System.out.print(typhoon.getType()+"\t");
            System.out.print(typhoon.getArea()+"\t");
            System.out.print(typhoon.getTotalpercent()+"\t");

            System.out.println();
        }
        /*照id尋找*/

        System.out.println("請輸入查詢資料行的id");
        int num = sc.nextInt();
        IndigenousData ind = ij.findIndigenousByID(num);
        System.out.print(ind.getSeq() + "\t");
        System.out.print(ind.getDatelisted() + "\t");
        System.out.print(ind.getYear() + "\t");
        System.out.print(ind.getType() + "\t");
        System.out.print(ind.getArea() + "\t");



        /*照id insert*/
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
        System.out.println(ij.insertIndigenous(indigenousData));



        /*照id update*/

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
        System.out.println(ij.updateIndigenous(indigenousData));

        /*照id 刪除元素*/
        /*如果有人亂輸入id我就完了
        但我懶得用try catch了(ﾟ∀。)*/

        System.out.println("請輸入要刪除的資料行的id:");
        int deleteID = sc.nextInt();
        System.out.println(ij.deleteIndigenousByID(deleteID));

    }

}