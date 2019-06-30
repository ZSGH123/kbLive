package com.kblive.usersystem.common.db;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * title: BaseDao
 * projectName kbLive
 * description: 基础dao
 * author 2671242147@qq.com
 * date 2019-06-29 15:00
 ***/
public class BaseDao extends MysdalBaseDao {

    private int BATCH_SIZE = 1000;

    @Transactional
    public void insertBatch(final String statement, final List list, String tableName, String listName) {

        if (CollectionUtils.isNotEmpty(list)) {
            List subList = new ArrayList();
            Map<String, Object> map = new HashMap<>();
            if (StringUtils.isNotBlank(tableName)) {
                map.put("tableName", tableName);
            }
            for (int i = 0; i < list.size(); i++) {
                subList.add(list.get(i));
                if (i != 0 && i % BATCH_SIZE == 0) {
                    map.put(listName, subList);
                    getSqlMapClientTemplate().insert(statement, map);
                    subList.clear();
                }
            }
            if (subList.size() > 0) {
                map.put(listName, subList);
                getSqlMapClientTemplate().insert(statement, map);
                subList.clear();
            }
        }
    }

    public void addOrUpdBatch(final List list, final String statement) throws SQLException {

        if (list != null && list.size() > 0) {
            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {
                    executor.startBatch();
                    for (int i = 0; i < list.size(); i++) {
                        executor.insert(statement, list.get(i));

                        if (i != 0 && i % BATCH_SIZE == 0) {
                            executor.executeBatch();
                        }
                    }
                    executor.executeBatch();
                    return null;
                }

            });
        }
    }

    @Transactional
    public void replaceBatch(final String statement, final List list, String tableName, String fkId, String listName) {

        if (CollectionUtils.isNotEmpty(list)) {
            List subList = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            if (StringUtils.isNotBlank(tableName)) {
                map.put("tableName", tableName);
            }
            if (StringUtils.isNotBlank(fkId)) {
                map.put("fkId", fkId);
            }
            for (int i = 0; i < list.size(); i++) {
                subList.add(list.get(i));
                if (i != 0 && i % BATCH_SIZE == 0) {
                    map.put(listName, subList);
                    getSqlMapClientTemplate().insert(statement, map);
                    subList.clear();
                }
            }
            if (subList.size() > 0) {
                map.put(listName, subList);
                getSqlMapClientTemplate().insert(statement, map);
                subList.clear();
            }
        }
    }

//    public void updateBatch(final List list, final String statement) {
//        if (CollectionUtils.isNotEmpty(list)) {
//            getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
//
//                public Object doInSqlMapClient(SqlMapExecutor executor)
//                        throws SQLException {
//                    executor.startBatch();
//                    for (int i = 0; i < list.size(); i++) {
//                        executor.update(statement, list.get(i));
//
//                        if (i != 0 && i % BATCH_SIZE == 0) {
//                            executor.executeBatch();
//                        }
//                    }
//                    executor.executeBatch();
//                    return null;
//                }
//
//            });
//        }
//    }
}
