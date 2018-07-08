/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.orders.web;

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
import com.jeesite.modules.orders.entity.AllOrdersData;
import com.jeesite.modules.orders.service.AllOrdersDataService;

/**
 * all_orders_dataController
 * @author xlk
 * @version 2018-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/orders/allOrdersData")
public class AllOrdersDataController extends BaseController {

	@Autowired
	private AllOrdersDataService allOrdersDataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public AllOrdersData get(String code, boolean isNewRecord) {
		return allOrdersDataService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("orders:allOrdersData:view")
	@RequestMapping(value = {"list", ""})
	public String list(AllOrdersData allOrdersData, Model model) {
		model.addAttribute("allOrdersData", allOrdersData);
		return "modules/orders/allOrdersDataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("orders:allOrdersData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<AllOrdersData> listData(AllOrdersData allOrdersData, HttpServletRequest request, HttpServletResponse response) {
		Page<AllOrdersData> page = allOrdersDataService.findPage(new Page<AllOrdersData>(request, response), allOrdersData); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("orders:allOrdersData:view")
	@RequestMapping(value = "form")
	public String form(AllOrdersData allOrdersData, Model model) {
		model.addAttribute("allOrdersData", allOrdersData);
		return "modules/orders/allOrdersDataForm";
	}

	/**
	 * 保存all_orders_data
	 */
	@RequiresPermissions("orders:allOrdersData:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated AllOrdersData allOrdersData) {
		allOrdersDataService.save(allOrdersData);
		return renderResult(Global.TRUE, "保存all_orders_data成功！");
	}
	
	/**
	 * 删除all_orders_data
	 */
	@RequiresPermissions("orders:allOrdersData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(AllOrdersData allOrdersData) {
		allOrdersDataService.delete(allOrdersData);
		return renderResult(Global.TRUE, "删除all_orders_data成功！");
	}
	
}