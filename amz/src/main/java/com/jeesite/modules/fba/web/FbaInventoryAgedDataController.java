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
import com.jeesite.modules.fba.entity.FbaInventoryAgedData;
import com.jeesite.modules.fba.service.FbaInventoryAgedDataService;

/**
 * fba_inventory_aged_dataController
 * @author xlk
 * @version 2018-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/fba/fbaInventoryAgedData")
public class FbaInventoryAgedDataController extends BaseController {

	@Autowired
	private FbaInventoryAgedDataService fbaInventoryAgedDataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaInventoryAgedData get(String code, boolean isNewRecord) {
		return fbaInventoryAgedDataService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fba:fbaInventoryAgedData:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaInventoryAgedData fbaInventoryAgedData, Model model) {
		model.addAttribute("fbaInventoryAgedData", fbaInventoryAgedData);
		return "modules/fba/fbaInventoryAgedDataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fba:fbaInventoryAgedData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaInventoryAgedData> listData(FbaInventoryAgedData fbaInventoryAgedData, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaInventoryAgedData> page = fbaInventoryAgedDataService.findPage(new Page<FbaInventoryAgedData>(request, response), fbaInventoryAgedData); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fba:fbaInventoryAgedData:view")
	@RequestMapping(value = "form")
	public String form(FbaInventoryAgedData fbaInventoryAgedData, Model model) {
		model.addAttribute("fbaInventoryAgedData", fbaInventoryAgedData);
		return "modules/fba/fbaInventoryAgedDataForm";
	}

	/**
	 * 保存fba_inventory_aged_data
	 */
	@RequiresPermissions("fba:fbaInventoryAgedData:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaInventoryAgedData fbaInventoryAgedData) {
		fbaInventoryAgedDataService.save(fbaInventoryAgedData);
		return renderResult(Global.TRUE, "保存fba_inventory_aged_data成功！");
	}
	
	/**
	 * 删除fba_inventory_aged_data
	 */
	@RequiresPermissions("fba:fbaInventoryAgedData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaInventoryAgedData fbaInventoryAgedData) {
		fbaInventoryAgedDataService.delete(fbaInventoryAgedData);
		return renderResult(Global.TRUE, "删除fba_inventory_aged_data成功！");
	}
	
}