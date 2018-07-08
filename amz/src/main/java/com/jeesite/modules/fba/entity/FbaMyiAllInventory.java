/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * fba_myi_all_inventoryEntity
 * @author xlk
 * @version 2018-05-16
 */
@Table(name="fba_myi_all_inventory", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="condition", attrName="condition", label="condition"),
		@Column(name="your_price", attrName="yourPrice", label="your_price"),
		@Column(name="mfn_listing_exists", attrName="mfnListingExists", label="mfn_listing_exists"),
		@Column(name="mfn_fulfillable_quantity", attrName="mfnFulfillableQuantity", label="mfn_fulfillable_quantity"),
		@Column(name="afn_listing_exists", attrName="afnListingExists", label="afn_listing_exists"),
		@Column(name="afn_warehouse_quantity", attrName="afnWarehouseQuantity", label="afn_warehouse_quantity"),
		@Column(name="afn_fulfillable_quantity", attrName="afnFulfillableQuantity", label="afn_fulfillable_quantity"),
		@Column(name="afn_unsellable_quantity", attrName="afnUnsellableQuantity", label="afn_unsellable_quantity"),
		@Column(name="afn_reserved_quantity", attrName="afnReservedQuantity", label="afn_reserved_quantity"),
		@Column(name="afn_total_quantity", attrName="afnTotalQuantity", label="afn_total_quantity"),
		@Column(name="per_unit_volume", attrName="perUnitVolume", label="per_unit_volume"),
		@Column(name="afn_inbound_working_quantity", attrName="afnInboundWorkingQuantity", label="afn_inbound_working_quantity"),
		@Column(name="afn_inbound_shipped_quantity", attrName="afnInboundShippedQuantity", label="afn_inbound_shipped_quantity"),
		@Column(name="afn_inbound_receiving_quantity", attrName="afnInboundReceivingQuantity", label="afn_inbound_receiving_quantity"),
	}, orderBy="a.update_date DESC"
)
public class FbaMyiAllInventory extends DataEntity<FbaMyiAllInventory> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String sku;		// sku
	private String fnsku;		// fnsku
	private String asin;		// asin
	private String productName;		// product_name
	private String condition;		// condition
	private String yourPrice;		// your_price
	private String mfnListingExists;		// mfn_listing_exists
	private String mfnFulfillableQuantity;		// mfn_fulfillable_quantity
	private String afnListingExists;		// afn_listing_exists
	private String afnWarehouseQuantity;		// afn_warehouse_quantity
	private String afnFulfillableQuantity;		// afn_fulfillable_quantity
	private String afnUnsellableQuantity;		// afn_unsellable_quantity
	private String afnReservedQuantity;		// afn_reserved_quantity
	private String afnTotalQuantity;		// afn_total_quantity
	private String perUnitVolume;		// per_unit_volume
	private String afnInboundWorkingQuantity;		// afn_inbound_working_quantity
	private String afnInboundShippedQuantity;		// afn_inbound_shipped_quantity
	private String afnInboundReceivingQuantity;		// afn_inbound_receiving_quantity
	
	public FbaMyiAllInventory() {
		this(null);
	}

	public FbaMyiAllInventory(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="task_code不能为空")
	@Length(min=0, max=255, message="task_code长度不能超过 255 个字符")
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	@NotBlank(message="store_name不能为空")
	@Length(min=0, max=255, message="store_name长度不能超过 255 个字符")
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@NotBlank(message="sku不能为空")
	@Length(min=0, max=255, message="sku长度不能超过 255 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@NotBlank(message="fnsku不能为空")
	@Length(min=0, max=255, message="fnsku长度不能超过 255 个字符")
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}
	
	@NotBlank(message="asin不能为空")
	@Length(min=0, max=255, message="asin长度不能超过 255 个字符")
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
	
	@NotBlank(message="condition不能为空")
	@Length(min=0, max=255, message="condition长度不能超过 255 个字符")
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@NotBlank(message="your_price不能为空")
	@Length(min=0, max=255, message="your_price长度不能超过 255 个字符")
	public String getYourPrice() {
		return yourPrice;
	}

	public void setYourPrice(String yourPrice) {
		this.yourPrice = yourPrice;
	}
	
	@NotBlank(message="mfn_listing_exists不能为空")
	@Length(min=0, max=255, message="mfn_listing_exists长度不能超过 255 个字符")
	public String getMfnListingExists() {
		return mfnListingExists;
	}

	public void setMfnListingExists(String mfnListingExists) {
		this.mfnListingExists = mfnListingExists;
	}
	
	@NotBlank(message="mfn_fulfillable_quantity不能为空")
	@Length(min=0, max=255, message="mfn_fulfillable_quantity长度不能超过 255 个字符")
	public String getMfnFulfillableQuantity() {
		return mfnFulfillableQuantity;
	}

	public void setMfnFulfillableQuantity(String mfnFulfillableQuantity) {
		this.mfnFulfillableQuantity = mfnFulfillableQuantity;
	}
	
	@NotBlank(message="afn_listing_exists不能为空")
	@Length(min=0, max=255, message="afn_listing_exists长度不能超过 255 个字符")
	public String getAfnListingExists() {
		return afnListingExists;
	}

	public void setAfnListingExists(String afnListingExists) {
		this.afnListingExists = afnListingExists;
	}
	
	@NotBlank(message="afn_warehouse_quantity不能为空")
	@Length(min=0, max=255, message="afn_warehouse_quantity长度不能超过 255 个字符")
	public String getAfnWarehouseQuantity() {
		return afnWarehouseQuantity;
	}

	public void setAfnWarehouseQuantity(String afnWarehouseQuantity) {
		this.afnWarehouseQuantity = afnWarehouseQuantity;
	}
	
	@NotBlank(message="afn_fulfillable_quantity不能为空")
	@Length(min=0, max=255, message="afn_fulfillable_quantity长度不能超过 255 个字符")
	public String getAfnFulfillableQuantity() {
		return afnFulfillableQuantity;
	}

	public void setAfnFulfillableQuantity(String afnFulfillableQuantity) {
		this.afnFulfillableQuantity = afnFulfillableQuantity;
	}
	
	@NotBlank(message="afn_unsellable_quantity不能为空")
	@Length(min=0, max=255, message="afn_unsellable_quantity长度不能超过 255 个字符")
	public String getAfnUnsellableQuantity() {
		return afnUnsellableQuantity;
	}

	public void setAfnUnsellableQuantity(String afnUnsellableQuantity) {
		this.afnUnsellableQuantity = afnUnsellableQuantity;
	}
	
	@NotBlank(message="afn_reserved_quantity不能为空")
	@Length(min=0, max=255, message="afn_reserved_quantity长度不能超过 255 个字符")
	public String getAfnReservedQuantity() {
		return afnReservedQuantity;
	}

	public void setAfnReservedQuantity(String afnReservedQuantity) {
		this.afnReservedQuantity = afnReservedQuantity;
	}
	
	@NotBlank(message="afn_total_quantity不能为空")
	@Length(min=0, max=255, message="afn_total_quantity长度不能超过 255 个字符")
	public String getAfnTotalQuantity() {
		return afnTotalQuantity;
	}

	public void setAfnTotalQuantity(String afnTotalQuantity) {
		this.afnTotalQuantity = afnTotalQuantity;
	}
	
	@NotBlank(message="per_unit_volume不能为空")
	@Length(min=0, max=255, message="per_unit_volume长度不能超过 255 个字符")
	public String getPerUnitVolume() {
		return perUnitVolume;
	}

	public void setPerUnitVolume(String perUnitVolume) {
		this.perUnitVolume = perUnitVolume;
	}
	
	@NotBlank(message="afn_inbound_working_quantity不能为空")
	@Length(min=0, max=255, message="afn_inbound_working_quantity长度不能超过 255 个字符")
	public String getAfnInboundWorkingQuantity() {
		return afnInboundWorkingQuantity;
	}

	public void setAfnInboundWorkingQuantity(String afnInboundWorkingQuantity) {
		this.afnInboundWorkingQuantity = afnInboundWorkingQuantity;
	}
	
	@NotBlank(message="afn_inbound_shipped_quantity不能为空")
	@Length(min=0, max=255, message="afn_inbound_shipped_quantity长度不能超过 255 个字符")
	public String getAfnInboundShippedQuantity() {
		return afnInboundShippedQuantity;
	}

	public void setAfnInboundShippedQuantity(String afnInboundShippedQuantity) {
		this.afnInboundShippedQuantity = afnInboundShippedQuantity;
	}
	
	@NotBlank(message="afn_inbound_receiving_quantity不能为空")
	@Length(min=0, max=255, message="afn_inbound_receiving_quantity长度不能超过 255 个字符")
	public String getAfnInboundReceivingQuantity() {
		return afnInboundReceivingQuantity;
	}

	public void setAfnInboundReceivingQuantity(String afnInboundReceivingQuantity) {
		this.afnInboundReceivingQuantity = afnInboundReceivingQuantity;
	}
	
}