package com.kblive.usersystem.common.query.user;

import com.kblive.usersystem.common.db.BaseQuery;
import java.util.*;

/**
 * KbliveUser  Query
 * @author zhong qiang
 */
public class KbliveUserQuery extends BaseQuery {

    private static final long serialVersionUID = -1L;

	/**==============================批量查询、更新、删除时的Where条件设置==================================**/
	/** id **/
    private Long id;
	public Long getId () {
    	return id;
   	}
    public void setId(Long id) {
    	this.id = id;
    }
	/** user_name **/
    private String userName;
	public String getUserName () {
    	return userName;
   	}
    public void setUserName(String userName) {
    	this.userName = userName;
    }
	/** user_phone_number **/
    private String userPhoneNumber;
	public String getUserPhoneNumber () {
    	return userPhoneNumber;
   	}
    public void setUserPhoneNumber(String userPhoneNumber) {
    	this.userPhoneNumber = userPhoneNumber;
    }
	/** 用户密码 **/
    private String userPassword;
	public String getUserPassword () {
    	return userPassword;
   	}
    public void setUserPassword(String userPassword) {
    	this.userPassword = userPassword;
    }
    /** 修改时间 **/
    private Date modifyDateStart;
    public Date getModifyDateStart () {
        return modifyDateStart;
    }
    public void setModifyDateStart(Date modifyDate) {
        this.modifyDateStart = modifyDate;
    }

    private Date modifyDateEnd;
    public Date getModifyDateEnd () {
        return modifyDateEnd;
    }
    public void setModifyDateEnd(Date modifyDate) {
        this.modifyDateEnd = modifyDate;
    }

    private Date modifyDateEqual;
    public Date getModifyDateEqual () {
        return modifyDateEqual;
    }
    public void setModifyDateEqual(Date modifyDate) {
        this.modifyDateEqual = modifyDate;
    }
	/** 用户真实姓名 **/
    private String userRealName;
	public String getUserRealName () {
    	return userRealName;
   	}
    public void setUserRealName(String userRealName) {
    	this.userRealName = userRealName;
    }
	/** user_sex **/
    private String userSex;
	public String getUserSex () {
    	return userSex;
   	}
    public void setUserSex(String userSex) {
    	this.userSex = userSex;
    }
	/** user_idcard **/
    private String userIdcard;
	public String getUserIdcard () {
    	return userIdcard;
   	}
    public void setUserIdcard(String userIdcard) {
    	this.userIdcard = userIdcard;
    }
	/** user_weibo_id **/
    private String userWeiboId;
	public String getUserWeiboId () {
    	return userWeiboId;
   	}
    public void setUserWeiboId(String userWeiboId) {
    	this.userWeiboId = userWeiboId;
    }
	/** user_qq_id **/
    private String userQqId;
	public String getUserQqId () {
    	return userQqId;
   	}
    public void setUserQqId(String userQqId) {
    	this.userQqId = userQqId;
    }
	/** 用户头像地址 **/
    private String userIcon;
	public String getUserIcon () {
    	return userIcon;
   	}
    public void setUserIcon(String userIcon) {
    	this.userIcon = userIcon;
    }
	/** 支付包账号 **/
    private String userAlipay;
	public String getUserAlipay () {
    	return userAlipay;
   	}
    public void setUserAlipay(String userAlipay) {
    	this.userAlipay = userAlipay;
    }
	/** user_bank_card **/
    private String userBankCard;
	public String getUserBankCard () {
    	return userBankCard;
   	}
    public void setUserBankCard(String userBankCard) {
    	this.userBankCard = userBankCard;
    }
	/** 状态 **/
    private Integer status;
	public Integer getStatus () {
    	return status;
   	}
    public void setStatus(Integer status) {
    	this.status = status;
    }
    /** create_date **/
    private Date createDateStart;
    public Date getCreateDateStart () {
        return createDateStart;
    }
    public void setCreateDateStart(Date createDate) {
        this.createDateStart = createDate;
    }

    private Date createDateEnd;
    public Date getCreateDateEnd () {
        return createDateEnd;
    }
    public void setCreateDateEnd(Date createDate) {
        this.createDateEnd = createDate;
    }

    private Date createDateEqual;
    public Date getCreateDateEqual () {
        return createDateEqual;
    }
    public void setCreateDateEqual(Date createDate) {
        this.createDateEqual = createDate;
    }
	/** login_times **/
    private Integer loginTimes;
	public Integer getLoginTimes () {
    	return loginTimes;
   	}
    public void setLoginTimes(Integer loginTimes) {
    	this.loginTimes = loginTimes;
    }
    /** 上次登陆时间 **/
    private Date lastLoginDateStart;
    public Date getLastLoginDateStart () {
        return lastLoginDateStart;
    }
    public void setLastLoginDateStart(Date lastLoginDate) {
        this.lastLoginDateStart = lastLoginDate;
    }

