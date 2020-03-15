package dao;

import domain.Yes;

import java.util.List;

public interface YesDao {
    int getTotal(String table);
    void add(String table,Yes yes);
    void update(String table,Yes yes);
    void delete(String table,String id) ;
    List<Yes> list(String table);
    Yes get(String table,String id);
    void deleteTable(String tableName);
}
