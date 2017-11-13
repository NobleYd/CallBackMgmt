/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.callback.dao.UploadDao;
import com.app.buzz.callback.entity.Upload;
import com.app.buzz.callback.service.UploadService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 脚本
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("uploadService")
public class UploadServiceImpl extends BaseServiceImpl<Upload, Long> implements UploadService {

	@Resource
	private UploadDao uploadDao;

	@Resource
	public void setBaseDao(UploadDao uploadDao) {
		super.setBaseDao(uploadDao);
	}
	

}
