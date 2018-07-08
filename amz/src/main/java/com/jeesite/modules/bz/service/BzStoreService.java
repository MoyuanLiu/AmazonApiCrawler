/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.bz.entity.BzStore;
import com.jeesite.modules.bz.dao.BzStoreDao;
import com.jeesite.modules.bz.entity.BzStoreAttr;
import com.jeesite.modules.bz.dao.BzStoreAttrDao;

/**
 * 店铺Service
 * @author xunliku
 * @version 2018-05-09
 */
@Service
@Transactional(readOnly=true)
public class BzStoreService extends CrudService<BzStoreDao, BzStore> {
	
	@Autowired
	private BzStoreAttrDao bzStoreAttrDao;
	
	/**
	 * 获取单条数据
	 * @param bzStore
	 * @return
	 */
	@Override
	public BzStore get(BzStore bzStore) {
		BzStore entity = super.get(bzStore);
		if (entity != null){
			BzStoreAttr bzStoreAttr = new BzStoreAttr(entity);
			bzStoreAttr.setStatus(BzStoreAttr.STATUS_NORMAL);
			entity.setBzStoreAttrList(bzStoreAttrDao.findList(bzStoreAttr));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param bzStore
	 * @return
	 */
	@Override
	public Page<BzStore> findPage(Page<BzStore> page, BzStore bzStore) {
		return super.findPage(page, bzStore);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param bzStore
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BzStore bzStore) {
		super.save(bzStore);
		// 保存 BzStore子表
		for (BzStoreAttr bzStoreAttr : bzStore.getBzStoreAttrList()){
			if (!BzStoreAttr.STATUS_DELETE.equals(bzStoreAttr.getStatus())){
				bzStoreAttr.setStoreCode(bzStore);
				if (bzStoreAttr.getIsNewRecord()){
					bzStoreAttr.preInsert();
					bzStoreAttrDao.insert(bzStoreAttr);
				}else{
					bzStoreAttr.preUpdate();
					bzStoreAttrDao.update(bzStoreAttr);
				}
			}else{
				bzStoreAttrDao.delete(bzStoreAttr);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param bzStore
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BzStore bzStore) {
		super.updateStatus(bzStore);
	}
	
	/**
	 * 删除数据
	 * @param bzStore
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BzStore bzStore) {
		super.delete(bzStore);
		BzStoreAttr bzStoreAttr = new BzStoreAttr();
		bzStoreAttr.setStoreCode(bzStore);
		bzStoreAttrDao.delete(bzStoreAttr);
	}
	
}