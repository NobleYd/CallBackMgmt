/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.advertise.dao.AdClickDao;
import com.app.buzz.advertise.entity.AdClick;
import com.app.buzz.advertise.service.AdClickService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 点击复制行为
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("adClickService")
public class AdClickServiceImpl extends BaseServiceImpl<AdClick, Long> implements AdClickService {

	@Resource
	private AdClickDao adClickDao;

	@Resource
	public void setBaseDao(AdClickDao adClickDao) {
		super.setBaseDao(adClickDao);
	}
	

}
