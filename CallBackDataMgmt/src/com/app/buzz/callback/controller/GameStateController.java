/*
 * Copyright 2015-2025. All rights reserved.
 * Support: @Support
 * License: @License
 */
package com.app.buzz.callback.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.Message;
import com.app.Order;
import com.app.Page;
import com.app.Pageable;
import com.app.buzz.callback.entity.GameState;
import com.app.buzz.callback.service.GameStateService;
import com.app.controller.admin.BaseController;
import com.app.service.FileService;

/***
 *
 * 控制器 - 游戏状态
 *
 * @author APP TEAM
 * @version 1.0
 */
@Controller
@RequestMapping("/game_state")
public class GameStateController extends BaseController implements ServletContextAware {

	/** servletContext */
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private String viewPath = "/game_state";

	@Resource(name = "fileService")
	private FileService fileService;

	@Resource
	private GameStateService gameStateService;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 列表
	 */
	@RequestMapping(value = "/game_list", method = RequestMethod.GET)
	public String game_list(Pageable pageable, ModelMap model) {
		List<String> gameList = gameStateService.getGameList();
		model.put("gameList", gameList);
		return viewPath + "/game_list";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/game_list2", method = RequestMethod.GET)
	public String game_list2(Pageable pageable, ModelMap model) {
		List<String> gameList = gameStateService.getGameList();
		model.put("gameList", gameList);
		return viewPath + "/game_list2";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Pageable pageable, Date searchDate, String gameName, ModelMap model) {
		pageable.setUnlimitPageSize();
		pageable.getOrders().add(Order.asc("gameName"));
		pageable.getOrders().add(Order.asc("title"));
		pageable.getOrders().add(Order.asc("recordDate"));

		if (gameName != null && !gameName.isEmpty()) {
			pageable.setSearchProperty("gameName");
			pageable.setSearchValue(gameName);
		}

		if (searchDate != null) {
			model.put("searchDate", searchDate);
		}

		Page<GameState> page = gameStateService.findPage(pageable);

		List<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();
		String lastGame = "";
		String lastTitle = "";
		// 为了方便实现日期搜查
		boolean isNew = false;
		Map<String, Object> current = new LinkedHashMap<String, Object>();
		for (GameState gameState : page.getContent()) {
			if (!lastGame.equals(gameState.getGameName()) || !lastTitle.equals(gameState.getTitle())) {
				current = new LinkedHashMap<String, Object>();
				current.put("pictures", new ArrayList<String>());
				lastGame = gameState.getGameName();
				lastTitle = gameState.getTitle();
				contents.add(current);
				isNew = true;
			}
			current.put("gameName", gameState.getGameName());
			current.put("title", gameState.getTitle());
			((ArrayList) current.get("pictures"))
					.add(new Object[] { gameState.getPicture(), gameState.getRecordDate() });
			if (isNew) {
				isNew = false;
				current.put("firstDate", gameState.getRecordDate());
			}
		}
		
		if(searchDate!=null) {
			List<Map<String, Object>> contents2 = new ArrayList<Map<String, Object>>();
			for(Map<String, Object> m :contents) {
				if(((Date)(m.get("firstDate"))).compareTo(searchDate)==0) {
					contents2.add(m);
				}
			}
			contents = contents2;
		}
		page.setTotal(contents.size());
		model.addAttribute("contents", contents);
		model.addAttribute("page", page);

		return viewPath + "/list";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	public String list2(Pageable pageable, Date searchDate, String gameName, ModelMap model) {
		pageable.setUnlimitPageSize();
		pageable.getOrders().add(Order.asc("gameName"));
		pageable.getOrders().add(Order.asc("title"));
		pageable.getOrders().add(Order.asc("recordDate"));

		if (gameName != null && !gameName.isEmpty()) {
			pageable.setSearchProperty("gameName");
			pageable.setSearchValue(gameName);
		}

		if (searchDate != null) {
			model.put("searchDate", searchDate);
		}

		Page<GameState> page = gameStateService.findPage(pageable);

		List<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();
		String lastGame = "";
		String lastTitle = "";
		// 为了方便实现日期搜查
		boolean isNew = false;
		Map<String, Object> current = new LinkedHashMap<String, Object>();
		for (GameState gameState : page.getContent()) {
			if (!lastGame.equals(gameState.getGameName()) || !lastTitle.equals(gameState.getTitle())) {
				current = new LinkedHashMap<String, Object>();
				current.put("pictures", new ArrayList<String>());
				lastGame = gameState.getGameName();
				lastTitle = gameState.getTitle();
				contents.add(current);
				isNew = true;
			}
			current.put("gameName", gameState.getGameName());
			current.put("title", gameState.getTitle());
			((ArrayList) current.get("pictures"))
					.add(new Object[] { gameState.getPicture(), gameState.getRecordDate() });
			if (isNew) {
				isNew = false;
				current.put("firstDate", gameState.getRecordDate());
			}
		}
		
		if(searchDate!=null) {
			List<Map<String, Object>> contents2 = new ArrayList<Map<String, Object>>();
			for(Map<String, Object> m :contents) {
				if(((Date)(m.get("firstDate"))).compareTo(searchDate)==0) {
					contents2.add(m);
				}
			}
			contents = contents2;
		}
		page.setTotal(contents.size());
		model.addAttribute("contents", contents);
		model.addAttribute("page", page);

		return viewPath + "/list2";
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public String refresh(RedirectAttributes redirectAttributes) {
		File gameStateDir = new File(servletContext.getRealPath("/upload/gamestate/"));
		if (!gameStateDir.exists() || !gameStateDir.isDirectory()) {
			gameStateDir.mkdirs();
			addFlashMessage(redirectAttributes, Message.success("刷新成功！"));
			return "redirect:list.jhtml";
		}
		for (File dayNumberFile : gameStateDir.listFiles()) {
			try {
				if (dayNumberFile.isDirectory()) {
					Date recordDate = sdf.parse(dayNumberFile.getName());
					for (File gameNameFile : dayNumberFile.listFiles()) {
						String gameName = gameNameFile.getName();
						if (gameNameFile.listFiles(new FilenameFilter() {
							@Override
							public boolean accept(File dir, String name) {
								if (name.equals("done")) {
									return true;
								}
								return false;
							}
						}).length <= 0) {
							new File(gameNameFile, "done").createNewFile();
							for (File pictureFile : gameNameFile.listFiles()) {
								if (!pictureFile.getName().equals("done")) {
									String title = pictureFile.getName();
									title = title.substring(0, title.indexOf("."));
									GameState gameState = new GameState();
									gameState.setGameName(gameName);
									gameState.setRecordDate(recordDate);
									gameState.setTitle(title);
									gameState.setPicture("/upload/gamestate/" + dayNumberFile.getName() + "/" + gameName
											+ "/" + pictureFile.getName());
									System.out.println(gameState);
									gameStateService.save(gameState);
								}
							}
						} else {
							// 该目录已经持久化
						}
					}
				} else {
					// 非目录
				}
			} catch (Exception e) {
			}
		}

		addFlashMessage(redirectAttributes, Message.success("刷新成功！"));
		return "redirect:list.jhtml";
	}

	/**
	 * 添加
	 */
	// @RequestMapping(value = "/add", method = RequestMethod.GET)
	// public String add(ModelMap model) {
	// return viewPath + "/add";
	// }

	/**
	 * 保存
	 */
	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	// public String save(GameState gameState, MultipartFile pictureImage,
	// RedirectAttributes redirectAttributes) {
	// if (!isValid(gameState)) {
	// return ERROR_VIEW;
	// }
	// if (pictureImage != null && !pictureImage.isEmpty()) {
	// if (!fileService.isValid(FileType.image, pictureImage)) {
	// addFlashMessage(redirectAttributes, Message.error("不合法的文件扩展名！"));
	// return "redirect:list.jhtml";
	// } else {
	// String url = fileService.upload(FileType.gamestate, pictureImage, false);
	// if (url == null) {
	// addFlashMessage(redirectAttributes, ERROR_MESSAGE);
	// return "redirect:list.jhtml";
	// } else {
	// gameState.setPicture(url);
	// }
	// }
	// }
	// if(gameState.getGameName() == null){
	// addFlashMessage(redirectAttributes, Message.error("游戏名称是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	// if(gameState.getTitle() == null){
	// addFlashMessage(redirectAttributes, Message.error("账号唯一标识是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	// if(gameState.getPicture() == null){
	// addFlashMessage(redirectAttributes, Message.error("图片是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	// if(gameState.getRecordDate() == null){
	// addFlashMessage(redirectAttributes, Message.error("添加时间是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	//
	// gameStateService.save(gameState);
	//
	// addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
	// return "redirect:list.jhtml";
	// }

	/**
	 * 删除
	 */
	// @RequestMapping(value = "/delete")
	// public @ResponseBody Message delete(Long[] ids) {
	// try {
	// gameStateService.delete(ids);
	// } catch (Exception e) {
	// return ERROR_MESSAGE;
	// }
	// return SUCCESS_MESSAGE;
	// }

	/**
	 * 编辑
	 */
	// @RequestMapping(value = "/edit", method = RequestMethod.GET)
	// public String edit(Long id, ModelMap model) {
	// GameState gameState = gameStateService.find(id);
	// model.addAttribute("gameState", gameState);
	// return viewPath + "/edit";
	// }

	/**
	 * 更新
	 */
	// @RequestMapping(value = "/update", method = RequestMethod.POST)
	// public String update(GameState gameState, MultipartFile pictureImage,
	// RedirectAttributes redirectAttributes) {
	// if (!isValid(gameState)) {
	// return ERROR_VIEW;
	// }
	// ArrayList<String> ignoreFileTypeAttributeNames = new ArrayList<String>();
	// if (pictureImage != null && !pictureImage.isEmpty()) {
	// if (!fileService.isValid(FileType.image, pictureImage)) {
	// addFlashMessage(redirectAttributes, Message.error("不合法的文件扩展名！"));
	// return "redirect:list.jhtml";
	// } else {
	// String url = fileService.upload(FileType.gamestate, pictureImage, false);
	// if (url == null) {
	// addFlashMessage(redirectAttributes, ERROR_MESSAGE);
	// return "redirect:list.jhtml";
	// } else {
	// gameState.setPicture(url);
	// }
	// }
	// }
	// else{
	// ignoreFileTypeAttributeNames.add("picture");
	// }
	// if(gameState.getGameName() == null){
	// addFlashMessage(redirectAttributes, Message.error("游戏名称是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	// if(gameState.getTitle() == null){
	// addFlashMessage(redirectAttributes, Message.error("账号唯一标识是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	// if(gameState.getRecordDate() == null){
	// addFlashMessage(redirectAttributes, Message.error("添加时间是必填项哦！"));
	// return "redirect:list.jhtml";
	// }
	// GameState persistant = gameStateService.find(gameState.getId());
	// if (persistant != null) {
	// BeanUtils.copyProperties(gameState, persistant,
	// new ArrayList<String>(ignoreFileTypeAttributeNames) {
	// {
	// add(BaseEntity.ID_PROPERTY_NAME);
	// add(BaseEntity.CREATE_DATE_PROPERTY_NAME);
	// add(BaseEntity.MODIFY_DATE_PROPERTY_NAME);
	// }
	// }.toArray(new String[]{})
	// );
	// gameStateService.update(persistant);
	// addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
	// } else {
	// addFlashMessage(redirectAttributes, ERROR_MESSAGE);
	// }
	// return "redirect:list.jhtml";
	// }

}