    private Date lastLoginDateEnd;
    public Date getLastLoginDateEnd () {
        return lastLoginDateEnd;
    }
    public void setLastLoginDateEnd(Date lastLoginDate) {
        this.lastLoginDateEnd = lastLoginDate;
    }

    private Date lastLoginDateEqual;
    public Date getLastLoginDateEqual () {
        return lastLoginDateEqual;
    }
    public void setLastLoginDateEqual(Date lastLoginDate) {
        this.lastLoginDateEqual = lastLoginDate;
    }
	/** user_note **/
    private String userNote;
	public String getUserNote () {
    	return userNote;
   	}
    public void setUserNote(String userNote) {
    	this.userNote = userNote;
    }
	/**==============================批量查询时的Order条件顺序设置==================================**/
	public class OrderField{
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}
	}

	/**==============================批量查询时的Order条件顺序设置==================================**/
	/**排序列表字段**/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * 设置排序按属性：id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserName(boolean isAsc){
		orderFields.add(new OrderField("user_name",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_phone_number
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserPhoneNumber(boolean isAsc){
		orderFields.add(new OrderField("user_phone_number",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：用户密码
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserPassword(boolean isAsc){
		orderFields.add(new OrderField("user_password",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：修改时间
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyModifyDate(boolean isAsc){
		orderFields.add(new OrderField("modify_date",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：用户真实姓名
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserRealName(boolean isAsc){
		orderFields.add(new OrderField("user_real_name",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_sex
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserSex(boolean isAsc){
		orderFields.add(new OrderField("user_sex",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_idcard
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserIdcard(boolean isAsc){
		orderFields.add(new OrderField("user_idcard",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_weibo_id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserWeiboId(boolean isAsc){
		orderFields.add(new OrderField("user_weibo_id",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_qq_id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserQqId(boolean isAsc){
		orderFields.add(new OrderField("user_qq_id",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：用户头像地址
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserIcon(boolean isAsc){
		orderFields.add(new OrderField("user_icon",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：支付包账号
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserAlipay(boolean isAsc){
		orderFields.add(new OrderField("user_alipay",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_bank_card
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserBankCard(boolean isAsc){
		orderFields.add(new OrderField("user_bank_card",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：状态
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyStatus(boolean isAsc){
		orderFields.add(new OrderField("status",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：create_date
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyCreateDate(boolean isAsc){
		orderFields.add(new OrderField("create_date",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：login_times
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyLoginTimes(boolean isAsc){
		orderFields.add(new OrderField("login_times",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：上次登陆时间
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyLastLoginDate(boolean isAsc){
		orderFields.add(new OrderField("last_login_date",isAsc?"ASC":"DESC"));
	}
	/**
	 * 设置排序按属性：user_note
	 * @param isAsc 是否升序，否则为降序
	 */	
	public void orderbyUserNote(boolean isAsc){
		orderFields.add(new OrderField("user_note",isAsc?"ASC":"DESC"));
	}
    private String fields;
    /**
     * 提供自定义字段使用
     */
    private static Map<String,String> fieldMap;

    private static Map<String,String> getFieldSet() {
        if (fieldMap == null){
            fieldMap =new HashMap<String,String>();
                    fieldMap.put("id", "id");
                    fieldMap.put("user_name", "userName");
                    fieldMap.put("user_phone_number", "userPhoneNumber");
                    fieldMap.put("user_password", "userPassword");
                    fieldMap.put("modify_date", "modifyDate");
                    fieldMap.put("user_real_name", "userRealName");
                    fieldMap.put("user_sex", "userSex");
                    fieldMap.put("user_idcard", "userIdcard");
                    fieldMap.put("user_weibo_id", "userWeiboId");
                    fieldMap.put("user_qq_id", "userQqId");
                    fieldMap.put("user_icon", "userIcon");
                    fieldMap.put("user_alipay", "userAlipay");
                    fieldMap.put("user_bank_card", "userBankCard");
                    fieldMap.put("status", "status");
                    fieldMap.put("create_date", "createDate");
                    fieldMap.put("login_times", "loginTimes");
                    fieldMap.put("last_login_date", "lastLoginDate");
                    fieldMap.put("user_note", "userNote");
                }
        return fieldMap;
    }

    public String getFields(){
        return this.fields;
    }
    public void  setFields(String fields){
        String[] array = fields.split(",");
        StringBuilder buffer = new StringBuilder();
        for (String field : array){
            if(getFieldSet().containsKey(field)){
                buffer.append(field).append(" as ").append(getFieldSet().get(field)).append(" ,");
            }
            if(getFieldSet().containsKey("`"+field+"`")){
                buffer.append("`"+field+"`").append(" as ").append(getFieldSet().get(field)).append(" ,");
            }
        }
        if (buffer.length() != 0){
            this.fields = buffer.substring(0, buffer.length() - 1);
        }else{
            this.fields = " 1 ";//没有一个参数可能会报错
        }
    }
}
