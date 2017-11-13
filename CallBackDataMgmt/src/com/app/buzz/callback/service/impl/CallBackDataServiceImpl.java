/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.callback.dao.CallBackDataDao;
import com.app.buzz.callback.entity.CallBackData;
import com.app.buzz.callback.service.CallBackDataService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("callBackDataService")
public class CallBackDataServiceImpl extends BaseServiceImpl<CallBackData, Long> implements CallBackDataService {

	@Resource
	private CallBackDataDao callBackDataDao;

	@Resource
	public void setBaseDao(CallBackDataDao callBackDataDao) {
		super.setBaseDao(callBackDataDao);
	}

	@Override
	public List<Object> findAdFirstList() {
		return callBackDataDao.findAdFirstList();
	}

	@Override
	public List<Object> findAllUploadNames() {
		return callBackDataDao.findAllUploadNames();
	}

	@Override
	public void deleteByAd(String ad) {
		callBackDataDao.deleteByAd(ad);
	}

	@Override
	public void updateRemark(String ad, List<String> userNameList, String remark) {
		callBackDataDao.updateRemark(ad,userNameList,remark);
	}

}
