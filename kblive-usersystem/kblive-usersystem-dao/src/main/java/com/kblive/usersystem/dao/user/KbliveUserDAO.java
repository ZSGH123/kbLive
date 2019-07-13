package com.kblive.usersystem.dao.user;

import com.alibaba.cobarclient.dao.MysdalBaseDao;
import com.kblive.usersystem.common.db.Result;
import com.kblive.usersystem.common.query.user.KbliveUserQuery;
import com.kblive.usersystem.model.user.KbliveUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhong qiang
 * Date    2019-07-13
 */
@Repository
public class KbliveUserDAO extends MysdalBaseDao {


    /**
     * 添加
     */
    public Integer addKbliveUser(KbliveUser kbliveUser)  {
        return (Integer) getSqlMapClientTemplate().insert("KbliveUser.insertKbliveUser", kbliveUser);
    }

    /**
     * 根据主键查找
     */
    public KbliveUser getKbliveUserByKey(Long id) {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("id", id);
        return (KbliveUser) getSqlMapClientTemplate().queryForObject(
                "KbliveUser.getKbliveUserByKey", params);
    }

    /**
     * 根据主键批量查找
     */
    public List<KbliveUser> getKbliveUserByKeys(List<Long> idList) {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("keys", idList);
        return (List<KbliveUser>) getSqlMapClientTemplate().queryForList("KbliveUser.getKbliveUsersByKeys", params);
    }

    /**
     * 根据主键删除
     */
    public Integer deleteByKey(Long id) {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("id", id);
        return (Integer) getSqlMapClientTemplate().delete("KbliveUser.deleteByKey", params);
    }

    /**
     * 根据主键批量删除
     */
    public Integer deleteByKeys(List<Long> idList) {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("keys", idList);
        return (Integer) getSqlMapClientTemplate().delete("KbliveUser.deleteByKeys", params);
    }

    /**
     * 根据主键更新
     */
    public Integer updateKbliveUserByKey(KbliveUser kbliveUser) {
        return (Integer) getSqlMapClientTemplate().update("KbliveUser.updateKbliveUserByKey", kbliveUser);
    }

    /**
     * 根据条件查询分页查询
     */
    @SuppressWarnings("unchecked")
    public Result<KbliveUser> getKbliveUserListWithPage(KbliveUserQuery kbliveUserQuery) {
        Result<KbliveUser> rs = new Result<KbliveUser>();
        rs.setCount((Integer) getSqlMapClientTemplate().queryForObject("KbliveUser.getKbliveUserListCount", kbliveUserQuery));
        if (StringUtils.isNotEmpty(kbliveUserQuery.getFields())) {
            rs.setList((List<KbliveUser>) getSqlMapClientTemplate().queryForList("KbliveUser.getKbliveUserListWithPageFields", kbliveUserQuery));
        } else {
            rs.setList((List<KbliveUser>) getSqlMapClientTemplate().queryForList("KbliveUser.getKbliveUserListWithPage", kbliveUserQuery));
        }
        return rs;
    }

    /**
     * 根据条件查询
     */
    @SuppressWarnings("unchecked")
    public List<KbliveUser> getKbliveUserList(KbliveUserQuery kbliveUserQuery) {
        if (StringUtils.isNotEmpty(kbliveUserQuery.getFields())) {
            return (List<KbliveUser>) getSqlMapClientTemplate().queryForList("KbliveUser.getKbliveUserListFields", kbliveUserQuery);
        }
        return (List<KbliveUser>) getSqlMapClientTemplate().queryForList("KbliveUser.getKbliveUserList", kbliveUserQuery);
    }


}