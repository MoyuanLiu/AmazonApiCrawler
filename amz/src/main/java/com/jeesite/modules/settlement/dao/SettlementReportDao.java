/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.settlement.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.settlement.entity.SettlementReport;

/**
 * settlement_reportDAO接口
 * @author 荀立坤
 * @version 2018-06-06
 */
@MyBatisDao
public interface SettlementReportDao extends CrudDao<SettlementReport> {
	
}