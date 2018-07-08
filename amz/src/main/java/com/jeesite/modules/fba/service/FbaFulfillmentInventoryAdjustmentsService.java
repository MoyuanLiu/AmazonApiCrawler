/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryAdjustments;
import com.jeesite.modules.fba.dao.FbaFulfillmentInventoryAdjustmentsDao;

/**
 * fba_fulfillment_inventory_adjustmentsService
 * @author xlk
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly=true)
public class FbaFulfillmentInventoryAdjustmentsService extends CrudService<FbaFulfillmentInventoryAdjustmentsDao, FbaFulfillmentInventoryAdjustments> {
	
	/**
	 * 获取单条数据
	 * @param fbaFulfillmentInventoryAdjustments
	 * @return
	 */
	@Override
	public FbaFulfillmentInventoryAdjustments get(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		return super.get(fbaFulfillmentInventoryAdjustments);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaFulfillmentInventoryAdjustments
	 * @return
	 */
	@Override
	public Page<FbaFulfillmentInventoryAdjustments> findPage(Page<FbaFulfillmentInventoryAdjustments> page, FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		return super.findPage(page, fbaFulfillmentInventoryAdjustments);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaFulfillmentInventoryAdjustments
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		super.save(fbaFulfillmentInventoryAdjustments);
	}
	
	/**
	 * 更新状态
	 * @param fbaFulfillmentInventoryAdjustments
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		super.updateStatus(fbaFulfillmentInventoryAdjustments);
	}
	
	/**
	 * 删除数据
	 * @param fbaFulfillmentInventoryAdjustments
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaFulfillmentInventoryAdjustments fbaFulfillmentInventoryAdjustments) {
		super.delete(fbaFulfillmentInventoryAdjustments);
	}
	
}