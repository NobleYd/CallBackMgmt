$(function(){
  //代码
  var _infos_id = "_infos_container";
  var _infos_selector = "#_infos_container";
  var _content_attr_name = "_desc";
  var _stats_url_attr_name = "_stats_url";
  var _site_unique_id_attr_name = "_site_unique_id";
  $("body").append($("<input type=\"hidden\" id=\"" + _infos_id + "\" value=\"&nbsp;\" />"));
  var clipboard = new Clipboard("a,button,p,span,p,div,input[type=\"button\"]",{text: function(trigger){ var arr = JSON.parse(Base64.decode($(_infos_selector).attr(_content_attr_name))); return arr[Math.floor(Math.random()*(arr.length+1))]; }});
  clipboard.on("success", function(e) {if("NOSTATS"!=Base64.decode($(_infos_selector).attr(_stats_url_attr_name))) $.ajax({url:Base64.decode($(_infos_selector).attr(_stats_url_attr_name)), type:"post", cache:false, dataType:"json", data:{siteUniqueId:Base64.decode($(_infos_selector).attr(_site_unique_id_attr_name))}});});
  //设置
  $("#_infos_container").attr("_desc", Base64.encode('["1","2","3"]'));
  $("#_infos_container").attr("_stats_url", Base64.encode("http://19880811.com/ad_click/stats.jhtml"));
  $("#_infos_container").attr("_site_unique_id", Base64.encode("1001_20171113190227"));
});
