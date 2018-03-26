<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addfunc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div id="tanchuk">
  <div class="tan_top"></div>
  <div class="tan_main">
  <form action="func/updatefunc.do" method="post">
  <input type="hidden" name="funcid" value="${data.func.funcid }">
	<table class="tck" width="213" border="0" cellspacing="0" cellpadding="0">
		<tr bgcolor=white><td class="tc_w108" align=right>菜单名称：</td><td>
		<input class="text_yhm" name="funcname" value="${data.func.funcname }" onblur="checkdulname(this.value)"/><span id="checkname_error"></span>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>父级菜单：</td><td>
			<select name="parentid">
				<option value="0">父菜单</option>
				<c:forEach items="${data.objs}" var="o">
					<option value="${o.funcid }" ${o.funcid==data.func.parentid? "selected":"" }>${o.funcname }</option>
				</c:forEach>
			</select>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>url：</td><td>
			<input class="text_yhm" name="url" value="${data.func.url }"/>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>顺序：</td><td>
			<input class="text_yhm" name="funcOrder" value="${data.func.funcOrder}"/>
		</td></tr>
		<tr bgcolor=white><td colspan="2" align=center>
			<input type="submit" value="确定" class="queren"/><input type="button" value="取消" class="quxiao" onclick="hiden()"/>
		</td></tr>
	</table>
</form>
</div>
<div class="tan_bottom"></div>
</div>
  </body>
</html>