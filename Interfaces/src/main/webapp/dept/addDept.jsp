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
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/houtai.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var aa=false,bb=false,cc=false,dd=false,ee=false;
		function checkdulname(a){
			if(a.length>0){
				$("#checkname_error").html("");
				aa=true;
				$.post("func/checkname.do",{
					"funcname":a
				},function(data){
					if(data=="Y"||data=="\Y\""){
						bb=true;
					}else{
						$("#checkname_error").html("<font color=red>该菜单已存在！</font>");
						bb=false;
					}
				});
			}else{
				$("#checkname_error").html("<font color=red>请填写菜单名称！</font>");
				aa=false;
			}
		}
		
	</script>

  </head>
  
  <body>
   <div id="tanchuk">
  <div class="tan_top"></div>
  <div class="tan_main">
  <form action="dept/addDept.do" method="post">
	<table class="tck" width="213" border="0" cellspacing="0" cellpadding="0">
		<tr bgcolor=white><td class="tc_w108" align=right>名&nbsp;&nbsp;称：</td><td>
		<input class="text_yhm" name="deptname" onblur="checkdulname(this.value)"/><span id="checkname_error"></span>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>描&nbsp;&nbsp;述：</td><td>
			<input class="text_yhm" name="description"/>
		</td></tr>
		<tr bgcolor=white><td colspan="2" align=center>
			<input type="submit" value="确定" class="queren"/><input type="button" value="取消" class="quxiao" onclick="hiden()"/>
		</td></tr>
	</table>
</form>
</div>
<div class="tan_bottom" style="position: absolute;"></div>
</div>
  </body>
</html>