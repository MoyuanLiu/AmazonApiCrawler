/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.settlement.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.settlement.entity.SettlementReport;
import com.jeesite.modules.settlement.service.SettlementReportService;

/**
 * settlement_reportController
 * @author 荀立坤
 * @version 2018-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/settlement/settlementReport")
public class SettlementReportController extends BaseController {

	@Autowired
	private SettlementReportService settlementReportService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SettlementReport get(String code, boolean isNewRecord) {
		return settlementReportService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("settlement:settlementReport:view")
	@RequestMapping(value = {"list", ""})
	public String list(SettlementReport settlementReport, Model model) {
		model.addAttribute("settlementReport", settlementReport);
		return "modules/settlement/settlementReportList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("settlement:settlementReport:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SettlementReport> listData(SettlementReport settlementReport, HttpServletRequest request, HttpServletResponse response) {
		Page<SettlementReport> page = settlementReportService.findPage(new Page<SettlementReport>(request, response), settlementReport); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("settlement:settlementReport:view")
	@RequestMapping(value = "form")
	public String form(SettlementReport settlementReport, Model model) {
		model.addAttribute("settlementReport", settlementReport);
		return "modules/settlement/settlementReportForm";
	}

	/**
	 * 保存settlement_report
	 */
	@RequiresPermissions("settlement:settlementReport:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SettlementReport settlementReport) {
		settlementReportService.save(settlementReport);
		return renderResult(Global.TRUE, "保存settlement_report成功！");
	}
	
	/**
	 * 删除settlement_report
	 */
	@RequiresPermissions("settlement:settlementReport:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SettlementReport settlementReport) {
		settlementReportService.delete(settlementReport);
		return renderResult(Global.TRUE, "删除settlement_report成功！");
	}
	
}