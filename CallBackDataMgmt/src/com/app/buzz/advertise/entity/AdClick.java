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

/***
 *
 * 实体 - 点击复制行为
 *
 * @author APP TEAM
 * @version 1.0
 */
@Entity
@Table(name = "app_ad_click")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_ad_click_seq")
public class AdClick extends BaseEntity {
	private static final long serialVersionUID = -4805691545924031801L;

	/** 用户IP */
	private String ip;

	/** 网站识别号 */
	private String siteUniqueId;

	/** ip get */
	public String getIp() {
		return ip;
	}

	/** ip set */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/** siteUniqueId get */
	public String getSiteUniqueId() {
		return siteUniqueId;
	}

	/** siteUniqueId set */
	public void setSiteUniqueId(String siteUniqueId) {
		this.siteUniqueId = siteUniqueId;
	}

}
