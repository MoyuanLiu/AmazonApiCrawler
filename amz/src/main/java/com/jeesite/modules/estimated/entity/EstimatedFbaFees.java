/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.estimated.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * estimated_fba_feesEntity
 * @author xlk
 * @version 2018-05-16
 */
@Table(name="estimated_fba_fees", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="product_group", attrName="productGroup", label="product_group"),
		@Column(name="brand", attrName="brand", label="brand"),
		@Column(name="fulfilled_by", attrName="fulfilledBy", label="fulfilled_by"),
		@Column(name="your_price", attrName="yourPrice", label="your_price"),
		@Column(name="sales_price", attrName="salesPrice", label="sales_price"),
		@Column(name="longest_side", attrName="longestSide", label="longest_side"),
		@Column(name="median_side", attrName="medianSide", label="median_side"),
		@Column(name="shortest_side", attrName="shortestSide", label="shortest_side"),
		@Column(name="length_and_girth", attrName="lengthAndGirth", label="length_and_girth"),
		@Column(name="unit_of_dimension", attrName="unitOfDimension", label="unit_of_dimension"),
		@Column(name="item_package_weight", attrName="itemPackageWeight", label="item_package_weight"),
		@Column(name="unit_of_weight", attrName="unitOfWeight", label="unit_of_weight"),
		@Column(name="product_size_tier", attrName="productSizeTier", label="product_size_tier"),
		@Column(name="currency", attrName="currency", label="currency"),
		@Column(name="estimated_fee_total", attrName="estimatedFeeTotal", label="estimated_fee_total"),
		@Column(name="estimated_referral_fee_per_unit", attrName="estimatedReferralFeePerUnit", label="estimated_referral_fee_per_unit"),
		@Column(name="estimated_variable_closing_fee", attrName="estimatedVariableClosingFee", label="estimated_variable_closing_fee"),
		@Column(name="estimated_order_handling_fee_per_order", attrName="estimatedOrderHandlingFeePerOrder", label="estimated_order_handling_fee_per_order"),
		@Column(name="estimated_pick_pack_fee_per_unit", attrName="estimatedPickPackFeePerUnit", label="estimated_pick_pack_fee_per_unit"),
		@Column(name="estimated_weight_handling_fee_per_unit", attrName="estimatedWeightHandlingFeePerUnit", label="estimated_weight_handling_fee_per_unit"),
		@Column(name="expected_fulfillment_fee_per_unit", attrName="expectedFulfillmentFeePerUnit", label="expected_fulfillment_fee_per_unit"),
	}, orderBy="a.update_date DESC"
)
public class EstimatedFbaFees extends DataEntity<EstimatedFbaFees> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String sku;		// sku
	private String fnsku;		// fnsku
	private String asin;		// asin
	private String productName;		// product_name
	private String productGroup;		// product_group
	private String brand;		// brand
	private String fulfilledBy;		// fulfilled_by
	private String yourPrice;		// your_price
	private String salesPrice;		// sales_price
	private String longestSide;		// longest_side
	private String medianSide;		// median_side
	private String shortestSide;		// shortest_side
	private String lengthAndGirth;		// length_and_girth
	private String unitOfDimension;		// unit_of_dimension
	private String itemPackageWeight;		// item_package_weight
	private String unitOfWeight;		// unit_of_weight
	private String productSizeTier;		// product_size_tier
	private String currency;		// currency
	private String estimatedFeeTotal;		// estimated_fee_total
	private String estimatedReferralFeePerUnit;		// estimated_referral_fee_per_unit
	private String estimatedVariableClosingFee;		// estimated_variable_closing_fee
	private String estimatedOrderHandlingFeePerOrder;		// estimated_order_handling_fee_per_order
	private String estimatedPickPackFeePerUnit;		// estimated_pick_pack_fee_per_unit
	private String estimatedWeightHandlingFeePerUnit;		// estimated_weight_handling_fee_per_unit
	private String expectedFulfillmentFeePerUnit;		// expected_fulfillment_fee_per_unit
	
	public EstimatedFbaFees() {
		this(null);
	}

	public EstimatedFbaFees(String id){
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
	
	@NotBlank(message="product_group不能为空")
	@Length(min=0, max=255, message="product_group长度不能超过 255 个字符")
	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}
	
	@NotBlank(message="brand不能为空")
	@Length(min=0, max=255, message="brand长度不能超过 255 个字符")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@NotBlank(message="fulfilled_by不能为空")
	@Length(min=0, max=255, message="fulfilled_by长度不能超过 255 个字符")
	public String getFulfilledBy() {
		return fulfilledBy;
	}

	public void setFulfilledBy(String fulfilledBy) {
		this.fulfilledBy = fulfilledBy;
	}
	
	@NotBlank(message="your_price不能为空")
	@Length(min=0, max=255, message="your_price长度不能超过 255 个字符")
	public String getYourPrice() {
		return yourPrice;
	}

	public void setYourPrice(String yourPrice) {
		this.yourPrice = yourPrice;
	}
	
	@NotBlank(message="sales_price不能为空")
	@Length(min=0, max=255, message="sales_price长度不能超过 255 个字符")
	public String getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	@NotBlank(message="longest_side不能为空")
	@Length(min=0, max=255, message="longest_side长度不能超过 255 个字符")
	public String getLongestSide() {
		return longestSide;
	}

	public void setLongestSide(String longestSide) {
		this.longestSide = longestSide;
	}
	
	@NotBlank(message="median_side不能为空")
	@Length(min=0, max=255, message="median_side长度不能超过 255 个字符")
	public String getMedianSide() {
		return medianSide;
	}

	public void setMedianSide(String medianSide) {
		this.medianSide = medianSide;
	}
	
	@NotBlank(message="shortest_side不能为空")
	@Length(min=0, max=255, message="shortest_side长度不能超过 255 个字符")
	public String getShortestSide() {
		return shortestSide;
	}

	public void setShortestSide(String shortestSide) {
		this.shortestSide = shortestSide;
	}
	
	@NotBlank(message="length_and_girth不能为空")
	@Length(min=0, max=255, message="length_and_girth长度不能超过 255 个字符")
	public String getLengthAndGirth() {
		return lengthAndGirth;
	}

	public void setLengthAndGirth(String lengthAndGirth) {
		this.lengthAndGirth = lengthAndGirth;
	}
	
	@NotBlank(message="unit_of_dimension不能为空")
	@Length(min=0, max=255, message="unit_of_dimension长度不能超过 255 个字符")
	public String getUnitOfDimension() {
		return unitOfDimension;
	}

	public void setUnitOfDimension(String unitOfDimension) {
		this.unitOfDimension = unitOfDimension;
	}
	
	@NotBlank(message="item_package_weight不能为空")
	@Length(min=0, max=255, message="item_package_weight长度不能超过 255 个字符")
	public String getItemPackageWeight() {
		return itemPackageWeight;
	}

	public void setItemPackageWeight(String itemPackageWeight) {
		this.itemPackageWeight = itemPackageWeight;
	}
	
	@NotBlank(message="unit_of_weight不能为空")
	@Length(min=0, max=255, message="unit_of_weight长度不能超过 255 个字符")
	public String getUnitOfWeight() {
		return unitOfWeight;
	}

	public void setUnitOfWeight(String unitOfWeight) {
		this.unitOfWeight = unitOfWeight;
	}
	
	@NotBlank(message="product_size_tier不能为空")
	@Length(min=0, max=255, message="product_size_tier长度不能超过 255 个字符")
	public String getProductSizeTier() {
		return productSizeTier;
	}

	public void setProductSizeTier(String productSizeTier) {
		this.productSizeTier = productSizeTier;
	}
	
	@NotBlank(message="currency不能为空")
	@Length(min=0, max=255, message="currency长度不能超过 255 个字符")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@NotBlank(message="estimated_fee_total不能为空")
	@Length(min=0, max=255, message="estimated_fee_total长度不能超过 255 个字符")
	public String getEstimatedFeeTotal() {
		return estimatedFeeTotal;
	}

	public void setEstimatedFeeTotal(String estimatedFeeTotal) {
		this.estimatedFeeTotal = estimatedFeeTotal;
	}
	
	@NotBlank(message="estimated_referral_fee_per_unit不能为空")
	@Length(min=0, max=255, message="estimated_referral_fee_per_unit长度不能超过 255 个字符")
	public String getEstimatedReferralFeePerUnit() {
		return estimatedReferralFeePerUnit;
	}

	public void setEstimatedReferralFeePerUnit(String estimatedReferralFeePerUnit) {
		this.estimatedReferralFeePerUnit = estimatedReferralFeePerUnit;
	}
	
	@NotBlank(message="estimated_variable_closing_fee不能为空")
	@Length(min=0, max=255, message="estimated_variable_closing_fee长度不能超过 255 个字符")
	public String getEstimatedVariableClosingFee() {
		return estimatedVariableClosingFee;
	}

	public void setEstimatedVariableClosingFee(String estimatedVariableClosingFee) {
		this.estimatedVariableClosingFee = estimatedVariableClosingFee;
	}
	
	@NotBlank(message="estimated_order_handling_fee_per_order不能为空")
	@Length(min=0, max=255, message="estimated_order_handling_fee_per_order长度不能超过 255 个字符")
	public String getEstimatedOrderHandlingFeePerOrder() {
		return estimatedOrderHandlingFeePerOrder;
	}

	public void setEstimatedOrderHandlingFeePerOrder(String estimatedOrderHandlingFeePerOrder) {
		this.estimatedOrderHandlingFeePerOrder = estimatedOrderHandlingFeePerOrder;
	}
	
	@NotBlank(message="estimated_pick_pack_fee_per_unit不能为空")
	@Length(min=0, max=255, message="estimated_pick_pack_fee_per_unit长度不能超过 255 个字符")
	public String getEstimatedPickPackFeePerUnit() {
		return estimatedPickPackFeePerUnit;
	}

	public void setEstimatedPickPackFeePerUnit(String estimatedPickPackFeePerUnit) {
		this.estimatedPickPackFeePerUnit = estimatedPickPackFeePerUnit;
	}
	
	@NotBlank(message="estimated_weight_handling_fee_per_unit不能为空")
	@Length(min=0, max=255, message="estimated_weight_handling_fee_per_unit长度不能超过 255 个字符")
	public String getEstimatedWeightHandlingFeePerUnit() {
		return estimatedWeightHandlingFeePerUnit;
	}

	public void setEstimatedWeightHandlingFeePerUnit(String estimatedWeightHandlingFeePerUnit) {
		this.estimatedWeightHandlingFeePerUnit = estimatedWeightHandlingFeePerUnit;
	}
	
	@NotBlank(message="expected_fulfillment_fee_per_unit不能为空")
	@Length(min=0, max=255, message="expected_fulfillment_fee_per_unit长度不能超过 255 个字符")
	public String getExpectedFulfillmentFeePerUnit() {
		return expectedFulfillmentFeePerUnit;
	}

	public void setExpectedFulfillmentFeePerUnit(String expectedFulfillmentFeePerUnit) {
		this.expectedFulfillmentFeePerUnit = expectedFulfillmentFeePerUnit;
	}
	
}