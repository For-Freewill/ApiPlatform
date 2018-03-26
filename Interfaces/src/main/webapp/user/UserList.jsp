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
    
	<title>用户管理界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />  
	<link href="<%=path %>/css/houtai.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=path %>/js/DD_belatedPNG_0.0.8a-min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
	
	<script type="text/javascript">
	function adduser(){
		$.post("user/toedituser.do",{},function(data){
			$("#adduser").show();
			$("#adduser").html(data).show();
		});
	}
	function updaterole(v){
		$.post("user/toedituser.do",{
			"userid":v
		},function(data){
			$("#adduser").show();
			$("#adduser").html(data).show();
		});
	}
	
	function hiden(){
		$("#adduser").hide();//hide()函数,实现隐藏,括号里还可以带一个时间参数(毫秒)例如hide(2000)以2000毫秒的速度隐藏,还可以带slow,fast
	}
	
	function toPage(p){
		var total = ${data.total};
		if(p<=0||p>total){
			return;
		}
  		document.frm.action="user/userlist.do";
  		document.getElementById("pag").value = p;
		document.frm.submit();
  	}
  	
  		function submitForm(){
  		document.frm.action="user/userlist.do";
  		document.getElementById("pag").value = 0;
		document.frm.submit();
  	}
	</script>

  </head>
  
  <body>
 <form name="frm" action="" method="get">
 
 <div class="tai_right" id="tai_right">
    	<table width="100%" class="table_da">
    	<tr></tr>
          <tr class="back_tit">
            <td style="width:15%;">编号</td>
            <td style="width:10%;">用户名</td>
            <td style="width:10%;">姓名</td>
            <td style="width:10%;">性别</td>
            <td style="width:25%;">描述</td>
            <td style="width:20%;"><a href="javascript:void(0)" onclick="adduser()"><font color="#fc7305"><b>添加</b></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作</td>
          </tr>
            <c:forEach items="${data.objs}" var="o" varStatus="status">
		    <tr class="hang01"><td>
		    ${status.count}
		    </td><td>
		    ${o.username }
		    </td><td>
		    ${o.name }
		    </td>
		    <td>
		   ${o.sex }
		    </td><td style="text-align:left; line-height:25px; padding:0 7px;">
		    &nbsp;${o.description }
		    </td><td class="w_190">
		    <input type="button" class="gaic" value="修改" onclick="updaterole('${o.userid }')"/>
		    <input type="button" class="gaic" value="删除" onclick="window.location.href='<%=path %>/user/delete.do?userid=${o.userid }'"/>
		    <%-- <a href="user/delete.do?userid=${o.userid }">
		    </a> --%>
		    </td></tr>
		    </c:forEach>
        </table><br>
				<table border=0 align="center" width="90%">
		        <tr><td width="50%">
		        每页显示      <select name="pagesize" style="font-size:18px;70px;height:25px;"onChange="javascript:submitForm(${data.pag});">
		        	<option value="10" <c:if test="${data.pagesize==10 }">selected</c:if>>10</option>
		        	<option value="20" <c:if test="${data.pagesize==20 }">selected</c:if>>20</option>
		        	<option value="50" <c:if test="${data.pagesize==50 }">selected</c:if>>50</option>
		        	<option value="100" <c:if test="${data.pagesize==100 }">selected</c:if>>100</option>
		        </select></td><td width="50%" align="right">
		   <a href="javascript:toPage(${data.pag-1 });" class="gaic" >上一页</a>&nbsp;&nbsp;
		   <a href="javascript:toPage(${data.pag+1 });" class="gaic" >下一页</a>
		&nbsp;第<font color="red">${data.pag}<font><font color="black">页&nbsp;共${data.total }页</font>&nbsp;&nbsp;
        </td></tr>
        
        </table>
          <input type="hidden" name="pag"  id="pag"  value="${data.pag}">
    </div>
   </form>
	<div id="adduser" style="position:absolute;top:150px;left: 200px;"></div>
  </body>
</html>