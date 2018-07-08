/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tk.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.mws.finances._2015_05_01.model.AdjustmentEvent;
import com.amazon.mws.finances._2015_05_01.model.CouponPaymentEvent;
import com.amazon.mws.finances._2015_05_01.model.DebtRecoveryEvent;
import com.amazon.mws.finances._2015_05_01.model.FBALiquidationEvent;
import com.amazon.mws.finances._2015_05_01.model.FinancialEventGroup;
import com.amazon.mws.finances._2015_05_01.model.FinancialEvents;
import com.amazon.mws.finances._2015_05_01.model.ImagingServicesFeeEvent;
import com.amazon.mws.finances._2015_05_01.model.ListFinancialEventGroupsByNextTokenResponse;
import com.amazon.mws.finances._2015_05_01.model.ListFinancialEventGroupsResponse;
import com.amazon.mws.finances._2015_05_01.model.ListFinancialEventsByNextTokenResponse;
import com.amazon.mws.finances._2015_05_01.model.ListFinancialEventsResponse;
import com.amazon.mws.finances._2015_05_01.model.LoanServicingEvent;
import com.amazon.mws.finances._2015_05_01.model.PayWithAmazonEvent;
import com.amazon.mws.finances._2015_05_01.model.PerformanceBondRefundEvent;
import com.amazon.mws.finances._2015_05_01.model.ProductAdsPaymentEvent;
import com.amazon.mws.finances._2015_05_01.model.RentalTransactionEvent;
import com.amazon.mws.finances._2015_05_01.model.RetrochargeEvent;
import com.amazon.mws.finances._2015_05_01.model.SAFETReimbursementEvent;
import com.amazon.mws.finances._2015_05_01.model.SellerDealPaymentEvent;
import com.amazon.mws.finances._2015_05_01.model.SellerReviewEnrollmentPaymentEvent;
import com.amazon.mws.finances._2015_05_01.model.ServiceFeeEvent;
import com.amazon.mws.finances._2015_05_01.model.ShipmentEvent;
import com.amazon.mws.finances._2015_05_01.model.SolutionProviderCreditEvent;
import com.amazonaws.mws.model.GetReportListResponse;
import com.amazonaws.mws.model.GetReportRequestListResponse;
import com.amazonaws.mws.model.GetReportResponse;
import com.amazonaws.mws.model.ReportInfo;
import com.amazonaws.mws.model.ReportRequestInfo;
import com.amazonaws.mws.model.RequestReportResponse;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.modules.bz.dao.BzStoreAttrDao;
import com.jeesite.modules.bz.entity.BzStore;
import com.jeesite.modules.bz.entity.BzStoreAttr;
import com.jeesite.modules.bz.service.BzReportService;
import com.jeesite.modules.bz.service.BzStoreService;
import com.jeesite.modules.estimated.dao.EstimatedFbaFeesDao;
import com.jeesite.modules.estimated.entity.EstimatedFbaFees;
import com.jeesite.modules.fba.dao.FbaFulfillmentCustomerReturnsDao;
import com.jeesite.modules.fba.dao.FbaFulfillmentCustomerShipmentSalesDao;
import com.jeesite.modules.fba.dao.FbaFulfillmentInventoryAdjustmentsDao;
import com.jeesite.modules.fba.dao.FbaFulfillmentInventoryReceiptsDao;
import com.jeesite.modules.fba.dao.FbaInventoryAgedDataDao;
import com.jeesite.modules.fba.dao.FbaMyiAllInventoryDao;
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerReturns;
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerShipmentSales;
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryAdjustments;
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryReceipts;
import com.jeesite.modules.fba.entity.FbaInventoryAgedData;
import com.jeesite.modules.fba.entity.FbaMyiAllInventory;
import com.jeesite.modules.fbair.dao.fmi.FbaFulfillmentMonthlyInventoryDataDao;
import com.jeesite.modules.fbair.dao.rid.ReservedInventoryDataDao;
import com.jeesite.modules.fbair.entity.fmi.FbaFulfillmentMonthlyInventoryData;
import com.jeesite.modules.fbair.entity.rid.ReservedInventoryData;
import com.jeesite.modules.financial.dao.FinancialEventGroupDao;
import com.jeesite.modules.orders.dao.AllOrdersDataDao;
import com.jeesite.modules.orders.entity.AllOrdersData;
import com.jeesite.modules.report.entity.ReportTask;
import com.jeesite.modules.report.service.ReportTaskService;
import com.jeesite.modules.settlement.dao.SettlementReportDao;
import com.jeesite.modules.settlement.entity.SettlementReport;
import com.jeesite.modules.tk.utils.ResponseResultUtils;
import com.jeesite.modules.tk.utils.StoreUtils;
import com.xunlikun.amz.finances.FinanceUtils;
import com.xunlikun.amz.report.ReportUtils;
import com.xunlikun.constant.ConfigConstant;

