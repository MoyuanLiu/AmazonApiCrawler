/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.orders.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * all_orders_dataEntity
 * @author xlk
 * @version 2018-05-16
 */
@Table(name="all_orders_data", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="amazon_order_id", attrName="amazonOrderId", label="amazon_order_id"),
		@Column(name="merchant_order_id", attrName="merchantOrderId", label="merchant_order_id"),
		@Column(name="purchase_date", attrName="purchaseDate", label="purchase_date"),
		@Column(name="last_updated_date", attrName="lastUpdatedDate", label="last_updated_date"),
		@Column(name="order_status", attrName="orderStatus", label="order_status"),
		@Column(name="fulfillment_channel", attrName="fulfillmentChannel", label="fulfillment_channel"),
		@Column(name="sales_channel", attrName="salesChannel", label="sales_channel"),
		@Column(name="order_channel", attrName="orderChannel", label="order_channel"),
		@Column(name="url", attrName="url", label="url"),
		@Column(name="ship_service_level", attrName="shipServiceLevel", label="ship_service_level"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="item_status", attrName="itemStatus", label="item_status"),
		@Column(name="quantity", attrName="quantity", label="quantity"),
		@Column(name="currency", attrName="currency", label="currency"),
		@Column(name="item_price", attrName="itemPrice", label="item_price"),
		@Column(name="item_tax", attrName="itemTax", label="item_tax"),
		@Column(name="shipping_price", attrName="shippingPrice", label="shipping_price"),
		@Column(name="shipping_tax", attrName="shippingTax", label="shipping_tax"),
		@Column(name="gift_wrap_price", attrName="giftWrapPrice", label="gift_wrap_price"),
		@Column(name="gift_wrap_tax", attrName="giftWrapTax", label="gift_wrap_tax"),
		@Column(name="item_promotion_discount", attrName="itemPromotionDiscount", label="item_promotion_discount"),
		@Column(name="ship_promotion_discount", attrName="shipPromotionDiscount", label="ship_promotion_discount"),
		@Column(name="ship_city", attrName="shipCity", label="ship_city"),
		@Column(name="ship_state", attrName="shipState", label="ship_state"),
		@Column(name="ship_postal_code", attrName="shipPostalCode", label="ship_postal_code"),
		@Column(name="ship_country", attrName="shipCountry", label="ship_country"),
		@Column(name="promotion_ids", attrName="promotionIds", label="promotion_ids"),
		@Column(name="is_business_order", attrName="isBusinessOrder", label="is_business_order"),
		@Column(name="purchase_order_number", attrName="purchaseOrderNumber", label="purchase_order_number"),
		@Column(name="price_designation", attrName="priceDesignation", label="price_designation"),
	}, orderBy="a.update_date DESC"
)
public class AllOrdersData extends DataEntity<AllOrdersData> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String amazonOrderId;		// amazon_order_id
	private String merchantOrderId;		// merchant_order_id
	private String purchaseDate;		// purchase_date
	private String lastUpdatedDate;		// last_updated_date
	private String orderStatus;		// order_status
	private String fulfillmentChannel;		// fulfillment_channel
	private String salesChannel;		// sales_channel
	private String orderChannel;		// order_channel
	private String url;		// url
	private String shipServiceLevel;		// ship_service_level
	private String productName;		// product_name
	private String sku;		// sku
	private String asin;		// asin
	private String itemStatus;		// item_status
	private String quantity;		// quantity
	private String currency;		// currency
	private String itemPrice;		// item_price
	private String itemTax;		// item_tax
	private String shippingPrice;		// shipping_price
	private String shippingTax;		// shipping_tax
	private String giftWrapPrice;		// gift_wrap_price
	private String giftWrapTax;		// gift_wrap_tax
	private String itemPromotionDiscount;		// item_promotion_discount
	private String shipPromotionDiscount;		// ship_promotion_discount
	private String shipCity;		// ship_city
	private String shipState;		// ship_state
	private String shipPostalCode;		// ship_postal_code
	private String shipCountry;		// ship_country
	private String promotionIds;		// promotion_ids
	private String isBusinessOrder;		// is_business_order
	private String purchaseOrderNumber;		// purchase_order_number
	private String priceDesignation;		// price_designation
	
	public AllOrdersData() {
		this(null);
	}

	public AllOrdersData(String id){
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
	
	@NotBlank(message="amazon_order_id不能为空")
	@Length(min=0, max=255, message="amazon_order_id长度不能超过 255 个字符")
	public String getAmazonOrderId() {
		return amazonOrderId;
	}

	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}
	
	@NotBlank(message="merchant_order_id不能为空")
	@Length(min=0, max=255, message="merchant_order_id长度不能超过 255 个字符")
	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	
	@NotBlank(message="purchase_date不能为空")
	@Length(min=0, max=255, message="purchase_date长度不能超过 255 个字符")
	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@NotBlank(message="last_updated_date不能为空")
	@Length(min=0, max=255, message="last_updated_date长度不能超过 255 个字符")
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@NotBlank(message="order_status不能为空")
	@Length(min=0, max=255, message="order_status长度不能超过 255 个字符")
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@NotBlank(message="fulfillment_channel不能为空")
	@Length(min=0, max=255, message="fulfillment_channel长度不能超过 255 个字符")
	public String getFulfillmentChannel() {
		return fulfillmentChannel;
	}

	public void setFulfillmentChannel(String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
	}
	
	@NotBlank(message="sales_channel不能为空")
	@Length(min=0, max=255, message="sales_channel长度不能超过 255 个字符")
	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}
	
	@NotBlank(message="order_channel不能为空")
	@Length(min=0, max=255, message="order_channel长度不能超过 255 个字符")
	public String getOrderChannel() {
		return orderChannel;
	}

	public void setOrderChannel(String orderChannel) {
		this.orderChannel = orderChannel;
	}
	
	@NotBlank(message="url不能为空")
	@Length(min=0, max=255, message="url长度不能超过 255 个字符")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@NotBlank(message="ship_service_level不能为空")
	@Length(min=0, max=255, message="ship_service_level长度不能超过 255 个字符")
	public String getShipServiceLevel() {
		return shipServiceLevel;
	}

	public void setShipServiceLevel(String shipServiceLevel) {
		this.shipServiceLevel = shipServiceLevel;
	}
	
	@NotBlank(message="product_name不能为空")
	@Length(min=0, max=255, message="product_name长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@NotBlank(message="sku不能为空")
	@Length(min=0, max=255, message="sku长度不能超过 255 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@NotBlank(message="asin不能为空")
	@Length(min=0, max=255, message="asin长度不能超过 255 个字符")
	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}
	
	@NotBlank(message="item_status不能为空")
	@Length(min=0, max=255, message="item_status长度不能超过 255 个字符")
	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	
	@NotBlank(message="quantity不能为空")
	@Length(min=0, max=255, message="quantity长度不能超过 255 个字符")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@NotBlank(message="currency不能为空")
	@Length(min=0, max=255, message="currency长度不能超过 255 个字符")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@NotBlank(message="item_price不能为空")
	@Length(min=0, max=255, message="item_price长度不能超过 255 个字符")
	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@NotBlank(message="item_tax不能为空")
	@Length(min=0, max=255, message="item_tax长度不能超过 255 个字符")
	public String getItemTax() {
		return itemTax;
	}

	public void setItemTax(String itemTax) {
		this.itemTax = itemTax;
	}
	
	@NotBlank(message="shipping_price不能为空")
	@Length(min=0, max=255, message="shipping_price长度不能超过 255 个字符")
	public String getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(String shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	
	@NotBlank(message="shipping_tax不能为空")
	@Length(min=0, max=255, message="shipping_tax长度不能超过 255 个字符")
	public String getShippingTax() {
		return shippingTax;
	}

	public void setShippingTax(String shippingTax) {
		this.shippingTax = shippingTax;
	}
	
	@NotBlank(message="gift_wrap_price不能为空")
	@Length(min=0, max=255, message="gift_wrap_price长度不能超过 255 个字符")
	public String getGiftWrapPrice() {
		return giftWrapPrice;
	}

	public void setGiftWrapPrice(String giftWrapPrice) {
		this.giftWrapPrice = giftWrapPrice;
	}
	
	@NotBlank(message="gift_wrap_tax不能为空")
	@Length(min=0, max=255, message="gift_wrap_tax长度不能超过 255 个字符")
	public String getGiftWrapTax() {
		return giftWrapTax;
	}

	public void setGiftWrapTax(String giftWrapTax) {
		this.giftWrapTax = giftWrapTax;
	}
	
	@NotBlank(message="item_promotion_discount不能为空")
	@Length(min=0, max=255, message="item_promotion_discount长度不能超过 255 个字符")
	public String getItemPromotionDiscount() {
		return itemPromotionDiscount;
	}

	public void setItemPromotionDiscount(String itemPromotionDiscount) {
		this.itemPromotionDiscount = itemPromotionDiscount;
	}
	
	@NotBlank(message="ship_promotion_discount不能为空")
	@Length(min=0, max=255, message="ship_promotion_discount长度不能超过 255 个字符")
	public String getShipPromotionDiscount() {
		return shipPromotionDiscount;
	}

	public void setShipPromotionDiscount(String shipPromotionDiscount) {
		this.shipPromotionDiscount = shipPromotionDiscount;
	}
	
	@NotBlank(message="ship_city不能为空")
	@Length(min=0, max=255, message="ship_city长度不能超过 255 个字符")
	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	
	@NotBlank(message="ship_state不能为空")
	@Length(min=0, max=255, message="ship_state长度不能超过 255 个字符")
	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	
	@NotBlank(message="ship_postal_code不能为空")
	@Length(min=0, max=255, message="ship_postal_code长度不能超过 255 个字符")
	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}
	
	@NotBlank(message="ship_country不能为空")
	@Length(min=0, max=255, message="ship_country长度不能超过 255 个字符")
	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}
	
	@NotBlank(message="promotion_ids不能为空")
	@Length(min=0, max=255, message="promotion_ids长度不能超过 255 个字符")
	public String getPromotionIds() {
		return promotionIds;
	}

	public void setPromotionIds(String promotionIds) {
		this.promotionIds = promotionIds;
	}
	
	@NotBlank(message="is_business_order不能为空")
	@Length(min=0, max=255, message="is_business_order长度不能超过 255 个字符")
	public String getIsBusinessOrder() {
		return isBusinessOrder;
	}

	public void setIsBusinessOrder(String isBusinessOrder) {
		this.isBusinessOrder = isBusinessOrder;
	}
	
	@NotBlank(message="purchase_order_number不能为空")
	@Length(min=0, max=255, message="purchase_order_number长度不能超过 255 个字符")
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	
	@NotBlank(message="price_designation不能为空")
	@Length(min=0, max=255, message="price_designation长度不能超过 255 个字符")
	public String getPriceDesignation() {
		return priceDesignation;
	}

	public void setPriceDesignation(String priceDesignation) {
		this.priceDesignation = priceDesignation;
	}
	
}