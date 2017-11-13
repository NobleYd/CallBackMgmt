/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.Filter;
import com.app.buzz.callback.entity.CallBackData;
import com.app.buzz.callback.service.CallBackDataService;
import com.app.controller.admin.BaseController;
import com.app.plugin.StoragePlugin;
import com.app.service.PluginService;

/***
 *
 * 控制器 - 游戏
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/ad")
public class AdController extends BaseController {

	private String viewPath = "/ad";

	@Resource
	private CallBackDataService callBackDataService;

	@Resource(name = "pluginService")
	private PluginService pluginService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("page", callBackDataService.findAdFirstList());
		return viewPath + "/list";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(final String ad) {
		List<CallBackData> callBackDatas = callBackDataService.findList(null, new ArrayList<Filter>() {
			{
				add(Filter.eq("ad", ad, false));

			}
		}, null);
		StringBuffer sb = new StringBuffer("");
		for (CallBackData callBackData : callBackDatas) {
			sb.append(callBackData.getUserName() + ","//
					+ callBackData.getPassword() + ","//
					+ callBackData.getRemark() + ","//
					+ System.lineSeparator());
		}
		File tempFile = new File(System.getProperty("java.io.tmpdir") + "/upload_" + UUID.randomUUID() + ".tmp");
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdirs();
		}
		String destPath = "/upload/download/" + UUID.randomUUID() + ".txt";
		try {
			FileUtils.writeStringToFile(tempFile, sb.toString());
			for (StoragePlugin storagePlugin : pluginService.getStoragePlugins(true)) {
				try {
					storagePlugin.upload(destPath, tempFile, "text/plain");
				} finally {
					FileUtils.deleteQuietly(tempFile);
				}
				return "redirect:" + storagePlugin.getUrl(destPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(final String ad) {
		if (ad == null || ad.isEmpty())
			return "redirect:list.jhtml";
		callBackDataService.deleteByAd(ad);
		// List<CallBackData> callBackDatas = callBackDataService.findList(null, new ArrayList<Filter>() {
		// {
		// add(Filter.eq("ad", ad, false));
		//
		// }
		// }, null);
		// for (CallBackData callBackData : callBackDatas) {
		// callBackDataService.delete(callBackData.getId());
		// }
		return "redirect:list.jhtml";
	}

	/**
	 * 批量修改remark
	 */
	@RequestMapping(value = "/remark_batch_update", method = RequestMethod.GET)
	@ResponseBody
	public String batchUpdateRemark(final String ad, final String remark, final String[] userNames) {
		if (ad == null || ad.isEmpty())
			return "ad can not be null.";
		if (userNames == null || userNames.length == 0)
			return "userNames can not be null.";
		if (remark == null || remark.isEmpty())
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
		// add(Filter.eq("ad", ad, false));
		// add(Filter.in("userName", userNameList));
		// }
		// }, null);
		// for (CallBackData callBackData : callBackDatas) {
		// callBackData.setRemark(remark);
		// callBackDataService.update(callBackData);
		// }
		callBackDataService.updateRemark(ad, userNameList, remark);
		return "success";
	}

}
