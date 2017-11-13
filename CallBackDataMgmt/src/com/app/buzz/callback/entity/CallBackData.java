/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 *
 * 实体 - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
@Entity
@Table(name = "app_call_back_data")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_call_back_data_seq")
public class CallBackData extends BaseEntity {

	private static final long serialVersionUID = 5187731045977211615L;

	/** 设备名称 */
	private String idfa;

	/** 点击IP */
	private String clientIp;

	/** 游戏 */
	private String ad;

	/** 账号 */
	private String userName;

	/** 密码 */
	private String password;

	/** 备注 */
	private String remark;

	/** 索引 */
	private Long adIndex;

	private String usedGames;

	/** 状态 */
	private String state;

	/** 等级 */
	private String leves;

	/** 在线时长 */
	private String onlineTime;

	/** 登录次数 */
	private String loginCount;

	/** 上传次数 */
	private String uploadName;
	
	
	/** idfa get */
	@JsonProperty
	public String getIdfa() {
		return idfa;
	}

	/** idfa set */
	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	/** clientIp get */
	@JsonProperty
	public String getClientIp() {
		return clientIp;
	}

	/** clientIp set */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	/** ad get */
	@JsonProperty
	public String getAd() {
		return ad;
	}

	/** ad set */
	public void setAd(String ad) {
		this.ad = ad;
	}

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@JsonProperty
	public Long getAdIndex() {
		return adIndex;
	}

	public void setAdIndex(Long adIndex) {
		this.adIndex = adIndex;
	}

	@JsonProperty
	public String getUsedGames() {
		return usedGames;
	}

	public void setUsedGames(String usedGames) {
		this.usedGames = usedGames != null ? usedGames : "";
	}

	@JsonProperty
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty
	public String getLeves() {
		return leves;
	}

	public void setLeves(String leves) {
		this.leves = leves;
	}

	@JsonProperty
	public String getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}

	@JsonProperty
	public String getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	public String getUploadName() {
		return uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	
}
