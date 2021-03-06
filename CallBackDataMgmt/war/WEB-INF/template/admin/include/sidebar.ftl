<!-- #section:basics/sidebar -->
<script type="text/javascript">
	try{ace.settings.check('main-container' , 'fixed')}catch(e){}
</script>
<div id="sidebar" class="sidebar responsive">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>
	
	<!-- 菜单区域 -->
	<ul class="nav nav-list">
		<li class="[#if subMenu=="callBackData"]active open[/#if]">
			<a href="${base}/call_back_data/list.jhtml" >
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">回调数据查询</span>
			</a>
		</li>
		<li class="[#if subMenu=="upload"]active open[/#if]">
			<a href="${base}/upload/list.jhtml" >
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">上传账号</span>
			</a>
		</li>
		<li class="[#if subMenu=="script"]active open[/#if]">
			<a href="${base}/script/list.jhtml" >
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">脚本管理</span>
			</a>
		</li>
		<li class="[#if subMenu=="remarkUpdate"]active open[/#if]">
			<a href="${base}/remark_update/list.jhtml" >
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">任务调度</span>
			</a>
		</li>
		<li class="[#if subMenu=="adList"]active open[/#if]">
			<a href="${base}/ad/list.jhtml" >
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">游戏列表</span>
			</a>
		</li>
		<li class="[#if menu=="advertise"]active open[/#if]">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">广告投放</span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<ul class="submenu">
				<li class="[#if subMenu=="advertise_site"]active open[/#if]">
					<a href="${base}/ad_site/list.jhtml" >
						<i class="menu-icon fa fa-dashboard"></i>
						<span class="menu-text">投放站点列表</span>
					</a>
				</li>
				<li class="[#if subMenu=="advertise_click"]active open[/#if]">
					<a href="${base}/ad_click/list.jhtml" >
						<i class="menu-icon fa fa-dashboard"></i>
						<span class="menu-text">点击复制列表</span>
					</a>
				</li>
			</ul>
		</li>
		
		<li class="[#if menu=="gameStateMenu"]active open[/#if]">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-dashboard"></i>
				<span class="menu-text">账户状态管理</span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<ul class="submenu">
				<li class="[#if subMenu=="gameList"]active open[/#if]">
					<a href="${base}/game_state/game_list.jhtml" >
						<i class="menu-icon fa fa-dashboard"></i>
						<span class="menu-text">游戏列表</span>
					</a>
				</li>
				<li class="[#if subMenu=="gameState"]active open[/#if]">
					<a href="${base}/game_state/list.jhtml" >
						<i class="menu-icon fa fa-dashboard"></i>
						<span class="menu-text">账号截图列表</span>
					</a>
				</li>
			</ul>
		</li>
		[#--
		[#include "/admin/include/sidebar2.ftl"]
		--]
	</ul>
	
	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
</div>
<!-- /section:basics/sidebar -->