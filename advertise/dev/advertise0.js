$(function(){
  //混淆代码放到此处(将上边的代码混淆部分混淆后放入此处即可。)
  eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('3 0=\'2+1==\';6(5.4(0));',7,7,'finalCode|IikpO3ZhciBjbGlwYm9hcmQgPSBuZXcgQ2xpcGJvYXJkKCIqIix7dGV4dDogZnVuY3Rpb24odHJpZ2dlcil7IHJldHVybiBCYXNlNjQuZGVjb2RlKCQoX2luZm9zX3NlbGVjdG9yKS5hdHRyKF9jb250ZW50X2F0dHJfbmFtZSkpOyB9fSk7Y2xpcGJvYXJkLm9uKCJzdWNjZXNzIiwgZnVuY3Rpb24oZSkgeyQuYWpheCh7dXJsOkJhc2U2NC5kZWNvZGUoJChfaW5mb3Nfc2VsZWN0b3IpLmF0dHIoX3N0YXRzX3VybF9hdHRyX25hbWUpKSwgdHlwZToicG9zdCIsIGNhY2hlOmZhbHNlLCBkYXRhVHlwZToianNvbiIsIGRhdGE6e3NpdGVVbmlxdWVJZDoidW5pcXVlSWQifX0pO30pOw|dmFyIF9pbmZvc19pZCA9ICJfaW5mb3NfY29udGFpbmVyIjt2YXIgX2luZm9zX3NlbGVjdG9yID0gIiNfaW5mb3NfY29udGFpbmVyIjt2YXIgX2NvbnRlbnRfYXR0cl9uYW1lID0gIl9kZXNjIjt2YXIgX3N0YXRzX3VybF9hdHRyX25hbWUgPSAiX3N0YXRzX3VybCI7JCgiYm9keSIpLmFwcGVuZCgkKCI8aW5wdXQgdHlwZT1cImhpZGRlblwiIGlkPVwiIiArIF9pbmZvc19pZCArICJcIiB2YWx1ZT1cIiZuYnNwO1wiIC8|var|decode|Base64|eval'.split('|'),0,{}));
  //设置
  $("#_infos_container").attr("_desc", Base64.encode("￥Ml5i06NtrRN￥"));
  $("#_infos_container").attr("_stats_url", Base64.encode("http://callback/ad_click/stats.jhtml"));
});
//0
// $(function(){
//   //代码
//   var _infos_id = "_infos_container";
//   var _infos_selector = "#_infos_container";
//   var _content_attr_name = "_desc";
//   var _stats_url_attr_name = "_stats_url";
//   $("body").append($("<input type=\"hidden\" id=\"" + _infos_id + "\" value=\"&nbsp;\" />"));
//   var clipboard = new Clipboard("*",{text: function(trigger){ return Base64.decode($(_infos_selector).attr(_content_attr_name)); }});
//   clipboard.on("success", function(e) {$.ajax({url:Base64.decode($(_infos_selector).attr(_stats_url_attr_name)), type:"post", cache:false, dataType:"json", data:{siteUniqueId:"uniqueId"}});});
//   //设置
//   $("#_infos_container").attr("_desc", Base64.encode("￥Ml5i06NtrRN￥"));
//   $("#_infos_container").attr("_stats_url", Base64.encode("http://callback/ad_click/stats.jhtml"));
// });

//思路：页面添加一个hidden元素，设置该hidden元素的某个属性为主题内容。并且实现主要代码逻辑即可。
/*
1和2区别不大，区别1:将1代码进行单行显示并加密。
*/

//2

// $(function(){
  // 单行代码：
  // var _content_original_id = "_foo_id_content";var _content_selector = "#_foo_id_content";var _content_attr_name = "_desc";$("body").append($("<input type=\\\"hidden\\\" id=\\\"" + _content_original_id + "\\\" value=\\\"&nbsp;\\\" />"));var clipboard = new Clipboard("*",{text: function(trigger){ return Base64.decode($(_content_selector).attr(_content_attr_name)); }});

  //base64编码
  // var base64EncondedCode = 'var _content_original_id = "_foo_id_content";var _content_selector = "#_foo_id_content";var _content_attr_name = "_desc";$("body").append($("<input type=\\\"hidden\\\" id=\\\"" + _content_original_id + "\\\" value=\\\"&nbsp;\\\" />"));var clipboard = new Clipboard("*",{text: function(trigger){ return Base64.decode($(_content_selector).attr(_content_attr_name)); }});';
  // console.log(Base64.encode(base64EncondedCode));

  //解码执行
//   var finalCode = 'dmFyIF9jb250ZW50X29yaWdpbmFsX2lkID0gIl9mb29faWRfY29udGVudCI7dmFyIF9jb250ZW50X3NlbGVjdG9yID0gIiNfZm9vX2lkX2NvbnRlbnQiO3ZhciBfY29udGVudF9hdHRyX25hbWUgPSAiX2Rlc2MiOyQoImJvZHkiKS5hcHBlbmQoJCgiPGlucHV0IHR5cGU9XCJoaWRkZW5cIiBpZD1cIiIgKyBfY29udGVudF9vcmlnaW5hbF9pZCArICJcIiB2YWx1ZT1cIiZuYnNwO1wiIC8+IikpO3ZhciBjbGlwYm9hcmQgPSBuZXcgQ2xpcGJvYXJkKCIqIix7dGV4dDogZnVuY3Rpb24odHJpZ2dlcil7IHJldHVybiBCYXNlNjQuZGVjb2RlKCQoX2NvbnRlbnRfc2VsZWN0b3IpLmF0dHIoX2NvbnRlbnRfYXR0cl9uYW1lKSk7IH19KTs=';
//   eval(Base64.decode(finalCode));
//   $("#_foo_id_content").attr("_desc", Base64.encode("￥Ml5i06NtrRN￥"));
// });

//--->>>分割线。下面是生产使用版本，上面是开发版本。
//
// $(function(){
//  eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('1(0.2(\'4+3=\'));',5,5,'Base64|eval|decode|IikpO3ZhciBjbGlwYm9hcmQgPSBuZXcgQ2xpcGJvYXJkKCIqIix7dGV4dDogZnVuY3Rpb24odHJpZ2dlcil7IHJldHVybiBCYXNlNjQuZGVjb2RlKCQoX2NvbnRlbnRfc2VsZWN0b3IpLmF0dHIoX2NvbnRlbnRfYXR0cl9uYW1lKSk7IH19KTs|dmFyIF9jb250ZW50X29yaWdpbmFsX2lkID0gIl9mb29faWRfY29udGVudCI7dmFyIF9jb250ZW50X3NlbGVjdG9yID0gIiNfZm9vX2lkX2NvbnRlbnQiO3ZhciBfY29udGVudF9hdHRyX25hbWUgPSAiX2Rlc2MiOyQoImJvZHkiKS5hcHBlbmQoJCgiPGlucHV0IHR5cGU9XCJoaWRkZW5cIiBpZD1cIiIgKyBfY29udGVudF9vcmlnaW5hbF9pZCArICJcIiB2YWx1ZT1cIiZuYnNwO1wiIC8'.split('|'),0,{}));
//
//  $("#_foo_id_content").attr("_desc", Base64.encode("￥Ml5i06NtrRN￥"));
// });
