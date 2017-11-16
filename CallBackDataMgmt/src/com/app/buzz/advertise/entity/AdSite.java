/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 *
 * 实体 - 网站
 *
 * @author APP TEAM
 * @version 1.0
 */
@Entity
@Table(name = "app_ad_site")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_ad_site_seq")
public class AdSite extends BaseEntity {
	private static final long serialVersionUID = -5471959410135730514L;

	/** 网站唯一识别号 */
	private String uniqueId;
	
	/** 网站名称 */
	private String name;
	
	/** 网站主 */
	private String author;
	
	/** 联系电话 */
	private String mobile;
	
	/** 备注信息 */
	private String remark;
	
	/** 推广员 */
	private String salesMan;
	
	private Long ipCount = 0L;
	private Long clickCount = 0L;
	
	private Long todayIpCount = 0L;
	private Long todayClickCount = 0L;
	
	/** uniqueId get */
	public String getUniqueId(){
		return uniqueId;
	}
	
	/** uniqueId set */
	public void setUniqueId(String uniqueId){
		this.uniqueId = uniqueId;
	}
	
	
	@JsonProperty
	
	/** name get */
	public String getName(){
		return name;
	}
	
	/** name set */
	public void setName(String name){
		this.name = name;
	}
	
	
	
	/** author get */
	public String getAuthor(){
		return author;
	}
	
	/** author set */
	public void setAuthor(String author){
		this.author = author;
	}
	
	
	
	/** mobile get */
	public String getMobile(){
		return mobile;
	}
	
	/** mobile set */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	
	
	/** remark get */
	public String getRemark(){
		return remark;
	}
	
	/** remark set */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	
	
	/** salesMan get */
	public String getSalesMan(){
		return salesMan;
	}
	
	/** salesMan set */
	public void setSalesMan(String salesMan){
		this.salesMan = salesMan;
	}

	public Long getIpCount() {
		return ipCount;
	}

	public void setIpCount(Long ipCount) {
		this.ipCount = ipCount;
	}

	public Long getClickCount() {
		return clickCount;
	}

	public void setClickCount(Long clickCount) {
		this.clickCount = clickCount;
	}

	public Long getTodayIpCount() {
		return todayIpCount;
	}

	public void setTodayIpCount(Long todayIpCount) {
		this.todayIpCount = todayIpCount;
	}

	public Long getTodayClickCount() {
		return todayClickCount;
	}

	public void setTodayClickCount(Long todayClickCount) {
		this.todayClickCount = todayClickCount;
	}
	
	
	
}
