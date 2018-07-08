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
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerShipmentSales;
import com.jeesite.modules.fba.service.FbaFulfillmentCustomerShipmentSalesService;

/**
 * fba_fulfillment_customer_shipment_salesController
 * @author xlk
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/fba/fbaFulfillmentCustomerShipmentSales")
public class FbaFulfillmentCustomerShipmentSalesController extends BaseController {

	@Autowired
	private FbaFulfillmentCustomerShipmentSalesService fbaFulfillmentCustomerShipmentSalesService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaFulfillmentCustomerShipmentSales get(String code, boolean isNewRecord) {
		return fbaFulfillmentCustomerShipmentSalesService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerShipmentSales:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales, Model model) {
		model.addAttribute("fbaFulfillmentCustomerShipmentSales", fbaFulfillmentCustomerShipmentSales);
		return "modules/fba/fbaFulfillmentCustomerShipmentSalesList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerShipmentSales:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaFulfillmentCustomerShipmentSales> listData(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaFulfillmentCustomerShipmentSales> page = fbaFulfillmentCustomerShipmentSalesService.findPage(new Page<FbaFulfillmentCustomerShipmentSales>(request, response), fbaFulfillmentCustomerShipmentSales); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerShipmentSales:view")
	@RequestMapping(value = "form")
	public String form(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales, Model model) {
		model.addAttribute("fbaFulfillmentCustomerShipmentSales", fbaFulfillmentCustomerShipmentSales);
		return "modules/fba/fbaFulfillmentCustomerShipmentSalesForm";
	}

	/**
	 * 保存fba_fulfillment_customer_shipment_sales
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerShipmentSales:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		fbaFulfillmentCustomerShipmentSalesService.save(fbaFulfillmentCustomerShipmentSales);
		return renderResult(Global.TRUE, "保存fba_fulfillment_customer_shipment_sales成功！");
	}
	
	/**
	 * 删除fba_fulfillment_customer_shipment_sales
	 */
	@RequiresPermissions("fba:fbaFulfillmentCustomerShipmentSales:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		fbaFulfillmentCustomerShipmentSalesService.delete(fbaFulfillmentCustomerShipmentSales);
		return renderResult(Global.TRUE, "删除fba_fulfillment_customer_shipment_sales成功！");
	}
	
}