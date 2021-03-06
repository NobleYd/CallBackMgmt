/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.buzz.callback.dao.GameStateDao;
import com.app.buzz.callback.entity.GameState;
import com.app.buzz.callback.entity.GameStateBean;
import com.app.buzz.callback.service.GameStateService;
import com.app.service.impl.BaseServiceImpl;

/***
 *
 * ServiceImpl - 游戏状态
 *
 * @author APP TEAM
 * @version 1.0
 */
@Service("gameStateService")
public class GameStateServiceImpl extends BaseServiceImpl<GameState, Long> implements GameStateService {

	@Resource
	private GameStateDao gameStateDao;

	@Resource
	public void setBaseDao(GameStateDao gameStateDao) {
		super.setBaseDao(gameStateDao);
	}

	@Override
	public List<String> getGameList() {
		return gameStateDao.getGameList();
	}

	@Override
	public void deleteByGameName(String gameName) {
		gameStateDao.deleteByGameName(gameName);
	}

	@Override
	public List<GameStateBean> findGameStateList() {
		return gameStateDao.findGameStateList();
	}

	@Override
	public List<GameStateBean> findGameStateList(String gameName) {
		return gameStateDao.findGameStateList(gameName);
	}

	@Override
	public List<Object[]> findPictures(String gameName, String title) {
		return gameStateDao.findPictures(gameName,title);
	}
}
