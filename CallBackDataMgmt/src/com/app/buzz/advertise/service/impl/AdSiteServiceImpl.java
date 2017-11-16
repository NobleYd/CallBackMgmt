/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.advertise.dao.AdSiteDao;
import com.app.buzz.advertise.entity.AdSite;
import com.app.buzz.advertise.service.AdSiteService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 网站
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("adSiteService")
public class AdSiteServiceImpl extends BaseServiceImpl<AdSite, Long> implements AdSiteService {

	@Resource
	private AdSiteDao adSiteDao;

	@Resource
	public void setBaseDao(AdSiteDao adSiteDao) {
		super.setBaseDao(adSiteDao);
	}

	@Override
	public Long getIpCount(String id) {
		return adSiteDao.getIpCount(id);
	}

	@Override
	public Long getClickCount(String id) {
		return adSiteDao.getClickCount(id);
	}

	@Override
	public Long getIpCount(String uniqueId, Date start, Date end) {
		return adSiteDao.getIpCount(uniqueId,start,end);
	}

	@Override
	public Long getClickCount(String uniqueId, Date start, Date end) {
		return adSiteDao.getClickCount(uniqueId,start,end);
	}
	

}
