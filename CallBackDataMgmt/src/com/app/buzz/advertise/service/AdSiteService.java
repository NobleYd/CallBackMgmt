/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.service;

import java.util.Date;

import com.app.buzz.advertise.entity.AdSite;
import com.app.service.BaseService;

/***
 *
 * Service - 网站
 *
 * @author APP TEAM
 * @version 1.0
 */
public interface AdSiteService extends BaseService<AdSite, Long>{

	Long getIpCount(String id);

	Long getClickCount(String id);

	Long getIpCount(String uniqueId, Date start, Date end);

	Long getClickCount(String uniqueId, Date start, Date end);
	
}
