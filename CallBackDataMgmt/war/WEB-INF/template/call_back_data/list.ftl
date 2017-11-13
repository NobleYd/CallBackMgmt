<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- 引入页头部分 -->
		[#include "/admin/include/header.ftl"]
		
		<title>回调列表 - Powered By APP TEAM</title>
		
		<!-- 页面自定义插件样式引入区 page specific plugin styles -->
		<!-- 页面自定义内联样式 inline styles related to this page -->
	
	</head>
	<body class="no-skin">
		
		<!-- 引入顶部导航部分 -->
		[#include "/admin/include/navbar.ftl"]
		
		<div class="main-container" id="main-container">
			<!-- {定义左侧菜单选中项 menu="《此处填写左侧大分类》" subMenu="《此处填写小分类》" } -->
			[#assign menu="devGroup" subMenu="callBackData" ]
			
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
								<span>回调列表</span>
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
								</div>
							
								<!-- 页面显示记录条数调整 按钮 -->
								<div class="btn-group">
								    <a id="pageSizeSelect" aria-expanded="false" data-toggle="dropdown" class="btn btn-success btn-sm dropdown-toggle">
								        <span>${message("admin.page.pageSize")}</span>
								        <i class="ace-icon fa fa-angle-down icon-on-right"></i>
								    </a>
								    <ul id="pageSizeOption" class="dropdown-menu dropdown-success">
								        <li [#if page.pageSize == 10] class="active"[/#if]>
											<a href="javascript:;" val="10">10</a>
										</li>
										<li [#if page.pageSize == 20] class="active"[/#if]>
											<a href="javascript:;" val="20">20</a>
										</li>
										<li [#if page.pageSize == 50] class="active"[/#if]>
											<a href="javascript:;" val="50">50</a>
										</li>
										<li [#if page.pageSize == 100] class="active"[/#if]>
											<a href="javascript:;" val="100">100</a>
										</li>
								    </ul>
								</div>
								
								<span>设备名称：</span>
								<input type="text" name="idfa" value="${(idfa)!}" />
								
								<span>游戏：</span>
								<input type="text" name="ad" value="${(ad)!}" />
								
								<span>索引：</span>
								<input type="text" name="adIndex" value="${(adIndex)!}" />
								
								<br/><br/>
								
								<span>时间：</span>
								
								<input type="text" id="fromDate" name="fromDate" value="[#if fromDate?? ]${(fromDate?string('yyyy-MM-dd HH:mm:ss'))!''}[/#if]" class="text Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss', maxDate: '#F{$dp.$D(\'toDate\')}'});" />
								~>
								<input type="text" id="toDate" name="toDate" value="[#if toDate?? ]${(toDate?string('yyyy-MM-dd HH:mm:ss'))!''}[/#if]" class="text Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss', minDate: '#F{$dp.$D(\'fromDate\')}'});" />
								
								<span>在线时长：</span>
								<input type="text" name="onlineTime" value="${(onlineTime)!}" />
								
								<span>登录次数：</span>
								<input type="text" name="loginCount" value="${(loginCount)!}" />
								
								<br/><br/>
								
								<span>账号：</span>
								<input type="text" name="userName" value="${(userName)!}" />
								
								<span>密码：</span>
								<input type="text" name="password" value="${(password)!}" />
								
								<span>状态：</span>
								<input type="text" name="state" value="${(state)!}" />
								
								<span>等级：</span>
								<input type="text" name="leves" value="${(leves)!}" />
								
								<input type="submit" class="btn btn-success btn-sm" />
								
							</div><!-- 列表工具条部分结束/.page-header -->
							
							<!-- 列表表格开始 -->
							<div class="row">
								<div class="col-xs-12">
									<!-- 表格开始 -->
									<table id="listTable" class="list table table-bordered table-hover">
										<thead>
											<tr>
												<th>
													<a href="javascript:;" class="sort" name="idfa">
														区
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="ad">
														游戏
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="adIndex">
														索引
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="state">
														状态
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="leves">
														等级
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="onlineTime">
														在线时长
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="loginCount">
														登录次数
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="clientIp">
														其他
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="createDate">
														新增时间
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="userName">
														账号
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="password">
														密码
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="remark">
														备注
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
												<th>
													<a href="javascript:;" class="sort" name="usedGames">
														使用游戏
														<i class="glyphicon pull-right"></i>
													</a>
												</th>
											</tr>
										</thead>
										<tbody>
										[#list page.content as callBackData ]
											<tr id="${callBackData.id}" title="${callBackData.id}">
												<td>				
													<span name="idfa">${(callBackData.idfa)!}</span>
												</td>
												<td>				
													<span name="ad">${(callBackData.ad)!}</span>
												</td>
												<td>				
													<span name="adIndex">${(callBackData.adIndex)!}</span>
												</td>
												<td>				
													<span name="state">${(callBackData.state)!}</span>
												</td>
												<td>				
													<span name="leves">${(callBackData.leves)!}</span>
												</td>
												<td>				
													<span name="onlineTime">${(callBackData.onlineTime)!}</span>
												</td>
												<td>				
													<span name="loginCount">${(callBackData.loginCount)!}</span>
												</td>
												<td>				
													<span name="clientIp">${(callBackData.clientIp)!}</span>
												</td>
												<td>				
													<span name="createDate">${(callBackData.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</span>
												</td>
												<td>				
													<span name="userNmae">${(callBackData.userName)!}</span>
												</td>
												<td>				
													<span name="password">${(callBackData.password)!}</span>
												</td>
												<td>				
													<span name="remark">${(callBackData.remark)!}</span>
												</td>
												<td>				
													<span name="usedGames">${(callBackData.usedGames)!}</span>
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
			
		[#-- list页表格单行操作按钮列的删除功能 --]
			var $listTable = $("#listTable");
			var $pageTotal = $("#pageTotal");
			var $deleteButton2 = $(".deleteButton");
			$deleteButton2.click( function() {
				var $this = $(this);
				if ($this.hasClass("disabled")) {
					return false;
				}
				$this.addClass("disabled");
				var $ids = $this.attr("ids");
				$.dialog({
					type: "warn",
					content: message("admin.dialog.deleteConfirm"),
					ok: message("admin.dialog.ok"),
					cancel: message("admin.dialog.cancel"),
					onOk: function() {
						$.ajax({
							url: "delete.jhtml",
							type: "POST",
							data: {ids:$ids},
							dataType: "json",
							cache: false,
							success: function(message) {
								$.message(message);
								if (message.type == "success") {
									$pageTotal.text(parseInt($pageTotal.text()) - 1);
									$this.closest("tr").remove();
									if ($listTable.find("tr").size() <= 1) {
										setTimeout(function() {
											location.reload(true);
										}, 2000);
									}
								}
								$deleteButton2.removeClass("disabled");
							}
						});
					},
					onCancel: function(){
						$deleteButton2.removeClass("disabled");
					},
					onClose: function(){
						$deleteButton2.removeClass("disabled");
					}
				});
			});
			
		</script>

	</body>
</html>
