/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.Filter;
import com.app.Message;
import com.app.Pageable;
import com.app.buzz.advertise.entity.AdSite;
import com.app.buzz.advertise.service.AdSiteService;
import com.app.controller.admin.BaseController;
import com.app.entity.BaseEntity;

/***
 *
 * 控制器 - 网站
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/ad_site")
public class AdSiteController extends BaseController {

	private String viewPath = "/ad_site";

	@Resource
	private AdSiteService adSiteService;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", adSiteService.findPage(pageable));
		return viewPath + "/list";
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
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(AdSite adSite, RedirectAttributes redirectAttributes) {
		if (!isValid(adSite)) {
			return ERROR_VIEW;
		}
		// if (adSite.getUniqueId() == null) {
		// addFlashMessage(redirectAttributes, Message.error("网站唯一识别号是必填项哦！"));
		// return "redirect:list.jhtml";
		// }
		if (adSite.getName() == null) {
			addFlashMessage(redirectAttributes, Message.error("网站名称是必填项哦！"));
			return "redirect:list.jhtml";
		}
		adSiteService.save(adSite);

		AdSite persist = adSiteService.find(adSite.getId());
		Long uniqueIdPrefix = (1000 + persist.getId());
		String dayNumber = sdf.format(new Date());
		persist.setUniqueId(uniqueIdPrefix + "_" + dayNumber);
		adSiteService.update(persist);

		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:list.jhtml";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message delete(Long[] ids) {
		try {
			adSiteService.delete(ids);
		} catch (Exception e) {
			return ERROR_MESSAGE;
		}
		return SUCCESS_MESSAGE;
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Long id, ModelMap model) {
		AdSite adSite = adSiteService.find(id);
		model.addAttribute("adSite", adSite);
		return viewPath + "/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(AdSite adSite, RedirectAttributes redirectAttributes) {
		if (!isValid(adSite)) {
			return ERROR_VIEW;
		}
		// if (adSite.getUniqueId() == null) {
		// addFlashMessage(redirectAttributes, Message.error("网站唯一识别号是必填项哦！"));
		// return "redirect:list.jhtml";
		// }
		if (adSite.getName() == null) {
			addFlashMessage(redirectAttributes, Message.error("网站名称是必填项哦！"));
			return "redirect:list.jhtml";
		}
		AdSite persistant = adSiteService.find(adSite.getId());
		if (persistant != null) {
			BeanUtils.copyProperties(adSite, persistant, new ArrayList<String>() {
				{
					add(BaseEntity.ID_PROPERTY_NAME);
					add(BaseEntity.CREATE_DATE_PROPERTY_NAME);
					add(BaseEntity.MODIFY_DATE_PROPERTY_NAME);
					add("uniqueId");
				}
			}.toArray(new String[] {}));
			adSiteService.update(persistant);
			addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		} else {
			addFlashMessage(redirectAttributes, ERROR_MESSAGE);
		}
		return "redirect:list.jhtml";
	}

	@RequestMapping("/check_unique_id_unique")
	@ResponseBody
	public Boolean checkUniqueIdUnique(final String previousUniqueId, final String uniqueId) {
		// string类型请使用注释部分的if判断替换下面对应两个if判断
		// if (StringUtils.isEmpty(uniqueId)) {
		// return false;
		// }
		// if (StringUtils.equalsIgnoreCase(previousUniqueId, uniqueId)) {
		// return true;
		// }
		if (uniqueId == null) {
			return false;
		}
		if (uniqueId.equals(previousUniqueId)) {
			return true;
		}
		return adSiteService.find(Filter.eq("uniqueId", uniqueId, false)) == null;
	}

	/**
	 * stats
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String stats(Long id, ModelMap model) {
		AdSite adSite = adSiteService.find(id);

		Long ipCount = adSiteService.getIpCount(adSite.getUniqueId());
		Long clickCount = adSiteService.getClickCount(adSite.getUniqueId());
		adSite.setIpCount(ipCount);
		adSite.setClickCount(clickCount);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date end = calendar.getTime();
		Long todayIpCount = adSiteService.getIpCount(adSite.getUniqueId(), start, end);
		Long todayClickCount = adSiteService.getClickCount(adSite.getUniqueId(), start, end);
		adSite.setTodayIpCount(todayIpCount);
		adSite.setTodayClickCount(todayClickCount);
		
		adSiteService.update(adSite);
		return "redirect:list.jhtml";
	}

}
