package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YishengOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yisheng_order")
public class YishengOrderView extends YishengOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 挂号时间段的值
	*/
	@ColumnInfo(comment="挂号时间段的字典表值",type="varchar(200)")
	private String shijianduanValue;
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String yishengOrderValue;

	//级联表 医生
		/**
		* 医生名称
		*/

		@ColumnInfo(comment="医生名称",type="varchar(200)")
		private String yishengName;
		/**
		* 医生手机号
		*/

		@ColumnInfo(comment="医生手机号",type="varchar(200)")
		private String yishengPhone;
		/**
		* 医生头像
		*/

		@ColumnInfo(comment="医生头像",type="varchar(200)")
		private String yishengPhoto;
		/**
		* 医生邮箱
		*/

		@ColumnInfo(comment="医生邮箱",type="varchar(200)")
		private String yishengEmail;
		/**
		* 科室
		*/
		@ColumnInfo(comment="科室",type="int(11)")
		private Integer yishengTypes;
			/**
			* 科室的值
			*/
			@ColumnInfo(comment="科室的字典表值",type="varchar(200)")
			private String yishengValue;
		/**
		* 挂号人数限制
		*/

		@ColumnInfo(comment="挂号人数限制",type="int(11)")
		private Integer yishengNumber;
		/**
		* 挂号价格
		*/
		@ColumnInfo(comment="挂号价格",type="decimal(10,2)")
		private Double yishengNewMoney;
		/**
		* 在诊日期
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="在诊日期",type="timestamp")
		private Date yishengTime;
		/**
		* 职称
		*/

		@ColumnInfo(comment="职称",type="varchar(200)")
		private String yishengZhicheng;
		/**
		* 医生简介
		*/

		@ColumnInfo(comment="医生简介",type="longtext")
		private String yishengContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yishengDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 现有余额
		*/
		@ColumnInfo(comment="现有余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public YishengOrderView() {

	}

	public YishengOrderView(YishengOrderEntity yishengOrderEntity) {
		try {
			BeanUtils.copyProperties(this, yishengOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 挂号时间段的值
	*/
	public String getShijianduanValue() {
		return shijianduanValue;
	}
	/**
	* 设置： 挂号时间段的值
	*/
	public void setShijianduanValue(String shijianduanValue) {
		this.shijianduanValue = shijianduanValue;
	}
	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getYishengOrderValue() {
		return yishengOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setYishengOrderValue(String yishengOrderValue) {
		this.yishengOrderValue = yishengOrderValue;
	}


	//级联表的get和set 医生

		/**
		* 获取： 医生名称
		*/
		public String getYishengName() {
			return yishengName;
		}
		/**
		* 设置： 医生名称
		*/
		public void setYishengName(String yishengName) {
			this.yishengName = yishengName;
		}

		/**
		* 获取： 医生手机号
		*/
		public String getYishengPhone() {
			return yishengPhone;
		}
		/**
		* 设置： 医生手机号
		*/
		public void setYishengPhone(String yishengPhone) {
			this.yishengPhone = yishengPhone;
		}

		/**
		* 获取： 医生头像
		*/
		public String getYishengPhoto() {
			return yishengPhoto;
		}
		/**
		* 设置： 医生头像
		*/
		public void setYishengPhoto(String yishengPhoto) {
			this.yishengPhoto = yishengPhoto;
		}

		/**
		* 获取： 医生邮箱
		*/
		public String getYishengEmail() {
			return yishengEmail;
		}
		/**
		* 设置： 医生邮箱
		*/
		public void setYishengEmail(String yishengEmail) {
			this.yishengEmail = yishengEmail;
		}
		/**
		* 获取： 科室
		*/
		public Integer getYishengTypes() {
			return yishengTypes;
		}
		/**
		* 设置： 科室
		*/
		public void setYishengTypes(Integer yishengTypes) {
			this.yishengTypes = yishengTypes;
		}


			/**
			* 获取： 科室的值
			*/
			public String getYishengValue() {
				return yishengValue;
			}
			/**
			* 设置： 科室的值
			*/
			public void setYishengValue(String yishengValue) {
				this.yishengValue = yishengValue;
			}

		/**
		* 获取： 挂号人数限制
		*/
		public Integer getYishengNumber() {
			return yishengNumber;
		}
		/**
		* 设置： 挂号人数限制
		*/
		public void setYishengNumber(Integer yishengNumber) {
			this.yishengNumber = yishengNumber;
		}

		/**
		* 获取： 挂号价格
		*/
		public Double getYishengNewMoney() {
			return yishengNewMoney;
		}
		/**
		* 设置： 挂号价格
		*/
		public void setYishengNewMoney(Double yishengNewMoney) {
			this.yishengNewMoney = yishengNewMoney;
		}

		/**
		* 获取： 在诊日期
		*/
		public Date getYishengTime() {
			return yishengTime;
		}
		/**
		* 设置： 在诊日期
		*/
		public void setYishengTime(Date yishengTime) {
			this.yishengTime = yishengTime;
		}

		/**
		* 获取： 职称
		*/
		public String getYishengZhicheng() {
			return yishengZhicheng;
		}
		/**
		* 设置： 职称
		*/
		public void setYishengZhicheng(String yishengZhicheng) {
			this.yishengZhicheng = yishengZhicheng;
		}

		/**
		* 获取： 医生简介
		*/
		public String getYishengContent() {
			return yishengContent;
		}
		/**
		* 设置： 医生简介
		*/
		public void setYishengContent(String yishengContent) {
			this.yishengContent = yishengContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYishengDelete() {
			return yishengDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYishengDelete(Integer yishengDelete) {
			this.yishengDelete = yishengDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 现有余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 现有余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "YishengOrderView{" +
			", shijianduanValue=" + shijianduanValue +
			", yishengOrderValue=" + yishengOrderValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			", yishengName=" + yishengName +
			", yishengPhone=" + yishengPhone +
			", yishengPhoto=" + yishengPhoto +
			", yishengEmail=" + yishengEmail +
			", yishengNumber=" + yishengNumber +
			", yishengNewMoney=" + yishengNewMoney +
			", yishengTime=" + DateUtil.convertString(yishengTime,"yyyy-MM-dd") +
			", yishengZhicheng=" + yishengZhicheng +
			", yishengContent=" + yishengContent +
			", yishengDelete=" + yishengDelete +
			"} " + super.toString();
	}
}
