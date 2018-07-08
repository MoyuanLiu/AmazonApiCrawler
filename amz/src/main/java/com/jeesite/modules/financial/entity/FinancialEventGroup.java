/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.financial.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * financial_event_groupEntity
 * @author xlk
 * @version 2018-05-21
 */
@Table(name="financial_event_group", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="store_name", attrName="storeName", label="store_name", queryType=QueryType.LIKE),
		@Column(name="group_id", attrName="groupId", label="group_id"),
		@Column(name="processing_status", attrName="processingStatus", label="processing_status"),
		@Column(name="download_status", attrName="downloadStatus", label="download_status"),
		@Column(name="fund_transfer_status", attrName="fundTransferStatus", label="fund_transfer_status"),
		@Column(name="original_total_currency", attrName="originalTotalCurrency", label="original_total_currency"),
		@Column(name="original_total_amount", attrName="originalTotalAmount", label="original_total_amount"),
		@Column(name="converted_total_currency", attrName="convertedTotalCurrency", label="converted_total_currency"),
		@Column(name="converted_total_amount", attrName="convertedTotalAmount", label="converted_total_amount"),
		@Column(name="fund_transfer_date", attrName="fundTransferDate", label="fund_transfer_date"),
		@Column(name="trance_id", attrName="tranceId", label="trance_id"),
		@Column(name="account_tail", attrName="accountTail", label="account_tail"),
		@Column(name="beginning_balance_currency", attrName="beginningBalanceCurrency", label="beginning_balance_currency"),
		@Column(name="beginning_balance_amount", attrName="beginningBalanceAmount", label="beginning_balance_amount"),
		@Column(name="group_start", attrName="groupStart", label="group_start"),
		@Column(name="group_end", attrName="groupEnd", label="group_end"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class FinancialEventGroup extends DataEntity<FinancialEventGroup> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String storeName;		// store_name
	private String groupId;		// group_id
	private String processingStatus;		// processing_status
	private String downloadStatus;		// download_status
	private String fundTransferStatus;		// fund_transfer_status
	private String originalTotalCurrency;		// original_total_currency
	private String originalTotalAmount;		// original_total_amount
	private String convertedTotalCurrency;		// converted_total_currency
	private String convertedTotalAmount;		// converted_total_amount
	private String fundTransferDate;		// fund_transfer_date
	private String tranceId;		// trance_id
	private String accountTail;		// account_tail
	private String beginningBalanceCurrency;		// beginning_balance_currency
	private String beginningBalanceAmount;		// beginning_balance_amount
	private String groupStart;		// group_start
	private String groupEnd;		// group_end
	
	public FinancialEventGroup() {
		this(null);
	}

	public FinancialEventGroup(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="store_name不能为空")
	@Length(min=0, max=255, message="store_name长度不能超过 255 个字符")
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Length(min=0, max=64, message="group_id长度不能超过 64 个字符")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@Length(min=0, max=64, message="processing_status长度不能超过 64 个字符")
	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}
	
	@Length(min=0, max=255, message="download_status长度不能超过 255 个字符")
	public String getDownloadStatus() {
		return downloadStatus;
	}

	public void setDownloadStatus(String downloadStatus) {
		this.downloadStatus = downloadStatus;
	}
	
	@Length(min=0, max=64, message="fund_transfer_status长度不能超过 64 个字符")
	public String getFundTransferStatus() {
		return fundTransferStatus;
	}

	public void setFundTransferStatus(String fundTransferStatus) {
		this.fundTransferStatus = fundTransferStatus;
	}
	
	@Length(min=0, max=64, message="original_total_currency长度不能超过 64 个字符")
	public String getOriginalTotalCurrency() {
		return originalTotalCurrency;
	}

	public void setOriginalTotalCurrency(String originalTotalCurrency) {
		this.originalTotalCurrency = originalTotalCurrency;
	}
	
	@Length(min=0, max=64, message="original_total_amount长度不能超过 64 个字符")
	public String getOriginalTotalAmount() {
		return originalTotalAmount;
	}

	public void setOriginalTotalAmount(String originalTotalAmount) {
		this.originalTotalAmount = originalTotalAmount;
	}
	
	@Length(min=0, max=64, message="converted_total_currency长度不能超过 64 个字符")
	public String getConvertedTotalCurrency() {
		return convertedTotalCurrency;
	}

	public void setConvertedTotalCurrency(String convertedTotalCurrency) {
		this.convertedTotalCurrency = convertedTotalCurrency;
	}
	
	@Length(min=0, max=64, message="converted_total_amount长度不能超过 64 个字符")
	public String getConvertedTotalAmount() {
		return convertedTotalAmount;
	}

	public void setConvertedTotalAmount(String convertedTotalAmount) {
		this.convertedTotalAmount = convertedTotalAmount;
	}
	
	@Length(min=0, max=64, message="fund_transfer_date长度不能超过 64 个字符")
	public String getFundTransferDate() {
		return fundTransferDate;
	}

	public void setFundTransferDate(String fundTransferDate) {
		this.fundTransferDate = fundTransferDate;
	}
	
	@Length(min=0, max=64, message="trance_id长度不能超过 64 个字符")
	public String getTranceId() {
		return tranceId;
	}

	public void setTranceId(String tranceId) {
		this.tranceId = tranceId;
	}
	
	@Length(min=0, max=64, message="account_tail长度不能超过 64 个字符")
	public String getAccountTail() {
		return accountTail;
	}

	public void setAccountTail(String accountTail) {
		this.accountTail = accountTail;
	}
	
	@Length(min=0, max=64, message="beginning_balance_currency长度不能超过 64 个字符")
	public String getBeginningBalanceCurrency() {
		return beginningBalanceCurrency;
	}

	public void setBeginningBalanceCurrency(String beginningBalanceCurrency) {
		this.beginningBalanceCurrency = beginningBalanceCurrency;
	}
	
	@Length(min=0, max=64, message="beginning_balance_amount长度不能超过 64 个字符")
	public String getBeginningBalanceAmount() {
		return beginningBalanceAmount;
	}

	public void setBeginningBalanceAmount(String beginningBalanceAmount) {
		this.beginningBalanceAmount = beginningBalanceAmount;
	}
	
	@Length(min=0, max=64, message="group_start长度不能超过 64 个字符")
	public String getGroupStart() {
		return groupStart;
	}

	public void setGroupStart(String groupStart) {
		this.groupStart = groupStart;
	}
	
	@Length(min=0, max=64, message="group_end长度不能超过 64 个字符")
	public String getGroupEnd() {
		return groupEnd;
	}

	public void setGroupEnd(String groupEnd) {
		this.groupEnd = groupEnd;
	}
	
}