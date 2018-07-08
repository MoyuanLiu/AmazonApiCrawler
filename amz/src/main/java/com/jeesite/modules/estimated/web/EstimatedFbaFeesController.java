/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.estimated.web;

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
import com.jeesite.modules.estimated.entity.EstimatedFbaFees;
import com.jeesite.modules.estimated.service.EstimatedFbaFeesService;

/**
 * estimated_fba_feesController
 * @author xlk
 * @version 2018-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/estimated/estimatedFbaFees")
public class EstimatedFbaFeesController extends BaseController {

	@Autowired
	private EstimatedFbaFeesService estimatedFbaFeesService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public EstimatedFbaFees get(String code, boolean isNewRecord) {
		return estimatedFbaFeesService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("estimated:estimatedFbaFees:view")
	@RequestMapping(value = {"list", ""})
	public String list(EstimatedFbaFees estimatedFbaFees, Model model) {
		model.addAttribute("estimatedFbaFees", estimatedFbaFees);
		return "modules/estimated/estimatedFbaFeesList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("estimated:estimatedFbaFees:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<EstimatedFbaFees> listData(EstimatedFbaFees estimatedFbaFees, HttpServletRequest request, HttpServletResponse response) {
		Page<EstimatedFbaFees> page = estimatedFbaFeesService.findPage(new Page<EstimatedFbaFees>(request, response), estimatedFbaFees); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("estimated:estimatedFbaFees:view")
	@RequestMapping(value = "form")
	public String form(EstimatedFbaFees estimatedFbaFees, Model model) {
		model.addAttribute("estimatedFbaFees", estimatedFbaFees);
		return "modules/estimated/estimatedFbaFeesForm";
	}

	/**
	 * 保存estimated_fba_fees
	 */
	@RequiresPermissions("estimated:estimatedFbaFees:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated EstimatedFbaFees estimatedFbaFees) {
		estimatedFbaFeesService.save(estimatedFbaFees);
		return renderResult(Global.TRUE, "保存estimated_fba_fees成功！");
	}
	
	/**
	 * 删除estimated_fba_fees
	 */
	@RequiresPermissions("estimated:estimatedFbaFees:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(EstimatedFbaFees estimatedFbaFees) {
		estimatedFbaFeesService.delete(estimatedFbaFees);
		return renderResult(Global.TRUE, "删除estimated_fba_fees成功！");
	}
	
}