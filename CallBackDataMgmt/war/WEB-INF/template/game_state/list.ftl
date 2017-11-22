<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- 引入页头部分 -->
		[#include "/admin/include/header.ftl"]
		
		<title>游戏状态列表 - Powered By APP TEAM</title>
		
		<!-- 页面自定义插件样式引入区 page specific plugin styles -->
		<!-- 页面自定义内联样式 inline styles related to this page -->
	
	</head>
	<body class="no-skin">
		
		<!-- 引入顶部导航部分 -->
		[#include "/admin/include/navbar.ftl"]
		
		<div class="main-container" id="main-container">
			
			<!-- {定义左侧菜单选中项 menu="《此处填写左侧大分类》" subMenu="《此处填写小分类》" } -->
			[#assign menu="gameStateMenu" subMenu="gameState" ]
			
			<!-- 引入左侧菜单部分 -->
			[#include "/admin/include/sidebar.ftl"]
			
			<!-- 页面主题部分开始 -->
			<div class="main-content">
				
				<!-- 主页面区域 -->
				<div class="main-content-inner">
					
					<!-- 面包屑路径 + 全局搜索 -->
					<div class="breadcrumbs" >
						
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						
						<!-- 面包屑路径 -->
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="${base}/admin/common/main.jhtml">${message("admin.path.index")}</a>
							</li>
							<li class="active">
								<span>游戏状态列表</span>
								<span>(${message("admin.page.total", page.total)})</span>
							</li>
						</ul><!-- /面包屑路径结束/.breadcrumb -->
						
						<!-- 全局搜索 注释掉（暂不支持）。
                        <div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div>
                        -->
                        
					</div><!-- /面包屑路径 + 全局搜索 结束 /.breadcrumbs -->
					
					<!-- 主页面列表部分 -->
					<div class="page-content">
						
						<!-- 引入设置工具箱部分 -->
						[#include "/admin/include/ace-setting-box.ftl"]
						
						<!-- 列表表单开始 -->
						<form id="listForm" action="list.jhtml" method="get">
							
							<!-- 列表工具条部分 -->
							<div class="page-header">
							
								<input type="submit" name="default" class="hidden" />
							
								<!-- 增删刷新 按钮 -->
								<div class="btn-group btn-corner">
									[#--
									<a href="add.jhtml" class="btn btn-info btn-sm">
										<i class="glyphicon glyphicon-plus"></i>
										<span>${message("admin.common.add")}</span>
									</a>
									<a href="javascript:;" id="deleteButton" class="disabled btn btn-danger btn-sm">
								        <i class="glyphicon glyphicon-trash"></i>
								        <span>${message("admin.common.delete")}</span>
								    </a>
								    --]
								    <a href="javascript:;" id="refreshButton" class="btn btn-success btn-sm">
								        <i class="glyphicon glyphicon-refresh"></i>
								        <span>${message("admin.common.refresh")}</span>
								    </a>
								    <a href="refresh.jhtml" class="btn btn-success btn-sm">
								        <i class="glyphicon glyphicon-refresh"></i>
								        <span>刷新内容</span>
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
														<th>&nbsp;${(gameState.recordDate?string("yyyy-MM-dd"))!}&nbsp;</th>
														[/#list]													 
													 </tr>
													 <tr>
														[#list gameState.pictures as obj]
														<td>&nbsp;<img width="200px" height="200px" src="${obj!}" title="${(gameState.recordDate?string("yyyy-MM-dd"))!}" alt="${(gameState.recordDate?string("yyyy-MM-dd"))!}" />&nbsp;</td>
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
			
			<!-- 引入页脚部分 -->
			[#include "/admin/include/footer.ftl"]
			
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
