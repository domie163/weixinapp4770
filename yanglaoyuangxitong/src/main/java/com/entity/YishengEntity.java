package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 医生
 *
 * @author 
 * @email
 */
@TableName("yisheng")
public class YishengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengEntity() {

	}

	public YishengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 医生名称
     */
    @ColumnInfo(comment="医生名称",type="varchar(200)")
    @TableField(value = "yisheng_name")

    private String yishengName;


    /**
     * 医生手机号
     */
    @ColumnInfo(comment="医生手机号",type="varchar(200)")
    @TableField(value = "yisheng_phone")

    private String yishengPhone;


    /**
     * 医生头像
     */
    @ColumnInfo(comment="医生头像",type="varchar(200)")
    @TableField(value = "yisheng_photo")

    private String yishengPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 医生邮箱
     */
    @ColumnInfo(comment="医生邮箱",type="varchar(200)")
    @TableField(value = "yisheng_email")

    private String yishengEmail;


    /**
     * 科室
     */
    @ColumnInfo(comment="科室",type="int(11)")
    @TableField(value = "yisheng_types")

    private Integer yishengTypes;


    /**
     * 挂号人数限制
     */
    @ColumnInfo(comment="挂号人数限制",type="int(11)")
    @TableField(value = "yisheng_number")

    private Integer yishengNumber;


    /**
     * 挂号价格
     */
    @ColumnInfo(comment="挂号价格",type="decimal(10,2)")
    @TableField(value = "yisheng_newMoney")

    private Double yishengNewmoney;


    /**
     * 在诊日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="在诊日期",type="timestamp")
    @TableField(value = "yisheng_time")

    private Date yishengTime;


    /**
     * 职称
     */
    @ColumnInfo(comment="职称",type="varchar(200)")
    @TableField(value = "yisheng_zhicheng")

    private String yishengZhicheng;


    /**
     * 医生简介
     */
    @ColumnInfo(comment="医生简介",type="longtext")
    @TableField(value = "yisheng_content")

    private String yishengContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yisheng_delete")

    private Integer yishengDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：医生名称
	 */
    public String getYishengName() {
        return yishengName;
    }
    /**
	 * 设置：医生名称
	 */

    public void setYishengName(String yishengName) {
        this.yishengName = yishengName;
    }
    /**
	 * 获取：医生手机号
	 */
    public String getYishengPhone() {
        return yishengPhone;
    }
    /**
	 * 设置：医生手机号
	 */

    public void setYishengPhone(String yishengPhone) {
        this.yishengPhone = yishengPhone;
    }
    /**
	 * 获取：医生头像
	 */
    public String getYishengPhoto() {
        return yishengPhoto;
    }
    /**
	 * 设置：医生头像
	 */

    public void setYishengPhoto(String yishengPhoto) {
        this.yishengPhoto = yishengPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：医生邮箱
	 */
    public String getYishengEmail() {
        return yishengEmail;
    }
    /**
	 * 设置：医生邮箱
	 */

    public void setYishengEmail(String yishengEmail) {
        this.yishengEmail = yishengEmail;
    }
    /**
	 * 获取：科室
	 */
    public Integer getYishengTypes() {
        return yishengTypes;
    }
    /**
	 * 设置：科室
	 */

    public void setYishengTypes(Integer yishengTypes) {
        this.yishengTypes = yishengTypes;
    }
    /**
	 * 获取：挂号人数限制
	 */
    public Integer getYishengNumber() {
        return yishengNumber;
    }
    /**
	 * 设置：挂号人数限制
	 */

    public void setYishengNumber(Integer yishengNumber) {
        this.yishengNumber = yishengNumber;
    }
    /**
	 * 获取：挂号价格
	 */
    public Double getYishengNewmoney() {
        return yishengNewmoney;
    }
    /**
	 * 设置：挂号价格
	 */

    public void setYishengNewmoney(Double yishengNewmoney) {
        this.yishengNewmoney = yishengNewmoney;
    }
    /**
	 * 获取：在诊日期
	 */
    public Date getYishengTime() {
        return yishengTime;
    }
    /**
	 * 设置：在诊日期
	 */

    public void setYishengTime(Date yishengTime) {
        this.yishengTime = yishengTime;
    }
    /**
	 * 获取：职称
	 */
    public String getYishengZhicheng() {
        return yishengZhicheng;
    }
    /**
	 * 设置：职称
	 */

    public void setYishengZhicheng(String yishengZhicheng) {
        this.yishengZhicheng = yishengZhicheng;
    }
    /**
	 * 获取：医生简介
	 */
    public String getYishengContent() {
        return yishengContent;
    }
    /**
	 * 设置：医生简介
	 */

    public void setYishengContent(String yishengContent) {
        this.yishengContent = yishengContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYishengDelete() {
        return yishengDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYishengDelete(Integer yishengDelete) {
        this.yishengDelete = yishengDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yisheng{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yishengName=" + yishengName +
            ", yishengPhone=" + yishengPhone +
            ", yishengPhoto=" + yishengPhoto +
            ", sexTypes=" + sexTypes +
            ", yishengEmail=" + yishengEmail +
            ", yishengTypes=" + yishengTypes +
            ", yishengNumber=" + yishengNumber +
            ", yishengNewmoney=" + yishengNewmoney +
            ", yishengTime=" + DateUtil.convertString(yishengTime,"yyyy-MM-dd") +
            ", yishengZhicheng=" + yishengZhicheng +
            ", yishengContent=" + yishengContent +
            ", yishengDelete=" + yishengDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
