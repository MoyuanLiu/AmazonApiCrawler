/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fba.entity.FbaInventoryAgedData;
import com.jeesite.modules.fba.dao.FbaInventoryAgedDataDao;

/**
 * fba_inventory_aged_dataService
 * @author xlk
 * @version 2018-05-16
 */
@Service
@Transactional(readOnly=true)
public class FbaInventoryAgedDataService extends CrudService<FbaInventoryAgedDataDao, FbaInventoryAgedData> {
	
	/**
	 * 获取单条数据
	 * @param fbaInventoryAgedData
	 * @return
	 */
	@Override
	public FbaInventoryAgedData get(FbaInventoryAgedData fbaInventoryAgedData) {
		return super.get(fbaInventoryAgedData);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaInventoryAgedData
	 * @return
	 */
	@Override
	public Page<FbaInventoryAgedData> findPage(Page<FbaInventoryAgedData> page, FbaInventoryAgedData fbaInventoryAgedData) {
		return super.findPage(page, fbaInventoryAgedData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaInventoryAgedData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaInventoryAgedData fbaInventoryAgedData) {
		super.save(fbaInventoryAgedData);
	}
	
	/**
	 * 更新状态
	 * @param fbaInventoryAgedData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaInventoryAgedData fbaInventoryAgedData) {
		super.updateStatus(fbaInventoryAgedData);
	}
	
	/**
	 * 删除数据
	 * @param fbaInventoryAgedData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaInventoryAgedData fbaInventoryAgedData) {
		super.delete(fbaInventoryAgedData);
	}
	
}