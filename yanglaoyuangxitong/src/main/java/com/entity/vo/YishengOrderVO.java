package com.entity.vo;

import com.entity.YishengOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yisheng_order")
public class YishengOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 编号
     */

    @TableField(value = "yisheng_order_uuid_number")
    private String yishengOrderUuidNumber;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yisheng_order_time")
    private Date yishengOrderTime;


    /**
     * 挂号时间段
     */

    @TableField(value = "shijianduan_types")
    private Integer shijianduanTypes;


    /**
     * 实付价格
     */

    @TableField(value = "yisheng_order_true_price")
    private Double yishengOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "yisheng_order_types")
    private Integer yishengOrderTypes;


    /**
     * 订单创建时间
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
	 * 设置：编号
	 */
    public String getYishengOrderUuidNumber() {
        return yishengOrderUuidNumber;
    }


    /**
	 * 获取：编号
	 */

    public void setYishengOrderUuidNumber(String yishengOrderUuidNumber) {
        this.yishengOrderUuidNumber = yishengOrderUuidNumber;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
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
	 * 设置：挂号日期
	 */
    public Date getYishengOrderTime() {
        return yishengOrderTime;
    }


    /**
	 * 获取：挂号日期
	 */

    public void setYishengOrderTime(Date yishengOrderTime) {
        this.yishengOrderTime = yishengOrderTime;
    }
    /**
	 * 设置：挂号时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }


    /**
	 * 获取：挂号时间段
	 */

    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getYishengOrderTruePrice() {
        return yishengOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setYishengOrderTruePrice(Double yishengOrderTruePrice) {
        this.yishengOrderTruePrice = yishengOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getYishengOrderTypes() {
        return yishengOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setYishengOrderTypes(Integer yishengOrderTypes) {
        this.yishengOrderTypes = yishengOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
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
