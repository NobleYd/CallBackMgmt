<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- 引入页头部分 -->
		[#include "/admin/include/header.ftl"]
		
		<title>游戏状态列表 - Powered By APP TEAM</title>
	</head>
	<body class="no-skin">
		
		<!-- 引入顶部导航部分 -->
		
		<div class="main-container" id="main-container">
			
			<!-- 页面主题部分开始 -->
			<div class="main-content">
				
				<!-- 主页面区域 -->
				<div class="main-content-inner">
					<!-- 主页面列表部分 -->
					<div class="page-content">
						
						<!-- 引入设置工具箱部分 -->
						[#include "/admin/include/ace-setting-box.ftl"]
						
						<!-- 列表表单开始 -->
						<form id="listForm" action="list2.jhtml" method="get">
							
							<!-- 列表工具条部分 -->
							<div class="page-header">
							
								<input type="submit" name="default" class="hidden" />
							
								<!-- 增删刷新 按钮 -->
								<div class="btn-group btn-corner">
								    <a href="javascript:;" id="refreshButton" class="btn btn-success btn-sm">
								        <i class="glyphicon glyphicon-refresh"></i>
								        <span>${message("admin.common.refresh")}</span>
								    </a>
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    日期查询：<input type="text" id="searchDate" name="searchDate" value="[#if searchDate?? ]${(searchDate?string('yyyy-MM-dd'))!''}[/#if]" class="text Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'});" />
								    
								</div>
							
								<!-- 列表搜索 -->
								<div class="btn-group btn-corner pull-right">
									<div class="btn-group">
										<a id="searchPropertySelect" aria-expanded="false" data-toggle="dropdown" class="btn btn-info btn-sm dropdown-toggle">
									        <i class="ace-icon fa fa-angle-down"></i>
									    </a>
									    <ul id="searchPropertyOption" class="dropdown-menu dropdown-info">
											<li [#if page.searchProperty == "gameName" ] class="active" [/#if] val="gameName" >
												<a href="javascript:;" >游戏名称</a>
											</li>
											<li [#if page.searchProperty == "title" ] class="active" [/#if] val="title" >
												<a href="javascript:;" >账号密码</a>
											</li>
									    </ul>
									</div>
									<span class="input-icon pull-left">
								       <i class="ace-icon fa fa-search"></i>
								       <input id="searchValue" name="searchValue" value="${page.searchValue}" type="text" class="nav-search-input input-sm input-info" placeholder="Search ..." autocomplete="off" />
								    </span>
								    <input type="submit" name="search" class="btn btn-info btn-sm pull-left" value="Search &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
								</div>
								
							</div><!-- 列表工具条部分结束/.page-header -->
							
							<!-- 列表表格开始 -->
							<div class="row">
								<div class="col-xs-12">
									<!-- 表格开始 -->
									<table id="listTable" class="list table table-bordered table-hover">
										<thead>
											<tr>
												<th>
													<span name="index">序号</span>
												</th>
												<th>
													<span name="title">账号密码</span>
												</th>
												<th>
													<span name="picture">游戏截图</span>
												</th>
											</tr>
										</thead>
										<tbody>
										[#list contents as gameState ]
											<tr>
												<td>				
													<span name="index">${(gameState_index + 1)!}</span>
												</td>
												<td>				
													<span name="title">${(gameState.title)!}</span>
												</td>
												<td>
													<table>
													 <tr>
														[#list gameState.pictures as obj]
														<th>&nbsp;${(obj[1]?string("yyyy-MM-dd"))!}&nbsp;</th>
														[/#list]													 
													 </tr>
													 <tr>
														[#list gameState.pictures as obj]
														<td>&nbsp;<img width="200px" height="200px" src="${obj[0]!}" title="${(obj[1]?string("yyyy-MM-dd"))!}" alt="${(obj[1]?string("yyyy-MM-dd"))!}" />&nbsp;</td>
														[/#list]													 
													 </tr>
													</table>
												</td>
											</tr>
										[/#list]
										</tbody>
									</table><!-- /表格部分结束 -->
									<!-- 引入分页部分 -->
									[@pagination pageNumber = page.pageNumber totalPages = page.totalPages]
										[#include "/admin/include/pagination.ftl"]
									[/@pagination]
								</div><!-- /.col -->
							</div><!-- /.row -->
						</form><!-- /列表表单结束 /form -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- 页面主题部分开始 - /.main-content -->
			
		</div><!-- /.main-container -->

		<!-- 引入公共基础脚本 -->
		[#include "/admin/include/scripts.ftl"]

		<!-- 页面自定义插件脚本引入区 page specific plugin scripts -->
		<script type="text/javascript" src="${base}/resources/admin/js/list.js"></script>
		<script type="text/javascript" src="${base}/resources/admin/datePicker/WdatePicker.js"></script>
		
		<!-- 页面自定义内联脚本区 inline scripts related to this page -->
		<script type="text/javascript">
			[@flash_message /]
		</script>

	</body>
</html>
