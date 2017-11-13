/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.buzz.advertise.dao.AdClickDao;
import com.app.buzz.advertise.entity.AdClick;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 点击复制行为
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("adClickDao")
public class AdClickDaoImpl extends BaseDaoImpl<AdClick, Long> implements AdClickDao {
}
