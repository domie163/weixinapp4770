package com.entity.vo;

import com.entity.YishengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医生
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yisheng")
public class YishengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 医生名称
     */

    @TableField(value = "yisheng_name")
    private String yishengName;


    /**
     * 医生手机号
     */

    @TableField(value = "yisheng_phone")
    private String yishengPhone;


    /**
     * 医生头像
     */

    @TableField(value = "yisheng_photo")
    private String yishengPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 医生邮箱
     */

    @TableField(value = "yisheng_email")
    private String yishengEmail;


    /**
     * 科室
     */

    @TableField(value = "yisheng_types")
    private Integer yishengTypes;


    /**
     * 挂号人数限制
     */

    @TableField(value = "yisheng_number")
    private Integer yishengNumber;


    /**
     * 挂号价格
     */

    @TableField(value = "yisheng_newMoney")
    private Double yishengNewmoney;


    /**
     * 在诊日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yisheng_time")
    private Date yishengTime;


    /**
     * 职称
     */

    @TableField(value = "yisheng_zhicheng")
    private String yishengZhicheng;


    /**
     * 医生简介
     */

    @TableField(value = "yisheng_content")
    private String yishengContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yisheng_delete")
    private Integer yishengDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：医生名称
	 */
    public String getYishengName() {
        return yishengName;
    }


    /**
	 * 获取：医生名称
	 */

    public void setYishengName(String yishengName) {
        this.yishengName = yishengName;
    }
    /**
	 * 设置：医生手机号
	 */
    public String getYishengPhone() {
        return yishengPhone;
    }


    /**
	 * 获取：医生手机号
	 */

    public void setYishengPhone(String yishengPhone) {
        this.yishengPhone = yishengPhone;
    }
    /**
	 * 设置：医生头像
	 */
    public String getYishengPhoto() {
        return yishengPhoto;
    }


    /**
	 * 获取：医生头像
	 */

    public void setYishengPhoto(String yishengPhoto) {
        this.yishengPhoto = yishengPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：医生邮箱
	 */
    public String getYishengEmail() {
        return yishengEmail;
    }


    /**
	 * 获取：医生邮箱
	 */

    public void setYishengEmail(String yishengEmail) {
        this.yishengEmail = yishengEmail;
    }
    /**
	 * 设置：科室
	 */
    public Integer getYishengTypes() {
        return yishengTypes;
    }


    /**
	 * 获取：科室
	 */

    public void setYishengTypes(Integer yishengTypes) {
        this.yishengTypes = yishengTypes;
    }
    /**
	 * 设置：挂号人数限制
	 */
    public Integer getYishengNumber() {
        return yishengNumber;
    }


    /**
	 * 获取：挂号人数限制
	 */

    public void setYishengNumber(Integer yishengNumber) {
        this.yishengNumber = yishengNumber;
    }
    /**
	 * 设置：挂号价格
	 */
    public Double getYishengNewmoney() {
        return yishengNewmoney;
    }


    /**
	 * 获取：挂号价格
	 */

    public void setYishengNewmoney(Double yishengNewmoney) {
        this.yishengNewmoney = yishengNewmoney;
    }
    /**
	 * 设置：在诊日期
	 */
    public Date getYishengTime() {
        return yishengTime;
    }


    /**
	 * 获取：在诊日期
	 */

    public void setYishengTime(Date yishengTime) {
        this.yishengTime = yishengTime;
    }
    /**
	 * 设置：职称
	 */
    public String getYishengZhicheng() {
        return yishengZhicheng;
    }


    /**
	 * 获取：职称
	 */

    public void setYishengZhicheng(String yishengZhicheng) {
        this.yishengZhicheng = yishengZhicheng;
    }
    /**
	 * 设置：医生简介
	 */
    public String getYishengContent() {
        return yishengContent;
    }


    /**
	 * 获取：医生简介
	 */

    public void setYishengContent(String yishengContent) {
        this.yishengContent = yishengContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYishengDelete() {
        return yishengDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYishengDelete(Integer yishengDelete) {
        this.yishengDelete = yishengDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
