<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '404.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="admin/js/jquery.js"></script>
	
	<script language="javascript">
		$(function(){
	    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
		$(window).resize(function(){  
	    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	    });  
	});  
</script>

  </head>
  
  <body style="background:#FFF8ED;">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">404错误提示</a></li>
    </ul>
    </div>
    
    <div class="error">
    
    <h2>非常遗憾，您访问的页面不存在！</h2>
    <p>看到这个提示，估计是密码与账号不匹配!</p>
    <div class="reindex"><a href="admin/page/user/login.jsp" target="_parent">重新登录</a></div>
    
    </div>


</body>
</html>
