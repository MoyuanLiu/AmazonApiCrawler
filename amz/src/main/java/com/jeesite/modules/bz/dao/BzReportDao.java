/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.bz.entity.BzReport;

/**
 * bz_reportDAO接口
 * @author xlk
 * @version 2018-05-09
 */
@MyBatisDao
public interface BzReportDao extends CrudDao<BzReport> {
	
}