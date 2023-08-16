package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class IndigenousDAOimplement implements iIndigenousJob {

    @Override
    public IndigenousData findIndigenousByID(int id) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        IndigenousData IndigenousData = new IndigenousData();
        String sql = "SELECT TOP (1)  [Seq]\n" +
                "      ,[DateListed]\n" +
                "      ,[年度]\n" +
                "      ,[類別]\n" +
                "      ,[項目別]\n" +
                "      ,[總計]\n" +
                "      ,[民意代表_主管及經理人員]\n" +
                "      ,[專業人員]\n" +
                "      ,[技術員及助理專業人員]\n" +
                "      ,[事務支援人員]\n" +
                "      ,[服務及銷售工作人員]\n" +
                "      ,[農_林_漁_牧業生產人員]\n" +
                "      ,[技藝有關工作人員]\n" +
                "      ,[機械設備操作及組裝人員]\n" +
                "      ,[基層技術工及勞力工]\n" +
                "      ,[樣本數_人]\n" +
                "      ,[母體數_人]\n" +
                "  FROM [dbo].[IndigenousJob]\n" +
                "  WHERE Seq=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            IndigenousData indigenousData = new IndigenousData();
            boolean i = false;
            if (i = rs.next()) {
                System.out.println(i);
                indigenousData.setDatelisted(rs.getString(2));
                indigenousData.setYear(rs.getString(3));
                indigenousData.setType(rs.getString(4));
                indigenousData.setArea(rs.getString(5));
                indigenousData.setTotalpercent(rs.getFloat(6));
                indigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                indigenousData.setSeq(rs.getInt(1));
                indigenousData.setProfessionalspercent(rs.getFloat(8));
                indigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                indigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                indigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                indigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                indigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                indigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                indigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                indigenousData.setSampleCount(rs.getFloat(16));
                indigenousData.setPopulationCount(rs.getFloat(17));

            }
            return indigenousData;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }

        return null;
    }

    @Override
    public IndigenousData findIndigenousByIDbyDB(int id, String dbname) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        IndigenousData IndigenousData = new IndigenousData();
        String sql = "SELECT  [Seq]\n" +
                "      ,[DateListed]\n" +
                "      ,[year]\n" +
                "      ,[type]\n" +
                "      ,[area]\n" +
                "      ,[totalpercent]\n" +
                "      ,[legislatorsAndManagerspercent]\n" +
                "      ,[professionalspercent]\n" +
                "      ,[technicianAndassistantTechnicianpercent]\n" +
                "      ,[clericalSupportWorkerpercent]\n" +
                "      ,[serviceAndsalesWorkerpercent]\n" +
                "      ,[primaryIndustrialWorkerpercent]\n" +
                "      ,[craftAndRelatedWorkerpercent]\n" +
                "      ,[machineryOperatorAndAssemblerpercent]\n" +
                "      ,[elementaryWorkerLaborerpercent]\n" +
                "      ,[sampleCount]\n" +
                "      ,[populationCount]\n" +
                "  FROM [iSpanMidterm].[dbo].[" + dbname + "]\n" +
                "  WHERE Seq=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            IndigenousData indigenousData = new IndigenousData();
            boolean i = false;
            if (i = rs.next()) {
                System.out.println(i);
                indigenousData.setDatelisted(rs.getString(2));
                indigenousData.setYear(rs.getString(3));
                indigenousData.setType(rs.getString(4));
                indigenousData.setArea(rs.getString(5));
                indigenousData.setTotalpercent(rs.getFloat(6));
                indigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                indigenousData.setSeq(rs.getInt(1));
                indigenousData.setProfessionalspercent(rs.getFloat(8));
                indigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                indigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                indigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                indigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                indigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                indigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                indigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                indigenousData.setSampleCount(rs.getFloat(16));
                indigenousData.setPopulationCount(rs.getFloat(17));

            }
            return indigenousData;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }

        return null;
    }

    @Override
    public List<IndigenousData> findAllIndigenous() {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        List<IndigenousData> IndigenousDataList = new ArrayList<>();
        String sql = "SELECT  [Seq]\n" +
                "      ,[DateListed]\n" +
                "      ,[年度]\n" +
                "      ,[類別]\n" +
                "      ,[項目別]\n" +
                "      ,[總計]\n" +
                "      ,[民意代表_主管及經理人員]\n" +
                "      ,[專業人員]\n" +
                "      ,[技術員及助理專業人員]\n" +
                "      ,[事務支援人員]\n" +
                "      ,[服務及銷售工作人員]\n" +
                "      ,[農_林_漁_牧業生產人員]\n" +
                "      ,[技藝有關工作人員]\n" +
                "      ,[機械設備操作及組裝人員]\n" +
                "      ,[基層技術工及勞力工]\n" +
                "      ,[樣本數_人]\n" +
                "      ,[母體數_人]\n" +
                "  FROM [iSpanMidterm].[dbo].[IndigenousJob]\n";
        try (Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                IndigenousData IndigenousData = new IndigenousData();
                IndigenousData.setSeq(rs.getInt(1));
                IndigenousData.setDatelisted(rs.getString(2));
                IndigenousData.setYear(rs.getString(3));
                IndigenousData.setType(rs.getString(4));
                IndigenousData.setArea(rs.getString(5));
                IndigenousData.setTotalpercent(rs.getInt(6));
                IndigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                IndigenousData.setProfessionalspercent(rs.getFloat(8));
                IndigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                IndigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                IndigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                IndigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                IndigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                IndigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                IndigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                IndigenousData.setSampleCount(rs.getFloat(16));
                IndigenousData.setPopulationCount(rs.getFloat(17));
                IndigenousDataList.add(IndigenousData);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            connectionutil.closeConnection(connection);
        }
        return IndigenousDataList;

    }


    public List<IndigenousData> RearOnlineCSV() {
        List<IndigenousData> dataList = new ArrayList<>();

        try {
            URL url = new URL("https://data.cip.gov.tw/API/v1/dump/datastore/A53000000A-112031-003");
            InputStream openStream = url.openStream();
            InputStreamReader isr = new InputStreamReader(openStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                Object[] values = line.split(",");

                IndigenousData indigenousData = new IndigenousData();

                // data.setSeq(Integer.parseInt(values[0]));
                // data.setDatelisted(values[1]);
                // data.setYear(values[2]);
                indigenousData.setSeq(Integer.parseInt(values[0].toString()));

//                indigenousData.setDatelisted(values[1].toString());
                indigenousData.setDatelisted(removeHeadAndTail(values[1].toString()));
                indigenousData.setYear(removeHeadAndTail(values[2].toString()));
                indigenousData.setType(removeHeadAndTail(values[3].toString()));
                indigenousData.setArea(removeHeadAndTail(values[4].toString()));
//                System.out.println("convert(values[5].toString())= "+convert(values[5].toString()));
                indigenousData.setTotalpercent(convert(values[5].toString()));
                indigenousData.setLegislatorsAndManagerspercent(convert(values[6].toString()));
//                System.out.println("convert(values[6].toString())= "+convert(values[6].toString()));
                indigenousData.setProfessionalspercent(convert(values[7].toString()));
//                System.out.println("convert(values[7].toString())= "+convert(values[7].toString()));
                indigenousData.setTechnicianAndassistantTechnicianpercent(convert(values[8].toString()));
//                System.out.println("convert(values[8].toString())= "+convert(values[8].toString()));
                indigenousData.setClericalSupportWorkerpercent(convert(values[9].toString()));
//                System.out.println("convert(values[9].toString())= "+convert(values[9].toString()));
                indigenousData.setServiceAndsalesWorkerpercent(convert(values[10].toString()));
//                System.out.println("convert(values[10].toString())= "+convert(values[10].toString()));
                indigenousData.setPrimaryIndustrialWorkerpercent(convert(values[11].toString()));
//                System.out.println("convert(values[11].toString())= "+convert(values[11].toString()));
                indigenousData.setCraftAndRelatedWorkerpercent(convert(values[12].toString()));
//                System.out.println("convert(values[12].toString())= "+convert(values[12].toString()));
                indigenousData.setMachineryOperatorAndAssemblerpercent(convert(values[13].toString()));
//                System.out.println("convert(values[13].toString())= "+convert(values[13].toString()));
                indigenousData.setElementaryWorkerLaborerpercent(convert(values[14].toString()));
//                System.out.println("convert(values[14].toString())= "+convert(values[14].toString()));
                indigenousData.setSampleCount(convert(values[15].toString()));
//                System.out.println("convert(values[15].toString())= "+convert(values[15].toString()));
                indigenousData.setPopulationCount(convert(values[16].toString()));
//                System.out.println("convert(values[16].toString())= "+convert(values[16].toString()));
//                indigenousData.setSeq(Integer.decode((String) values[0]));
//                indigenousData.setDatelisted((String) values[1]);
//                indigenousData.setYear((String) values[2]);
//                indigenousData.setType((String) values[3]);
//                indigenousData.setArea((String) values[4]);
//                indigenousData.setTotalpercent(Integer.parseInt(String.valueOf(5)));
//                indigenousData.setLegislatorsAndManagerspercent(Float.parseFloat(String.valueOf(6)));
//                indigenousData.setProfessionalspercent(Float.parseFloat(String.valueOf(7)));
//                indigenousData.setTechnicianAndassistantTechnicianpercent(Float.parseFloat(String.valueOf(8)));
//                indigenousData.setClericalSupportWorkerpercent(Float.parseFloat(String.valueOf(9)));
//                indigenousData.setServiceAndsalesWorkerpercent(Float.parseFloat(String.valueOf(10)));
//                indigenousData.setPrimaryIndustrialWorkerpercent(Float.parseFloat(String.valueOf(11)));
//                indigenousData.setCraftAndRelatedWorkerpercent(Float.parseFloat(String.valueOf(12)));
//                indigenousData.setMachineryOperatorAndAssemblerpercent(Float.parseFloat(String.valueOf(13)));
//                indigenousData.setElementaryWorkerLaborerpercent(Float.parseFloat(String.valueOf(14)));
//                indigenousData.setSampleCount(Float.parseFloat(String.valueOf(15)));
//                indigenousData.setPopulationCount(Float.parseFloat(String.valueOf(16)));

                dataList.add(indigenousData);
            }

        } catch (MalformedURLException e) {
            // TODO: handle exception
            e.printStackTrace();

        } catch (Exception e) {
            // 捕捉剩餘所有異常
            e.printStackTrace();
        }


        return dataList;
    }

    @Override
    public int CREATENewDB(String dbname) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();

        //在tableIndex新增dbname資料
        String sql="INSERT INTO [dbo].[tableIndex]\n" +
                "           ([tableName])\n" +
                "     VALUES\n" +
                "           (?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dbname);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //建立新資料庫
        sql = "CREATE TABLE " + dbname +
                "(Seq int,\n" +
                "DateListed nvarchar(10),\n" +
                "year nvarchar(10),\n" +
                "type nvarchar(50),\n" +
                "area nvarchar(50),\n" +
                "totalpercent float,\n" +
                "legislatorsAndManagerspercent float,\n" +
                "professionalspercent float,\n" +
                "technicianAndassistantTechnicianpercent float,\n" +
                "clericalSupportWorkerpercent float,\n" +
                "serviceAndsalesWorkerpercent float,\n" +
                "primaryIndustrialWorkerpercent float,\n" +
                "craftAndRelatedWorkerpercent float,\n" +
                "machineryOperatorAndAssemblerpercent float,\n" +
                "elementaryWorkerLaborerpercent float,\n" +
                "sampleCount float,\n" +
                "populationCount float);\n";


        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //取得新資料庫ID並回傳
        sql = "SELECT TOP (1) [tableID] FROM [iSpanMidterm].[dbo].[tableIndex] ORDER BY [tableID] DESC;";
        int sqlID = 0;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
