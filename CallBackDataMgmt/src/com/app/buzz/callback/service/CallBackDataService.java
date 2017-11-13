/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service;

import java.util.List;

import com.app.buzz.callback.entity.CallBackData;
import com.app.service.BaseService;

/***
 *
 * Service - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
public interface CallBackDataService extends BaseService<CallBackData, Long> {

	List<Object> findAdFirstList();

	List<Object> findAllUploadNames();

	void deleteByAd(String ad);

	void updateRemark(String ad, List<String> userNameList, String remark);

}
