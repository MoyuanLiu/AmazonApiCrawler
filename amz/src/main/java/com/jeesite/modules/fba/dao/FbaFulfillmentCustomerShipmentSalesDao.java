/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerShipmentSales;

/**
 * fba_fulfillment_customer_shipment_salesDAO接口
 * @author xlk
 * @version 2018-05-17
 */
@MyBatisDao(dataSourceName="ds2")
public interface FbaFulfillmentCustomerShipmentSalesDao extends CrudDao<FbaFulfillmentCustomerShipmentSales> {
	
}