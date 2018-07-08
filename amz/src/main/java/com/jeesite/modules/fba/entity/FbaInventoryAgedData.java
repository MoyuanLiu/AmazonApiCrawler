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
 * fba_inventory_aged_dataEntity
 * @author xlk
 * @version 2018-05-16
 */
@Table(name="fba_inventory_aged_data", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="task_code", attrName="taskCode", label="task_code"),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="snapshot_date", attrName="snapshotDate", label="snapshot_date"),
		@Column(name="sku", attrName="sku", label="sku"),
		@Column(name="fnsku", attrName="fnsku", label="fnsku"),
		@Column(name="asin", attrName="asin", label="asin"),
		@Column(name="product_name", attrName="productName", label="product_name", queryType=QueryType.LIKE),
		@Column(name="condition", attrName="condition", label="condition"),
		@Column(name="avaliable_quantity_sellable", attrName="avaliableQuantitySellable", label="avaliable_quantity_sellable"),
		@Column(name="qty_with_removals_in_progress", attrName="qtyWithRemovalsInProgress", label="qty_with_removals_in_progress"),
		@Column(name="inv_age_0_to_90_days", attrName="invAge0To90Days", label="inv_age_0_to_90_days"),
		@Column(name="inv_age_91_to_180_days", attrName="invAge91To180Days", label="inv_age_91_to_180_days"),
		@Column(name="inv_age_181_to_270_days", attrName="invAge181To270Days", label="inv_age_181_to_270_days"),
		@Column(name="inv_age_271_to_365_days", attrName="invAge271To365Days", label="inv_age_271_to_365_days"),
		@Column(name="inv_age_365_plus_days", attrName="invAge365PlusDays", label="inv_age_365_plus_days"),
		@Column(name="currency", attrName="currency", label="currency"),
		@Column(name="qty_to_be_charged_ltsf_6_mo", attrName="qtyToBeChargedLtsf6Mo", label="qty_to_be_charged_ltsf_6_mo"),
		@Column(name="projected_ltsf_6_mo", attrName="projectedLtsf6Mo", label="projected_ltsf_6_mo"),
		@Column(name="qty_to_be_charged_ltsf_12_mo", attrName="qtyToBeChargedLtsf12Mo", label="qty_to_be_charged_ltsf_12_mo"),
		@Column(name="projected_ltsf_12_mo", attrName="projectedLtsf12Mo", label="projected_ltsf_12_mo"),
		@Column(name="units_shipped_last_7_days", attrName="unitsShippedLast7Days", label="units_shipped_last_7_days"),
		@Column(name="units_shipped_last_30_days", attrName="unitsShippedLast30Days", label="units_shipped_last_30_days"),
		@Column(name="units_shipped_last_60_days", attrName="unitsShippedLast60Days", label="units_shipped_last_60_days"),
		@Column(name="units_shipped_last_90_days", attrName="unitsShippedLast90Days", label="units_shipped_last_90_days"),
		@Column(name="alert", attrName="alert", label="alert"),
		@Column(name="your_price", attrName="yourPrice", label="your_price"),
		@Column(name="sales_price", attrName="salesPrice", label="sales_price"),
		@Column(name="lowest_price_new", attrName="lowestPriceNew", label="lowest_price_new"),
		@Column(name="lowest_price_used", attrName="lowestPriceUsed", label="lowest_price_used"),
		@Column(name="recommended_action", attrName="recommendedAction", label="recommended_action"),
		@Column(name="healthy_inventory_level", attrName="healthyInventoryLevel", label="healthy_inventory_level"),
		@Column(name="recommended_sales_price", attrName="recommendedSalesPrice", label="recommended_sales_price"),
		@Column(name="recommended_sale_duration_days", attrName="recommendedSaleDurationDays", label="recommended_sale_duration_days"),
		@Column(name="recommended_removal_quantity", attrName="recommendedRemovalQuantity", label="recommended_removal_quantity"),
		@Column(name="estimated_cost_savings_of_removal", attrName="estimatedCostSavingsOfRemoval", label="estimated_cost_savings_of_removal"),
	}, orderBy="a.update_date DESC"
)
public class FbaInventoryAgedData extends DataEntity<FbaInventoryAgedData> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String taskCode;		// task_code
	private String storeName;		// store_name
	private String snapshotDate;		// snapshot_date
	private String sku;		// sku
	private String fnsku;		// fnsku
	private String asin;		// asin
	private String productName;		// product_name
	private String condition;		// condition
	private String avaliableQuantitySellable;		// avaliable_quantity_sellable
	private String qtyWithRemovalsInProgress;		// qty_with_removals_in_progress
	private String invAge0To90Days;		// inv_age_0_to_90_days
	private String invAge91To180Days;		// inv_age_91_to_180_days
	private String invAge181To270Days;		// inv_age_181_to_270_days
	private String invAge271To365Days;		// inv_age_271_to_365_days
	private String invAge365PlusDays;		// inv_age_365_plus_days
	private String currency;		// currency
	private String qtyToBeChargedLtsf6Mo;		// qty_to_be_charged_ltsf_6_mo
	private String projectedLtsf6Mo;		// projected_ltsf_6_mo
	private String qtyToBeChargedLtsf12Mo;		// qty_to_be_charged_ltsf_12_mo
	private String projectedLtsf12Mo;		// projected_ltsf_12_mo
	private String unitsShippedLast7Days;		// units_shipped_last_7_days
	private String unitsShippedLast30Days;		// units_shipped_last_30_days
	private String unitsShippedLast60Days;		// units_shipped_last_60_days
	private String unitsShippedLast90Days;		// units_shipped_last_90_days
	private String alert;		// alert
	private String yourPrice;		// your_price
	private String salesPrice;		// sales_price
	private String lowestPriceNew;		// lowest_price_new
	private String lowestPriceUsed;		// lowest_price_used
	private String recommendedAction;		// recommended_action
	private String healthyInventoryLevel;		// healthy_inventory_level
	private String recommendedSalesPrice;		// recommended_sales_price
	private String recommendedSaleDurationDays;		// recommended_sale_duration_days
	private String recommendedRemovalQuantity;		// recommended_removal_quantity
	private String estimatedCostSavingsOfRemoval;		// estimated_cost_savings_of_removal
	
	public FbaInventoryAgedData() {
		this(null);
	}

	public FbaInventoryAgedData(String id){
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
	
	@NotBlank(message="snapshot_date不能为空")
	@Length(min=0, max=255, message="snapshot_date长度不能超过 255 个字符")
	public String getSnapshotDate() {
		return snapshotDate;
	}

	public void setSnapshotDate(String snapshotDate) {
		this.snapshotDate = snapshotDate;
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
	
	@NotBlank(message="avaliable_quantity_sellable不能为空")
	@Length(min=0, max=255, message="avaliable_quantity_sellable长度不能超过 255 个字符")
	public String getAvaliableQuantitySellable() {
		return avaliableQuantitySellable;
	}

	public void setAvaliableQuantitySellable(String avaliableQuantitySellable) {
		this.avaliableQuantitySellable = avaliableQuantitySellable;
	}
	
	@NotBlank(message="qty_with_removals_in_progress不能为空")
	@Length(min=0, max=255, message="qty_with_removals_in_progress长度不能超过 255 个字符")
	public String getQtyWithRemovalsInProgress() {
		return qtyWithRemovalsInProgress;
	}

	public void setQtyWithRemovalsInProgress(String qtyWithRemovalsInProgress) {
		this.qtyWithRemovalsInProgress = qtyWithRemovalsInProgress;
	}
	
	@NotBlank(message="inv_age_0_to_90_days不能为空")
	@Length(min=0, max=255, message="inv_age_0_to_90_days长度不能超过 255 个字符")
	public String getInvAge0To90Days() {
		return invAge0To90Days;
	}

	public void setInvAge0To90Days(String invAge0To90Days) {
		this.invAge0To90Days = invAge0To90Days;
	}
	
	@NotBlank(message="inv_age_91_to_180_days不能为空")
	@Length(min=0, max=255, message="inv_age_91_to_180_days长度不能超过 255 个字符")
	public String getInvAge91To180Days() {
		return invAge91To180Days;
	}

	public void setInvAge91To180Days(String invAge91To180Days) {
		this.invAge91To180Days = invAge91To180Days;
	}
	
	@NotBlank(message="inv_age_181_to_270_days不能为空")
	@Length(min=0, max=255, message="inv_age_181_to_270_days长度不能超过 255 个字符")
	public String getInvAge181To270Days() {
		return invAge181To270Days;
	}

	public void setInvAge181To270Days(String invAge181To270Days) {
		this.invAge181To270Days = invAge181To270Days;
	}
	
	@NotBlank(message="inv_age_271_to_365_days不能为空")
	@Length(min=0, max=255, message="inv_age_271_to_365_days长度不能超过 255 个字符")
	public String getInvAge271To365Days() {
		return invAge271To365Days;
	}

	public void setInvAge271To365Days(String invAge271To365Days) {
		this.invAge271To365Days = invAge271To365Days;
	}
	
	@NotBlank(message="inv_age_365_plus_days不能为空")
	@Length(min=0, max=255, message="inv_age_365_plus_days长度不能超过 255 个字符")
	public String getInvAge365PlusDays() {
		return invAge365PlusDays;
	}

	public void setInvAge365PlusDays(String invAge365PlusDays) {
		this.invAge365PlusDays = invAge365PlusDays;
	}
	
	@NotBlank(message="currency不能为空")
	@Length(min=0, max=255, message="currency长度不能超过 255 个字符")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@NotBlank(message="qty_to_be_charged_ltsf_6_mo不能为空")
	@Length(min=0, max=255, message="qty_to_be_charged_ltsf_6_mo长度不能超过 255 个字符")
	public String getQtyToBeChargedLtsf6Mo() {
		return qtyToBeChargedLtsf6Mo;
	}

	public void setQtyToBeChargedLtsf6Mo(String qtyToBeChargedLtsf6Mo) {
		this.qtyToBeChargedLtsf6Mo = qtyToBeChargedLtsf6Mo;
	}
	
	@NotBlank(message="projected_ltsf_6_mo不能为空")
	@Length(min=0, max=255, message="projected_ltsf_6_mo长度不能超过 255 个字符")
	public String getProjectedLtsf6Mo() {
		return projectedLtsf6Mo;
	}

	public void setProjectedLtsf6Mo(String projectedLtsf6Mo) {
		this.projectedLtsf6Mo = projectedLtsf6Mo;
	}
	
	@NotBlank(message="qty_to_be_charged_ltsf_12_mo不能为空")
	@Length(min=0, max=255, message="qty_to_be_charged_ltsf_12_mo长度不能超过 255 个字符")
	public String getQtyToBeChargedLtsf12Mo() {
		return qtyToBeChargedLtsf12Mo;
	}

	public void setQtyToBeChargedLtsf12Mo(String qtyToBeChargedLtsf12Mo) {
		this.qtyToBeChargedLtsf12Mo = qtyToBeChargedLtsf12Mo;
	}
	
	@NotBlank(message="projected_ltsf_12_mo不能为空")
	@Length(min=0, max=255, message="projected_ltsf_12_mo长度不能超过 255 个字符")
	public String getProjectedLtsf12Mo() {
		return projectedLtsf12Mo;
	}

	public void setProjectedLtsf12Mo(String projectedLtsf12Mo) {
		this.projectedLtsf12Mo = projectedLtsf12Mo;
	}
	
	@NotBlank(message="units_shipped_last_7_days不能为空")
	@Length(min=0, max=255, message="units_shipped_last_7_days长度不能超过 255 个字符")
	public String getUnitsShippedLast7Days() {
		return unitsShippedLast7Days;
	}

	public void setUnitsShippedLast7Days(String unitsShippedLast7Days) {
		this.unitsShippedLast7Days = unitsShippedLast7Days;
	}
	
	@NotBlank(message="units_shipped_last_30_days不能为空")
	@Length(min=0, max=255, message="units_shipped_last_30_days长度不能超过 255 个字符")
	public String getUnitsShippedLast30Days() {
		return unitsShippedLast30Days;
	}

	public void setUnitsShippedLast30Days(String unitsShippedLast30Days) {
		this.unitsShippedLast30Days = unitsShippedLast30Days;
	}
	
	@NotBlank(message="units_shipped_last_60_days不能为空")
	@Length(min=0, max=255, message="units_shipped_last_60_days长度不能超过 255 个字符")
	public String getUnitsShippedLast60Days() {
		return unitsShippedLast60Days;
	}

	public void setUnitsShippedLast60Days(String unitsShippedLast60Days) {
		this.unitsShippedLast60Days = unitsShippedLast60Days;
	}
	
	@NotBlank(message="units_shipped_last_90_days不能为空")
	@Length(min=0, max=255, message="units_shipped_last_90_days长度不能超过 255 个字符")
	public String getUnitsShippedLast90Days() {
		return unitsShippedLast90Days;
	}

	public void setUnitsShippedLast90Days(String unitsShippedLast90Days) {
		this.unitsShippedLast90Days = unitsShippedLast90Days;
	}
	
	@NotBlank(message="alert不能为空")
	@Length(min=0, max=255, message="alert长度不能超过 255 个字符")
	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
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
	
	@NotBlank(message="lowest_price_new不能为空")
	@Length(min=0, max=255, message="lowest_price_new长度不能超过 255 个字符")
	public String getLowestPriceNew() {
		return lowestPriceNew;
	}

	public void setLowestPriceNew(String lowestPriceNew) {
		this.lowestPriceNew = lowestPriceNew;
	}
	
	@NotBlank(message="lowest_price_used不能为空")
	@Length(min=0, max=255, message="lowest_price_used长度不能超过 255 个字符")
	public String getLowestPriceUsed() {
		return lowestPriceUsed;
	}

	public void setLowestPriceUsed(String lowestPriceUsed) {
		this.lowestPriceUsed = lowestPriceUsed;
	}
	
	@NotBlank(message="recommended_action不能为空")
	@Length(min=0, max=255, message="recommended_action长度不能超过 255 个字符")
	public String getRecommendedAction() {
		return recommendedAction;
	}

	public void setRecommendedAction(String recommendedAction) {
		this.recommendedAction = recommendedAction;
	}
	
	@NotBlank(message="healthy_inventory_level不能为空")
	@Length(min=0, max=255, message="healthy_inventory_level长度不能超过 255 个字符")
	public String getHealthyInventoryLevel() {
		return healthyInventoryLevel;
	}

	public void setHealthyInventoryLevel(String healthyInventoryLevel) {
		this.healthyInventoryLevel = healthyInventoryLevel;
	}
	
	@NotBlank(message="recommended_sales_price不能为空")
	@Length(min=0, max=255, message="recommended_sales_price长度不能超过 255 个字符")
	public String getRecommendedSalesPrice() {
		return recommendedSalesPrice;
	}

	public void setRecommendedSalesPrice(String recommendedSalesPrice) {
		this.recommendedSalesPrice = recommendedSalesPrice;
	}
	
	@NotBlank(message="recommended_sale_duration_days不能为空")
	@Length(min=0, max=255, message="recommended_sale_duration_days长度不能超过 255 个字符")
	public String getRecommendedSaleDurationDays() {
		return recommendedSaleDurationDays;
	}

	public void setRecommendedSaleDurationDays(String recommendedSaleDurationDays) {
		this.recommendedSaleDurationDays = recommendedSaleDurationDays;
	}
	
	@NotBlank(message="recommended_removal_quantity不能为空")
	@Length(min=0, max=255, message="recommended_removal_quantity长度不能超过 255 个字符")
	public String getRecommendedRemovalQuantity() {
		return recommendedRemovalQuantity;
	}

	public void setRecommendedRemovalQuantity(String recommendedRemovalQuantity) {
		this.recommendedRemovalQuantity = recommendedRemovalQuantity;
	}
	
	@NotBlank(message="estimated_cost_savings_of_removal不能为空")
	@Length(min=0, max=255, message="estimated_cost_savings_of_removal长度不能超过 255 个字符")
	public String getEstimatedCostSavingsOfRemoval() {
		return estimatedCostSavingsOfRemoval;
	}

	public void setEstimatedCostSavingsOfRemoval(String estimatedCostSavingsOfRemoval) {
		this.estimatedCostSavingsOfRemoval = estimatedCostSavingsOfRemoval;
	}
	
}