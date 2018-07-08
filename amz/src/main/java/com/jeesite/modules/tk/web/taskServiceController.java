/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.io.FileUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.tk.service.TaskService;
import com.xunlikun.constant.ConfigConstant;

/**
 * 店铺Controller
 * @author xunliku
 * @version 2018-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/bz/tkService")
public class taskServiceController extends BaseController {

	@Autowired
	TaskService taskService;
	
	@RequestMapping(value = "requestAll")
	@ResponseBody
	public String requestAll(String reportType) {
		try {
//			taskService.submitReportRequest(reportType,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_ESTIMATED_FBA_FEES_TXT_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_FULFILLMENT_CUSTOMER_RETURNS_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_FULFILLMENT_CUSTOMER_SHIPMENT_SALES_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_FULFILLMENT_INVENTORY_ADJUSTMENTS_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_FULFILLMENT_INVENTORY_RECEIPTS_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_FULFILLMENT_MONTHLY_INVENTORY_DATA_,"$1","$1" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_FULFILLMENT_REMOVAL_ORDER_DETAIL_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_INVENTORY_AGED_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FBA_MYI_ALL_INVENTORY_DATA_,"0","0" );
//			taskService.submitReportRequest(ConfigConstant._GET_FLAT_FILE_ALL_ORDERS_DATA_BY_ORDER_DATE_,"0","0" );
			taskService.submitReportRequest(ConfigConstant._GET_RESERVED_INVENTORY_DATA_,"0","0" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "reservedInv")
	@ResponseBody
	public String requestReservedInventory(String reportType) {
		try {
			taskService.submitReportRequest(ConfigConstant._GET_RESERVED_INVENTORY_DATA_,"0","0" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "run over";
	}
	
	@RequestMapping(value = "requestList")
	@ResponseBody
	public String requestList() {
		try {
			taskService.getReportRequsetList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "reportList")
	@ResponseBody
	public String reportList() {
		try {
			taskService.getReportList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "settlement")
	@ResponseBody
	public String settlementReport() {
		try {
			taskService.getSettlementReportList(ConfigConstant._GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE_,"13","0");
			//taskService.getSettlementReportList(ConfigConstant._GET_V2_SETTLEMENT_REPORT_DATA_FLAT_FILE_V2_,"13","0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "over";
	}
	
	@RequestMapping(value = "getReport")
	@ResponseBody
	public String getReport() {
		try {
			taskService.getReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "getReport over!";
	}
	
	@RequestMapping(value = "importReport")
	@ResponseBody
	public String importReport(String reportType) {
		taskService.importReport("");
		return "";
	}
	
	@RequestMapping(value = "financialeg")
	@ResponseBody
	public String getFinancialEventGroup() {
		taskService.getFinancesGroup();
		return "over";
	}
	
	@RequestMapping(value = "file")
	@ResponseBody
	public String createFile() {
		return FileUtils.createFile("todo/path.log")+"";
	}
}