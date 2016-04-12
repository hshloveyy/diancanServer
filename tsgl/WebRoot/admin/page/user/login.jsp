<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="admin/js/jquery.js"></script>
    <script src="admin/js/cloud.js" type="text/javascript"></script>
	<script language="javascript">
		$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    });  
	});  
   </script> 
  </head>
  
  <body style="background-color:#df7611; background-image:url(admin/imgs/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎访问点餐系统管理后台</span>    
    <ul>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    <div class="loginbody" style="margin-top:80px;">
  
    <div class="loginbox" >
    <form action="user?method=login" method="post">
    <ul>
    <li><input name="name" type="text" class="loginuser"/></li>
    <li><input name="pwd" type="password" class="loginpwd" /></li>
    <li><input type="submit" class="loginbtn" value="登录" />
    </li>
    </ul>
    </form>
    </div>
    </div>
</body>
</html>
