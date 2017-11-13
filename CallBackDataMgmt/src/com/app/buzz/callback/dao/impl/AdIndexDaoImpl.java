/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.AdIndexDao;
import com.app.buzz.callback.entity.AdIndex;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - AdIndex
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("adIndexDao")
public class AdIndexDaoImpl extends BaseDaoImpl<AdIndex, Long> implements AdIndexDao {
}
