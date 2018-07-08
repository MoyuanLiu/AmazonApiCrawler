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
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryAdjustments;
import com.jeesite.modules.fba.service.FbaFulfillmentInventoryAdjustmentsService;

/**
 * fba_fulfillment_inventory_adjustmentsController
 * @author xlk
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/fba/fbaFulfillmentInventoryAdjustments")
public class FbaFulfillmentInventoryAdjustmentsController extends BaseController {

	@Autowired
	private FbaFulfillmentInventoryAdjustmentsService fbaFulfillmentInventoryAdjustmentsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaFulfillmentInventoryAdjustments get(String code, boolean isNewRecord) {
		return fbaFulfillmentInventoryAdjustmentsService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryAdjustments:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments, Model model) {
		model.addAttribute("fbaFulfillmentInventoryAdjustments", fbaFulfillmentInventoryAdjustments);
		return "modules/fba/fbaFulfillmentInventoryAdjustmentsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryAdjustments:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaFulfillmentInventoryAdjustments> listData(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaFulfillmentInventoryAdjustments> page = fbaFulfillmentInventoryAdjustmentsService.findPage(new Page<FbaFulfillmentInventoryAdjustments>(request, response), fbaFulfillmentInventoryAdjustments); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryAdjustments:view")
	@RequestMapping(value = "form")
	public String form(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments, Model model) {
		model.addAttribute("fbaFulfillmentInventoryAdjustments", fbaFulfillmentInventoryAdjustments);
		return "modules/fba/fbaFulfillmentInventoryAdjustmentsForm";
	}

	/**
	 * 保存fba_fulfillment_inventory_adjustments
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryAdjustments:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		fbaFulfillmentInventoryAdjustmentsService.save(fbaFulfillmentInventoryAdjustments);
		return renderResult(Global.TRUE, "保存fba_fulfillment_inventory_adjustments成功！");
	}
	
	/**
	 * 删除fba_fulfillment_inventory_adjustments
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryAdjustments:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		fbaFulfillmentInventoryAdjustmentsService.delete(fbaFulfillmentInventoryAdjustments);
		return renderResult(Global.TRUE, "删除fba_fulfillment_inventory_adjustments成功！");
	}
	
}