/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.Filter;
import com.app.Message;
import com.app.Pageable;
import com.app.FileInfo.FileType;
import com.app.buzz.callback.entity.AdIndex;
import com.app.buzz.callback.entity.CallBackData;
import com.app.buzz.callback.entity.Upload;
import com.app.buzz.callback.service.AdIndexService;
import com.app.buzz.callback.service.CallBackDataService;
import com.app.buzz.callback.service.UploadService;
import com.app.controller.admin.BaseController;
import com.app.service.FileService;

/***
 *
 * 批量上传接口
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {

	private String viewPath = "/upload";

	@Resource(name = "fileService")
	private FileService fileService;

	@Resource
	private UploadService uploadService;

	@Resource
	private CallBackDataService callBackDataService;

	@Resource
	private AdIndexService adIndexService;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", uploadService.findPage(pageable));
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
	public String save(Upload upload, MultipartFile attachmentFile, RedirectAttributes redirectAttributes) {
		if (!isValid(upload)) {
			return ERROR_VIEW;
		}
		if (attachmentFile != null && !attachmentFile.isEmpty()) {
			if (!fileService.isValid(FileType.file, attachmentFile)) {
				addFlashMessage(redirectAttributes, Message.error("不合法的文件扩展名！"));
				return "redirect:list.jhtml";
			} else {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(attachmentFile.getInputStream()));
					String nextLine = null;
					while ((nextLine = br.readLine()) != null) {
						if (nextLine.trim().isEmpty()) {
							continue;
						}
						String[] splits = nextLine.split(",");
						CallBackData callBackData = new CallBackData();

						// 做一个初始化
						callBackData.setUsedGames("");

						if (splits.length >= 1) {
							callBackData.setAd(splits[0].trim());
						}
						if (splits.length >= 2) {
							callBackData.setUserName(splits[1].trim());
						}
						if (splits.length >= 3) {
							callBackData.setPassword(splits[2].trim());
						}
						if (splits.length >= 4) {
							callBackData.setRemark(splits[3].trim());
						}

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

						callBackData.setUploadName(upload.getName());
						callBackDataService.save(callBackData);
					}
					br.close();
					addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
				} catch (IllegalStateException e) {
					e.printStackTrace();
					addFlashMessage(redirectAttributes, ERROR_MESSAGE);
				} catch (IOException e) {
					e.printStackTrace();
					addFlashMessage(redirectAttributes, ERROR_MESSAGE);
				}

				String url = fileService.upload(FileType.file, attachmentFile, false);
				if (url == null) {
					addFlashMessage(redirectAttributes, ERROR_MESSAGE);
					return "redirect:list.jhtml";
				} else {
					upload.setAttachment(url);
				}
			}
		}
		uploadService.save(upload);

		return "redirect:list.jhtml";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message delete(Long[] ids) {
		final List<Upload> uploadList = uploadService.findList(ids);
		if (uploadList == null && uploadList.size() == 0)
			return SUCCESS_MESSAGE;
		try {
			List<CallBackData> list = callBackDataService.findList(null, new ArrayList<Filter>() {
				{
					add(Filter.eq("uploadName", uploadList.get(0).getName(), false));
				}
			}, null);
			if (list != null && list.size() > 0) {
				for (CallBackData callBackData : list) {
					callBackDataService.delete(callBackData.getId());
				}
			}
			uploadService.delete(ids);

		} catch (Exception e) {
			return ERROR_MESSAGE;
		}
		return SUCCESS_MESSAGE;
	}

}
