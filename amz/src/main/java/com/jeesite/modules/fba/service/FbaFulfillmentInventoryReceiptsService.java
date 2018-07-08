/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryReceipts;
import com.jeesite.modules.fba.dao.FbaFulfillmentInventoryReceiptsDao;

/**
 * fba_fulfillment_inventory_receiptsService
 * @author xlk
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly=true)
public class FbaFulfillmentInventoryReceiptsService extends CrudService<FbaFulfillmentInventoryReceiptsDao, FbaFulfillmentInventoryReceipts> {
	
	/**
	 * 获取单条数据
	 * @param fbaFulfillmentInventoryReceipts
	 * @return
	 */
	@Override
	public FbaFulfillmentInventoryReceipts get(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		return super.get(fbaFulfillmentInventoryReceipts);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaFulfillmentInventoryReceipts
	 * @return
	 */
	@Override
	public Page<FbaFulfillmentInventoryReceipts> findPage(Page<FbaFulfillmentInventoryReceipts> page, FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		return super.findPage(page, fbaFulfillmentInventoryReceipts);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaFulfillmentInventoryReceipts
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		super.save(fbaFulfillmentInventoryReceipts);
	}
	
	/**
	 * 更新状态
	 * @param fbaFulfillmentInventoryReceipts
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		super.updateStatus(fbaFulfillmentInventoryReceipts);
	}
	
	/**
	 * 删除数据
	 * @param fbaFulfillmentInventoryReceipts
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaFulfillmentInventoryReceipts fbaFulfillmentInventoryReceipts) {
		super.delete(fbaFulfillmentInventoryReceipts);
	}
	
}