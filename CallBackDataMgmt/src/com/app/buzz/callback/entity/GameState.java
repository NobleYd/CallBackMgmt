/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.entity.BaseEntity;

/***
 *
 * 实体 - 游戏状态
 *
 * @author APP TEAM
 * @version 1.0
 */
@Entity
@Table(name = "app_game_state")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_game_state_seq")
public class GameState extends BaseEntity {
	private static final long serialVersionUID = 3360805735128526774L;

	/** 游戏名称 */
	private String gameName;

	/** 账号唯一标识 */
	private String title;

	/** 图片 */
	private String picture;

	/** 添加时间 */
	private Date recordDate;

	/** gameName get */
	public String getGameName() {
		return gameName;
	}

	/** gameName set */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/** title get */
	public String getTitle() {
		return title;
	}

	/** title set */
	public void setTitle(String title) {
		this.title = title;
	}

	/** - get */
	public String getPicture() {
		return picture;
	}

	/** - set */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/** recordDate get */
	public Date getRecordDate() {
		return recordDate;
	}

	/** recordDate set */
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	@Override
	public String toString() {
		return "GameState [gameName=" + gameName + ", title=" + title + ", picture=" + picture + ", recordDate="
				+ recordDate + "]";
	}

}
