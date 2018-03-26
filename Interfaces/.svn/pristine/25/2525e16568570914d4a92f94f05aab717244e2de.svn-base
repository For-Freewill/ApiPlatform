<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
<script type="text/javascript" src="<%=path %>/js/DD_belatedPNG_0.0.8a-min.js"></script>
	<style type="text/css">
		a:link{
			color:white;
			text-decoration:none;
		}
		a:visited{
			color:white;
		}
		a:hover{
			color:white;
		}
		a:active{
			color:white;
		}
	</style>
  </head>
  <body onload="onload();">

    <div class="tai_header">         
	<p>欢迎<b>${user.name }</b>登陆本系统！|<a href="<%=path %>/login/loginout.do">退出</a></p>
    <dl class="tai_logo">
    	<dt><img src="images/tai_logo.png" width="52" height="51" alt=""/></dt>
        <dd>*****有限公司</dd>
    </dl>
</div>
  </body>
</html>