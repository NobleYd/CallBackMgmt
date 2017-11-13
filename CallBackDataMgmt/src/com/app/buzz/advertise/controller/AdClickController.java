/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.advertise.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.Message;
import com.app.Pageable;
import com.app.buzz.advertise.entity.AdClick;
import com.app.buzz.advertise.service.AdClickService;
import com.app.controller.admin.BaseController;
import com.app.entity.BaseEntity;

/***
 *
 * 控制器 - 点击复制行为
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/ad_click")
public class AdClickController extends BaseController {

	private String viewPath = "/ad_click";

	@Resource
	private AdClickService adClickService;

	/**
	 * 统计 - 用户 - 点击复制 - 行为
	 */
	@ResponseBody
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	public String adClickStats(AdClick adClick, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (!isValid(adClick)) {
			return ERROR_VIEW;
		}
		adClick.setIp(request.getRemoteAddr());
		adClickService.save(adClick);
		return "success";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", adClickService.findPage(pageable));
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
	public String save(AdClick adClick, RedirectAttributes redirectAttributes) {
		if (!isValid(adClick)) {
			return ERROR_VIEW;
		}

		adClickService.save(adClick);

		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:list.jhtml";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message delete(Long[] ids) {
		try {
			adClickService.delete(ids);
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
		AdClick adClick = adClickService.find(id);
		model.addAttribute("adClick", adClick);
		return viewPath + "/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(AdClick adClick, RedirectAttributes redirectAttributes) {
		if (!isValid(adClick)) {
			return ERROR_VIEW;
		}
		AdClick persistant = adClickService.find(adClick.getId());
		if (persistant != null) {
			BeanUtils.copyProperties(adClick, persistant, new ArrayList<String>() {
				{
					add(BaseEntity.ID_PROPERTY_NAME);
					add(BaseEntity.CREATE_DATE_PROPERTY_NAME);
					add(BaseEntity.MODIFY_DATE_PROPERTY_NAME);
				}
			}.toArray(new String[] {}));
			adClickService.update(persistant);
			addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		} else {
			addFlashMessage(redirectAttributes, ERROR_MESSAGE);
		}
		return "redirect:list.jhtml";
	}

}
