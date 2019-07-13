package com.kblive.usersystem.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * title: KbliveUser
 * projectName kbLive
 * description: 用户实体
 * author 2671242147@qq.com
 * date 2019-07-13 22:39
 ***/
public class KbliveUser implements Serializable {

    /**
     *序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * user_name
     */
    private String userName;
    /**
     * user_phone_number
     */
    private String userPhoneNumber;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 用户真实姓名
     */
    private String userRealName;
    /**
     * user_sex
     */
    private String userSex;
    /**
     * user_idcard
     */
    private String userIdcard;
    /**
     * user_weibo_id
     */
    private String userWeiboId;
    /**
     * user_qq_id
     */
    private String userQqId;
    /**
     * 用户头像地址
     */
    private String userIcon;
    /**
     * 支付包账号
     */
    private String userAlipay;
    /**
     * user_bank_card
     */
    private String userBankCard;
    /**
     * 状态
     */
    private Integer status;
    /**
     * create_date
     */
    private Date createDate;
    /**
     * login_times
     */
    private Integer loginTimes;
    /**
     * 上次登陆时间
     */
    private Date lastLoginDate;
    /**
     * user_note
     */
    private String userNote;


    /**
     * @return id id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return userName user_name
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return userPhoneNumber user_phone_number
     */
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
    /**
     * @param userPhoneNumber user_phone_number
     */
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    /**
     * @return userPassword 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }
    /**
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return modifyDate 修改时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }
    /**
     * @param modifyDate 修改时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return userRealName 用户真实姓名
     */
    public String getUserRealName() {
        return userRealName;
    }
    /**
     * @param userRealName 用户真实姓名
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /**
     * @return userSex user_sex
     */
    public String getUserSex() {
        return userSex;
    }
    /**
     * @param userSex user_sex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * @return userIdcard user_idcard
     */
    public String getUserIdcard() {
        return userIdcard;
    }
    /**
     * @param userIdcard user_idcard
     */
    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    /**
     * @return userWeiboId user_weibo_id
     */
    public String getUserWeiboId() {
        return userWeiboId;
    }
    /**
     * @param userWeiboId user_weibo_id
     */
    public void setUserWeiboId(String userWeiboId) {
        this.userWeiboId = userWeiboId;
    }

    /**
     * @return userQqId user_qq_id
     */
    public String getUserQqId() {
        return userQqId;
    }
    /**
     * @param userQqId user_qq_id
     */
    public void setUserQqId(String userQqId) {
        this.userQqId = userQqId;
    }

    /**
     * @return userIcon 用户头像地址
     */
    public String getUserIcon() {
        return userIcon;
    }
    /**
     * @param userIcon 用户头像地址
     */
    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    /**
     * @return userAlipay 支付包账号
     */
    public String getUserAlipay() {
        return userAlipay;
    }
    /**
     * @param userAlipay 支付包账号
     */
    public void setUserAlipay(String userAlipay) {
        this.userAlipay = userAlipay;
    }

    /**
     * @return userBankCard user_bank_card
     */
    public String getUserBankCard() {
        return userBankCard;
    }
    /**
     * @param userBankCard user_bank_card
     */
    public void setUserBankCard(String userBankCard) {
        this.userBankCard = userBankCard;
    }

    /**
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return createDate create_date
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * @param createDate create_date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return loginTimes login_times
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }
    /**
     * @param loginTimes login_times
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * @return lastLoginDate 上次登陆时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }
    /**
     * @param lastLoginDate 上次登陆时间
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * @return userNote user_note
     */
    public String getUserNote() {
        return userNote;
    }
    /**
     * @param userNote user_note
     */
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

}
