/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.estimated.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.estimated.entity.EstimatedFbaFees;
import com.jeesite.modules.estimated.dao.EstimatedFbaFeesDao;

/**
 * estimated_fba_feesService
 * @author xlk
 * @version 2018-05-16
 */
@Service
@Transactional(readOnly=true)
public class EstimatedFbaFeesService extends CrudService<EstimatedFbaFeesDao, EstimatedFbaFees> {
	
	/**
	 * 获取单条数据
	 * @param estimatedFbaFees
	 * @return
	 */
	@Override
	public EstimatedFbaFees get(EstimatedFbaFees estimatedFbaFees) {
		return super.get(estimatedFbaFees);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param estimatedFbaFees
	 * @return
	 */
	@Override
	public Page<EstimatedFbaFees> findPage(Page<EstimatedFbaFees> page, EstimatedFbaFees estimatedFbaFees) {
		return super.findPage(page, estimatedFbaFees);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param estimatedFbaFees
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(EstimatedFbaFees estimatedFbaFees) {
		super.save(estimatedFbaFees);
	}
	
	/**
	 * 更新状态
	 * @param estimatedFbaFees
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(EstimatedFbaFees estimatedFbaFees) {
		super.updateStatus(estimatedFbaFees);
	}
	
	/**
	 * 删除数据
	 * @param estimatedFbaFees
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(EstimatedFbaFees estimatedFbaFees) {
		super.delete(estimatedFbaFees);
	}
	
}