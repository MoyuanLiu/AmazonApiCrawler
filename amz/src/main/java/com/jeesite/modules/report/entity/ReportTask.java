/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.report.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * report_taskEntity
 * @author xunlikun
 * @version 2018-05-15
 */
@Table(name="report_task", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="store_code", attrName="storeCode", label="店铺编码"),
		@Column(name="task_name", attrName="taskName", label="任务名称", queryType=QueryType.LIKE),
		@Column(name="report_type", attrName="reportType", label="报告类型"),
		@Column(name="start", attrName="start", label="开始日期"),
		@Column(name="end", attrName="end", label="结束日期"),
		@Column(name="report_options", attrName="reportOptions", label="报告参数"),
		@Column(name="marketplace_id_list", attrName="marketplaceIdList", label="市场列表"),
		@Column(name="report_request_id", attrName="reportRequestId", label="请求ID"),
		@Column(name="scheduled", attrName="scheduled", label="是否定时"),
		@Column(name="submitted", attrName="submitted", label="提交日期"),
		@Column(name="report_processing_status", attrName="reportProcessingStatus", label="报告处理状态"),
		@Column(name="complete", attrName="complete", label="完成日期"),
		@Column(name="report_id", attrName="reportId", label="报告ID"),
		@Column(name="avaliable", attrName="avaliable", label="生效时间"),
		@Column(name="acknowledged", attrName="acknowledged", label="是否确认"),
		@Column(name="filename", attrName="filename", label="文件名称"),
		@Column(name="imported", attrName="imported", label="是否导入"),
		@Column(name="packaged", attrName="packaged", label="是否归档"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ReportTask extends DataEntity<ReportTask> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private String storeCode;		// 店铺编码
	private String taskName;		// 任务名称
	private String reportType;		// 报告类型
	private String start;		// 开始日期
	private String end;		// 结束日期
	private String reportOptions;		// 报告参数
	private String marketplaceIdList;		// 市场列表
	private String reportRequestId;		// 请求ID
	private String scheduled;		// 是否定时
	private String submitted;		// 提交日期
	private String reportProcessingStatus;		// 报告处理状态
	private String complete;		// 完成日期
	private String reportId;		// 报告ID
	private String avaliable;		// 生效时间
	private String acknowledged;		// 是否确认
	private String filename;		// 文件名称
	private String imported;		// 是否导入
	private String packaged;		// 是否归档
	
	public ReportTask() {
		this(null);
	}

	public ReportTask(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="店铺编码不能为空")
	@Length(min=0, max=64, message="店铺编码长度不能超过 64 个字符")
	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	
	@NotBlank(message="任务名称不能为空")
	@Length(min=0, max=255, message="任务名称长度不能超过 255 个字符")
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@NotBlank(message="报告类型不能为空")
	@Length(min=0, max=100, message="报告类型长度不能超过 100 个字符")
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	@NotBlank(message="开始日期不能为空")
	@Length(min=0, max=64, message="开始日期长度不能超过 64 个字符")
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
	
	@NotBlank(message="结束日期不能为空")
	@Length(min=0, max=64, message="结束日期长度不能超过 64 个字符")
	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
	@NotBlank(message="报告参数不能为空")
	@Length(min=0, max=255, message="报告参数长度不能超过 255 个字符")
	public String getReportOptions() {
		return reportOptions;
	}

	public void setReportOptions(String reportOptions) {
		this.reportOptions = reportOptions;
	}
	
	@NotBlank(message="市场列表不能为空")
	@Length(min=0, max=255, message="市场列表长度不能超过 255 个字符")
	public String getMarketplaceIdList() {
		return marketplaceIdList;
	}

	public void setMarketplaceIdList(String marketplaceIdList) {
		this.marketplaceIdList = marketplaceIdList;
	}
	
	@NotBlank(message="请求ID不能为空")
	@Length(min=0, max=32, message="请求ID长度不能超过 32 个字符")
	public String getReportRequestId() {
		return reportRequestId;
	}

	public void setReportRequestId(String reportRequestId) {
		this.reportRequestId = reportRequestId;
	}
	
	@NotBlank(message="是否定时不能为空")
	@Length(min=0, max=1, message="是否定时长度不能超过 1 个字符")
	public String getScheduled() {
		return scheduled;
	}

	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}
	
	@NotBlank(message="提交日期不能为空")
	@Length(min=0, max=64, message="提交日期长度不能超过 64 个字符")
	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
	
	@NotBlank(message="报告处理状态不能为空")
	@Length(min=0, max=32, message="报告处理状态长度不能超过 32 个字符")
	public String getReportProcessingStatus() {
		return reportProcessingStatus;
	}

	public void setReportProcessingStatus(String reportProcessingStatus) {
		this.reportProcessingStatus = reportProcessingStatus;
	}
	
	@NotBlank(message="完成日期不能为空")
	@Length(min=0, max=64, message="完成日期长度不能超过 64 个字符")
	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	@NotBlank(message="报告ID不能为空")
	@Length(min=0, max=32, message="报告ID长度不能超过 32 个字符")
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	@NotBlank(message="生效时间不能为空")
	@Length(min=0, max=64, message="生效时间长度不能超过 64 个字符")
	public String getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(String avaliable) {
		this.avaliable = avaliable;
	}
	
	@NotBlank(message="是否确认不能为空")
	@Length(min=0, max=1, message="是否确认长度不能超过 1 个字符")
	public String getAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(String acknowledged) {
		this.acknowledged = acknowledged;
	}
	
	@NotBlank(message="文件名称不能为空")
	@Length(min=0, max=255, message="文件名称长度不能超过 255 个字符")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@NotBlank(message="是否导入不能为空")
	@Length(min=0, max=1, message="是否导入长度不能超过 1 个字符")
	public String getImported() {
		return imported;
	}

	public void setImported(String imported) {
		this.imported = imported;
	}
	
	@NotBlank(message="是否归档不能为空")
	@Length(min=0, max=1, message="是否归档长度不能超过 1 个字符")
	public String getPackaged() {
		return packaged;
	}

	public void setPackaged(String packaged) {
		this.packaged = packaged;
	}
	
}