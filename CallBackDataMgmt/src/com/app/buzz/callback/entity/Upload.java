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

/***
 *
 * 实体 - 脚本
 *
 * @author APP TEAM
 * @version 1.0
 */
@Entity
@Table(name = "app_upload")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_upload_seq")
public class Upload extends BaseEntity {
	private static final long serialVersionUID = 4962509833812675666L;

	/** 标题 */
	private String name;

	/** 附近 */
	private String attachment;

	/** name get */
	public String getName() {
		return name;
	}

	/** name set */
	public void setName(String name) {
		this.name = name;
	}

	/** - get */
	public String getAttachment() {
		return attachment;
	}

	/** - set */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}
