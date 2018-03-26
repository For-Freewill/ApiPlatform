<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'mune.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />  
<script type="text/javascript" src="<%=path %>/js/DD_belatedPNG_0.0.8a-min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
		<style> 
		*{padding:0; margin:0;}
		body{ font-family:"Microsoft YaHei"}
		li,ul{ list-style:none;}
		a{ text-decoration:none;}
		input{ vertical-align:middle;}
		.nav{ width:230px;background: #eeeeee;height: 100%;}
		.nav_list {
		background: #ebebeb;
		border-top: 1px solid #e2e2e2;
		}
		.nav_list li a {
		height: 40px;
		line-height: 40px;
		padding-left: 65px;
		display: block;
		color: #666666;
		}
		.nav_list li a:hover {
		height: 40px;
		line-height: 40px;
		background: #f4f4f4;
		}
		.nav_title{
		height: 47px;
		background-image:url(images/all_bg.png);
		background-repeat: no-repeat;
		font-size: 16px;
		}
		.nav_title_default {
		background-position: left -927px;
		}
		.nav_title a {
		height: 47px;
		line-height: 47px;
		padding-left: 65px;
		font-size: 16px;
		color: #444444;
		display: block;
		}
		.nav_list .selected a, .nav_list .selected a:hover {
		height: 40px;
		line-height: 40px;
		padding-left: 60px;
		display: block;
		color: #666666;
		border-left: 5px solid #0057ff;
		background: #fff;
		position: absolute;
		width: 173px;
		z-index: 1;
		}
		.paap {
		background:no-repeat 30px center;
		}
		.group_babel {font-size:12px;
		float: left;
		height: 24px;
		line-height: 24px;
		width: 170px;
		}
		.group_babel input {
		height: 14px;
		width: 14px;
		margin: 0 5px 0 0;
		}
		a.group_help {
		background-image: url("images/all_bg.png");
		background-position: left -497px;
		height: 20px;
		margin: 1px 0 0 5px;
		width: 16px;
		display: inline-block;
		text-decoration: none;
		z-index: 1;
		position: absolute;
		}
		</style>
		<script type="text/javascript">
		
	</script>
</head>

<body >
<div class="nav">
		 <div class="nav_title nav_title_default">
		 <c:set var="g" value="1"></c:set>
       	<c:forEach items="${objs}" var="a">
        <c:if test="${a.parentid=='0' }">
    	<p style="background: url(images/image${g}.png) no-repeat 30px center;"><a href="javascript:void(0);">
   		${a.funcname }</a></p>
    	<div style="display:block">
    		<ul class="nav_list">
		  <c:forEach items="${objs}" var="o">
			   	<c:if test="${o.parentid==a.funcid }">
				    <li><a href="${o.url }" target="right">
				   	${o.funcname }
				   	</a></li>	
			   	</c:if>
			   </c:forEach>
		</ul>
    	</div>
    	<c:set var="g" value="${g+1}"></c:set>
    	</c:if>
  	 	</c:forEach>
		</div>
</div>
  	
  </body>
</html>