/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.fba.entity.FbaFulfillmentInventoryReceipts;

/**
 * fba_fulfillment_inventory_receiptsDAO接口
 * @author xlk
 * @version 2018-05-17
 */
@MyBatisDao(dataSourceName="ds2")
public interface FbaFulfillmentInventoryReceiptsDao extends CrudDao<FbaFulfillmentInventoryReceipts> {
	
}