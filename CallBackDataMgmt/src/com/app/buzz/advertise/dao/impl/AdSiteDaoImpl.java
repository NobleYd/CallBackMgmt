/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.buzz.advertise.dao.AdSiteDao;
import com.app.buzz.advertise.entity.AdSite;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 网站
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("adSiteDao")
public class AdSiteDaoImpl extends BaseDaoImpl<AdSite, Long> implements AdSiteDao {
}
