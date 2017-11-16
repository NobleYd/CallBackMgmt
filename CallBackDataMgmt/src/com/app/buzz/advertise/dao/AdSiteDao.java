/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.dao;

import java.util.Date;

import com.app.buzz.advertise.entity.AdSite;
import com.app.dao.BaseDao;

/***
 *
 * Dao - 网站
 *
 * @author APP TEAM
 * @version 1.0
 */
public interface AdSiteDao extends BaseDao<AdSite, Long>{

	Long getIpCount(String id);

	Long getClickCount(String id);

	Long getIpCount(String uniqueId, Date start, Date end);

	Long getClickCount(String uniqueId, Date start, Date end);
}
