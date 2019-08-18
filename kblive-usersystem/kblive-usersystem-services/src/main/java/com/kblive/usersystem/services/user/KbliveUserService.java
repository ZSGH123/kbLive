package com.kblive.usersystem.services.user;

import java.util.List;
import javax.annotation.Resource;

import com.kblive.usersystem.common.db.Result;
import com.kblive.usersystem.common.query.user.KbliveUserQuery;
import com.kblive.usersystem.dao.user.KbliveUserDAO;
import com.kblive.usersystem.model.user.KbliveUser;
import org.springframework.stereotype.Service;

/**
 * KbliveUser  Service
 *
 * @author zhong qiang
 * @since 2019-07-13
 */
@Service
public class KbliveUserService {

    @Resource
    KbliveUserDAO kbliveUserDAO;

    public void setKbliveUserDAO(KbliveUserDAO kbliveUserDAO) {
        this.kbliveUserDAO = kbliveUserDAO;
    }

    public String test() {
        return kbliveUserDAO.test();
    }
    /**
     * 插入
     */
    public Integer addKbliveUser(KbliveUser kbliveUser) {
        return kbliveUserDAO.addKbliveUser(kbliveUser);
    }

    /**
     * 根据主键查找
     */
    public KbliveUser getKbliveUserByKey(Long id) {
        return kbliveUserDAO.getKbliveUserByKey(id);
    }

    /**
     * 根据主键查找
     */
    public KbliveUser getKbliveUserByKey(KbliveUser kbliveUser) {
        return kbliveUserDAO.getKbliveUserByKey(kbliveUser.getId());
    }


    /**
     * 根据主键组进行查找
     */
    public List<KbliveUser> getKbliveUserByKeys(KbliveUser kbliveUser, List<Long> idList) {
        return kbliveUserDAO.getKbliveUserByKeys(idList);
    }

    /**
     * 根据主键组进行查找
     */
    public List<KbliveUser> getKbliveUserByKeys(List<Long> idList) {
        return kbliveUserDAO.getKbliveUserByKeys(idList);
    }

    /**
     * 根据主键删除
     */
    public Integer deleteByKey(Long id) {
        return kbliveUserDAO.deleteByKey(id);
    }

    /**
     * 根据主键组进行删除
     */
    public Integer deleteByKeys(List<Long> idList) {
        return kbliveUserDAO.deleteByKeys(idList);
    }

    /**
     * 根据主键更新
     */
    public Integer updateKbliveUserByKey(KbliveUser kbliveUser) {
        return kbliveUserDAO.updateKbliveUserByKey(kbliveUser);
    }

    /**
     * 根据条件查询分页查询
     */
    public Result<KbliveUser> getKbliveUserListWithPage(KbliveUserQuery kbliveUserQuery) {
        return kbliveUserDAO.getKbliveUserListWithPage(kbliveUserQuery);
    }

    /**
     * 根据条件查询
     */
    public List<KbliveUser> getKbliveUserList(KbliveUserQuery kbliveUserQuery) {
        return kbliveUserDAO.getKbliveUserList(kbliveUserQuery);
    }

}
