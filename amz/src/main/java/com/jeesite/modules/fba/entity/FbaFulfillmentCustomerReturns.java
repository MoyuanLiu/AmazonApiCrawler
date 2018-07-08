/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * fba_fulfillment_customer_returnsEntity
 * @author xlk
 * @version 2018-05-17
 */
@Table(name="fba_fulfillment_customer_returns", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="return_date", attrName="returnDate", label="return_date"),
		@Column(name="order_id", attrName="orderId", label="order_id"),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="quantity", attrName="quantity", label="quantity"),
		@Column(name="fulfillment_center_id", attrName="fulfillmentCenterId", label="fulfillment_center_id"),
		@Column(name="detailed_disposition", attrName="detailedDisposition", label="detailed_disposition"),
		@Column(name="reason", attrName="reason", label="reason"),
		@Column(name="status1", attrName="status1", label="status1"),
		@Column(name="license_plate_number", attrName="licensePlateNumber", label="license_plate_number"),
		@Column(name="customer_comments", attrName="customerComments", label="customer_comments"),
	}, orderBy="a.update_date DESC"
)
public class FbaFulfillmentCustomerReturns extends DataEntity<FbaFulfillmentCustomerReturns> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String returnDate;		// return_date
	private String orderId;		// order_id
	private String sku;		// sku
	private String asin;		// asin
	private String fnsku;		// fnsku
	private String productName;		// product_name
	private String quantity;		// quantity
	private String fulfillmentCenterId;		// fulfillment_center_id
	private String detailedDisposition;		// detailed_disposition
	private String reason;		// reason
	private String status1;		// status1
	private String licensePlateNumber;		// license_plate_number
	private String customerComments;		// customer_comments
	
	public FbaFulfillmentCustomerReturns() {
		this(null);
	}

	public FbaFulfillmentCustomerReturns(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=255, message="task_code长度不能超过 255 个字符")
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	@Length(min=0, max=255, message="store_name长度不能超过 255 个字符")
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Length(min=0, max=255, message="return_date长度不能超过 255 个字符")
	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	@Length(min=0, max=255, message="order_id长度不能超过 255 个字符")
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@Length(min=0, max=255, message="sku长度不能超过 255 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Length(min=0, max=255, message="asin长度不能超过 255 个字符")
	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}
	
	@Length(min=0, max=255, message="fnsku长度不能超过 255 个字符")
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}
	
	@Length(min=0, max=255, message="product_name长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=0, max=255, message="quantity长度不能超过 255 个字符")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Length(min=0, max=255, message="fulfillment_center_id长度不能超过 255 个字符")
	public String getFulfillmentCenterId() {
		return fulfillmentCenterId;
	}

	public void setFulfillmentCenterId(String fulfillmentCenterId) {
		this.fulfillmentCenterId = fulfillmentCenterId;
	}
	
	@Length(min=0, max=255, message="detailed_disposition长度不能超过 255 个字符")
	public String getDetailedDisposition() {
		return detailedDisposition;
	}

	public void setDetailedDisposition(String detailedDisposition) {
		this.detailedDisposition = detailedDisposition;
	}
	
	@Length(min=0, max=255, message="reason长度不能超过 255 个字符")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Length(min=0, max=255, message="status1长度不能超过 255 个字符")
	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	
	@Length(min=0, max=255, message="license_plate_number长度不能超过 255 个字符")
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	
	@Length(min=0, max=255, message="customer_comments长度不能超过 255 个字符")
	public String getCustomerComments() {
		return customerComments;
	}

	public void setCustomerComments(String customerComments) {
		this.customerComments = customerComments;
	}
	
}