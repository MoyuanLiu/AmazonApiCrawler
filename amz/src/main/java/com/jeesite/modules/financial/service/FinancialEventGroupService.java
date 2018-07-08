/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.financial.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.financial.entity.FinancialEventGroup;
import com.jeesite.modules.financial.dao.FinancialEventGroupDao;

/**
 * financial_event_groupService
 * @author xlk
 * @version 2018-05-21
 */
@Service
@Transactional(readOnly=true)
public class FinancialEventGroupService extends CrudService<FinancialEventGroupDao, FinancialEventGroup> {
	
	/**
	 * 获取单条数据
	 * @param financialEventGroup
	 * @return
	 */
	@Override
	public FinancialEventGroup get(FinancialEventGroup financialEventGroup) {
		return super.get(financialEventGroup);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param financialEventGroup
	 * @return
	 */
	@Override
	public Page<FinancialEventGroup> findPage(Page<FinancialEventGroup> page, FinancialEventGroup financialEventGroup) {
		return super.findPage(page, financialEventGroup);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param financialEventGroup
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FinancialEventGroup financialEventGroup) {
		super.save(financialEventGroup);
	}
	
	/**
	 * 更新状态
	 * @param financialEventGroup
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FinancialEventGroup financialEventGroup) {
		super.updateStatus(financialEventGroup);
	}
	
	/**
	 * 删除数据
	 * @param financialEventGroup
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FinancialEventGroup financialEventGroup) {
		super.delete(financialEventGroup);
	}
	
}