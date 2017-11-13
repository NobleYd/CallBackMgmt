/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.FileInfo.FileType;
import com.app.Message;
import com.app.Pageable;
import com.app.buzz.callback.entity.Script;
import com.app.buzz.callback.service.ScriptService;
import com.app.controller.admin.BaseController;
import com.app.entity.BaseEntity;
import com.app.service.FileService;

/***
 *
 * 控制器 - 脚本
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/script")
public class ScriptController extends BaseController {

	private String viewPath = "/script";

	@Resource(name = "fileService")
	private FileService fileService;

	@Resource
	private ScriptService scriptService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", scriptService.findPage(pageable));
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
	public String save(Script script, MultipartFile attachmentFile, RedirectAttributes redirectAttributes) {
		if (!isValid(script)) {
			return ERROR_VIEW;
		}
		if (attachmentFile != null && !attachmentFile.isEmpty()) {
			if (!fileService.isValid(FileType.file, attachmentFile)) {
				addFlashMessage(redirectAttributes, Message.error("不合法的文件扩展名！"));
				return "redirect:list.jhtml";
			} else {
				String url = fileService.upload(FileType.file, attachmentFile, false);
				if (url == null) {
					addFlashMessage(redirectAttributes, ERROR_MESSAGE);
					return "redirect:list.jhtml";
				} else {
					script.setAttachment(url);
				}
			}
		}
		if (script.getName() == null) {
			addFlashMessage(redirectAttributes, Message.error("标题是必填项哦！"));
			return "redirect:list.jhtml";
		}
		if (script.getAttachment() == null) {
			addFlashMessage(redirectAttributes, Message.error("脚本是必填项哦！"));
			return "redirect:list.jhtml";
		}

		scriptService.save(script);

		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:list.jhtml";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message delete(Long[] ids) {
		try {
			scriptService.delete(ids);
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
		Script script = scriptService.find(id);
		model.addAttribute("script", script);
		return viewPath + "/edit";
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Script script, MultipartFile attachmentFile, RedirectAttributes redirectAttributes) {
		if (!isValid(script)) {
			return ERROR_VIEW;
		}
		ArrayList<String> ignoreFileTypeAttributeNames = new ArrayList<String>();
		if (attachmentFile != null && !attachmentFile.isEmpty()) {
			if (!fileService.isValid(FileType.file, attachmentFile)) {
				addFlashMessage(redirectAttributes, Message.error("不合法的文件扩展名！"));
				return "redirect:list.jhtml";
			} else {
				String url = fileService.upload(FileType.file, attachmentFile, false);
				if (url == null) {
					addFlashMessage(redirectAttributes, ERROR_MESSAGE);
					return "redirect:list.jhtml";
				} else {
					script.setAttachment(url);
				}
			}
		} else {
			ignoreFileTypeAttributeNames.add("attachment");
		}
		if (script.getName() == null) {
			addFlashMessage(redirectAttributes, Message.error("标题是必填项哦！"));
			return "redirect:list.jhtml";
		}
		Script persistant = scriptService.find(script.getId());
		if (persistant != null) {
			BeanUtils.copyProperties(script, persistant, new ArrayList<String>(ignoreFileTypeAttributeNames) {
				{
					add(BaseEntity.ID_PROPERTY_NAME);
					add(BaseEntity.CREATE_DATE_PROPERTY_NAME);
					add(BaseEntity.MODIFY_DATE_PROPERTY_NAME);
				}
			}.toArray(new String[] {}));
			scriptService.update(persistant);
			addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		} else {
			addFlashMessage(redirectAttributes, ERROR_MESSAGE);
		}
		return "redirect:list.jhtml";
	}

}
