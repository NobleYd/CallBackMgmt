package com.app.buzz.callback.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameStateBean {

	/** 游戏名称 */
	private String gameName;

	/** 账号唯一标识 */
	private String title;

	/** 图片 */
	private List<Object[]> pictures = new ArrayList<Object[]>();
	private Long count = 0L;

	/** 添加时间 */
	private Date recordDate;

	public GameStateBean() {
		super();
	}

	public GameStateBean(String gameName, String title, Long count, Date recordDate) {
		super();
		this.gameName = gameName;
		this.title = title;
		this.count = count;
		this.recordDate = recordDate;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Object[]> getPictures() {
		return pictures;
	}

	public void setPictures(List<Object[]> pictures) {
		this.pictures = pictures;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
