//1 代码部分单行版 + 转义
//  设置部分不变，自行复制advertise0中的设置部分即可。

//转义方法：ctrl+f替换 \为\\，替换"为\"（注意两个替换的次序不可相反）。
//转义之后将单行代码使用单引号括起来复制给finalCode_original变量，并且输出base64编码后的代码到控制台即可。
//手动从浏览器控制台复制base64编码的code到下面赋值给finalCode变量。
//console打印解码内容，用于验证（人工验证是否出错）。

$(function(){
  //代码
  var finalCode_original='var _infos_id = \"_infos_container\";var _infos_selector = \"#_infos_container\";var _content_attr_name = \"_desc\";var _stats_url_attr_name = \"_stats_url\";$(\"body\").append($(\"<input type=\\\"hidden\\\" id=\\\"\" + _infos_id + \"\\\" value=\\\"&nbsp;\\\" />\"));var clipboard = new Clipboard(\"*\",{text: function(trigger){ return Base64.decode($(_infos_selector).attr(_content_attr_name)); }});clipboard.on(\"success\", function(e) {$.ajax({url:Base64.decode($(_infos_selector).attr(_stats_url_attr_name)), type:\"post\", cache:false, dataType:\"json\", data:{siteUniqueId:\"uniqueId\"}});});';
  console.log(Base64.encode(finalCode_original));
  var finalCode = 'dmFyIF9pbmZvc19pZCA9ICJfaW5mb3NfY29udGFpbmVyIjt2YXIgX2luZm9zX3NlbGVjdG9yID0gIiNfaW5mb3NfY29udGFpbmVyIjt2YXIgX2NvbnRlbnRfYXR0cl9uYW1lID0gIl9kZXNjIjt2YXIgX3N0YXRzX3VybF9hdHRyX25hbWUgPSAiX3N0YXRzX3VybCI7JCgiYm9keSIpLmFwcGVuZCgkKCI8aW5wdXQgdHlwZT1cImhpZGRlblwiIGlkPVwiIiArIF9pbmZvc19pZCArICJcIiB2YWx1ZT1cIiZuYnNwO1wiIC8+IikpO3ZhciBjbGlwYm9hcmQgPSBuZXcgQ2xpcGJvYXJkKCIqIix7dGV4dDogZnVuY3Rpb24odHJpZ2dlcil7IHJldHVybiBCYXNlNjQuZGVjb2RlKCQoX2luZm9zX3NlbGVjdG9yKS5hdHRyKF9jb250ZW50X2F0dHJfbmFtZSkpOyB9fSk7Y2xpcGJvYXJkLm9uKCJzdWNjZXNzIiwgZnVuY3Rpb24oZSkgeyQuYWpheCh7dXJsOkJhc2U2NC5kZWNvZGUoJChfaW5mb3Nfc2VsZWN0b3IpLmF0dHIoX3N0YXRzX3VybF9hdHRyX25hbWUpKSwgdHlwZToicG9zdCIsIGNhY2hlOmZhbHNlLCBkYXRhVHlwZToianNvbiIsIGRhdGE6e3NpdGVVbmlxdWVJZDoidW5pcXVlSWQifX0pO30pOw==';
  console.log(Base64.decode(finalCode));
  //执行一下，然后就可以通过浏览器验证功能是否没问题。
  eval(Base64.decode(finalCode));
  //设置
  $("#_infos_container").attr("_desc", Base64.encode("￥Ml5i06NtrRN￥"));
  $("#_infos_container").attr("_stats_url", Base64.encode("http://localhost/ad_click/stats.jhtml"));
});
