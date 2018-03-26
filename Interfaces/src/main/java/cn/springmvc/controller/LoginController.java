package cn.springmvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Function;
import cn.springmvc.model.User;
import cn.springmvc.service.ILoginService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ILoginService loginService;
	
	
	
	
	@RequestMapping(value = "/login.do")
	public String login(User user){
		if(StringUtils.isEmpty(user.getUsername())){
			request.setAttribute("error", "用户名不能为空!");
			return "index";
		}
		
		if(StringUtils.isEmpty(user.getPassword())){
			request.setAttribute("error", "密码不能为空!");
			return "index";
		}
		String vCode = (String) request.getSession().getAttribute("verifycode");
		if(!user.getCode().equalsIgnoreCase(vCode)){
			request.setAttribute("error", "验证码错误!");
			return "index";
		}
		request.setAttribute("username", user.getUsername());
		return loginService.checkUser(request,user);
	}
	
	
	@RequestMapping(value = "/mune.do")
	public String mune(){
		request.setAttribute("objs", loginService.mune(request));
		//request.setAttribute("childrens", loginService.munes(request));
		return "mune";
	}
	
	
	@RequestMapping(value = "/loginout.do")
	public void loginout(HttpServletResponse response){
		loginService.loginout(request);
		 try {
				response.getWriter().write(
				            "<script>window.parent.location='"+request.getContextPath()+"/index.jsp';</script>");
				response.getWriter().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
