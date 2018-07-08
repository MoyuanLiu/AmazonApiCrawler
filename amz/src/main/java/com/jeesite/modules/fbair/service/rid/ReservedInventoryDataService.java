/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.service.rid;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fbair.entity.rid.ReservedInventoryData;
import com.jeesite.modules.fbair.dao.rid.ReservedInventoryDataDao;

/**
 * reserved_inventory_dataService
 * @author xunlikun
 * @version 2018-05-16
 */
@Service
@Transactional(readOnly=true)
public class ReservedInventoryDataService extends CrudService<ReservedInventoryDataDao, ReservedInventoryData> {
	
	/**
	 * 获取单条数据
	 * @param reservedInventoryData
	 * @return
	 */
	@Override
	public ReservedInventoryData get(ReservedInventoryData reservedInventoryData) {
		return super.get(reservedInventoryData);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param reservedInventoryData
	 * @return
	 */
	@Override
	public Page<ReservedInventoryData> findPage(Page<ReservedInventoryData> page, ReservedInventoryData reservedInventoryData) {
		return super.findPage(page, reservedInventoryData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param reservedInventoryData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ReservedInventoryData reservedInventoryData) {
		super.save(reservedInventoryData);
	}
	
	/**
	 * 更新状态
	 * @param reservedInventoryData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ReservedInventoryData reservedInventoryData) {
		super.updateStatus(reservedInventoryData);
	}
	
	/**
	 * 删除数据
	 * @param reservedInventoryData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ReservedInventoryData reservedInventoryData) {
		super.delete(reservedInventoryData);
	}
	
}