/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.financial.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.financial.entity.FinancialEventGroup;

/**
 * financial_event_groupDAO接口
 * @author xlk
 * @version 2018-05-21
 */
@MyBatisDao
public interface FinancialEventGroupDao extends CrudDao<FinancialEventGroup> {
	
}