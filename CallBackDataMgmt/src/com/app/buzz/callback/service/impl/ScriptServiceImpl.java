/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.callback.dao.ScriptDao;
import com.app.buzz.callback.entity.Script;
import com.app.buzz.callback.service.ScriptService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 脚本
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("scriptService")
public class ScriptServiceImpl extends BaseServiceImpl<Script, Long> implements ScriptService {

	@Resource
	private ScriptDao scriptDao;

	@Resource
	public void setBaseDao(ScriptDao scriptDao) {
		super.setBaseDao(scriptDao);
	}
	

}
