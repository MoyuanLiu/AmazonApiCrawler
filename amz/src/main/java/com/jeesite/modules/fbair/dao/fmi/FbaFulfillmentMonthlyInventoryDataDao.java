/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fbair.dao.fmi;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.fbair.entity.fmi.FbaFulfillmentMonthlyInventoryData;

/**
 * fba_fulfillment_monthly_inventory_dataDAO接口
 * @author xunlikun
 * @version 2018-05-16
 */
@MyBatisDao(dataSourceName="ds2")
public interface FbaFulfillmentMonthlyInventoryDataDao extends CrudDao<FbaFulfillmentMonthlyInventoryData> {
	
}