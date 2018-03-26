<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<frameset name="parents" rows="79,*" border=0 style="z-index:1">
	<frame name="top" scrolling="no" src="<%=path%>/top.jsp" style="z-index:1">
	<frameset cols="228,*" style="z-index:1">
		<frame name="left" tyle="overflow-x:hidden;overflow-y:auto;" src="<%=path%>/login/mune.do" scrolling="auto" border="0" style="z-index:1" noresize>
		<frame name="right" src="<%=path%>/func/funclist.do" style="z-index:1">
	</frameset>
</frameset>