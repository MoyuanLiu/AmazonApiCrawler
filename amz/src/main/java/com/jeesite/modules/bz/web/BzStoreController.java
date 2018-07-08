/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.web;

import java.util.ArrayList;
import java.util.List;

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
import com.jeesite.modules.bz.dao.BzStoreAttrDao;
import com.jeesite.modules.bz.entity.BzStore;
import com.jeesite.modules.bz.entity.BzStoreAttr;
import com.jeesite.modules.bz.service.BzStoreService;
import com.jeesite.modules.tk.utils.StoreUtils;
import com.xunlikun.amz.report.ReportUtils;

/**
 * 店铺Controller
 * @author xunliku
 * @version 2018-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/bz/bzStore")
public class BzStoreController extends BaseController {

	@Autowired
	private BzStoreService bzStoreService;
	
	@Autowired
	private BzStoreAttrDao bzStoreAttrDao;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BzStore get(String code, boolean isNewRecord) {
		return bzStoreService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("bz:bzStore:view")
	@RequestMapping(value = {"list", ""})
	public String list(BzStore bzStore, Model model) {
		model.addAttribute("bzStore", bzStore);
		return "modules/bz/bzStoreList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("bz:bzStore:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BzStore> listData(BzStore bzStore, HttpServletRequest request, HttpServletResponse response) {
		Page<BzStore> page = bzStoreService.findPage(new Page<BzStore>(request, response), bzStore); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("bz:bzStore:view")
	@RequestMapping(value = "form")
	public String form(BzStore bzStore, Model model) {
		model.addAttribute("bzStore", bzStore);
		return "modules/bz/bzStoreForm";
	}

	/**
	 * 保存店铺
	 */
	@RequiresPermissions("bz:bzStore:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BzStore bzStore) {
		bzStoreService.save(bzStore);
		return renderResult(Global.TRUE, "保存店铺成功！");
	}
	
	/**
	 * 停用店铺
	 */
	@RequiresPermissions("bz:bzStore:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(BzStore bzStore) {
		bzStore.setStatus(BzStore.STATUS_DISABLE);
		bzStoreService.updateStatus(bzStore);
		return renderResult(Global.TRUE, "停用店铺成功");
	}
	
	/**
	 * 启用店铺
	 */
	@RequiresPermissions("bz:bzStore:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(BzStore bzStore) {
		bzStore.setStatus(BzStore.STATUS_NORMAL);
		bzStoreService.updateStatus(bzStore);
		return renderResult(Global.TRUE, "启用店铺成功");
	}
	
	/**
	 * 删除店铺
	 */
	@RequiresPermissions("bz:bzStore:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BzStore bzStore) {
		bzStoreService.delete(bzStore);
		return renderResult(Global.TRUE, "删除店铺成功！");
	}
	
	@RequestMapping(value = "test")
	@ResponseBody
	public String test() {
		List<BzStore> stores = bzStoreService.findList(new BzStore());
		for(BzStore store : stores) {
			if(null == store.getBzStoreAttrList() || store.getBzStoreAttrList().size() == 0) {
				BzStoreAttr storeAttr = new BzStoreAttr();
				storeAttr.setStoreCode(store);
				List<BzStoreAttr> list = bzStoreAttrDao.findList(storeAttr);
				store.setBzStoreAttrList(list);
			}
			
		}
		
		//ReportUtils.requestReport("_GET_RESERVED_INVENTORY_DATA_",stores.get(0),null,null);
//		List<String> requestIds = new ArrayList<String>();
//		requestIds.add("68960017665");
//		ReportUtils.getReportRequsetList(requestIds,stores.get(0));
//		GetReportListResponse response = ReportUtils.getReportList(requestIds,stores.get(0));
//		System.out.println("================"+response.getGetReportListResult().getReportInfoList().size());
		List<String> reportIds = new ArrayList<String>();
		reportIds.add("9531897147017665");
		ReportUtils.getReportAsync(reportIds,StoreUtils.genAmzStore(stores.get(0)));
//		ReportUtils.getReport("9531897147017665",stores.get(0));
		
		return "";
	}
	
}