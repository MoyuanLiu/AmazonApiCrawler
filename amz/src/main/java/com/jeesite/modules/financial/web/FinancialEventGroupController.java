/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.financial.web;

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
import com.jeesite.modules.financial.entity.FinancialEventGroup;
import com.jeesite.modules.financial.service.FinancialEventGroupService;

/**
 * financial_event_groupController
 * @author xlk
 * @version 2018-05-21
 */
@Controller
@RequestMapping(value = "${adminPath}/financial/financialEventGroup")
public class FinancialEventGroupController extends BaseController {

	@Autowired
	private FinancialEventGroupService financialEventGroupService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FinancialEventGroup get(String code, boolean isNewRecord) {
		return financialEventGroupService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("financial:financialEventGroup:view")
	@RequestMapping(value = {"list", ""})
	public String list(FinancialEventGroup financialEventGroup, Model model) {
		model.addAttribute("financialEventGroup", financialEventGroup);
		return "modules/financial/financialEventGroupList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("financial:financialEventGroup:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FinancialEventGroup> listData(FinancialEventGroup financialEventGroup, HttpServletRequest request, HttpServletResponse response) {
		Page<FinancialEventGroup> page = financialEventGroupService.findPage(new Page<FinancialEventGroup>(request, response), financialEventGroup); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("financial:financialEventGroup:view")
	@RequestMapping(value = "form")
	public String form(FinancialEventGroup financialEventGroup, Model model) {
		model.addAttribute("financialEventGroup", financialEventGroup);
		return "modules/financial/financialEventGroupForm";
	}

	/**
	 * 保存financial_event_group
	 */
	@RequiresPermissions("financial:financialEventGroup:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FinancialEventGroup financialEventGroup) {
		financialEventGroupService.save(financialEventGroup);
		return renderResult(Global.TRUE, "保存financial_event_group成功！");
	}
	
	/**
	 * 删除financial_event_group
	 */
	@RequiresPermissions("financial:financialEventGroup:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FinancialEventGroup financialEventGroup) {
		financialEventGroupService.delete(financialEventGroup);
		return renderResult(Global.TRUE, "删除financial_event_group成功！");
	}
	
}