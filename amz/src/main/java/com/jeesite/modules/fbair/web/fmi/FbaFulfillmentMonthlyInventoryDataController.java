/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.web.fmi;

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
import com.jeesite.modules.fbair.entity.fmi.FbaFulfillmentMonthlyInventoryData;
import com.jeesite.modules.fbair.service.fmi.FbaFulfillmentMonthlyInventoryDataService;

/**
 * fba_fulfillment_monthly_inventory_dataController
 * @author xunlikun
 * @version 2018-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/fbair/fmi/fbaFulfillmentMonthlyInventoryData")
public class FbaFulfillmentMonthlyInventoryDataController extends BaseController {

	@Autowired
	private FbaFulfillmentMonthlyInventoryDataService fbaFulfillmentMonthlyInventoryDataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaFulfillmentMonthlyInventoryData get(String code, boolean isNewRecord) {
		return fbaFulfillmentMonthlyInventoryDataService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fbair:fmi:fbaFulfillmentMonthlyInventoryData:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData, Model model) {
		model.addAttribute("fbaFulfillmentMonthlyInventoryData", fbaFulfillmentMonthlyInventoryData);
		return "modules/fbair/fmi/fbaFulfillmentMonthlyInventoryDataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fbair:fmi:fbaFulfillmentMonthlyInventoryData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaFulfillmentMonthlyInventoryData> listData(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaFulfillmentMonthlyInventoryData> page = fbaFulfillmentMonthlyInventoryDataService.findPage(new Page<FbaFulfillmentMonthlyInventoryData>(request, response), fbaFulfillmentMonthlyInventoryData); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fbair:fmi:fbaFulfillmentMonthlyInventoryData:view")
	@RequestMapping(value = "form")
	public String form(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData, Model model) {
		model.addAttribute("fbaFulfillmentMonthlyInventoryData", fbaFulfillmentMonthlyInventoryData);
		return "modules/fbair/fmi/fbaFulfillmentMonthlyInventoryDataForm";
	}

	/**
	 * 保存fba_fulfillment_monthly_inventory_data
	 */
	@RequiresPermissions("fbair:fmi:fbaFulfillmentMonthlyInventoryData:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		fbaFulfillmentMonthlyInventoryDataService.save(fbaFulfillmentMonthlyInventoryData);
		return renderResult(Global.TRUE, "保存fba_fulfillment_monthly_inventory_data成功！");
	}
	
	/**
	 * 删除fba_fulfillment_monthly_inventory_data
	 */
	@RequiresPermissions("fbair:fmi:fbaFulfillmentMonthlyInventoryData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		fbaFulfillmentMonthlyInventoryDataService.delete(fbaFulfillmentMonthlyInventoryData);
		return renderResult(Global.TRUE, "删除fba_fulfillment_monthly_inventory_data成功！");
	}
	
}