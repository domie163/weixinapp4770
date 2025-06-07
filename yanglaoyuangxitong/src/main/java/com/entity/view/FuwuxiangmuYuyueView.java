package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FuwuxiangmuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 服务项目预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fuwuxiangmu_yuyue")
public class FuwuxiangmuYuyueView extends FuwuxiangmuYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String fuwuxiangmuYuyueYesnoValue;

	//级联表 服务项目
		/**
		* 服务项目名称
		*/

		@ColumnInfo(comment="服务项目名称",type="varchar(200)")
		private String fuwuxiangmuName;
		/**
		* 服务项目类型
		*/
		@ColumnInfo(comment="服务项目类型",type="int(11)")
		private Integer fuwuxiangmuTypes;
			/**
			* 服务项目类型的值
			*/
			@ColumnInfo(comment="服务项目类型的字典表值",type="varchar(200)")
			private String fuwuxiangmuValue;
		/**
		* 服务项目封面
		*/

		@ColumnInfo(comment="服务项目封面",type="varchar(200)")
		private String fuwuxiangmuPhoto;
		/**
		* 服务项目介绍
		*/

		@ColumnInfo(comment="服务项目介绍",type="longtext")
		private String fuwuxiangmuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fuwuxiangmuDelete;
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



	public FuwuxiangmuYuyueView() {

	}

	public FuwuxiangmuYuyueView(FuwuxiangmuYuyueEntity fuwuxiangmuYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, fuwuxiangmuYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getFuwuxiangmuYuyueYesnoValue() {
		return fuwuxiangmuYuyueYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setFuwuxiangmuYuyueYesnoValue(String fuwuxiangmuYuyueYesnoValue) {
		this.fuwuxiangmuYuyueYesnoValue = fuwuxiangmuYuyueYesnoValue;
	}


	//级联表的get和set 服务项目

		/**
		* 获取： 服务项目名称
		*/
		public String getFuwuxiangmuName() {
			return fuwuxiangmuName;
		}
		/**
		* 设置： 服务项目名称
		*/
		public void setFuwuxiangmuName(String fuwuxiangmuName) {
			this.fuwuxiangmuName = fuwuxiangmuName;
		}
		/**
		* 获取： 服务项目类型
		*/
		public Integer getFuwuxiangmuTypes() {
			return fuwuxiangmuTypes;
		}
		/**
		* 设置： 服务项目类型
		*/
		public void setFuwuxiangmuTypes(Integer fuwuxiangmuTypes) {
			this.fuwuxiangmuTypes = fuwuxiangmuTypes;
		}


			/**
			* 获取： 服务项目类型的值
			*/
			public String getFuwuxiangmuValue() {
				return fuwuxiangmuValue;
			}
			/**
			* 设置： 服务项目类型的值
			*/
			public void setFuwuxiangmuValue(String fuwuxiangmuValue) {
				this.fuwuxiangmuValue = fuwuxiangmuValue;
			}

		/**
		* 获取： 服务项目封面
		*/
		public String getFuwuxiangmuPhoto() {
			return fuwuxiangmuPhoto;
		}
		/**
		* 设置： 服务项目封面
		*/
		public void setFuwuxiangmuPhoto(String fuwuxiangmuPhoto) {
			this.fuwuxiangmuPhoto = fuwuxiangmuPhoto;
		}

		/**
		* 获取： 服务项目介绍
		*/
		public String getFuwuxiangmuContent() {
			return fuwuxiangmuContent;
		}
		/**
		* 设置： 服务项目介绍
		*/
		public void setFuwuxiangmuContent(String fuwuxiangmuContent) {
			this.fuwuxiangmuContent = fuwuxiangmuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFuwuxiangmuDelete() {
			return fuwuxiangmuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFuwuxiangmuDelete(Integer fuwuxiangmuDelete) {
			this.fuwuxiangmuDelete = fuwuxiangmuDelete;
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


	@Override
	public String toString() {
		return "FuwuxiangmuYuyueView{" +
			", fuwuxiangmuYuyueYesnoValue=" + fuwuxiangmuYuyueYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			", fuwuxiangmuName=" + fuwuxiangmuName +
			", fuwuxiangmuPhoto=" + fuwuxiangmuPhoto +
			", fuwuxiangmuContent=" + fuwuxiangmuContent +
			", fuwuxiangmuDelete=" + fuwuxiangmuDelete +
			"} " + super.toString();
	}
}
