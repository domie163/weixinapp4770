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
 * 服务项目预约
 *
 * @author 
 * @email
 */
@TableName("fuwuxiangmu_yuyue")
public class FuwuxiangmuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuwuxiangmuYuyueEntity() {

	}

	public FuwuxiangmuYuyueEntity(T t) {
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
     * 服务项目
     */
    @ColumnInfo(comment="服务项目",type="int(11)")
    @TableField(value = "fuwuxiangmu_id")

    private Integer fuwuxiangmuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "fuwuxiangmu_yuyue_time")

    private Date fuwuxiangmuYuyueTime;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "fuwuxiangmu_yuyue_yesno_types")

    private Integer fuwuxiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "fuwuxiangmu_yuyue_yesno_text")

    private String fuwuxiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "fuwuxiangmu_yuyue_shenhe_time")

    private Date fuwuxiangmuYuyueShenheTime;


    /**
     * 服务项目服务项目时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="服务项目服务项目时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：服务项目
	 */
    public Integer getFuwuxiangmuId() {
        return fuwuxiangmuId;
    }
    /**
	 * 设置：服务项目
	 */

    public void setFuwuxiangmuId(Integer fuwuxiangmuId) {
        this.fuwuxiangmuId = fuwuxiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getFuwuxiangmuYuyueTime() {
        return fuwuxiangmuYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setFuwuxiangmuYuyueTime(Date fuwuxiangmuYuyueTime) {
        this.fuwuxiangmuYuyueTime = fuwuxiangmuYuyueTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getFuwuxiangmuYuyueYesnoTypes() {
        return fuwuxiangmuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setFuwuxiangmuYuyueYesnoTypes(Integer fuwuxiangmuYuyueYesnoTypes) {
        this.fuwuxiangmuYuyueYesnoTypes = fuwuxiangmuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getFuwuxiangmuYuyueYesnoText() {
        return fuwuxiangmuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setFuwuxiangmuYuyueYesnoText(String fuwuxiangmuYuyueYesnoText) {
        this.fuwuxiangmuYuyueYesnoText = fuwuxiangmuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFuwuxiangmuYuyueShenheTime() {
        return fuwuxiangmuYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setFuwuxiangmuYuyueShenheTime(Date fuwuxiangmuYuyueShenheTime) {
        this.fuwuxiangmuYuyueShenheTime = fuwuxiangmuYuyueShenheTime;
    }
    /**
	 * 获取：服务项目服务项目时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：服务项目服务项目时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FuwuxiangmuYuyue{" +
            ", id=" + id +
            ", fuwuxiangmuId=" + fuwuxiangmuId +
            ", yonghuId=" + yonghuId +
            ", fuwuxiangmuYuyueTime=" + DateUtil.convertString(fuwuxiangmuYuyueTime,"yyyy-MM-dd") +
            ", fuwuxiangmuYuyueYesnoTypes=" + fuwuxiangmuYuyueYesnoTypes +
            ", fuwuxiangmuYuyueYesnoText=" + fuwuxiangmuYuyueYesnoText +
            ", fuwuxiangmuYuyueShenheTime=" + DateUtil.convertString(fuwuxiangmuYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
