<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
	DD_belatedPNG.fix('div, ul, img, li, input,p,ul,ol,h1,h2,h3,a,span,i'); 
		var aa=false,bb=false,dd=false,ee=false,ff=false,gg=false,ee=false;
		function checkdulname(a){
			if(a.length>0){
				aa=true;
				$("#checkname_error").html("");
				$.post("user/checkname.do",{
					"username":a
				},function(data){
					if(data=="Y"){
						bb=true;
					}else{
						$("#checkname_error").html("<font color=red>用户名已存在！</font>");
						bb=false;
					}
				});
			}else{
				$("#checkname_error").html("<font color=red>请填写用户名！</font>");
				aa=false;
			}
		}
		function checknotnullb(e){
			if(e.length>0){
				$("#passwordb_error").html("");
				ee=true;
			}else{
				$("#passwordb_error").html("<font color=red>请填写工号！</font>");	
				ee=false;		
			}
		}
		function checknotnull3(e){
			if(e.length>0){
				$("#usersname_error").html("");
				dd=true;
			}else{
				$("#usersname_error").html("<font color=red>请填写姓名！</font>");
				dd=false;
			}
		}
		function checknotnull4(e){
			if(e.length>0){
				$("#usersex_error").html("");
				ee=true;
			}else{
				$("#usersex_error").html("<font color=red>请填写性别！</font>");
				ee=false;
			}
		}
		
		function checknotnull5(e){
			if(e.length>0){
				$("#useraddr_error").html("");
				ff=true;
			}else{
				$("#useraddr_error").html("<font color=red>请填写地址！</font>");
				ff=false;
			}
		}
		function checknotnull6(e){
			if(e.length>0){
				$("#description_error").html("");
				gg=true;
			}else{
				$("#description_error").html("<font color=red>请填写描述！</font>");
				gg=false;
			}
		}
		
		function checkishospital(a){
			if(a=='5c758bb3-87b2-4f5e-93b8-412e42288bff'){
				document.getElementById("hospitals").style.display='block';
			}else{
				document.getElementById("hospitals").style.display='none';
			}
		}
		
		function ccc(){
			if(aa&&bb&&dd&&ee&&gg&&ff){
				return true;
			}else{
				alert("数据填写不合法！");
				return false;
			}
		}
	</script>
<div id="tanchuk">
  <div class="tan_top"></div>
  <div class="tan_main">
  <form action="user/edituser.do" method="post">
  	<input type="hidden" name="userid" value="${data.user.userid }">
	<table class="tck" width="213" border="0" cellspacing="0" cellpadding="0">
		<tr bgcolor=white><td align=right>工&nbsp;&nbsp;号：</td><td>
		<input name="bianhao" class="text_yhm" value="${data.user.bianhao }" onblur="checknotnullb(this.value)"/><span id="passwordb_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right class="tc_w108">用户名：</td><td>
		<input class="text_yhm" name="username" value="${data.user.username }" onblur="checkdulname(this.value)" /><span id="checkname_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right class="tc_w108">密&nbsp;&nbsp;码：</td><td>
		<input class="text_yhm" name="password" value="${data.user.password }" onblur="checkdulname(this.value)" /><span id="checkname_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right>姓&nbsp;&nbsp;名：</td><td>
		<input name="name" class="text_yhm" value="${data.user.name }" onblur="checknotnull3(this.value)"/><span id="usersname_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right>性&nbsp;&nbsp;别：</td><td>
		<input name="sex" class="text_yhm" value="${data.user.sex }" onblur="checknotnull4(this.value)"/><span id="usersex_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right>地&nbsp;&nbsp;址：</td><td>
		<input name="addr" class="text_yhm" value="${data.user.addr }" onblur="checknotnull5(this.value)"/><span id="useraddr_error"></span>
		</td></tr>
		<tr bgcolor=white><td align=right>描&nbsp;&nbsp;述：</td><td>
		<input name="description" class="text_yhm" value="${data.user.description }" onblur="checknotnull6(this.value)"/><span id="description_error"></span>
		</td></tr>
		
		<tr bgcolor=white><td align=right>角&nbsp;&nbsp;色：</td><td>
		<select name="roleid" onchange="checkishospital(this.value)">
			<c:forEach items="${data.objs}" var="r">
				<option value="${r.roleid }" ${r.roleid==data.user.roleid?"selected":"" }>${r.rolename }</option>
			</c:forEach>
		</select><select name="hospitalId" id="hospitals" style="display: none;">
			<c:forEach items="${data.hospitals}" var="r">
				<option value="${r.id }" ${r.id==data.user.hospitalId?"selected":"" }>${r.name }</option>
			</c:forEach></select><br>
		
		</td></tr>
		<tr bgcolor=white><td colspan="2" align=center>
			<input type="submit" value="确定" class="queren"/><input type="button" value="取消" class="quxiao" onclick="hiden()"/>
		</td></tr>
	</table>
</form>
</div>
<div class="tan_bottom"></div>
</div>
