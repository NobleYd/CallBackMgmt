/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.app.buzz.callback.dao.CallBackDataDao;
import com.app.buzz.callback.entity.CallBackData;
import com.app.dao.impl.BaseDaoImpl;

/***
 *
 * DaoImpl - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
@Repository("callBackDataDao")
public class CallBackDataDaoImpl extends BaseDaoImpl<CallBackData, Long> implements CallBackDataDao {

	@Override
	public List<Object> findAdFirstList() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<CallBackData> root = criteriaQuery.from(CallBackData.class);
		criteriaQuery.groupBy(root.get("ad"));
		criteriaQuery.multiselect(root, criteriaBuilder.count(root));
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("createDate")));
		TypedQuery<Object> query = entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT);
		return query.getResultList();
	}

	@Override
	public List<Object> findAllUploadNames() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<CallBackData> root = criteriaQuery.from(CallBackData.class);
		criteriaQuery.distinct(true);
		criteriaQuery.multiselect(root.get("uploadName"));
		TypedQuery<Object> query = entityManager.createQuery(criteriaQuery).setFlushMode(FlushModeType.COMMIT);
		return query.getResultList();
	}

	@Override
	public void deleteByAd(String ad) {
		String jpql = "delete from CallBackData c where c.ad = :ad";
		entityManager.createQuery(jpql).setParameter("ad", ad).setFlushMode(FlushModeType.COMMIT).executeUpdate();
	}

	@Override
	public void updateRemark(String ad, List<String> userNameList, String remark) {
		String jpql = "update CallBackData c set c.remark = :remark, c.modifyDate = :modifyDate where c.ad = :ad and c.userName in :userNameList";
		entityManager.createQuery(jpql).setParameter("ad", ad)//
				.setParameter("userNameList", userNameList)//
				.setParameter("remark", remark)//
				.setParameter("modifyDate", new Date())//
				.setFlushMode(FlushModeType.COMMIT).executeUpdate();
	}
}
