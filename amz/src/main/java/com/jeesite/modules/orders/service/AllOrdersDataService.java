/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.orders.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.orders.entity.AllOrdersData;
import com.jeesite.modules.orders.dao.AllOrdersDataDao;

/**
 * all_orders_dataService
 * @author xlk
 * @version 2018-05-16
 */
@Service
@Transactional(readOnly=true)
public class AllOrdersDataService extends CrudService<AllOrdersDataDao, AllOrdersData> {
	
	/**
	 * 获取单条数据
	 * @param allOrdersData
	 * @return
	 */
	@Override
	public AllOrdersData get(AllOrdersData allOrdersData) {
		return super.get(allOrdersData);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param allOrdersData
	 * @return
	 */
	@Override
	public Page<AllOrdersData> findPage(Page<AllOrdersData> page, AllOrdersData allOrdersData) {
		return super.findPage(page, allOrdersData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param allOrdersData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(AllOrdersData allOrdersData) {
		super.save(allOrdersData);
	}
	
	/**
	 * 更新状态
	 * @param allOrdersData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(AllOrdersData allOrdersData) {
		super.updateStatus(allOrdersData);
	}
	
	/**
	 * 删除数据
	 * @param allOrdersData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(AllOrdersData allOrdersData) {
		super.delete(allOrdersData);
	}
	
}