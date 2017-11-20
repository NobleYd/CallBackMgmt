/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.GameStateDao;
import com.app.buzz.callback.entity.GameState;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 游戏状态
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("gameStateDao")
public class GameStateDaoImpl extends BaseDaoImpl<GameState, Long> implements GameStateDao {

	@Override
	public List<String> getGameList() {
		return this.entityManager.createNamedQuery("select distinct(t.gameName) from GameState t").getResultList();
	}
}
