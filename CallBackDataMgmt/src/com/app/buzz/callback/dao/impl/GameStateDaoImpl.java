/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.GameStateDao;
import com.app.buzz.callback.entity.GameState;
import com.app.buzz.callback.entity.GameStateBean;
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
		return this.entityManager.createQuery("select distinct(t.gameName) from GameState t order by t.gameName")
				.getResultList();
	}

	@Override
	public void deleteByGameName(String gameName) {
		this.entityManager.createQuery("delete from GameState t where t.gameName = :gameName")//
				.setParameter("gameName", gameName)//
				.setFlushMode(FlushModeType.COMMIT).executeUpdate();
	}

	@Override
	public List<GameStateBean> findGameStateList() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<GameStateBean> criteriaQuery = criteriaBuilder.createQuery(GameStateBean.class);
		Root<GameState> gameState = criteriaQuery.from(entityClass);
		criteriaQuery.multiselect(//
				gameState.get("gameName"), //
				gameState.get("title"), //
				criteriaBuilder.count(gameState.get("picture")), //
				gameState.<Date>get("recordDate")//
		);
		criteriaQuery.groupBy(gameState.get("gameName"), gameState.get("title"));
		criteriaQuery.orderBy(criteriaBuilder.asc(gameState.get("gameName")), //
				criteriaBuilder.asc(criteriaBuilder.count(gameState.get("picture"))), //
				criteriaBuilder.asc(gameState.get("title")), //
				criteriaBuilder.asc(gameState.get("recordDate"))//
		);

		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<GameStateBean> findGameStateList(String gameName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<GameStateBean> criteriaQuery = criteriaBuilder.createQuery(GameStateBean.class);
		Root<GameState> gameState = criteriaQuery.from(entityClass);
		criteriaQuery.multiselect(//
				gameState.get("gameName"), //
				gameState.get("title"), //
				criteriaBuilder.count(gameState.get("picture")), //
				gameState.<Date>get("recordDate")//
		);
		criteriaQuery.groupBy(gameState.get("gameName"), gameState.get("title"));
		criteriaQuery.orderBy(criteriaBuilder.asc(gameState.get("gameName")), //gameName
				criteriaBuilder.asc(criteriaBuilder.count(gameState.get("picture"))), //count
				criteriaBuilder.asc(gameState.get("title")), //
				criteriaBuilder.asc(gameState.get("recordDate"))//
		);

		Predicate restrictions = criteriaBuilder.conjunction();
		restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(gameState.get("gameName"), gameName));
		//restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(gameState.<String>get("gameName"), '%'+gameName+'%'));
		criteriaQuery.where(restrictions);

		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<String> findPictures(String gameName, String title) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<GameState> gameState = criteriaQuery.from(entityClass);
		criteriaQuery.select(gameState.<String>get("picture"));
		Predicate restrictions = criteriaBuilder.conjunction();
		restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(gameState.get("gameName"), gameName));
		restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(gameState.get("title"), title));
		criteriaQuery.where(restrictions);

		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

}
