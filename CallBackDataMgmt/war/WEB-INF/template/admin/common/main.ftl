<!DOCTYPE html>
<html lang="en">
	<head>
		<!-- 引入页头部分 -->
		[#include "/admin/include/header.ftl"]
		
		<title>首页</title>
		
		<!-- 页面自定义插件样式引入区 page specific plugin styles -->
		<!-- 页面自定义内联样式 inline styles related to this page -->
	
	</head>
	<body class="no-skin">
		
		<!-- 引入顶部导航部分 -->
		[#include "/admin/include/navbar.ftl"]
		
		<div class="main-container" id="main-container">
			
			<!-- {定义左侧菜单选中项} -->
			[#assign menu="Dashboard" subMenu="Dashboard" ]
			
			<!-- 引入左侧菜单部分 -->
			[#include "/admin/include/sidebar.ftl"]
			
			<!-- 页面主体部分开始 -->
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
							<li class="active">
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="${base}/admin/common/main.jhtml">${message("admin.path.index")}</a>
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
						[#include "/admin/include/ace-setting-box.ftl"]
						
						<div class="row">
							<div class="col-xs-12">
								<!-- /section:custom/extra.hr -->
								<div class="row">
									<div class="col-sm-12">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="widget-title lighter">
													<i class="ace-icon fa fa-star orange"></i>
													<span>系统信息</span>
												</h4>
												<div class="widget-toolbar">
													<a href="#" data-action="collapse">
														<i class="ace-icon fa fa-chevron-up"></i>
													</a>
												</div>
											</div>
											<div class="widget-body">
												<div class="widget-main no-padding">
													<table class="table table-bordered">
														<tbody>
															<tr>
																<th>
																	${message("admin.index.systemName")}:
																</th>
																<td>
																	${systemName}
																</td>
																<th>
																	${message("admin.index.systemVersion")}:
																</th>
																<td>
																	${systemVersion}
																</td>
															</tr>
															<tr>
																<th>
																	${message("admin.index.official")}:
																</th>
																<td>
																	<a href="#" target="_blank">#</a>
																</td>
																<th>
																	${message("admin.index.bbs")}:
																</th>
																<td>
																	<a href="#" target="_blank">#</a>
																</td>
															</tr>
															<tr>
																<td colspan="4">
																	&nbsp;
																</td>
															</tr>
															<tr>
																<th>
																	${message("admin.index.javaVersion")}:
																</th>
																<td>
																	${javaVersion}
																</td>
																<th>
																	${message("admin.index.javaHome")}:
																</th>
																<td>
																	${javaHome}
																</td>
															</tr>
															<tr>
																<th>
																	${message("admin.index.osName")}:
																</th>
																<td>
																	${osName}
																</td>
																<th>
																	${message("admin.index.osArch")}:
																</th>
																<td>
																	${osArch}
																</td>
															</tr>
															<tr>
																<th>
																	${message("admin.index.serverInfo")}:
																</th>
																<td>
																	${serverInfo}
																</td>
																<th>
																	${message("admin.index.servletVersion")}:
																</th>
																<td>
																	${servletVersion}
																</td>
															</tr>
															<tr>
																<td class="powered" colspan="4">
																	<strong class="green">COPYRIGHT © 2015-2025 APP TEAM. ALL RIGHTS RESERVED.</strong>
																</td>
															</tr>															
														</tbody>
													</table>
												</div><!-- /.widget-main -->
											</div><!-- /.widget-body -->
										</div><!-- /.widget-box -->
									</div><!-- /.col -->
								</div><!-- /.row -->
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			[#include "/admin/include/footer.ftl"]
			
		</div><!-- /.main-container -->

		<!-- basic scripts -->
		[#include "/admin/include/scripts.ftl"]

		<!-- 页面自定义插件脚本引入区 page specific plugin scripts -->

		<!-- 页面自定义内联脚本区 inline scripts related to this page -->
		<script type="text/javascript">
		</script>
	</body>
</html>
