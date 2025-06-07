package com.entity.vo;

import com.entity.FuwuxiangmuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 服务项目预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fuwuxiangmu_yuyue")
public class FuwuxiangmuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 服务项目
     */

    @TableField(value = "fuwuxiangmu_id")
    private Integer fuwuxiangmuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwuxiangmu_yuyue_time")
    private Date fuwuxiangmuYuyueTime;


    /**
     * 审核状态
     */

    @TableField(value = "fuwuxiangmu_yuyue_yesno_types")
    private Integer fuwuxiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "fuwuxiangmu_yuyue_yesno_text")
    private String fuwuxiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwuxiangmu_yuyue_shenhe_time")
    private Date fuwuxiangmuYuyueShenheTime;


    /**
     * 服务项目服务项目时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：服务项目
	 */
    public Integer getFuwuxiangmuId() {
        return fuwuxiangmuId;
    }


    /**
	 * 获取：服务项目
	 */

    public void setFuwuxiangmuId(Integer fuwuxiangmuId) {
        this.fuwuxiangmuId = fuwuxiangmuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getFuwuxiangmuYuyueTime() {
        return fuwuxiangmuYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setFuwuxiangmuYuyueTime(Date fuwuxiangmuYuyueTime) {
        this.fuwuxiangmuYuyueTime = fuwuxiangmuYuyueTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getFuwuxiangmuYuyueYesnoTypes() {
        return fuwuxiangmuYuyueYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setFuwuxiangmuYuyueYesnoTypes(Integer fuwuxiangmuYuyueYesnoTypes) {
        this.fuwuxiangmuYuyueYesnoTypes = fuwuxiangmuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getFuwuxiangmuYuyueYesnoText() {
        return fuwuxiangmuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setFuwuxiangmuYuyueYesnoText(String fuwuxiangmuYuyueYesnoText) {
        this.fuwuxiangmuYuyueYesnoText = fuwuxiangmuYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFuwuxiangmuYuyueShenheTime() {
        return fuwuxiangmuYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setFuwuxiangmuYuyueShenheTime(Date fuwuxiangmuYuyueShenheTime) {
        this.fuwuxiangmuYuyueShenheTime = fuwuxiangmuYuyueShenheTime;
    }
    /**
	 * 设置：服务项目服务项目时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：服务项目服务项目时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