//            System.out.println("sqlID="+sqlID);
            if (rs.next()) {
                sqlID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return sqlID;
    }


    @Override
    public boolean updateIndigenous(IndigenousData t) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "UPDATE [dbo].[IndigenousJob]\n" +
                "   SET [Seq] = ?\n" +
                "      ,[DateListed] = ?\n" +
                "      ,[年度] = ?\n" +
                "      ,[類別] = ?\n" +
                "      ,[項目別] = ?\n" +
                "      ,[總計] = ?\n" +
                "      ,[民意代表_主管及經理人員] = ?\n" +
                "      ,[專業人員] = ?\n" +
                "      ,[技術員及助理專業人員] = ?\n" +
                "      ,[事務支援人員] = ?\n" +
                "      ,[服務及銷售工作人員] = ?\n" +
                "      ,[農_林_漁_牧業生產人員] = ?\n" +
                "      ,[技藝有關工作人員] = ?\n" +
                "      ,[機械設備操作及組裝人員] = ?\n" +
                "      ,[基層技術工及勞力工] = ?\n" +
                "      ,[樣本數_人] = ?\n" +
                "      ,[母體數_人] = ?\n" +
                " WHERE Seq=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, t.getSeq());
            stmt.setString(2, t.getDatelisted());
            stmt.setString(3, t.getYear());
            stmt.setString(4, t.getType());
            stmt.setString(5, t.getArea());
            stmt.setFloat(6, t.getTotalpercent());
            stmt.setFloat(7, t.getLegislatorsAndManagerspercent());
            stmt.setFloat(8, t.getProfessionalspercent());
            stmt.setFloat(9, t.getTechnicianAndassistantTechnicianpercent());
            stmt.setFloat(10, t.getClericalSupportWorkerpercent());
            stmt.setFloat(11, t.getServiceAndsalesWorkerpercent());
            stmt.setFloat(12, t.getPrimaryIndustrialWorkerpercent());
            stmt.setFloat(13, t.getCraftAndRelatedWorkerpercent());
            stmt.setFloat(14, t.getMachineryOperatorAndAssemblerpercent());
            stmt.setFloat(15, t.getElementaryWorkerLaborerpercent());
            stmt.setFloat(16, t.getSampleCount());
            stmt.setFloat(17, t.getPopulationCount());
            stmt.setInt(18, t.getSeq());
            int c = stmt.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return false;

    }

    @Override
    public boolean updateIndigenousbyDB(String dbname, IndigenousData t) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "UPDATE [dbo].[" + dbname + "]\n" +
                "   SET [Seq] = ?\n" +
                "      ,[DateListed] = ?\n" +
                "      ,[year] = ?\n" +
                "      ,[type] = ?\n" +
                "      ,[area] = ?\n" +
                "      ,[totalpercent] = ?\n" +
                "      ,[legislatorsAndManagerspercent] = ?\n" +
                "      ,[professionalspercent] = ?\n" +
                "      ,[technicianAndassistantTechnicianpercent] = ?\n" +
                "      ,[clericalSupportWorkerpercent] = ?\n" +
                "      ,[serviceAndsalesWorkerpercent] = ?\n" +
                "      ,[primaryIndustrialWorkerpercent] = ?\n" +
                "      ,[craftAndRelatedWorkerpercent] = ?\n" +
                "      ,[machineryOperatorAndAssemblerpercent] = ?\n" +
                "      ,[elementaryWorkerLaborerpercent] = ?\n" +
                "      ,[sampleCount] = ?\n" +
                "      ,[populationCount] = ?\n" +
                " WHERE Seq=?";