/**
 * 测试数据Service
 * @author ThinkGem
 * @version 2018-04-22
 */
@Service
public class TaskService {
	
	@Autowired
	BzStoreService bzStoreService;
	
	@Autowired
	BzStoreAttrDao bzStoreAttrDao;
	
	@Autowired
	ReservedInventoryDataDao reservedInventoryDataDao;
	
	@Autowired
	FbaFulfillmentMonthlyInventoryDataDao fbaFulfillmentMonthlyInventoryDataDao;
	
	@Autowired
	EstimatedFbaFeesDao estimatedFbaFeesDao;
	
	@Autowired
	FbaInventoryAgedDataDao fbaInventoryAgedDataDao;
	
	@Autowired
	FbaMyiAllInventoryDao fbaMyiAllInventoryDao;
	
	@Autowired
	AllOrdersDataDao allOrdersDataDao;
	
	@Autowired
	FbaFulfillmentCustomerReturnsDao fbaFulfillmentCustomerReturnsDao;
	
	@Autowired
	FbaFulfillmentInventoryReceiptsDao fbaFulfillmentInventoryReceiptsDao;

	@Autowired
	FbaFulfillmentCustomerShipmentSalesDao fbaFulfillmentCustomerShipmentSalesDao;
	
	@Autowired
	FbaFulfillmentInventoryAdjustmentsDao fbaFulfillmentInventoryAdjustmentsDao;
	
	@Autowired
	FinancialEventGroupDao financialEventGroupDao;
	
	@Autowired
	BzReportService bzReportService;
	
	@Autowired
	ReportTaskService reportTaskService;
	
	@Autowired
	SettlementReportDao settlementReportDao;
	
	public void submitReportRequest(String reportType,String fdays,String tdays) throws Exception{
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		for(BzStore store : stores) {
			submitReportRequest(reportType,store.getCode(),fdays,tdays);
		}
		
	}
	
	@Transactional(readOnly=false)
	public void submitReportRequest(String reportType,String storeCode,String fdays,String tdays) throws Exception {
		BzStore store = bzStoreService.get(storeCode);
		if(null == store.getBzStoreAttrList() || store.getBzStoreAttrList().size() == 0) {
			BzStoreAttr storeAttr = new BzStoreAttr();
			storeAttr.setStoreCode(store);
			List<BzStoreAttr> list = bzStoreAttrDao.findList(storeAttr);
			store.setBzStoreAttrList(list);
		}
		
		RequestReportResponse response = ReportUtils.requestReport(reportType, StoreUtils.genAmzStore(store), fdays, tdays);
		
		if(null == response) {
			return;
		}
		ReportTask reportTask = new ReportTask();
		reportTask.setStoreCode(storeCode);
		reportTask.setTaskName(reportType + new Date());
		reportTask.setReportType(reportType);
		reportTask.setStart(fdays);
		reportTask.setEnd(tdays);
		
		//reportOptions
		reportTask.setMarketplaceIdList(store.getAttrMap().get(ReportUtils.AMZ_MARKETPLACE_ID).getAttrvalue());
		reportTask.setReportRequestId(response.getRequestReportResult().getReportRequestInfo().getReportRequestId());
		reportTask.setScheduled(ConfigConstant.NO);
		reportTask.setSubmitted(response.getRequestReportResult().getReportRequestInfo().getSubmittedDate().toString());
		reportTask.setReportProcessingStatus(
				response.getRequestReportResult().getReportRequestInfo().getReportProcessingStatus()
				);
		reportTaskService.save(reportTask);
		
	}
	
	@Transactional(readOnly=false)
	public void getReportRequsetList() throws Exception {
		//TODO:task 应该由执行次数限制
		ReportTask reportTask = new ReportTask();
		reportTask.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_SUBMITTED_);
		List<ReportTask> taskes = reportTaskService.findList(reportTask);
		Map<String,ReportTask> taskMap = new HashMap<String,ReportTask>();
		Map<String,List<String>> requestIdMap = new HashMap<String,List<String>>();
		for(ReportTask task : taskes) {
			if(requestIdMap.containsKey(task.getStoreCode())) {
				requestIdMap.get(task.getStoreCode()).add(task.getReportRequestId());
			}
			else {
				List<String> requestIds = new ArrayList<String>();
				requestIds.add(task.getReportRequestId());
				requestIdMap.put(task.getStoreCode(), requestIds);
			}
			taskMap.put(task.getReportRequestId(), task);
		}
		
