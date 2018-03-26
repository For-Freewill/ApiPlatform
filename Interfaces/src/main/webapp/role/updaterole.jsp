<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		function checkparentid(a){
			document.getElementById(a).checked=true;
		}
	</script>

  </head>
  
  <body>
     <div id="tanchuk">
  <div class="tan_top"></div>
  <div class="tan_main">
  <form action="role/updaterole.do" method="post">
  	<input type="hidden" name="roleid" value="${data.role.roleid }">
	<table class="tck" width="213" border="0" cellspacing="0" cellpadding="0">
		<tr bgcolor="white"><td align=right class="tc_w108">角色名：</td><td>
		<input class="text_yhm" name="rolename" value="${data.role.rolename }" id="rolename" onblur="checkdulname(this.value)"/><span id="checkname_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right class="tc_w108">描&nbsp;&nbsp;述：</td><td>
		<input class="text_yhm" name="description" value="${data.role.description }" onblur="checknotnull2(this.value)"/><span id="description_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right>权&nbsp;&nbsp;限：</td><td>
		<c:forEach items="${data.objs}" var="o">
				<c:if test="${o.parentid=='0'}">
					<input type="checkbox" id="${o.funcid }" name="aaa" value="${o.funcid }"  
						<c:forEach items="${data.funs}" var="f">
							<c:if test="${f.funcid eq o.funcid}">checked</c:if>
						</c:forEach>
					/>
					<b>${o.funcname }</b><br>
						<c:forEach items="${data.objs}" var="e">
		   						<c:if test="${e.parentid eq o.funcid && (e.url==null || e.url=='')}">
									 &nbsp;<input type="checkbox" id="${e.funcid }" name="aaa" value="${e.funcid }" onclick="checkparentid('${e.parentid }')" 
									 	<c:forEach items="${data.funs}" var="f">
											<c:if test="${f.funcid==e.funcid}">checked</c:if>
										</c:forEach> />
										<b>${e.funcname }</b><br>
										<c:forEach items="${data.objs}" var="a">
			 								<c:if test="${a.parentid eq e.funcid && (a.url==null || a.url=='')}">
												&nbsp;<input type="checkbox" id="${a.funcid }" name="aaa" value="${a.funcid }" onclick="checkparentid('${a.parentid }')"
												<c:forEach items="${data.funs}" var="f">
													<c:if test="${f.funcid eq a.funcid}">checked</c:if>
												</c:forEach> />
												${o.funcname }
											</c:if>
											<c:if test="${a.parentid eq e.funcid && a.url!=null && a.url!=''}">
												&nbsp;&nbsp;<input type="checkbox" id="${a.funcid }" onclick="checkparentid('${a.parentid }')" name="aaa" value="${a.funcid }"
													<c:forEach items="${data.funs}" var="f">
														<c:if test="${f.funcid eq a.funcid}">checked</c:if>
													</c:forEach> />
												${a.funcname }<br>
											</c:if>
			   							</c:forEach>
								</c:if>
								<c:if test="${e.url!=null && e.url!=''}">
									<c:if test="${e.parentid==o.funcid && e.url!=null}">
									&nbsp;&nbsp;<input type="checkbox" id="${e.funcid }" onclick="checkparentid('${e.parentid }')" name="aaa" value="${e.funcid }"
										<c:forEach items="${data.funs}" var="f">
											<c:if test="${f.funcid eq e.funcid}">checked</c:if>
										</c:forEach> />
									${e.funcname }<br>
									</c:if>
								</c:if>
	   					</c:forEach>
				</c:if>
		</c:forEach>
		</td></tr>
		<tr bgcolor="white"><td colspan="2" align="center">
			<input type="submit" value="确定" class="queren"/><input type="button" value="取消" class="quxiao" onclick="hiden()"/>
		</td></tr>
	</table>
</form>
</div>
<div class="tan_bottom"></div>
</div>
  </body>
</html>