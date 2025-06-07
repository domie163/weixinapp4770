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
 * 商品订单
 *
 * @author 
 * @email
 */
@TableName("yisheng_order")
public class YishengOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengOrderEntity() {

	}

	public YishengOrderEntity(T t) {
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
     * 编号
     */
    @ColumnInfo(comment="编号",type="varchar(200)")
    @TableField(value = "yisheng_order_uuid_number")

    private String yishengOrderUuidNumber;


    /**
     * 医生
     */
    @ColumnInfo(comment="医生",type="int(11)")
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="挂号日期",type="date")
    @TableField(value = "yisheng_order_time")

    private Date yishengOrderTime;


    /**
     * 挂号时间段
     */
    @ColumnInfo(comment="挂号时间段",type="int(11)")
    @TableField(value = "shijianduan_types")

    private Integer shijianduanTypes;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "yisheng_order_true_price")

    private Double yishengOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "yisheng_order_types")

    private Integer yishengOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
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
	 * 获取：编号
	 */
    public String getYishengOrderUuidNumber() {
        return yishengOrderUuidNumber;
    }
    /**
	 * 设置：编号
	 */

    public void setYishengOrderUuidNumber(String yishengOrderUuidNumber) {
        this.yishengOrderUuidNumber = yishengOrderUuidNumber;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }
    /**
	 * 设置：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
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
	 * 获取：挂号日期
	 */
    public Date getYishengOrderTime() {
        return yishengOrderTime;
    }
    /**
	 * 设置：挂号日期
	 */

    public void setYishengOrderTime(Date yishengOrderTime) {
        this.yishengOrderTime = yishengOrderTime;
    }
    /**
	 * 获取：挂号时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }
    /**
	 * 设置：挂号时间段
	 */

    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getYishengOrderTruePrice() {
        return yishengOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setYishengOrderTruePrice(Double yishengOrderTruePrice) {
        this.yishengOrderTruePrice = yishengOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getYishengOrderTypes() {
        return yishengOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setYishengOrderTypes(Integer yishengOrderTypes) {
        this.yishengOrderTypes = yishengOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
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
        return "YishengOrder{" +
            ", id=" + id +
            ", yishengOrderUuidNumber=" + yishengOrderUuidNumber +
            ", yishengId=" + yishengId +
            ", yonghuId=" + yonghuId +
            ", yishengOrderTime=" + DateUtil.convertString(yishengOrderTime,"yyyy-MM-dd") +
            ", shijianduanTypes=" + shijianduanTypes +
            ", yishengOrderTruePrice=" + yishengOrderTruePrice +
            ", yishengOrderTypes=" + yishengOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
