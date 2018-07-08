/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.orders.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.orders.entity.AllOrdersData;

/**
 * all_orders_dataDAO接口
 * @author xlk
 * @version 2018-05-16
 */
@MyBatisDao(dataSourceName="ds2")
public interface AllOrdersDataDao extends CrudDao<AllOrdersData> {
	
}