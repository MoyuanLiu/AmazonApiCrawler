/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.report.web;

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
import com.jeesite.modules.report.entity.ReportTask;
import com.jeesite.modules.report.service.ReportTaskService;

/**
 * report_taskController
 * @author xunlikun
 * @version 2018-05-15
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportTask")
public class ReportTaskController extends BaseController {

	@Autowired
	private ReportTaskService reportTaskService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ReportTask get(String code, boolean isNewRecord) {
		return reportTaskService.get(code, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("report:reportTask:view")
	@RequestMapping(value = {"list", ""})
	public String list(ReportTask reportTask, Model model) {
		model.addAttribute("reportTask", reportTask);
		return "modules/report/reportTaskList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("report:reportTask:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ReportTask> listData(ReportTask reportTask, HttpServletRequest request, HttpServletResponse response) {
		Page<ReportTask> page = reportTaskService.findPage(new Page<ReportTask>(request, response), reportTask); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("report:reportTask:view")
	@RequestMapping(value = "form")
	public String form(ReportTask reportTask, Model model) {
		model.addAttribute("reportTask", reportTask);
		return "modules/report/reportTaskForm";
	}

	/**
	 * 保存report_task
	 */
	@RequiresPermissions("report:reportTask:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ReportTask reportTask) {
		reportTaskService.save(reportTask);
		return renderResult(Global.TRUE, "保存report_task成功！");
	}
	
	/**
	 * 删除report_task
	 */
	@RequiresPermissions("report:reportTask:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ReportTask reportTask) {
		reportTaskService.delete(reportTask);
		return renderResult(Global.TRUE, "删除report_task成功！");
	}
	
}