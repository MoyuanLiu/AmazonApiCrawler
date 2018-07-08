/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.entity.rid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * reserved_inventory_dataEntity
 * @author xunlikun
 * @version 2018-05-16
 */
@Table(name="reserved_inventory_data", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="reserved_qty", attrName="reservedQty", label="reserved_qty"),
		@Column(name="reserved_customerorders", attrName="reservedCustomerorders", label="reserved_customerorders"),
		@Column(name="reserved_fc_transfers", attrName="reservedFcTransfers", label="reserved_fc_transfers"),
		@Column(name="reserved_fc_processing", attrName="reservedFcProcessing", label="reserved_fc_processing"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ReservedInventoryData extends DataEntity<ReservedInventoryData> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String sku;		// sku
	private String fnsku;		// fnsku
	private String asin;		// asin
	private String productName;		// product_name
	private Integer reservedQty;		// reserved_qty
	private Integer reservedCustomerorders;		// reserved_customerorders
	private Integer reservedFcTransfers;		// reserved_fc_transfers
	private Integer reservedFcProcessing;		// reserved_fc_processing
	
	public ReservedInventoryData() {
		this(null);
	}

	public ReservedInventoryData(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="task_code不能为空")
	@Length(min=0, max=64, message="task_code长度不能超过 64 个字符")
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	@NotBlank(message="store_name不能为空")
	@Length(min=0, max=100, message="store_name长度不能超过 100 个字符")
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@NotBlank(message="sku不能为空")
	@Length(min=0, max=64, message="sku长度不能超过 64 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@NotBlank(message="fnsku不能为空")
	@Length(min=0, max=64, message="fnsku长度不能超过 64 个字符")
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}
	
	@NotBlank(message="asin不能为空")
	@Length(min=0, max=64, message="asin长度不能超过 64 个字符")
	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}
	
	@NotBlank(message="product_name不能为空")
	@Length(min=0, max=255, message="product_name长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@NotNull(message="reserved_qty不能为空")
	public Integer getReservedQty() {
		return reservedQty;
	}

	public void setReservedQty(Integer reservedQty) {
		this.reservedQty = reservedQty;
	}
	
	@NotNull(message="reserved_customerorders不能为空")
	public Integer getReservedCustomerorders() {
		return reservedCustomerorders;
	}

	public void setReservedCustomerorders(Integer reservedCustomerorders) {
		this.reservedCustomerorders = reservedCustomerorders;
	}
	
	@NotNull(message="reserved_fc_transfers不能为空")
	public Integer getReservedFcTransfers() {
		return reservedFcTransfers;
	}

	public void setReservedFcTransfers(Integer reservedFcTransfers) {
		this.reservedFcTransfers = reservedFcTransfers;
	}
	
	@NotNull(message="reserved_fc_processing不能为空")
	public Integer getReservedFcProcessing() {
		return reservedFcProcessing;
	}

	public void setReservedFcProcessing(Integer reservedFcProcessing) {
		this.reservedFcProcessing = reservedFcProcessing;
	}
	
}