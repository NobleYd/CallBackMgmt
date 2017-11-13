/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.controller.admin.BaseController;

/***
 *
 * 公用 - 回调
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	private String viewPath = "/common";

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 获取客户端IP，地区
	 */
	@RequestMapping(value = "/get_ip")
	public @ResponseBody Map<String, String> getIp(HttpServletRequest request) {
		Map<String, String> ret = new HashMap<String, String>();
		String ip = "error";
		ip = request.getRemoteAddr();
		ip = "124.165.144.100";
		String address = "error";
		Document document;
		try {
			document = Jsoup.connect("http://ip138.com/ips1388.asp?action=2&ip=" + ip).get();
			Elements elements = document.select("ul.ul1 li:eq(0)");
			if (elements.size() > 0) {
				String addressString = elements.get(0).html();
				addressString = addressString.replace("本站数据：", "");
				if (addressString.contains(" ")) {
					addressString = addressString.trim().split(" ")[0];
				}
				address = addressString;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		ret.put("ip", ip);
		ret.put("address", address);
		return ret;
	}

}
