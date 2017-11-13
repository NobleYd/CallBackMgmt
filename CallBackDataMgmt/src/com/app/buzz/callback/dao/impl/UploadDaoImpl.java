/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.UploadDao;
import com.app.buzz.callback.entity.Upload;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 脚本
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("uploadDao")
public class UploadDaoImpl extends BaseDaoImpl<Upload, Long> implements UploadDao {
}
