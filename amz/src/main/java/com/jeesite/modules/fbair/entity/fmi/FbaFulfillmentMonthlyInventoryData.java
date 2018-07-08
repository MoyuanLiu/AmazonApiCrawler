/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.entity.fmi;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * fba_fulfillment_monthly_inventory_dataEntity
 * @author xunlikun
 * @version 2018-05-16
 */
@Table(name="fba_fulfillment_monthly_inventory_data", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="month", attrName="month", label="month"),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="average_quantity", attrName="averageQuantity", label="average_quantity"),
		@Column(name="end_quantity", attrName="endQuantity", label="end_quantity"),
		@Column(name="fulfillment_center_id", attrName="fulfillmentCenterId", label="fulfillment_center_id"),
		@Column(name="detailed_disposition", attrName="detailedDisposition", label="detailed_disposition"),
		@Column(name="country", attrName="country", label="country"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class FbaFulfillmentMonthlyInventoryData extends DataEntity<FbaFulfillmentMonthlyInventoryData> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String month;		// month
	private String taskCode;		// task_code
	private String fnsku;		// fnsku
	private String storeName;		// store_name
	private String sku;		// sku
	private String productName;		// product_name
	private String averageQuantity;		// average_quantity
	private String endQuantity;		// end_quantity
	private String fulfillmentCenterId;		// fulfillment_center_id
	private String detailedDisposition;		// detailed_disposition
	private String country;		// country
	
	public FbaFulfillmentMonthlyInventoryData() {
		this(null);
	}

	public FbaFulfillmentMonthlyInventoryData(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="month不能为空")
	@Length(min=0, max=32, message="month长度不能超过 32 个字符")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	@Length(min=0, max=64, message="task_code长度不能超过 64 个字符")
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	@NotBlank(message="fnsku不能为空")
	@Length(min=0, max=32, message="fnsku长度不能超过 32 个字符")
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}
	
	@Length(min=0, max=255, message="store_name长度不能超过 255 个字符")
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@NotBlank(message="sku不能为空")
	@Length(min=0, max=32, message="sku长度不能超过 32 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@NotBlank(message="product_name不能为空")
	@Length(min=0, max=255, message="product_name长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@NotBlank(message="average_quantity不能为空")
	@Length(min=0, max=32, message="average_quantity长度不能超过 32 个字符")
	public String getAverageQuantity() {
		return averageQuantity;
	}

	public void setAverageQuantity(String averageQuantity) {
		this.averageQuantity = averageQuantity;
	}
	
	@NotBlank(message="end_quantity不能为空")
	@Length(min=0, max=32, message="end_quantity长度不能超过 32 个字符")
	public String getEndQuantity() {
		return endQuantity;
	}

	public void setEndQuantity(String endQuantity) {
		this.endQuantity = endQuantity;
	}
	
	@NotBlank(message="fulfillment_center_id不能为空")
	@Length(min=0, max=32, message="fulfillment_center_id长度不能超过 32 个字符")
	public String getFulfillmentCenterId() {
		return fulfillmentCenterId;
	}

	public void setFulfillmentCenterId(String fulfillmentCenterId) {
		this.fulfillmentCenterId = fulfillmentCenterId;
	}
	
	@NotBlank(message="detailed_disposition不能为空")
	@Length(min=0, max=32, message="detailed_disposition长度不能超过 32 个字符")
	public String getDetailedDisposition() {
		return detailedDisposition;
	}

	public void setDetailedDisposition(String detailedDisposition) {
		this.detailedDisposition = detailedDisposition;
	}
	
	@NotBlank(message="country不能为空")
	@Length(min=0, max=32, message="country长度不能超过 32 个字符")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}