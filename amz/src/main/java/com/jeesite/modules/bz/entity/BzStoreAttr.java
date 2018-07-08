/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.bz.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 店铺Entity
 * @author xunliku
 * @version 2018-05-09
 */
@Table(name="bz_store_attr", alias="a", columns={
		@Column(name="code", attrName="code", label="code", isPK=true),
		@Column(name="store_code", attrName="storeCode.code", label="store_code"),
		@Column(name="attrname", attrName="attrname", label="属性名"),
		@Column(name="attrvalue", attrName="attrvalue", label="属性值"),
		@Column(name="tag", attrName="tag", label="标签"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.create_date ASC"
)
public class BzStoreAttr extends DataEntity<BzStoreAttr> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// code
	private BzStore storeCode;		// store_code 父类
	private String attrname;		// 属性名
	private String attrvalue;		// 属性值
	private String tag;		// 标签
	
	public BzStoreAttr() {
		this(null);
	}


	public BzStoreAttr(BzStore storeCode){
		this.storeCode = storeCode;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="store_code不能为空")
	@Length(min=0, max=64, message="store_code长度不能超过 64 个字符")
	public BzStore getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(BzStore storeCode) {
		this.storeCode = storeCode;
	}
	
	@Length(min=0, max=32, message="属性名长度不能超过 32 个字符")
	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}
	
	@Length(min=0, max=255, message="属性值长度不能超过 255 个字符")
	public String getAttrvalue() {
		return attrvalue;
	}

	public void setAttrvalue(String attrvalue) {
		this.attrvalue = attrvalue;
	}
	
	@Length(min=0, max=64, message="标签长度不能超过 64 个字符")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}