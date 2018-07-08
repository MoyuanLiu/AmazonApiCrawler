/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.entity.BaseEntity;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 店铺Entity
 * @author xunliku
 * @version 2018-05-09
 */
@Table(name="bz_store", alias="a", columns={
		@Column(name="code", attrName="code", label="店铺编码", isPK=true),
		@Column(name="store_type", attrName="storeType", label="平台名称"),
		@Column(name="store_name", attrName="storeName", label="店铺名称", queryType=QueryType.LIKE),
		@Column(name="owner", attrName="owner", label="负责人编码"),
		@Column(name="owner_name", attrName="ownerName", label="负责人姓名", queryType=QueryType.LIKE),
		@Column(name="office_code", attrName="officeCode", label="部门编码"),
		@Column(name="office_name", attrName="officeName", label="部门名称"),
		@Column(name="company_code", attrName="companyCode", label="公司编码"),
		@Column(name="company_name", attrName="companyName", label="公司名称"),
		@Column(includeEntity=BaseEntity.class),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class BzStore extends DataEntity<BzStore> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 店铺编码
	private String storeType;		// 平台名称
	private String storeName;		// 店铺名称
	private String owner;		// 负责人编码
	private String ownerName;		// 负责人姓名
	private String officeCode;		// 部门编码
	private String officeName;		// 部门名称
	private String companyCode;		// 公司编码
	private String companyName;		// 公司名称
	private List<BzStoreAttr> bzStoreAttrList = ListUtils.newArrayList();		// 子表列表
	
	private Map<String,BzStoreAttr> attrMap = new HashMap<String,BzStoreAttr>();
	
	public BzStore() {
		this(null);
	}

	public BzStore(String id){
		super(id);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=32, message="平台名称长度不能超过 32 个字符")
	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	
	@Length(min=0, max=255, message="店铺名称长度不能超过 255 个字符")
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Length(min=0, max=64, message="负责人编码长度不能超过 64 个字符")
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Length(min=0, max=100, message="负责人姓名长度不能超过 100 个字符")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Length(min=0, max=64, message="部门编码长度不能超过 64 个字符")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	@Length(min=0, max=100, message="部门名称长度不能超过 100 个字符")
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	@Length(min=0, max=64, message="公司编码长度不能超过 64 个字符")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Length(min=0, max=100, message="公司名称长度不能超过 100 个字符")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public List<BzStoreAttr> getBzStoreAttrList() {
		return bzStoreAttrList;
	}

	public void setBzStoreAttrList(List<BzStoreAttr> bzStoreAttrList) {
		this.bzStoreAttrList = bzStoreAttrList;
		for(BzStoreAttr attr : bzStoreAttrList) {
			attrMap.put(attr.getAttrname(), attr);
		}
	}

	public Map<String, BzStoreAttr> getAttrMap() {
		return attrMap;
	}

	public void setAttrMap(Map<String, BzStoreAttr> attrMap) {
		this.attrMap = attrMap;
	}
	
}