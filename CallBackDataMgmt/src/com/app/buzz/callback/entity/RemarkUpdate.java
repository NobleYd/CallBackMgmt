/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import com.app.entity.TreeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

import com.app.entity.BaseEntity;

/***
 *
 * 实体 - 批量修改备注
 *
 * @author APP TEAM
 * @version 1.0
 */
@Entity
@Table(name = "app_remark_update")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_remark_update_seq")
public class RemarkUpdate extends BaseEntity {
	/** 游戏 */
	private String ad;
	
	/** 备注 */
	private String remark;
	
	/** userNames */
	private String userNames;
	
	/** ad get */
	public String getAd(){
		return ad;
	}
	
	/** ad set */
	public void setAd(String ad){
		this.ad = ad;
	}
	
	
	
	/** remark get */
	public String getRemark(){
		return remark;
	}
	
	/** remark set */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	
	
	/** userNames get */
	public String getUserNames(){
		return userNames;
	}
	
	/** userNames set */
	public void setUserNames(String userNames){
		this.userNames = userNames;
	}
	
}
