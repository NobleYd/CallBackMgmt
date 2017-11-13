/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao;

import java.util.List;

import com.app.buzz.callback.entity.CallBackData;
import com.app.dao.BaseDao;

/***
 *
 * Dao - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
public interface CallBackDataDao extends BaseDao<CallBackData, Long>{

	List<Object> findAdFirstList();

	List<Object> findAllUploadNames();

	void deleteByAd(String ad);

	void updateRemark(String ad, List<String> userNameList, String remark);

}
