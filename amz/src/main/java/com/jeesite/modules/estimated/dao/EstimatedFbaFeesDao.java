/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.estimated.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.estimated.entity.EstimatedFbaFees;

/**
 * estimated_fba_feesDAO接口
 * @author xlk
 * @version 2018-05-16
 */
@MyBatisDao(dataSourceName="ds2")
public interface EstimatedFbaFeesDao extends CrudDao<EstimatedFbaFees> {
	
}