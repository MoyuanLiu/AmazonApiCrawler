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
 * fba_fulfillment_inventory_adjustmentsEntity
 * @author xlk
 * @version 2018-05-17
 */
@Table(name="fba_fulfillment_inventory_adjustments", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="adjusted_date", attrName="adjustedDate", label="adjusted_date"),
		@Column(name="transaction_item_id", attrName="transactionItemId", label="transaction_item_id"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="fulfillment_center_id", attrName="fulfillmentCenterId", label="fulfillment_center_id"),
		@Column(name="quantity", attrName="quantity", label="quantity"),
		@Column(name="reason", attrName="reason", label="reason"),
		@Column(name="disposition", attrName="disposition", label="disposition"),
	}, orderBy="a.update_date DESC"
)
public class FbaFulfillmentInventoryAdjustments extends DataEntity<FbaFulfillmentInventoryAdjustments> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String adjustedDate;		// adjusted_date
	private String transactionItemId;		// transaction_item_id
	private String fnsku;		// fnsku
	private String sku;		// sku
	private String productName;		// product_name
	private String fulfillmentCenterId;		// fulfillment_center_id
	private String quantity;		// quantity
	private String reason;		// reason
	private String disposition;		// disposition
	
	public FbaFulfillmentInventoryAdjustments() {
		this(null);
	}

	public FbaFulfillmentInventoryAdjustments(String id){
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
	
	@Length(min=0, max=255, message="adjusted_date长度不能超过 255 个字符")
	public String getAdjustedDate() {
		return adjustedDate;
	}

	public void setAdjustedDate(String adjustedDate) {
		this.adjustedDate = adjustedDate;
	}
	
	@Length(min=0, max=255, message="transaction_item_id长度不能超过 255 个字符")
	public String getTransactionItemId() {
		return transactionItemId;
	}

	public void setTransactionItemId(String transactionItemId) {
		this.transactionItemId = transactionItemId;
	}
	
	@Length(min=0, max=255, message="fnsku长度不能超过 255 个字符")
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}
	
	@Length(min=0, max=255, message="sku长度不能超过 255 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Length(min=0, max=255, message="product_name长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=0, max=255, message="fulfillment_center_id长度不能超过 255 个字符")
	public String getFulfillmentCenterId() {
		return fulfillmentCenterId;
	}

	public void setFulfillmentCenterId(String fulfillmentCenterId) {
		this.fulfillmentCenterId = fulfillmentCenterId;
	}
	
	@Length(min=0, max=255, message="quantity长度不能超过 255 个字符")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Length(min=0, max=255, message="reason长度不能超过 255 个字符")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Length(min=0, max=255, message="disposition长度不能超过 255 个字符")
	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	
}