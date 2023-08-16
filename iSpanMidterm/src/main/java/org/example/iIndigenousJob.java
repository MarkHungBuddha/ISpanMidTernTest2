package org.example;

import java.util.List;


public interface iIndigenousJob {

    //findByID
    IndigenousData findIndigenousByID(int id);

    IndigenousData findIndigenousByIDbyDB(int id, String dbname);


    //findAll
    List<IndigenousData> findAllIndigenous();


    //讀取網路csv儲存成資料庫
    List<IndigenousData> RearOnlineCSV();

    int CREATENewDB(String dbname);


    //update資料
    boolean updateIndigenous(IndigenousData t);

    boolean updateIndigenousbyDB(String dbname, IndigenousData t);

    //insert資料
    boolean insertIndigenous(IndigenousData t);

    boolean insertIndigenousbyDB(String dbname, IndigenousData t);


    //delete資料
    boolean deleteIndigenousByID(int id);

    boolean deleteIndigenousByIDByDB(int id, String dbname);


    List<IndigenousData> findAllIndigenousbyDB(String dbname);

    boolean isValidTableName(String tableName);

    boolean isValidFileName(String fileName);

    List<tableIndex> tableCatalog();

    String whatMyDBName(int ID);

    boolean exportToJSON(String fileName, String dbname);

    // 大于小于查询
    List<IndigenousData> findByGTLT(String dbname, int value, boolean isGreater);

    // BETWEEN查询
    List<IndigenousData> findByBetween(String dbname, int min, int max);

    // LIKE查询
    List<IndigenousData> findByLike(String dbname, String keyword);

    float convert(String s) ;
    String removeHeadAndTail(String s);

}
