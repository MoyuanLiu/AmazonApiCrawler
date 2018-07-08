/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.service.fmi;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fbair.entity.fmi.FbaFulfillmentMonthlyInventoryData;
import com.jeesite.modules.fbair.dao.fmi.FbaFulfillmentMonthlyInventoryDataDao;

/**
 * fba_fulfillment_monthly_inventory_dataService
 * @author xunlikun
 * @version 2018-05-16
 */
@Service
@Transactional(readOnly=true)
public class FbaFulfillmentMonthlyInventoryDataService extends CrudService<FbaFulfillmentMonthlyInventoryDataDao, FbaFulfillmentMonthlyInventoryData> {
	
	/**
	 * 获取单条数据
	 * @param fbaFulfillmentMonthlyInventoryData
	 * @return
	 */
	@Override
	public FbaFulfillmentMonthlyInventoryData get(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		return super.get(fbaFulfillmentMonthlyInventoryData);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaFulfillmentMonthlyInventoryData
	 * @return
	 */
	@Override
	public Page<FbaFulfillmentMonthlyInventoryData> findPage(Page<FbaFulfillmentMonthlyInventoryData> page, FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		return super.findPage(page, fbaFulfillmentMonthlyInventoryData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaFulfillmentMonthlyInventoryData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		super.save(fbaFulfillmentMonthlyInventoryData);
	}
	
	/**
	 * 更新状态
	 * @param fbaFulfillmentMonthlyInventoryData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		super.updateStatus(fbaFulfillmentMonthlyInventoryData);
	}
	
	/**
	 * 删除数据
	 * @param fbaFulfillmentMonthlyInventoryData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaFulfillmentMonthlyInventoryData fbaFulfillmentMonthlyInventoryData) {
		super.delete(fbaFulfillmentMonthlyInventoryData);
	}
	
}