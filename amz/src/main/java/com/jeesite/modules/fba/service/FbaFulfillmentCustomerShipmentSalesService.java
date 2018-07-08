/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.fba.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.fba.entity.FbaFulfillmentCustomerShipmentSales;
import com.jeesite.modules.fba.dao.FbaFulfillmentCustomerShipmentSalesDao;

/**
 * fba_fulfillment_customer_shipment_salesService
 * @author xlk
 * @version 2018-05-17
 */
@Service
@Transactional(readOnly=true)
public class FbaFulfillmentCustomerShipmentSalesService extends CrudService<FbaFulfillmentCustomerShipmentSalesDao, FbaFulfillmentCustomerShipmentSales> {
	
	/**
	 * 获取单条数据
	 * @param fbaFulfillmentCustomerShipmentSales
	 * @return
	 */
	@Override
	public FbaFulfillmentCustomerShipmentSales get(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		return super.get(fbaFulfillmentCustomerShipmentSales);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param fbaFulfillmentCustomerShipmentSales
	 * @return
	 */
	@Override
	public Page<FbaFulfillmentCustomerShipmentSales> findPage(Page<FbaFulfillmentCustomerShipmentSales> page, FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		return super.findPage(page, fbaFulfillmentCustomerShipmentSales);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param fbaFulfillmentCustomerShipmentSales
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		super.save(fbaFulfillmentCustomerShipmentSales);
	}
	
	/**
	 * 更新状态
	 * @param fbaFulfillmentCustomerShipmentSales
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		super.updateStatus(fbaFulfillmentCustomerShipmentSales);
	}
	
	/**
	 * 删除数据
	 * @param fbaFulfillmentCustomerShipmentSales
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FbaFulfillmentCustomerShipmentSales fbaFulfillmentCustomerShipmentSales) {
		super.delete(fbaFulfillmentCustomerShipmentSales);
	}
	
}