		Map<String, BzStore> storeMap = getAllStoreMap();
		
		List<String> tokens = new ArrayList<String>();
		for(String storeCode : requestIdMap.keySet()) {
			GetReportRequestListResponse response = ReportUtils.getReportRequsetList(requestIdMap.get(storeCode), StoreUtils.genAmzStore(storeMap.get(storeCode)));
			if(null == response) {
				return;
			}
			String token = response.getGetReportRequestListResult().getNextToken();
			if(StringUtils.isNotEmpty(token)) {
				tokens.add(token);
			}
			List<ReportRequestInfo> results = response.getGetReportRequestListResult().getReportRequestInfoList();
			for(ReportRequestInfo info : results) {
				System.out.println(info.getReportProcessingStatus());
				ReportTask task = taskMap.get(info.getReportRequestId());
				task.setReportProcessingStatus(info.getReportProcessingStatus());
				task.setStart(info.getStartDate().toString());
				task.setEnd(info.getEndDate().toString());
				task.setSubmitted(info.getSubmittedDate().toString());
				task.setComplete(info.getCompletedDate().toString());
				reportTaskService.save(task);
			}
		}
	}
	
	@Transactional(readOnly=false)
	public void getReportList() throws Exception {
		
		ReportTask reportTask = new ReportTask();
		reportTask.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_DONE_);
		List<ReportTask> taskes = reportTaskService.findList(reportTask);
		Map<String,ReportTask> taskMap = new HashMap<String,ReportTask>();
		Map<String,List<String>> requestIdMap = new HashMap<String,List<String>>();
		for(ReportTask task : taskes) {
			if(requestIdMap.containsKey(task.getStoreCode())) {
				requestIdMap.get(task.getStoreCode()).add(task.getReportRequestId());
			}
			else {
				List<String> requestIds = new ArrayList<String>();
				requestIds.add(task.getReportRequestId());
				requestIdMap.put(task.getStoreCode(), requestIds);
			}
			taskMap.put(task.getReportRequestId(), task);
		}
		
		Map<String, BzStore> storeMap = getAllStoreMap();
		
		List<String> tokens = new ArrayList<String>();
		for(String storeCode : requestIdMap.keySet()) {
			GetReportListResponse response = ReportUtils.getReportList(requestIdMap.get(storeCode), StoreUtils.genAmzStore(storeMap.get(storeCode)));
			if(null == response) {
				return;
			}
			String token = response.getGetReportListResult().getNextToken();
			if(StringUtils.isNotEmpty(token)) {
				tokens.add(token);
			}
			List<ReportInfo> results = response.getGetReportListResult().getReportInfoList();
			for(ReportInfo info : results) {
				ReportTask task = taskMap.get(info.getReportRequestId());
				task.setAvaliable(info.getAvailableDate().toString());
				if(info.isAcknowledged()) {
					task.setAcknowledged(info.getAcknowledgedDate().toString());
				}
				task.setReportId(info.getReportId());
				task.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_GOTREPORTID_);
				reportTaskService.save(task);
			}
		}
	}
	
	public void getSettlementReportList(String types, String fdays,String tdays) throws Exception {
			
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		List<String> reportTypes = ListUtils.newArrayList();
		reportTypes.add(types);
		List<String> tokens = ListUtils.newArrayList();
		for(BzStore store : stores) {
			if(null == store.getBzStoreAttrList() || store.getBzStoreAttrList().size() == 0) {
				BzStoreAttr storeAttr = new BzStoreAttr();
				storeAttr.setStoreCode(store);
				List<BzStoreAttr> list = bzStoreAttrDao.findList(storeAttr);
				store.setBzStoreAttrList(list);
			}
			GetReportListResponse res = ReportUtils.getReportList(reportTypes, StoreUtils.genAmzStore(store), fdays, tdays);
			if(null == res) {
				return;
			}
			if(StringUtils.isNotEmpty(res.getGetReportListResult().getNextToken())) {
				tokens.add(res.getGetReportListResult().getNextToken());
			}
			List<ReportInfo> reports = res.getGetReportListResult().getReportInfoList();
			String nextToken = res.getGetReportListResult().getNextToken();
			
			for(ReportInfo ri : reports) {
				ReportTask reportTask = new ReportTask();
				reportTask.setStoreCode(store.getCode());
				reportTask.setTaskName(types + new Date());
				reportTask.setReportType(types);
				reportTask.setStart(fdays);
				reportTask.setEnd(tdays);
				//reportOptions
				reportTask.setMarketplaceIdList(store.getAttrMap().get(ReportUtils.AMZ_MARKETPLACE_ID).getAttrvalue());
				reportTask.setReportRequestId(ri.getReportRequestId());
				reportTask.setScheduled(ConfigConstant.YES);
				reportTask.setSubmitted(ri.getAvailableDate().toString());
				reportTask.setReportId(ri.getReportId());
				reportTask.setAvaliable(ri.getAvailableDate().toString());
				reportTask.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_GOTREPORTID_);
				reportTaskService.save(reportTask);
			}
			
			
		}
		
	}
	
	
	public void getReport() throws Exception {
		Map<String, BzStore> storeMap = getAllStoreMap();
		ReportTask reportTask = new ReportTask();
		reportTask.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_GOTREPORTID_);
		List<ReportTask> taskes = reportTaskService.findList(reportTask);
		for(ReportTask task : taskes) {
			getSingleReport(storeMap, task);
		}
	}

	@Transactional(readOnly=false)
	private void getSingleReport(Map<String, BzStore> storeMap, ReportTask task) throws Exception {
		GetReportResponse response = ReportUtils.getReport(task.getReportId(), StoreUtils.genAmzStore(storeMap.get(task.getStoreCode())),task.getReportType());
		if(null != response) {
			task.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_IMPORT_);
			task.setFilename(ConfigConstant.FILE_PATH+task.getReportId()+".txt");
			reportTaskService.save(task);
		}
	}
	
	@Transactional(readOnly=false)
	public void importReport(String reportType) {
		
		Map<String, BzStore> storeMap = getAllStoreMap();
		
		ReportTask reportTask = new ReportTask();
		if(StringUtils.isNotEmpty(reportType)) {
			reportTask.setReportType(reportType);
		}
		reportTask.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_IMPORT_);
		List<ReportTask> taskes = reportTaskService.findList(reportTask);
		for(ReportTask task : taskes) {
			if(task.getReportType().equals(ConfigConstant._GET_RESERVED_INVENTORY_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<ReservedInventoryData> datas = new ArrayList<ReservedInventoryData>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					ReservedInventoryData rid = new ReservedInventoryData();
					rid.setTaskCode(task.getCode());
					rid.setStoreName(storeName);
					rid.setSku(info[0]);
					rid.setFnsku(info[1]);
					rid.setAsin(info[2]);
					rid.setProductName(info[3]);
					rid.setReservedQty(Integer.parseInt(info[4]));
					rid.setReservedCustomerorders(Integer.parseInt(info[5]));
					rid.setReservedFcTransfers(Integer.parseInt(info[6]));
					rid.setReservedFcProcessing(Integer.parseInt(info[7]));
					datas.add(rid);
				}
				reservedInventoryDataDao.insertBatch(datas);
			}
			if(task.getReportType().equals(ConfigConstant._GET_FBA_FULFILLMENT_MONTHLY_INVENTORY_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaFulfillmentMonthlyInventoryData> datas = new ArrayList<FbaFulfillmentMonthlyInventoryData>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaFulfillmentMonthlyInventoryData fmi = new FbaFulfillmentMonthlyInventoryData();
					fmi.setTaskCode(task.getCode());
					fmi.setStoreName(storeName);
					fmi.setMonth(info[0]);
					fmi.setSku(info[2]);
					fmi.setFnsku(info[1]);
					fmi.setProductName(info[3]);
					fmi.setAverageQuantity(info[4]);
					fmi.setEndQuantity(info[5]);
					fmi.setFulfillmentCenterId(info[6]);
					fmi.setDetailedDisposition(info[7]);
					fmi.setCountry(info[8]);
					datas.add(fmi);
				}
				fbaFulfillmentMonthlyInventoryDataDao.insertBatch(datas);
			}
			if(task.getReportType().equals(ConfigConstant._GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<EstimatedFbaFees> datas = new ArrayList<EstimatedFbaFees>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					EstimatedFbaFees ef = new EstimatedFbaFees();
					ef.setTaskCode(task.getCode());
					ef.setStoreName(storeName);
					ef.setSku(info[0]);
					ef.setFnsku(info[1]);
					ef.setAsin(info[2]);
					ef.setProductName(info[3]);
					ef.setProductGroup(info[4]);
					ef.setBrand(info[5]);
					ef.setFulfilledBy(info[6]);
					ef.setYourPrice(info[7]);
					ef.setSalesPrice(info[8]);
					ef.setLongestSide(info[9]);
					ef.setMedianSide(info[10]);
					ef.setShortestSide(info[11]);
					ef.setLengthAndGirth(info[12]);
					ef.setUnitOfDimension(info[13]);
					ef.setItemPackageWeight(info[14]);
					ef.setUnitOfWeight(info[15]);
					ef.setProductSizeTier(info[16]);
					ef.setCurrency(info[17]);
					ef.setEstimatedFeeTotal(info[18]);
					ef.setEstimatedReferralFeePerUnit(info[19]);
					ef.setEstimatedVariableClosingFee(info[20]);
					ef.setEstimatedOrderHandlingFeePerOrder(info[21]);
					ef.setEstimatedPickPackFeePerUnit(info[22]);
					ef.setEstimatedWeightHandlingFeePerUnit(info[23]);
					ef.setExpectedFulfillmentFeePerUnit(info[24]);
					datas.add(ef);
				}
				estimatedFbaFeesDao.insertBatch(datas);
			}
			if(task.getReportType().equals(ConfigConstant._GET_FBA_INVENTORY_AGED_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaInventoryAgedData> datas = new ArrayList<FbaInventoryAgedData>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaInventoryAgedData fia = new FbaInventoryAgedData();
					fia.setTaskCode(task.getCode());
					fia.setStoreName(storeName);
					fia.setSnapshotDate(info[0]);
					fia.setSku(info[1]);
					fia.setFnsku(info[2]);
					fia.setAsin(info[3]);
					fia.setProductName(info[4]);
					fia.setCondition(info[5]);
					fia.setAvaliableQuantitySellable(info[6]);
					fia.setQtyWithRemovalsInProgress(info[7]);
					fia.setInvAge0To90Days(info[8]);
					fia.setInvAge91To180Days(info[9]);
					fia.setInvAge181To270Days(info[10]);
					fia.setInvAge271To365Days(info[11]);
					fia.setInvAge365PlusDays(info[12]);
					fia.setCurrency(info[13]);
					fia.setQtyToBeChargedLtsf6Mo(info[14]);
					fia.setProjectedLtsf6Mo(info[15]);
					fia.setQtyToBeChargedLtsf12Mo(info[16]);
					fia.setProjectedLtsf12Mo(info[17]);
					fia.setUnitsShippedLast7Days(info[18]);
					fia.setUnitsShippedLast30Days(info[19]);
					fia.setUnitsShippedLast60Days(info[20]);
					fia.setUnitsShippedLast90Days(info[21]);
					fia.setAlert(info[22]);
					fia.setYourPrice(info[23]);
					fia.setSalesPrice(info[24]);
					fia.setLowestPriceNew(info[25]);
					fia.setLowestPriceUsed(info[26]);
					fia.setRecommendedAction(info[27]);
					fia.setHealthyInventoryLevel(info[28]);
					fia.setRecommendedSalesPrice(info[29]);
					fia.setRecommendedSaleDurationDays(info[30]);
					fia.setRecommendedRemovalQuantity(info[31]);
					fia.setEstimatedCostSavingsOfRemoval(info[32]);
					datas.add(fia);
				}
				fbaInventoryAgedDataDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_FBA_MYI_ALL_INVENTORY_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaMyiAllInventory> datas = new ArrayList<FbaMyiAllInventory>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaMyiAllInventory fia = new FbaMyiAllInventory();
					fia.setTaskCode(task.getCode());
					fia.setStoreName(storeName);
					fia.setSku(info[0]);
					fia.setFnsku(info[1]);
					fia.setAsin(info[2]);
					fia.setProductName(info[3]);
					fia.setCondition(info[4]);
					fia.setYourPrice(info[5]);
					fia.setMfnListingExists(info[6]);
					fia.setMfnFulfillableQuantity(info[7]);
					fia.setAfnListingExists(info[8]);
					fia.setAfnWarehouseQuantity(info[9]);
					fia.setAfnFulfillableQuantity(info[10]);
					fia.setAfnUnsellableQuantity(info[11]);
					fia.setAfnReservedQuantity(info[12]);
					fia.setAfnTotalQuantity(info[13]);
					fia.setPerUnitVolume(info[14]);
					fia.setAfnInboundWorkingQuantity(info[15]);
					fia.setAfnInboundShippedQuantity(info[16]);
					fia.setAfnInboundReceivingQuantity(info[17]);
					datas.add(fia);
				}
				fbaMyiAllInventoryDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_FLAT_FILE_ALL_ORDERS_DATA_BY_ORDER_DATE_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<AllOrdersData> datas = new ArrayList<AllOrdersData>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					AllOrdersData order = new AllOrdersData();
					order.setTaskCode(task.getCode());
					order.setStoreName(storeName);
					order.setAmazonOrderId(info[0]);
					order.setMerchantOrderId(info[1]);
					order.setPurchaseDate(info[2]);
					order.setLastUpdatedDate(info[3]);
					order.setOrderStatus(info[4]);
					order.setFulfillmentChannel(info[5]);
					order.setSalesChannel(info[6]);
					order.setOrderChannel(info[7]);
					order.setUrl(info[8]);
					order.setShipServiceLevel(info[9]);
					order.setProductName(info[10]);
					order.setSku(info[11]);
					order.setAsin(info[12]);
					order.setItemStatus(info[13]);
					order.setQuantity(info[14]);
					order.setCurrency(info[15]);
					order.setItemPrice(info[16]);
					order.setItemTax(info[17]);
					order.setShippingPrice(info[18]);
					order.setShippingTax(info[19]);
					order.setGiftWrapPrice(info[20]);
					order.setGiftWrapTax(info[21]);
					order.setItemPromotionDiscount(info[22]);
					order.setShipPromotionDiscount(info[23]);
					order.setShipCity(info[24]);
					order.setShipState(info[25]);
					order.setShipPostalCode(info[26]);
					order.setShipCountry(info[27]);
					order.setPromotionIds(info[28]);
					order.setIsBusinessOrder(info[29]);
					order.setPurchaseOrderNumber(info[30]);
					order.setPriceDesignation(info[31]);
					datas.add(order);
				}
				allOrdersDataDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_FBA_FULFILLMENT_CUSTOMER_RETURNS_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaFulfillmentCustomerReturns> datas = new ArrayList<FbaFulfillmentCustomerReturns>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaFulfillmentCustomerReturns entity = new FbaFulfillmentCustomerReturns();
					entity.setTaskCode(task.getCode());
					entity.setStoreName(storeName);
					entity.setReturnDate(info[0]);
					entity.setOrderId(info[1]);
					entity.setSku(info[2]);
					entity.setAsin(info[3]);
					entity.setFnsku(info[4]);
					entity.setProductName(info[5]);
					entity.setQuantity(info[6]);
					entity.setFulfillmentCenterId(info[7]);
					entity.setDetailedDisposition(info[8]);
					entity.setReason(info[9]);
					entity.setStatus1(info[10]);
					entity.setLicensePlateNumber(info[11]);
					entity.setCustomerComments(info[12]);
					datas.add(entity);
				}
				fbaFulfillmentCustomerReturnsDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_FBA_FULFILLMENT_INVENTORY_RECEIPTS_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaFulfillmentInventoryReceipts> datas = new ArrayList<FbaFulfillmentInventoryReceipts>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaFulfillmentInventoryReceipts entity = new FbaFulfillmentInventoryReceipts();
					entity.setTaskCode(task.getCode());
					entity.setStoreName(storeName);
					entity.setReceivedDate(info[0]);
					entity.setFnsku(info[1]);
					entity.setSku(info[2]);
					entity.setProductName(info[3]);
					entity.setQuantity(info[4]);
					entity.setFbaShipmentId(info[5]);
					entity.setFulfillmentCenterId(info[6]);
					datas.add(entity);
				}
				fbaFulfillmentInventoryReceiptsDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_SALES_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaFulfillmentCustomerShipmentSales> datas = new ArrayList<FbaFulfillmentCustomerShipmentSales>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaFulfillmentCustomerShipmentSales entity = new FbaFulfillmentCustomerShipmentSales();
					entity.setTaskCode(task.getCode());
					entity.setStoreName(storeName);
					entity.setShipmentDate(info[0]);
					entity.setSku(info[1]);
					entity.setFnsku(info[2]);
					entity.setAsin(info[3]);
					entity.setFulfillmentCenterId(info[4]);
					entity.setQuantity(info[5]);
					entity.setAmazonOrderId(info[6]);
					entity.setCurrency(info[7]);
					entity.setItemPricePerUnit(info[8]);
					entity.setShippingPrice(info[9]);
					entity.setGiftWrapPrice(info[10]);
					entity.setShipCity(info[11]);
					entity.setShipState(info[12]);
					entity.setShipPostalCode(info[13]);
					datas.add(entity);
				}
				fbaFulfillmentCustomerShipmentSalesDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_FBA_FULFILLMENT_INVENTORY_ADJUSTMENTS_DATA_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<FbaFulfillmentInventoryAdjustments> datas = new ArrayList<FbaFulfillmentInventoryAdjustments>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					FbaFulfillmentInventoryAdjustments entity = new FbaFulfillmentInventoryAdjustments();
					entity.setTaskCode(task.getCode());
					entity.setStoreName(storeName);
					entity.setAdjustedDate(info[0]);
					entity.setTransactionItemId(info[1]);
					entity.setFnsku(info[2]);
					entity.setSku(info[3]);
					entity.setProductName(info[4]);
					entity.setFulfillmentCenterId(info[5]);
					entity.setQuantity(info[6]);
					entity.setReason(info[7]);
					entity.setDisposition(info[8]);
					datas.add(entity);
				}
				fbaFulfillmentInventoryAdjustmentsDao.insertBatch(datas);
			}
			
			if(task.getReportType().equals(ConfigConstant._GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE_)) {
				String storeName = storeMap.get(task.getStoreCode()).getStoreName();
				List<SettlementReport> datas = new ArrayList<SettlementReport>();
				List<String> lines = readFileByLines(task.getFilename(),2);
				int count = 0;
				for(String line : lines) {
					String[] info = StringUtils.splitPreserveAllTokens(line, "\t");
					SettlementReport entity = new SettlementReport();
					entity.setTaskCode(task.getCode());
					entity.setStoreName(storeName);
					entity.setSettlementId(info[0]);
					entity.setSettlementStartDate(info[1]);
					entity.setSettlementEndDate(info[2]);
					entity.setDepositDate(info[3]);
					entity.setTotalAmount(info[4]);
					entity.setCurrency(info[5]);
					entity.setTransactionType(info[6]);
					entity.setOrderId(info[7]);
					entity.setMerchantOrderId(info[8]);
					entity.setAdjustmentId(info[9]);
					entity.setShipmentId(info[10]);
					entity.setMarketplaceName(info[11]);
					entity.setAmountType(info[12]);
					entity.setAmountDescription(info[13]);
					entity.setAmount(info[14]);
					entity.setFulfillmentId(info[15]);
					entity.setPostedDate(info[16]);
					entity.setPostedDateTime(info[17]);
					entity.setOrderItemCode(info[18]);
					entity.setMerchantOrderItemId(info[19]);
					entity.setMerchantAdjustmentItemId(info[20]);
					entity.setSku(info[21]);
					entity.setQuantityPurchased(info[22]);
					entity.setPromotionId(info[23]);
					datas.add(entity);
					count++;
					if(count%1000==0) {
						settlementReportDao.insertBatch(datas);
						datas.clear();
					}
				}
				settlementReportDao.insertBatch(datas);
			}
			
			
			task.setReportProcessingStatus(ReportUtils.PROCESSING_STATUS_FINISH_);
			reportTaskService.save(task);
		}
	}

	
	private List<String> readFileByLines(String fileName,int row) {  
        File file = new File(fileName);  
        List<String> lines = new ArrayList<String>();
        BufferedReader reader = null;  
        try {  
            //System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
//                System.out.println("line " + line + ": " + tempString); 
                if(line >= row)
                lines.add(tempString);
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }
        return lines;
    }  
	
	
	private Map<String, BzStore> getAllStoreMap() {
		Map<String,BzStore> storeMap = new HashMap<String,BzStore>();
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		for(BzStore store : stores) {
			if(null == store.getBzStoreAttrList() || store.getBzStoreAttrList().size() == 0) {
				BzStoreAttr storeAttr = new BzStoreAttr();
				storeAttr.setStoreCode(store);
				List<BzStoreAttr> list = bzStoreAttrDao.findList(storeAttr);
				store.setBzStoreAttrList(list);
			}
			storeMap.put(store.getCode(), store);
		}
		return storeMap;
	}
	
	public void getFinancesGroup() {
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		for(BzStore store : stores) {
			if(null == store.getBzStoreAttrList() || store.getBzStoreAttrList().size() == 0) {
				BzStoreAttr storeAttr = new BzStoreAttr();
				storeAttr.setStoreCode(store);
				List<BzStoreAttr> list = bzStoreAttrDao.findList(storeAttr);
				store.setBzStoreAttrList(list);
			}
			getNewFinancialDateOfStore(store);
		}
		
	}
	@Transactional(readOnly=false)
	private void getNewFinancialDateOfStore(BzStore store) {
		ListFinancialEventGroupsResponse res= FinanceUtils.getFinancesEventGroup(StoreUtils.genAmzStore(store),"15","0");
		List<FinancialEventGroup> group = res.getListFinancialEventGroupsResult().getFinancialEventGroupList();
		String nextToken = res.getListFinancialEventGroupsResult().getNextToken();
		while(StringUtils.isNotEmpty(nextToken)) {
			ListFinancialEventGroupsByNextTokenResponse nextRes = FinanceUtils.getFinancesEventGroupNext(StoreUtils.genAmzStore(store), nextToken);
			nextToken = nextRes.getListFinancialEventGroupsByNextTokenResult().getNextToken();
			group.addAll(nextRes.getListFinancialEventGroupsByNextTokenResult().getFinancialEventGroupList());
		}
		List<com.jeesite.modules.financial.entity.FinancialEventGroup> entitys = ListUtils.newArrayList();
		for(FinancialEventGroup a : group) {
			entitys.add(ResponseResultUtils.buildFinancialEventGroupEntity(a, store.getStoreName()));
		}
		financialEventGroupDao.insertBatch(entitys);
	}
	
	public void updateFinanceEventGroupStatus() {
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		for(BzStore store : stores) {
			com.jeesite.modules.financial.entity.FinancialEventGroup eventGroup = new com.jeesite.modules.financial.entity.FinancialEventGroup();
			eventGroup.setProcessingStatus(ResponseResultUtils.FINANCIAL_EVENT_GROUP_PROCESSING_STATUS_OPEN);
			eventGroup.setStoreName(store.getStoreName());
			List<com.jeesite.modules.financial.entity.FinancialEventGroup> list = financialEventGroupDao.findList(eventGroup);
		}
	}
	
	public void getFinancesEvent() {
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		for(BzStore store : stores) {
			if(null == store.getBzStoreAttrList() || store.getBzStoreAttrList().size() == 0) {
				BzStoreAttr storeAttr = new BzStoreAttr();
				storeAttr.setStoreCode(store);
				List<BzStoreAttr> list = bzStoreAttrDao.findList(storeAttr);
				store.setBzStoreAttrList(list);
			}
//			getNewFinancialDateOfStore(store);
			ListFinancialEventsResponse res = FinanceUtils.getFinancesEvent(StoreUtils.genAmzStore(store), null, null, "0", "0");
			
			String token = res.getListFinancialEventsResult().getNextToken();
			List<FinancialEvents> events = new ArrayList<FinancialEvents>();
			events.add(res.getListFinancialEventsResult().getFinancialEvents());
			
			while(StringUtils.isNotEmpty(token)) {
				ListFinancialEventsByNextTokenResponse resp = FinanceUtils.getFinancesEventNext(StoreUtils.genAmzStore(store), token);
				token = resp.getListFinancialEventsByNextTokenResult().getNextToken();
				events.add(resp.getListFinancialEventsByNextTokenResult().getFinancialEvents());
			}
			
			for(FinancialEvents event : events) {
				if(event.isSetAdjustmentEventList()) {
					List<AdjustmentEvent> adjs = event.getAdjustmentEventList();
					for(AdjustmentEvent adj : adjs) {
						adj.getAdjustmentItemList();
					}
				}
				List<ShipmentEvent> cbes = event.getChargebackEventList();
				List<CouponPaymentEvent> cpes = event.getCouponPaymentEventList();
				List<DebtRecoveryEvent> dres = event.getDebtRecoveryEventList();
				List<FBALiquidationEvent> fles = event.getFBALiquidationEventList();
				List<ShipmentEvent> gces = event.getGuaranteeClaimEventList();
				List<ImagingServicesFeeEvent> isfs = event.getImagingServicesFeeEventList();
				List<LoanServicingEvent> lses = event.getLoanServicingEventList();
				List<PayWithAmazonEvent> pwas = event.getPayWithAmazonEventList();
				List<PerformanceBondRefundEvent> pbre = event.getPerformanceBondRefundEventList();
				List<ProductAdsPaymentEvent> apes = event.getProductAdsPaymentEventList();
				List<ShipmentEvent> rfes = event.getRefundEventList();
				List<RentalTransactionEvent> rtes = event.getRentalTransactionEventList();
				List<RetrochargeEvent> rces = event.getRetrochargeEventList();
				List<SAFETReimbursementEvent> rbes = event.getSAFETReimbursementEventList();
				List<SellerDealPaymentEvent> sdps = event.getSellerDealPaymentEventList();
				List<SellerReviewEnrollmentPaymentEvent> reps = event.getSellerReviewEnrollmentPaymentEventList();
				List<ServiceFeeEvent> sfes = event.getServiceFeeEventList();
				List<SolutionProviderCreditEvent> spcs = event.getServiceProviderCreditEventList();
				List<ShipmentEvent> ses = event.getShipmentEventList();
				
				
			}
			
		}
	}
	
}