//        sql = "CREATE TABLE " + dbname +
//                "(Seq int,\n" +
//                "DateListed nvarchar(10),\n" +
//                "year nvarchar(10),\n" +
//                "type nvarchar(50),\n" +
//                "area nvarchar(50),\n" +
//                "totalpercent float,\n" +
//                "legislatorsAndManagerspercent float,\n" +
//                "professionalspercent float,\n" +
//                "technicianAndassistantTechnicianpercent float,\n" +
//                "clericalSupportWorkerpercent float,\n" +
//                "serviceAndsalesWorkerpercent float,\n" +
//                "primaryIndustrialWorkerpercent float,\n" +
//                "craftAndRelatedWorkerpercent float,\n" +
//                "machineryOperatorAndAssemblerpercent float,\n" +
//                "elementaryWorkerLaborerpercent float,\n" +
//                "sampleCount float,\n" +
//                "populationCount float);\n";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, t.getSeq());
            stmt.setString(2, t.getDatelisted());
            stmt.setString(3, t.getYear());
            stmt.setString(4, t.getType());
            stmt.setString(5, t.getArea());
            stmt.setFloat(6, t.getTotalpercent());
            stmt.setFloat(7, t.getLegislatorsAndManagerspercent());
            stmt.setFloat(8, t.getProfessionalspercent());
            stmt.setFloat(9, t.getTechnicianAndassistantTechnicianpercent());
            stmt.setFloat(10, t.getClericalSupportWorkerpercent());
            stmt.setFloat(11, t.getServiceAndsalesWorkerpercent());
            stmt.setFloat(12, t.getPrimaryIndustrialWorkerpercent());
            stmt.setFloat(13, t.getCraftAndRelatedWorkerpercent());
            stmt.setFloat(14, t.getMachineryOperatorAndAssemblerpercent());
            stmt.setFloat(15, t.getElementaryWorkerLaborerpercent());
            stmt.setFloat(16, t.getSampleCount());
            stmt.setFloat(17, t.getPopulationCount());
            stmt.setInt(18, t.getSeq());
            int c = stmt.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return false;

    }

    @Override
    public boolean insertIndigenous(IndigenousData t) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "INSERT INTO [dbo].[IndigenousJob]\n" +
                "           ([Seq]\n" +
                "           ,[DateListed]\n" +
                "           ,[年度]\n" +
                "           ,[類別]\n" +
                "           ,[項目別]\n" +
                "           ,[總計]\n" +
                "           ,[民意代表_主管及經理人員]\n" +
                "           ,[專業人員]\n" +
                "           ,[技術員及助理專業人員]\n" +
                "           ,[事務支援人員]\n" +
                "           ,[服務及銷售工作人員]\n" +
                "           ,[農_林_漁_牧業生產人員]\n" +
                "           ,[技藝有關工作人員]\n" +
                "           ,[機械設備操作及組裝人員]\n" +
                "           ,[基層技術工及勞力工]\n" +
                "           ,[樣本數_人]\n" +
                "           ,[母體數_人])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setInt(1, t.getSeq());
            stmt.setString(2, t.getDatelisted());
            stmt.setString(3, t.getYear());
            stmt.setString(4, t.getType());
            stmt.setString(5, t.getArea());
            stmt.setFloat(6, t.getTotalpercent());
            stmt.setFloat(7, t.getLegislatorsAndManagerspercent());
            stmt.setFloat(8, t.getProfessionalspercent());
            stmt.setFloat(9, t.getTechnicianAndassistantTechnicianpercent());
            stmt.setFloat(10, t.getClericalSupportWorkerpercent());
            stmt.setFloat(11, t.getServiceAndsalesWorkerpercent());
            stmt.setFloat(12, t.getPrimaryIndustrialWorkerpercent());
            stmt.setFloat(13, t.getCraftAndRelatedWorkerpercent());
            stmt.setFloat(14, t.getMachineryOperatorAndAssemblerpercent());
            stmt.setFloat(15, t.getElementaryWorkerLaborerpercent());
            stmt.setFloat(16, t.getSampleCount());
            stmt.setFloat(17, t.getPopulationCount());
            int c = stmt.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return false;

    }

    @Override
    public boolean insertIndigenousbyDB(String dbname, IndigenousData t) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "INSERT INTO [dbo].[" + dbname + "]\n" +
                "           ([Seq]\n" +
                "           ,[DateListed]\n" +
                "           ,[year]\n" +
                "           ,[type]\n" +
                "           ,[area]\n" +
                "           ,[totalpercent]\n" +
                "           ,[legislatorsAndManagerspercent]\n" +
                "           ,[professionalspercent]\n" +
                "           ,[technicianAndassistantTechnicianpercent]\n" +
                "           ,[clericalSupportWorkerpercent]\n" +
                "           ,[serviceAndsalesWorkerpercent]\n" +
                "           ,[primaryIndustrialWorkerpercent]\n" +
                "           ,[craftAndRelatedWorkerpercent]\n" +
                "           ,[machineryOperatorAndAssemblerpercent]\n" +
                "           ,[elementaryWorkerLaborerpercent]\n" +
                "           ,[sampleCount]\n" +
                "           ,[populationCount])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        try (PreparedStatement stmt = connection.prepareStatement(sql);) {

            stmt.setInt(1, t.getSeq());
            stmt.setString(2, t.getDatelisted());
            stmt.setString(3, t.getYear());
            stmt.setString(4, t.getType());
            stmt.setString(5, t.getArea());
            float totalpercent = t.getTotalpercent();
