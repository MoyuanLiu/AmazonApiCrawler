/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fba.entity.FbaMyiAllInventory;
import com.jeesite.modules.fba.dao.FbaMyiAllInventoryDao;

/**
 * fba_myi_all_inventoryService
 * @author xlk
 * @version 2018-05-16
 */
@Service
@Transactional(readOnly=true)
public class FbaMyiAllInventoryService extends CrudService<FbaMyiAllInventoryDao, FbaMyiAllInventory> {
	
	/**
	 * 获取单条数据
	 * @param fbaMyiAllInventory
	 * @return
	 */
	@Override
	public FbaMyiAllInventory get(FbaMyiAllInventory fbaMyiAllInventory) {
		return super.get(fbaMyiAllInventory);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaMyiAllInventory
	 * @return
	 */
	@Override
	public Page<FbaMyiAllInventory> findPage(Page<FbaMyiAllInventory> page, FbaMyiAllInventory fbaMyiAllInventory) {
		return super.findPage(page, fbaMyiAllInventory);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaMyiAllInventory
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaMyiAllInventory fbaMyiAllInventory) {
		super.save(fbaMyiAllInventory);
	}
	
	/**
	 * 更新状态
	 * @param fbaMyiAllInventory
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaMyiAllInventory fbaMyiAllInventory) {
		super.updateStatus(fbaMyiAllInventory);
	}
	
	/**
	 * 删除数据
	 * @param fbaMyiAllInventory
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaMyiAllInventory fbaMyiAllInventory) {
		super.delete(fbaMyiAllInventory);
	}
	
}