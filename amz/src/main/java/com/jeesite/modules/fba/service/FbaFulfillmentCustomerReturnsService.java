/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerReturns;
import com.jeesite.modules.fba.dao.FbaFulfillmentCustomerReturnsDao;

/**
 * fba_fulfillment_customer_returnsService
 * @author xlk
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly=true)
public class FbaFulfillmentCustomerReturnsService extends CrudService<FbaFulfillmentCustomerReturnsDao, FbaFulfillmentCustomerReturns> {
	
	/**
	 * 获取单条数据
	 * @param fbaFulfillmentCustomerReturns
	 * @return
	 */
	@Override
	public FbaFulfillmentCustomerReturns get(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		return super.get(fbaFulfillmentCustomerReturns);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaFulfillmentCustomerReturns
	 * @return
	 */
	@Override
	public Page<FbaFulfillmentCustomerReturns> findPage(Page<FbaFulfillmentCustomerReturns> page, FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		return super.findPage(page, fbaFulfillmentCustomerReturns);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaFulfillmentCustomerReturns
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		super.save(fbaFulfillmentCustomerReturns);
	}
	
	/**
	 * 更新状态
	 * @param fbaFulfillmentCustomerReturns
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		super.updateStatus(fbaFulfillmentCustomerReturns);
	}
	
	/**
	 * 删除数据
	 * @param fbaFulfillmentCustomerReturns
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaFulfillmentCustomerReturns fbaFulfillmentCustomerReturns) {
		super.delete(fbaFulfillmentCustomerReturns);
	}
	
}