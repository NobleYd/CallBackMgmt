/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.callback.dao.AdIndexDao;
import com.app.buzz.callback.entity.AdIndex;
import com.app.buzz.callback.service.AdIndexService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - adIndex
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("adIndexService")
public class AdIndexServiceImpl extends BaseServiceImpl<AdIndex, Long> implements AdIndexService {

	@Resource
	private AdIndexDao adIndexDao;

	@Resource
	public void setBaseDao(AdIndexDao adIndexDao) {
		super.setBaseDao(adIndexDao);
	}

}
