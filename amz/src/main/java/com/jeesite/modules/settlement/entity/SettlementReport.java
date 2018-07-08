/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.settlement.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * settlement_reportEntity
 * @author 荀立坤
 * @version 2018-06-06
 */
@Table(name="settlement_report", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(name="settlement_id", attrName="settlementId", label="settlement_id"),
		@Column(name="settlement_start_date", attrName="settlementStartDate", label="settlement_start_date"),
		@Column(name="settlement_end_date", attrName="settlementEndDate", label="settlement_end_date"),
		@Column(name="deposit_date", attrName="depositDate", label="deposit_date"),
		@Column(name="total_amount", attrName="totalAmount", label="total_amount"),
		@Column(name="currency", attrName="currency", label="currency"),
		@Column(name="transaction_type", attrName="transactionType", label="transaction_type"),
		@Column(name="order_id", attrName="orderId", label="order_id"),
		@Column(name="merchant_order_id", attrName="merchantOrderId", label="merchant_order_id"),
		@Column(name="adjustment_id", attrName="adjustmentId", label="adjustment_id"),
		@Column(name="shipment_id", attrName="shipmentId", label="shipment_id"),
		@Column(name="marketplace_name", attrName="marketplaceName", label="marketplace_name", queryType=QueryType.LIKE),
		@Column(name="amount_type", attrName="amountType", label="amount_type"),
		@Column(name="amount_description", attrName="amountDescription", label="amount_description"),
		@Column(name="amount", attrName="amount", label="amount"),
		@Column(name="fulfillment_id", attrName="fulfillmentId", label="fulfillment_id"),
		@Column(name="posted_date", attrName="postedDate", label="posted_date"),
		@Column(name="posted_date_time", attrName="postedDateTime", label="posted_date_time"),
		@Column(name="order_item_code", attrName="orderItemCode", label="order_item_code"),
		@Column(name="merchant_order_item_id", attrName="merchantOrderItemId", label="merchant_order_item_id"),
		@Column(name="merchant_adjustment_item_id", attrName="merchantAdjustmentItemId", label="merchant_adjustment_item_id"),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="quantity_purchased", attrName="quantityPurchased", label="quantity_purchased"),
		@Column(name="promotion_id", attrName="promotionId", label="promotion_id"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class SettlementReport extends DataEntity<SettlementReport> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;
	private String storeName;
	private String settlementId;		// settlement_id
	private String settlementStartDate;		// settlement_start_date
	private String settlementEndDate;		// settlement_end_date
	private String depositDate;		// deposit_date
	private String totalAmount;		// total_amount
	private String currency;		// currency
	private String transactionType;		// transaction_type
	private String orderId;		// order_id
	private String merchantOrderId;		// merchant_order_id
	private String adjustmentId;		// adjustment_id
	private String shipmentId;		// shipment_id
	private String marketplaceName;		// marketplace_name
	private String amountType;		// amount_type
	private String amountDescription;		// amount_description
	private String amount;		// amount
	private String fulfillmentId;		// fulfillment_id
	private String postedDate;		// posted_date
	private String postedDateTime;		// posted_date_time
	private String orderItemCode;		// order_item_code
	private String merchantOrderItemId;		// merchant_order_item_id
	private String merchantAdjustmentItemId;		// merchant_adjustment_item_id
	private String sku;		// sku
	private String quantityPurchased;		// quantity_purchased
	private String promotionId;		// promotion_id
	
	public SettlementReport() {
		this(null);
	}

	public SettlementReport(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=255, message="settlement_id长度不能超过 255 个字符")
	public String getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
	
	@Length(min=0, max=255, message="settlement_start_date长度不能超过 255 个字符")
	public String getSettlementStartDate() {
		return settlementStartDate;
	}

	public void setSettlementStartDate(String settlementStartDate) {
		this.settlementStartDate = settlementStartDate;
	}
	
	@Length(min=0, max=255, message="settlement_end_date长度不能超过 255 个字符")
	public String getSettlementEndDate() {
		return settlementEndDate;
	}

	public void setSettlementEndDate(String settlementEndDate) {
		this.settlementEndDate = settlementEndDate;
	}
	
	@Length(min=0, max=255, message="deposit_date长度不能超过 255 个字符")
	public String getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
	
	@Length(min=0, max=255, message="total_amount长度不能超过 255 个字符")
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Length(min=0, max=255, message="currency长度不能超过 255 个字符")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Length(min=0, max=255, message="transaction_type长度不能超过 255 个字符")
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Length(min=0, max=255, message="order_id长度不能超过 255 个字符")
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@Length(min=0, max=255, message="merchant_order_id长度不能超过 255 个字符")
	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}
	
	@Length(min=0, max=255, message="adjustment_id长度不能超过 255 个字符")
	public String getAdjustmentId() {
		return adjustmentId;
	}

	public void setAdjustmentId(String adjustmentId) {
		this.adjustmentId = adjustmentId;
	}
	
	@Length(min=0, max=255, message="shipment_id长度不能超过 255 个字符")
	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	
	@Length(min=0, max=255, message="marketplace_name长度不能超过 255 个字符")
	public String getMarketplaceName() {
		return marketplaceName;
	}

	public void setMarketplaceName(String marketplaceName) {
		this.marketplaceName = marketplaceName;
	}
	
	@Length(min=0, max=255, message="amount_type长度不能超过 255 个字符")
	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	
	@Length(min=0, max=255, message="amount_description长度不能超过 255 个字符")
	public String getAmountDescription() {
		return amountDescription;
	}

	public void setAmountDescription(String amountDescription) {
		this.amountDescription = amountDescription;
	}
	
	@Length(min=0, max=255, message="amount长度不能超过 255 个字符")
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Length(min=0, max=255, message="fulfillment_id长度不能超过 255 个字符")
	public String getFulfillmentId() {
		return fulfillmentId;
	}

	public void setFulfillmentId(String fulfillmentId) {
		this.fulfillmentId = fulfillmentId;
	}
	
	@Length(min=0, max=255, message="posted_date长度不能超过 255 个字符")
	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	
	@Length(min=0, max=255, message="posted_date_time长度不能超过 255 个字符")
	public String getPostedDateTime() {
		return postedDateTime;
	}

	public void setPostedDateTime(String postedDateTime) {
		this.postedDateTime = postedDateTime;
	}
	
	@Length(min=0, max=255, message="order_item_code长度不能超过 255 个字符")
	public String getOrderItemCode() {
		return orderItemCode;
	}

	public void setOrderItemCode(String orderItemCode) {
		this.orderItemCode = orderItemCode;
	}
	
	@Length(min=0, max=255, message="merchant_order_item_id长度不能超过 255 个字符")
	public String getMerchantOrderItemId() {
		return merchantOrderItemId;
	}

	public void setMerchantOrderItemId(String merchantOrderItemId) {
		this.merchantOrderItemId = merchantOrderItemId;
	}
	
	@Length(min=0, max=255, message="merchant_adjustment_item_id长度不能超过 255 个字符")
	public String getMerchantAdjustmentItemId() {
		return merchantAdjustmentItemId;
	}

	public void setMerchantAdjustmentItemId(String merchantAdjustmentItemId) {
		this.merchantAdjustmentItemId = merchantAdjustmentItemId;
	}
	
	@Length(min=0, max=255, message="sku长度不能超过 255 个字符")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Length(min=0, max=255, message="quantity_purchased长度不能超过 255 个字符")
	public String getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(String quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	
	@Length(min=0, max=255, message="promotion_id长度不能超过 255 个字符")
	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}