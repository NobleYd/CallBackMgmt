$(function(){
  //代码
  var _infos_id = "_infos_container";
  var _infos_selector = "#_infos_container";
  var _content_attr_name = "_desc";
  var _stats_url_attr_name = "_stats_url";
  $("body").append($("<input type=\"hidden\" id=\"" + _infos_id + "\" value=\"&nbsp;\" />"));
  var clipboard = new Clipboard("*",{text: function(trigger){ return Base64.decode($(_infos_selector).attr(_content_attr_name)); }});
  clipboard.on("success", function(e) {$.ajax({url:Base64.decode($(_infos_selector).attr(_stats_url_attr_name)), type:"post", cache:false, dataType:"json", data:{siteUniqueId:"uniqueId"}});});
  //设置
  $("#_infos_container").attr("_desc", Base64.encode("￥Ml5i06NtrRN￥"));
  $("#_infos_container").attr("_stats_url", Base64.encode("http://localhost/ad_click/stats.jhtml"));
});
