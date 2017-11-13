/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.Filter;
import com.app.Page;
import com.app.Pageable;
import com.app.buzz.callback.entity.AdIndex;
import com.app.buzz.callback.entity.CallBackData;
import com.app.buzz.callback.service.AdIndexService;
import com.app.buzz.callback.service.CallBackDataService;
import com.app.controller.admin.BaseController;
import com.app.entity.BaseEntity;

/***
 *
 * 控制器 - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/call_back_data")
public class CallBackDataController extends BaseController {

	private String viewPath = "/call_back_data";

	@Resource
	private CallBackDataService callBackDataService;

	@Resource
	private AdIndexService adIndexService;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String idfa, String ad, String adIndex, Date fromDate, Date toDate, String userName, String password, String state, String leves, String onlineTime, String loginCount, Pageable pageable, ModelMap model) {
		if (idfa != null && StringUtils.isNotEmpty(idfa)) {
			pageable.getFilters().add(Filter.eq("idfa", idfa, false));
			model.put("idfa", idfa);
		}
		if (ad != null && StringUtils.isNotEmpty(ad)) {
			pageable.getFilters().add(Filter.eq("ad", ad, false));
			model.put("ad", ad);
		}
		if (adIndex != null && StringUtils.isNotEmpty(adIndex)) {
			pageable.getFilters().add(Filter.eq("adIndex", adIndex, false));
			model.put("adIndex", adIndex);
		}
		if (fromDate != null) {
			pageable.getFilters().add(Filter.greaterThanOrEqualTo("createDate", fromDate, false));
			model.put("fromDate", fromDate);
		}
		if (toDate != null) {
			pageable.getFilters().add(Filter.lessThanOrEqualTo("createDate", toDate, false));
			model.put("toDate", toDate);
		}

		if (userName != null) {
			pageable.getFilters().add(Filter.eq("userName", userName, false));
			model.put("userName", userName);
		}
		if (password != null) {
			pageable.getFilters().add(Filter.eq("password", password, false));
			model.put("password", password);
		}
		if (state != null) {
			pageable.getFilters().add(Filter.eq("state", state, false));
			model.put("state", state);
		}
		if (leves != null) {
			pageable.getFilters().add(Filter.eq("leves", leves, false));
			model.put("leves", leves);
		}
		if (onlineTime != null) {
			pageable.getFilters().add(Filter.eq("onlineTime", onlineTime, false));
			model.put("onlineTime", onlineTime);
		}
		if (loginCount != null) {
			pageable.getFilters().add(Filter.eq("loginCount", loginCount, false));
			model.put("loginCount", loginCount);
		}

		model.addAttribute("page", callBackDataService.findPage(pageable));
		return viewPath + "/list";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public @ResponseBody Page<CallBackData> list2(String idfa, String ad, String adIndex, Date fromDate, Date toDate, String userName, String password, String state, String leves, String onlineTime, String loginCount, Pageable pageable, ModelMap model) {
		pageable.setUnlimitPageSize();
		if (idfa != null && StringUtils.isNotEmpty(idfa)) {
			pageable.getFilters().add(Filter.eq("idfa", idfa, false));
			model.put("idfa", idfa);
		}
		if (ad != null && StringUtils.isNotEmpty(ad)) {
			pageable.getFilters().add(Filter.eq("ad", ad, false));
			model.put("ad", ad);
		}
		if (adIndex != null && StringUtils.isNotEmpty(adIndex)) {
			pageable.getFilters().add(Filter.eq("adIndex", adIndex, false));
			model.put("adIndex", adIndex);
		}
		if (fromDate != null) {
			pageable.getFilters().add(Filter.greaterThanOrEqualTo("createDate", fromDate, false));
			model.put("fromDate", fromDate);
		}
		if (toDate != null) {
			pageable.getFilters().add(Filter.lessThanOrEqualTo("createDate", toDate, false));
			model.put("toDate", toDate);
		}

		if (userName != null) {
			pageable.getFilters().add(Filter.eq("userName", userName, false));
			model.put("userName", userName);
		}
		if (password != null) {
			pageable.getFilters().add(Filter.eq("password", password, false));
			model.put("password", password);
		}
		if (state != null) {
			pageable.getFilters().add(Filter.eq("state", state, false));
			model.put("state", state);
		}
		if (leves != null) {
			pageable.getFilters().add(Filter.eq("leves", leves, false));
			model.put("leves", leves);
		}
		if (onlineTime != null) {
			pageable.getFilters().add(Filter.eq("onlineTime", onlineTime, false));
			model.put("onlineTime", onlineTime);
		}
		if (loginCount != null) {
			pageable.getFilters().add(Filter.eq("loginCount", loginCount, false));
			model.put("loginCount", loginCount);
		}
		Page<CallBackData> page = callBackDataService.findPage(pageable);
		page.getPageable().getFilters().clear();
		return page;
	}

	/**
	 * 获取设备
	 */
	@RequestMapping(value = "/get_new_acc", method = RequestMethod.GET)
	public @ResponseBody Object getNewAcc(final String useGame) {
		if (useGame == null) {
			return "error useGame == null";
		}
		String[] usedGames = useGame.split(",");
		List<Filter> filters = new ArrayList<Filter>();
		for (String usedGame0 : usedGames) {
			filters.add(Filter.notLike("usedGames", "%" + usedGame0 + "%"));
		}
		filters.add(Filter.ne("state", "被封", false));
		List<CallBackData> list = callBackDataService.findList(1, filters, null);
		if (list == null || list.size() < 1) {
			return "error";
		}
		CallBackData callBackData = list.get(0);
		callBackData.setUsedGames(callBackData.getUsedGames() + "," + useGame);
		callBackDataService.update(callBackData);
		return callBackData;
	}

	/**
	 * 获取指定游戏分类的设备
	 */
	@RequestMapping(value = "/get_new_acc_for_ad", method = RequestMethod.GET)
	public @ResponseBody Object getNewAccForAd(final String ad, final String useGame) {
		if (useGame == null) {
			return "error useGame == null";
		}
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(Filter.notLike("usedGames", "%" + useGame + "%"));
		filters.add(Filter.eq("ad", ad, false));
		List<CallBackData> list = callBackDataService.findList(1, filters, null);
		if (list == null || list.size() < 1) {
			return "error";
		}
		CallBackData callBackData = list.get(0);
		callBackData.setUsedGames(callBackData.getUsedGames() + "," + useGame);
		callBackDataService.update(callBackData);
		return callBackData;
	}

	/**
	 * 删除指定id数据的usedGames字段
	 */
	@RequestMapping(value = "/clear_use_game", method = RequestMethod.GET)
	public @ResponseBody Object clearUseGame(Long id) {
		if (id == null) {
			return "error { id = null }";
		}
		CallBackData persist = callBackDataService.find(id);
		if (persist == null) {
			return "error { id = " + id + " not exist }";
		}
		persist.setUsedGames("");
		callBackDataService.update(persist);
		return "success";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		return viewPath + "/add";
	}

	/**
	 * 保存
	 * 
	 * 新增数据访问链接格式如下： http://host-ip/call_back_data/save.jhtml?idfa=IDFA&clientIp=CLIENTIP&ad=AD&userName=USERNAME&password=PASSWORD 大写部分请替换为实际值。
	 * 
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(CallBackData callBackData, RedirectAttributes redirectAttributes) {
		if (!isValid(callBackData)) {
			return "error";
		}

		// 做一个初始化
		callBackData.setUsedGames("");

		// 首先根据ad、日期查询adIndex的最大值
		Long dayNumber = Long.parseLong(sdf.format(new Date()));
		AdIndex adIndex = adIndexService.find(Filter.eq("ad", callBackData.getAd(), false), Filter.eq("dayNumber", dayNumber, false));

		if (adIndex == null) {
			adIndex = new AdIndex();
			adIndex.setAd(callBackData.getAd());
			adIndex.setDayNumber(dayNumber);
			adIndex.setIndexNumber(1L);
			adIndexService.save(adIndex);
		} else {
			// 自加1
			adIndex.setIndexNumber(adIndex.getIndexNumber() + 1);
			// 更新到数据库
			adIndexService.update(adIndex);
		}

		callBackData.setAdIndex(adIndex.getIndexNumber());
		callBackDataService.save(callBackData);

		return "success";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody String delete(Long[] ids) {
		try {
			callBackDataService.delete(ids);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Long id, ModelMap model) {
		CallBackData callBackData = callBackDataService.find(id);
		model.addAttribute("callBackData", callBackData);
		return viewPath + "/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update")
	public @ResponseBody String update(CallBackData callBackData, RedirectAttributes redirectAttributes) {
		if (!isValid(callBackData)) {
			return "error";
		}
		CallBackData persistant = callBackDataService.find(callBackData.getId());
		if (persistant != null) {
			BeanUtils.copyProperties(callBackData, persistant, new ArrayList<String>() {
				{
					add(BaseEntity.ID_PROPERTY_NAME);
					// add(BaseEntity.CREATE_DATE_PROPERTY_NAME);
					add(BaseEntity.MODIFY_DATE_PROPERTY_NAME);
				}
			}.toArray(new String[] {}));
			callBackDataService.update(persistant);
			addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		} else {
			addFlashMessage(redirectAttributes, ERROR_MESSAGE);
		}
		return "success";
	}

	/**
	 * 更新2
	 */
	@RequestMapping(value = "/update2")
	public @ResponseBody String update2(CallBackData callBackData, RedirectAttributes redirectAttributes) {
		if (!isValid(callBackData)) {
			return "error";
		}
		CallBackData persistant = callBackDataService.find(callBackData.getId());
		if (persistant != null) {
			if (StringUtils.isNotBlank(callBackData.getAd())) {
				persistant.setAd(callBackData.getAd());
			}
			if (callBackData.getAdIndex() != null) {
				persistant.setAdIndex(callBackData.getAdIndex());
			}
			if (StringUtils.isNotBlank(callBackData.getClientIp())) {
				persistant.setClientIp(callBackData.getClientIp());
			}
			if (callBackData.getCreateDate() != null) {
				persistant.setCreateDate(callBackData.getCreateDate());
			}
			if (StringUtils.isNotBlank(callBackData.getIdfa())) {
				persistant.setIdfa(callBackData.getIdfa());
			}
			if (StringUtils.isNotBlank(callBackData.getUserName())) {
				persistant.setUserName(callBackData.getUserName());
			}
			if (StringUtils.isNotBlank(callBackData.getPassword())) {
				persistant.setPassword(callBackData.getPassword());
			}
			if (StringUtils.isNotBlank(callBackData.getRemark())) {
				persistant.setRemark(callBackData.getRemark());
			}
			if (StringUtils.isNotBlank(callBackData.getState())) {
				persistant.setState(callBackData.getState());
			}
			if (StringUtils.isNotBlank(callBackData.getLeves())) {
				persistant.setLeves(callBackData.getLeves());
			}
			if (StringUtils.isNotBlank(callBackData.getOnlineTime())) {
				persistant.setOnlineTime(callBackData.getOnlineTime());
			}
			if (StringUtils.isNotBlank(callBackData.getLoginCount())) {
				persistant.setLoginCount(callBackData.getLoginCount());
			}

			callBackDataService.update(persistant);
		} else {
			return "error";
		}
		return "success";
	}

}
