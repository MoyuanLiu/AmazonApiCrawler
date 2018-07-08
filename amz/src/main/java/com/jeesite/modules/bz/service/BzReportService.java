/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.bz.entity.BzReport;
import com.jeesite.modules.bz.dao.BzReportDao;

/**
 * bz_reportService
 * @author xlk
 * @version 2018-05-09
 */
@Service
@Transactional(readOnly=true)
public class BzReportService extends CrudService<BzReportDao, BzReport> {
	
	/**
	 * 获取单条数据
	 * @param bzReport
	 * @return
	 */
	@Override
	public BzReport get(BzReport bzReport) {
		return super.get(bzReport);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param bzReport
	 * @return
	 */
	@Override
	public Page<BzReport> findPage(Page<BzReport> page, BzReport bzReport) {
		return super.findPage(page, bzReport);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param bzReport
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BzReport bzReport) {
		super.save(bzReport);
	}
	
	/**
	 * 更新状态
	 * @param bzReport
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BzReport bzReport) {
		super.updateStatus(bzReport);
	}
	
	/**
	 * 删除数据
	 * @param bzReport
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BzReport bzReport) {
		super.delete(bzReport);
	}
	
}