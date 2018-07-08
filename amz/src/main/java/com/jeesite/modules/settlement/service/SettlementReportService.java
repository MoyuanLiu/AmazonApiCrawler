/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.settlement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.settlement.entity.SettlementReport;
import com.jeesite.modules.settlement.dao.SettlementReportDao;

/**
 * settlement_reportService
 * @author 荀立坤
 * @version 2018-06-06
 */
@Service
@Transactional(readOnly=true)
public class SettlementReportService extends CrudService<SettlementReportDao, SettlementReport> {
	
	/**
	 * 获取单条数据
	 * @param settlementReport
	 * @return
	 */
	@Override
	public SettlementReport get(SettlementReport settlementReport) {
		return super.get(settlementReport);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param settlementReport
	 * @return
	 */
	@Override
	public Page<SettlementReport> findPage(Page<SettlementReport> page, SettlementReport settlementReport) {
		return super.findPage(page, settlementReport);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param settlementReport
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SettlementReport settlementReport) {
		super.save(settlementReport);
	}
	
	/**
	 * 更新状态
	 * @param settlementReport
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SettlementReport settlementReport) {
		super.updateStatus(settlementReport);
	}
	
	/**
	 * 删除数据
	 * @param settlementReport
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SettlementReport settlementReport) {
		super.delete(settlementReport);
	}
	
}