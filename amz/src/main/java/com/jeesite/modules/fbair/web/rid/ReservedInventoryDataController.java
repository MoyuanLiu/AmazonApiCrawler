/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.web.rid;

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
import com.jeesite.modules.fbair.entity.rid.ReservedInventoryData;
import com.jeesite.modules.fbair.service.rid.ReservedInventoryDataService;

/**
 * reserved_inventory_dataController
 * @author xunlikun
 * @version 2018-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/fbair/rid/reservedInventoryData")
public class ReservedInventoryDataController extends BaseController {

	@Autowired
	private ReservedInventoryDataService reservedInventoryDataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ReservedInventoryData get(String code, boolean isNewRecord) {
		return reservedInventoryDataService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("fbair:rid:reservedInventoryData:view")
	@RequestMapping(value = {"list", ""})
	public String list(ReservedInventoryData reservedInventoryData, Model model) {
		model.addAttribute("reservedInventoryData", reservedInventoryData);
		return "modules/fbair/rid/reservedInventoryDataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("fbair:rid:reservedInventoryData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ReservedInventoryData> listData(ReservedInventoryData reservedInventoryData, HttpServletRequest request, HttpServletResponse response) {
		Page<ReservedInventoryData> page = reservedInventoryDataService.findPage(new Page<ReservedInventoryData>(request, response), reservedInventoryData); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("fbair:rid:reservedInventoryData:view")
	@RequestMapping(value = "form")
	public String form(ReservedInventoryData reservedInventoryData, Model model) {
		model.addAttribute("reservedInventoryData", reservedInventoryData);
		return "modules/fbair/rid/reservedInventoryDataForm";
	}

	/**
	 * 保存reserved_inventory_data
	 */
	@RequiresPermissions("fbair:rid:reservedInventoryData:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ReservedInventoryData reservedInventoryData) {
		reservedInventoryDataService.save(reservedInventoryData);
		return renderResult(Global.TRUE, "保存reserved_inventory_data成功！");
	}
	
	/**
	 * 删除reserved_inventory_data
	 */
	@RequiresPermissions("fbair:rid:reservedInventoryData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ReservedInventoryData reservedInventoryData) {
		reservedInventoryDataService.delete(reservedInventoryData);
		return renderResult(Global.TRUE, "删除reserved_inventory_data成功！");
	}
	
}