//            System.out.println("totalpercent="+totalpercent);
            stmt.setFloat(6, totalpercent);
            stmt.setFloat(7, t.getLegislatorsAndManagerspercent());
            stmt.setFloat(8, t.getProfessionalspercent());
            stmt.setFloat(9, t.getTechnicianAndassistantTechnicianpercent());
            stmt.setFloat(10, t.getClericalSupportWorkerpercent());
            stmt.setFloat(11, t.getServiceAndsalesWorkerpercent());
            stmt.setFloat(12, t.getPrimaryIndustrialWorkerpercent());
            stmt.setFloat(13, t.getCraftAndRelatedWorkerpercent());
            stmt.setFloat(14, t.getMachineryOperatorAndAssemblerpercent());
            stmt.setFloat(15, t.getElementaryWorkerLaborerpercent());
            stmt.setFloat(16, t.getSampleCount());
            stmt.setFloat(17, t.getPopulationCount());
            int c = stmt.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return false;
    }


    @Override
    public boolean deleteIndigenousByID(int id) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "DELETE FROM [dbo].[IndigenousJob] WHERE Seq=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, id);
            int c = stmt.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean deleteIndigenousByIDByDB(int id, String dbname) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "DELETE FROM [dbo].[" + dbname + "] WHERE Seq=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, id);
            int c = stmt.executeUpdate();
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionutil.closeConnection(connection);
        }
        return false;
    }


    @Override
    public List<IndigenousData> findAllIndigenousbyDB(String dbname) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        List<IndigenousData> IndigenousDataList = new ArrayList<>();
        String sql = "SELECT  [Seq]\n" +
                "      ,[DateListed]\n" +
                "      ,[year]\n" +
                "      ,[type]\n" +
                "      ,[area]\n" +
                "      ,[totalpercent]\n" +
                "      ,[legislatorsAndManagerspercent]\n" +
                "      ,[professionalspercent]\n" +
                "      ,[technicianAndassistantTechnicianpercent]\n" +
                "      ,[clericalSupportWorkerpercent]\n" +
                "      ,[serviceAndsalesWorkerpercent]\n" +
                "      ,[primaryIndustrialWorkerpercent]\n" +
                "      ,[craftAndRelatedWorkerpercent]\n" +
                "      ,[machineryOperatorAndAssemblerpercent]\n" +
                "      ,[elementaryWorkerLaborerpercent]\n" +
                "      ,[sampleCount]\n" +
                "      ,[populationCount]\n" +
                "  FROM [iSpanMidterm].[dbo].[" + dbname + "]";
        try (Statement stmt = connection.createStatement()) {
//            stmt.setString(1, dbname);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                IndigenousData IndigenousData = new IndigenousData();
                IndigenousData.setSeq(rs.getInt(1));
                IndigenousData.setDatelisted(rs.getString(2));
                IndigenousData.setYear(rs.getString(3));
                IndigenousData.setType(rs.getString(4));
                IndigenousData.setArea(rs.getString(5));
                IndigenousData.setTotalpercent(rs.getInt(6));
                IndigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                IndigenousData.setProfessionalspercent(rs.getFloat(8));
                IndigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                IndigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                IndigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                IndigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                IndigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                IndigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                IndigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                IndigenousData.setSampleCount(rs.getFloat(16));
                IndigenousData.setPopulationCount(rs.getFloat(17));
                IndigenousDataList.add(IndigenousData);

            }
            return IndigenousDataList;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            connectionutil.closeConnection(connection);
        }
        return null;
    }

    public boolean isValidTableName(String tableName) {
        if (!Character.isLetter(tableName.charAt(0))) {
            return false;
        }
        for (char c : tableName.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    public boolean isValidFileName(String fileName) {
        return !fileName.contains("/") &&
                !fileName.contains("\\") &&
                !fileName.contains(":") &&
                !fileName.contains("*") &&
                !fileName.contains("?") &&
                !fileName.contains("\"") &&
                !fileName.contains("<") &&
                !fileName.contains(">") &&
                !fileName.contains("|");
    }

    public List<tableIndex> tableCatalog() {

        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        List<tableIndex> tableIndexList = new ArrayList<>();
        String sql = "SELECT  [tableID]\n" +
                "      ,[tableName]\n" +
                "  FROM [iSpanMidterm].[dbo].[tableIndex]";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tableIndex tableIndex = new tableIndex();
                tableIndex.setTableID(rs.getInt(1));
                tableIndex.setTableName(rs.getString(2));
                tableIndexList.add(tableIndex);
            }
            return tableIndexList;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            connectionutil.closeConnection(connection);
        }
        return tableIndexList;
    }

    public String whatMyDBName(int ID) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "SELECT  [tableName]\n" +
                "  FROM [iSpanMidterm].[dbo].[tableIndex]\n" +
                "  WHERE [tableID] = " + ID;
