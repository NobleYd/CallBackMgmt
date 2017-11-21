/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.service;

import java.util.List;

import com.app.buzz.callback.entity.GameState;
import com.app.service.BaseService;

/***
 *
 * Service - 游戏状态
 *
 * @author APP TEAM
 * @version 1.0
 */
public interface GameStateService extends BaseService<GameState, Long>{

	List<String> getGameList();

	void deleteByGameName(String gameName);
	
}
