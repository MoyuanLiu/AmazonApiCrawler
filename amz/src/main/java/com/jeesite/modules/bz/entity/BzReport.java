/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * bz_reportEntity
 * @author xlk
 * @version 2018-05-09
 */
@Table(name="bz_report", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="report_name", attrName="reportName", label="report_name", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class BzReport extends DataEntity<BzReport> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String reportName;		// report_name
	
	public BzReport() {
		this(null);
	}

	public BzReport(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=255, message="report_name长度不能超过 255 个字符")
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
}