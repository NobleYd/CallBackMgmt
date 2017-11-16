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

	@Override
	public Long getIpCount(String id) {
		return (Long) this.entityManager.createQuery("select count(distinct t.ip) from AdClick t where t.siteUniqueId = :id").setParameter("id",id).getSingleResult();
	}

	@Override
	public Long getClickCount(String id) {
		return (Long) this.entityManager.createQuery("select count(*) from AdClick t where t.siteUniqueId = :id").setParameter("id",id).getSingleResult();
	}
}
