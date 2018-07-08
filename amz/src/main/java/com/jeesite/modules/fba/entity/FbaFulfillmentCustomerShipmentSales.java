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
 * fba_fulfillment_customer_shipment_salesEntity
 * @author xlk
 * @version 2018-05-17
 */
@Table(name="fba_fulfillment_customer_shipment_sales", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="shipment_date", attrName="shipmentDate", label="shipment_date"),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="fulfillment_center_id", attrName="fulfillmentCenterId", label="fulfillment_center_id"),
		@Column(name="quantity", attrName="quantity", label="quantity"),
		@Column(name="amazon_order_id", attrName="amazonOrderId", label="amazon_order_id"),
		@Column(name="currency", attrName="currency", label="currency"),
		@Column(name="item_price_per_unit", attrName="itemPricePerUnit", label="item_price_per_unit"),
		@Column(name="shipping_price", attrName="shippingPrice", label="shipping_price"),
		@Column(name="gift_wrap_price", attrName="giftWrapPrice", label="gift_wrap_price"),
		@Column(name="ship_city", attrName="shipCity", label="ship_city"),
		@Column(name="ship_state", attrName="shipState", label="ship_state"),
		@Column(name="ship_postal_code", attrName="shipPostalCode", label="ship_postal_code"),
	}, orderBy="a.update_date DESC"
)
public class FbaFulfillmentCustomerShipmentSales extends DataEntity<FbaFulfillmentCustomerShipmentSales> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String shipmentDate;		// shipment_date
	private String sku;		// sku
	private String fnsku;		// fnsku
	private String asin;		// asin
	private String fulfillmentCenterId;		// fulfillment_center_id
	private String quantity;		// quantity
	private String amazonOrderId;		// amazon_order_id
	private String currency;		// currency
	private String itemPricePerUnit;		// item_price_per_unit
	private String shippingPrice;		// shipping_price
	private String giftWrapPrice;		// gift_wrap_price
	private String shipCity;		// ship_city
	private String shipState;		// ship_state
	private String shipPostalCode;		// ship_postal_code
	
	public FbaFulfillmentCustomerShipmentSales() {
		this(null);
	}

	public FbaFulfillmentCustomerShipmentSales(String id){
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
	
	@Length(min=0, max=255, message="shipment_date长度不能超过 255 个字符")
	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	@Length(min=0, max=255, message="sku长度不能超过 255 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Length(min=0, max=255, message="fnsku长度不能超过 255 个字符")
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}
	
	@Length(min=0, max=255, message="asin长度不能超过 255 个字符")
	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
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
	
	@Length(min=0, max=255, message="amazon_order_id长度不能超过 255 个字符")
	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}
	
	@Length(min=0, max=255, message="currency长度不能超过 255 个字符")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Length(min=0, max=255, message="item_price_per_unit长度不能超过 255 个字符")
	public String getItemPricePerUnit() {
		return itemPricePerUnit;
	}

	public void setItemPricePerUnit(String itemPricePerUnit) {
		this.itemPricePerUnit = itemPricePerUnit;
	}
	
	@Length(min=0, max=255, message="shipping_price长度不能超过 255 个字符")
	public String getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(String shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	
	@Length(min=0, max=255, message="gift_wrap_price长度不能超过 255 个字符")
	public String getGiftWrapPrice() {
		return giftWrapPrice;
	}

	public void setGiftWrapPrice(String giftWrapPrice) {
		this.giftWrapPrice = giftWrapPrice;
	}
	
	@Length(min=0, max=255, message="ship_city长度不能超过 255 个字符")
	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	
	@Length(min=0, max=255, message="ship_state长度不能超过 255 个字符")
	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	
	@Length(min=0, max=255, message="ship_postal_code长度不能超过 255 个字符")
	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}
	
}