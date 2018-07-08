package com.jeesite.modules.tk.utils;

import com.amazon.mws.finances._2015_05_01.model.FinancialEventGroup;
import com.xunlikun.constant.ConfigConstant;

public class ResponseResultUtils {
	
	public static final String FINANCIAL_EVENT_GROUP_PROCESSING_STATUS_OPEN = "Open";
	public static final String FINANCIAL_EVENT_GROUP_PROCESSING_STATUS_CLOSED = "Closed";
	
	public static com.jeesite.modules.financial.entity.FinancialEventGroup buildFinancialEventGroupEntity(FinancialEventGroup group,String storeName) {
		if(null == group) {
			return null;
		}
		com.jeesite.modules.financial.entity.FinancialEventGroup target = new com.jeesite.modules.financial.entity.FinancialEventGroup();
		target.setStoreName(storeName);
		target.setGroupId(group.getFinancialEventGroupId());
		target.setProcessingStatus(group.getProcessingStatus());
		target.setDownloadStatus(ConfigConstant.NO);
		target.setFundTransferStatus(group.getFundTransferStatus());
		if(null  != group.getOriginalTotal()) {
			target.setOriginalTotalAmount(group.getOriginalTotal().getCurrencyAmount().toString());
			target.setOriginalTotalCurrency(group.getOriginalTotal().getCurrencyCode());
		}
		if(null != group.getConvertedTotal()) {
			target.setConvertedTotalAmount(group.getConvertedTotal().getCurrencyAmount().toString());
			target.setConvertedTotalCurrency(group.getConvertedTotal().getCurrencyCode());
		}
		target.setFundTransferStatus(group.getFundTransferStatus());
		target.setTranceId(group.getTraceId());
		target.setAccountTail(group.getAccountTail());
		if(null != group.getBeginningBalance()) {
			target.setBeginningBalanceAmount(group.getBeginningBalance().getCurrencyAmount().toString());
			target.setBeginningBalanceCurrency(group.getBeginningBalance().getCurrencyCode());
		}
		target.setGroupStart(group.getFinancialEventGroupStart().toString());
		if(null != group.getFinancialEventGroupEnd()) {
			target.setGroupEnd(group.getFinancialEventGroupEnd().toString());
		}
		return target;
	}
	
}
