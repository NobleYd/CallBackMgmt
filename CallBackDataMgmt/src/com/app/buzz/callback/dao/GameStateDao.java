/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao;

import java.util.List;

import com.app.buzz.callback.entity.GameState;
import com.app.buzz.callback.entity.GameStateBean;
import com.app.dao.BaseDao;

/***
 *
 * Dao - 游戏状态
 *
 * @author APP TEAM
 * @version 1.0
 */
public interface GameStateDao extends BaseDao<GameState, Long>{

	List<String> getGameList();

	void deleteByGameName(String gameName);


	List<GameStateBean> findGameStateList();

	List<GameStateBean> findGameStateList(String gameName);

	List<Object[]> findPictures(String gameName, String title);
}
