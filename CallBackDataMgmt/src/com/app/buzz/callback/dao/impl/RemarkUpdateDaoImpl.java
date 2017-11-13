/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.RemarkUpdateDao;
import com.app.buzz.callback.entity.RemarkUpdate;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 批量修改备注
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("remarkUpdateDao")
public class RemarkUpdateDaoImpl extends BaseDaoImpl<RemarkUpdate, Long> implements RemarkUpdateDao {
}
