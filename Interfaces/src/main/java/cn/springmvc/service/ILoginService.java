package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.springmvc.model.Function;
import cn.springmvc.model.User;

public interface ILoginService {
	
	public String checkUser(HttpServletRequest request,User user);
	
	public void loginout(HttpServletRequest request);
	
	
	public List<Function> mune(HttpServletRequest request);
	
	
	//public Map<String,List<Function>> munes(HttpServletRequest request);

}