//        System.out.println(sql);
        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            connectionutil.closeConnection(connection);
        }


        return null;
    }

    @Override
    public boolean exportToJSON(String fileName, String dbname) {

        List<IndigenousData> dataList = findAllIndigenousbyDB(dbname);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataList);

        try (FileWriter writer = new FileWriter(fileName + ".json")) {
            writer.write(json);
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // 大于小于查询
    public List<IndigenousData> findByGTLT(String dbname, int value, boolean isGreater){
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();

        String sql = "SELECT * FROM " + dbname + " WHERE year > ? ";
        if(!isGreater) {
            sql = "SELECT * FROM " + dbname + " WHERE year < ? ";
        }

        try(PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setInt(1, value);

            ResultSet rs = stmt.executeQuery();

            List<IndigenousData> IndigenousDataList = new ArrayList<>();

            while(rs.next()) {
                // 封装结果集到对象
                IndigenousData IndigenousData = new IndigenousData();
                IndigenousData.setSeq(rs.getInt(1));
                IndigenousData.setDatelisted(rs.getString(2));
                IndigenousData.setYear(rs.getString(3));
                IndigenousData.setType(rs.getString(4));
                IndigenousData.setArea(rs.getString(5));
                IndigenousData.setTotalpercent(rs.getInt(6));
                IndigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                IndigenousData.setProfessionalspercent(rs.getFloat(8));
                IndigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                IndigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                IndigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                IndigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                IndigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                IndigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                IndigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                IndigenousData.setSampleCount(rs.getFloat(16));
                IndigenousData.setPopulationCount(rs.getFloat(17));
                IndigenousDataList.add(IndigenousData);
            }

            return IndigenousDataList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    // BETWEEN查询
    public List<IndigenousData> findByBetween(String dbname, int min, int max){
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "SELECT * FROM " + dbname + " WHERE year BETWEEN ? AND ? ";

        try(PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setInt(1, min);
            stmt.setInt(2, max);

            ResultSet rs = stmt.executeQuery();

            List<IndigenousData> IndigenousDataList = new ArrayList<>();

            while(rs.next()) {
                // 封装结果集到对象
                IndigenousData IndigenousData = new IndigenousData();
                IndigenousData.setSeq(rs.getInt(1));
                IndigenousData.setDatelisted(rs.getString(2));
                IndigenousData.setYear(rs.getString(3));
                IndigenousData.setType(rs.getString(4));
                IndigenousData.setArea(rs.getString(5));
                IndigenousData.setTotalpercent(rs.getInt(6));
                IndigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                IndigenousData.setProfessionalspercent(rs.getFloat(8));
                IndigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                IndigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                IndigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                IndigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                IndigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                IndigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                IndigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                IndigenousData.setSampleCount(rs.getFloat(16));
                IndigenousData.setPopulationCount(rs.getFloat(17));
                IndigenousDataList.add(IndigenousData);
            }

            return IndigenousDataList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;

    }

    // LIKE 查询
    public List<IndigenousData> findByLike(String dbname, String keyword) {
        ConnectionUtil connectionutil = new ConnectionUtil();
        Connection connection = connectionutil.getConnection();
        String sql = "SELECT * FROM " + dbname + " WHERE area LIKE ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();

            List<IndigenousData> IndigenousDataList = new ArrayList<>();

            while(rs.next()) {
                // 封装结果集到对象
                IndigenousData IndigenousData = new IndigenousData();
                IndigenousData.setSeq(rs.getInt(1));
                IndigenousData.setDatelisted(rs.getString(2));
                IndigenousData.setYear(rs.getString(3));
                IndigenousData.setType(rs.getString(4));
                IndigenousData.setArea(rs.getString(5));
                IndigenousData.setTotalpercent(rs.getInt(6));
                IndigenousData.setLegislatorsAndManagerspercent(rs.getFloat(7));
                IndigenousData.setProfessionalspercent(rs.getFloat(8));
                IndigenousData.setTechnicianAndassistantTechnicianpercent(rs.getFloat(9));
                IndigenousData.setClericalSupportWorkerpercent(rs.getFloat(10));
                IndigenousData.setServiceAndsalesWorkerpercent(rs.getFloat(11));
                IndigenousData.setPrimaryIndustrialWorkerpercent(rs.getFloat(12));
                IndigenousData.setCraftAndRelatedWorkerpercent(rs.getFloat(13));
                IndigenousData.setMachineryOperatorAndAssemblerpercent(rs.getFloat(14));
                IndigenousData.setElementaryWorkerLaborerpercent(rs.getFloat(15));
                IndigenousData.setSampleCount(rs.getFloat(16));
                IndigenousData.setPopulationCount(rs.getFloat(17));
                IndigenousDataList.add(IndigenousData);
            }

            return IndigenousDataList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;

    }

    @Override
    public float convert(String s) {
//        System.out.println("Input: " + s);
        if(s.isEmpty()) {
            return 0;
        }

        return Float.parseFloat(s.replace("\"", ""));
    }

    public  String removeHeadAndTail(String s){

        return s.substring(1,s.length()-1);

    }
}






