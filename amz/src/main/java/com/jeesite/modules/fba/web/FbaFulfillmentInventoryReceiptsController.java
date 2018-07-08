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
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryReceipts;
import com.jeesite.modules.fba.service.FbaFulfillmentInventoryReceiptsService;

/**
 * fba_fulfillment_inventory_receiptsController
 * @author xlk
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/fba/fbaFulfillmentInventoryReceipts")
public class FbaFulfillmentInventoryReceiptsController extends BaseController {

	@Autowired
	private FbaFulfillmentInventoryReceiptsService fbaFulfillmentInventoryReceiptsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaFulfillmentInventoryReceipts get(String code, boolean isNewRecord) {
		return fbaFulfillmentInventoryReceiptsService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryReceipts:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts, Model model) {
		model.addAttribute("fbaFulfillmentInventoryReceipts", fbaFulfillmentInventoryReceipts);
		return "modules/fba/fbaFulfillmentInventoryReceiptsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryReceipts:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaFulfillmentInventoryReceipts> listData(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaFulfillmentInventoryReceipts> page = fbaFulfillmentInventoryReceiptsService.findPage(new Page<FbaFulfillmentInventoryReceipts>(request, response), fbaFulfillmentInventoryReceipts); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryReceipts:view")
	@RequestMapping(value = "form")
	public String form(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts, Model model) {
		model.addAttribute("fbaFulfillmentInventoryReceipts", fbaFulfillmentInventoryReceipts);
		return "modules/fba/fbaFulfillmentInventoryReceiptsForm";
	}

	/**
	 * 保存fba_fulfillment_inventory_receipts
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryReceipts:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		fbaFulfillmentInventoryReceiptsService.save(fbaFulfillmentInventoryReceipts);
		return renderResult(Global.TRUE, "保存fba_fulfillment_inventory_receipts成功！");
	}
	
	/**
	 * 删除fba_fulfillment_inventory_receipts
	 */
	@RequiresPermissions("fba:fbaFulfillmentInventoryReceipts:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		fbaFulfillmentInventoryReceiptsService.delete(fbaFulfillmentInventoryReceipts);
		return renderResult(Global.TRUE, "删除fba_fulfillment_inventory_receipts成功！");
	}
	
}