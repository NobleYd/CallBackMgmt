/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.app.buzz.callback.entity.CallBackData;
import com.app.buzz.callback.entity.RemarkUpdate;
import com.app.buzz.callback.service.CallBackDataService;
import com.app.buzz.callback.service.RemarkUpdateService;
import com.app.controller.admin.BaseController;
import com.app.entity.BaseEntity;

/***
 *
 * 控制器 - 批量修改备注
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/remark_update")
public class RemarkUpdateController extends BaseController {

	private String viewPath = "/remark_update";

	@Resource
	private RemarkUpdateService remarkUpdateService;

	@Resource
	private CallBackDataService callBackDataService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		pageable.setUnlimitPageSize();
		model.addAttribute("page", remarkUpdateService.findPage(pageable));
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
	public String save(RemarkUpdate remarkUpdate, RedirectAttributes redirectAttributes) {
		if (!isValid(remarkUpdate)) {
			return ERROR_VIEW;
		}

		remarkUpdateService.save(remarkUpdate);

		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:list.jhtml";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message delete(Long[] ids) {
		try {
			remarkUpdateService.delete(ids);
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
		RemarkUpdate remarkUpdate = remarkUpdateService.find(id);
		model.addAttribute("remarkUpdate", remarkUpdate);
		return viewPath + "/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(RemarkUpdate remarkUpdate, RedirectAttributes redirectAttributes) {
		if (!isValid(remarkUpdate)) {
			return ERROR_VIEW;
		}
		RemarkUpdate persistant = remarkUpdateService.find(remarkUpdate.getId());
		if (persistant != null) {
			BeanUtils.copyProperties(remarkUpdate, persistant, new ArrayList<String>() {
				{
					add(BaseEntity.ID_PROPERTY_NAME);
					add(BaseEntity.CREATE_DATE_PROPERTY_NAME);
					add(BaseEntity.MODIFY_DATE_PROPERTY_NAME);
				}
			}.toArray(new String[] {}));
			remarkUpdateService.update(persistant);
			addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		} else {
			addFlashMessage(redirectAttributes, ERROR_MESSAGE);
		}
		return "redirect:list.jhtml";
	}

	/**
	 * 批量修改remark
	 */
	@RequestMapping(value = "/executeUpdate", method = RequestMethod.GET)
	public String executeUpdate(Long id) {
		final RemarkUpdate remarkUpdate = remarkUpdateService.find(id);

		if (remarkUpdate.getAd() == null || remarkUpdate.getAd().isEmpty())
			return "ad can not be null.";
		if (remarkUpdate.getUserNames() == null)
			return "userNames can not be null.";
		String[] userNames = remarkUpdate.getUserNames().split(",");
		if (userNames.length == 0)
			return "userNames can not be null.";
		if (remarkUpdate.getRemark() == null || remarkUpdate.getRemark().isEmpty())
			return "remark can not be null.";
		final List<String> userNameList = new ArrayList<String>();
		for (String userName : userNames) {
			if (userName.contains("-")) {
				String[] splits = userName.split("-");
				if (splits.length == 2) {
					int s = Integer.parseInt(splits[0].trim());
					int e = Integer.parseInt(splits[1].trim());
					for (int i = s; i <= e; i++) {
						userNameList.add(i + "");
					}
				}
			} else {
				userNameList.add(userName);
			}
		}
		// List<CallBackData> callBackDatas = callBackDataService.findList(null, new ArrayList<Filter>() {
		// {
		// add(Filter.eq("ad", remarkUpdate.getAd(), false));
		// add(Filter.in("userName", userNameList));
		// }
		// }, null);
		// for (CallBackData callBackData : callBackDatas) {
		// callBackData.setRemark(remarkUpdate.getRemark());
		// callBackDataService.update(callBackData);
		// }

		String userNamesStr = userNameList.toString().replace("[", "(").replace("]", ")");

		// callBackDataService.updateRemark(remarkUpdate.getAd(),userNamesStr,remarkUpdate.getRemark());
		callBackDataService.updateRemark(remarkUpdate.getAd(), userNameList, remarkUpdate.getRemark());
		return "redirect:list.jhtml";
	}
}
