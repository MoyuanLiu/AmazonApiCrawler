/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.report.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.report.entity.ReportTask;
import com.jeesite.modules.report.dao.ReportTaskDao;

/**
 * report_taskService
 * @author xunlikun
 * @version 2018-05-15
 */
@Service
@Transactional(readOnly=true)
public class ReportTaskService extends CrudService<ReportTaskDao, ReportTask> {
	
	/**
	 * 获取单条数据
	 * @param reportTask
	 * @return
	 */
	@Override
	public ReportTask get(ReportTask reportTask) {
		return super.get(reportTask);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param reportTask
	 * @return
	 */
	@Override
	public Page<ReportTask> findPage(Page<ReportTask> page, ReportTask reportTask) {
		return super.findPage(page, reportTask);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param reportTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ReportTask reportTask) {
		super.save(reportTask);
	}
	
	/**
	 * 更新状态
	 * @param reportTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ReportTask reportTask) {
		super.updateStatus(reportTask);
	}
	
	/**
	 * 删除数据
	 * @param reportTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ReportTask reportTask) {
		super.delete(reportTask);
	}
	
}