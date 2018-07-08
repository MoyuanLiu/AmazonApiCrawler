/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.web;

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
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerReturns;
import com.jeesite.modules.fba.service.FbaFulfillmentCustomerReturnsService;

/**
 * fba_fulfillment_customer_returnsController
 * @author xlk
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/fba/fbaFulfillmentCustomerReturns")
public class FbaFulfillmentCustomerReturnsController extends BaseController {

	@Autowired
	private FbaFulfillmentCustomerReturnsService fbaFulfillmentCustomerReturnsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaFulfillmentCustomerReturns get(String code, boolean isNewRecord) {
		return fbaFulfillmentCustomerReturnsService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerReturns:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns, Model model) {
		model.addAttribute("fbaFulfillmentCustomerReturns", fbaFulfillmentCustomerReturns);
		return "modules/fba/fbaFulfillmentCustomerReturnsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerReturns:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaFulfillmentCustomerReturns> listData(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaFulfillmentCustomerReturns> page = fbaFulfillmentCustomerReturnsService.findPage(new Page<FbaFulfillmentCustomerReturns>(request, response), fbaFulfillmentCustomerReturns); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerReturns:view")
	@RequestMapping(value = "form")
	public String form(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns, Model model) {
		model.addAttribute("fbaFulfillmentCustomerReturns", fbaFulfillmentCustomerReturns);
		return "modules/fba/fbaFulfillmentCustomerReturnsForm";
	}

	/**
	 * 保存fba_fulfillment_customer_returns
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerReturns:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		fbaFulfillmentCustomerReturnsService.save(fbaFulfillmentCustomerReturns);
		return renderResult(Global.TRUE, "保存fba_fulfillment_customer_returns成功！");
	}
	
	/**
	 * 删除fba_fulfillment_customer_returns
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerReturns:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		fbaFulfillmentCustomerReturnsService.delete(fbaFulfillmentCustomerReturns);
		return renderResult(Global.TRUE, "删除fba_fulfillment_customer_returns成功！");
	}
	
}