/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.report.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.report.entity.ReportTask;

/**
 * report_taskDAO接口
 * @author xunlikun
 * @version 2018-05-15
 */
@MyBatisDao
public interface ReportTaskDao extends CrudDao<ReportTask> {
	
}