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
import com.jeesite.modules.fba.entity.FbaMyiAllInventory;
import com.jeesite.modules.fba.service.FbaMyiAllInventoryService;

/**
 * fba_myi_all_inventoryController
 * @author xlk
 * @version 2018-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/fba/fbaMyiAllInventory")
public class FbaMyiAllInventoryController extends BaseController {

	@Autowired
	private FbaMyiAllInventoryService fbaMyiAllInventoryService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public FbaMyiAllInventory get(String code, boolean isNewRecord) {
		return fbaMyiAllInventoryService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fba:fbaMyiAllInventory:view")
	@RequestMapping(value = {"list", ""})
	public String list(FbaMyiAllInventory fbaMyiAllInventory, Model model) {
		model.addAttribute("fbaMyiAllInventory", fbaMyiAllInventory);
		return "modules/fba/fbaMyiAllInventoryList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fba:fbaMyiAllInventory:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<FbaMyiAllInventory> listData(FbaMyiAllInventory fbaMyiAllInventory, HttpServletRequest request, HttpServletResponse response) {
		Page<FbaMyiAllInventory> page = fbaMyiAllInventoryService.findPage(new Page<FbaMyiAllInventory>(request, response), fbaMyiAllInventory); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fba:fbaMyiAllInventory:view")
	@RequestMapping(value = "form")
	public String form(FbaMyiAllInventory fbaMyiAllInventory, Model model) {
		model.addAttribute("fbaMyiAllInventory", fbaMyiAllInventory);
		return "modules/fba/fbaMyiAllInventoryForm";
	}

	/**
	 * 保存fba_myi_all_inventory
	 */
	@RequiresPermissions("fba:fbaMyiAllInventory:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated FbaMyiAllInventory fbaMyiAllInventory) {
		fbaMyiAllInventoryService.save(fbaMyiAllInventory);
		return renderResult(Global.TRUE, "保存fba_myi_all_inventory成功！");
	}
	
	/**
	 * 删除fba_myi_all_inventory
	 */
	@RequiresPermissions("fba:fbaMyiAllInventory:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(FbaMyiAllInventory fbaMyiAllInventory) {
		fbaMyiAllInventoryService.delete(fbaMyiAllInventory);
		return renderResult(Global.TRUE, "删除fba_myi_all_inventory成功！");
	}
	
}