/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.bz.entity.BzStoreAttr;

/**
 * 店铺DAO接口
 * @author xunliku
 * @version 2018-05-09
 */
@MyBatisDao
public interface BzStoreAttrDao extends CrudDao<BzStoreAttr> {
	
}