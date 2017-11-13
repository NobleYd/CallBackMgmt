/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.ScriptDao;
import com.app.buzz.callback.entity.Script;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 脚本
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("scriptDao")
public class ScriptDaoImpl extends BaseDaoImpl<Script, Long> implements ScriptDao {
}
