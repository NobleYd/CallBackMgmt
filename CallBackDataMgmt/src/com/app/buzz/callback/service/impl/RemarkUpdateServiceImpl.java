/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.callback.dao.RemarkUpdateDao;
import com.app.buzz.callback.entity.RemarkUpdate;
import com.app.buzz.callback.service.RemarkUpdateService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 批量修改备注
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("remarkUpdateService")
public class RemarkUpdateServiceImpl extends BaseServiceImpl<RemarkUpdate, Long> implements RemarkUpdateService {

	@Resource
	private RemarkUpdateDao remarkUpdateDao;

	@Resource
	public void setBaseDao(RemarkUpdateDao remarkUpdateDao) {
		super.setBaseDao(remarkUpdateDao);
	}
	

}
