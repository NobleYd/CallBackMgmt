package com.app.buzz.callback.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.entity.BaseEntity;

@Entity
@Table(name = "app_ad_index")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "app_ad_index_seq")
public class AdIndex extends BaseEntity {
	private static final long serialVersionUID = 3071505389034625666L;

	// 游戏
	private String ad;

	// 日期 yyyyMMdd
	private Long dayNumber;

	// 索引值
	private Long indexNumber = 0L;

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Long getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Long dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Long getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(Long indexNumber) {
		this.indexNumber = indexNumber;
	}

}
