package cn.springmvc.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.User;
import cn.springmvc.service.IUserService;


@Controller
@RequestMapping(value = "/user")
public class UserController {


	@Autowired
	private IUserService usersService;

	@Autowired
	private HttpServletRequest request;

	public UserController() {
	}
	
	  @RequestMapping(value = "/addUser", method = RequestMethod.POST)  
	  @ResponseBody
	    public int addUserInfo(User user) {  
	        int result = usersService.adduser(user);  
	        return result;  
	    } 
	  
	@RequestMapping(value = "/checkName", method = RequestMethod.POST)
	@ResponseBody
	public User getUser(String id) {
		return usersService.getUser(id);
	}

	@RequestMapping(value = "/userlist.do")
	public String userlist(Integer pag, Integer pagesize) {
		request.setAttribute("data", usersService.userlist(pag, pagesize));
		return "user/UserList";
	}

	@RequestMapping(value = "/checkname.do")
	@ResponseBody
	public String checkname(String username) {
		return usersService.checkname(username);
	}

	@RequestMapping(value = "/toedituser.do")
	public String toadduser(String userid) {
		request.setAttribute("data", usersService.toedituser(userid));
		request.setAttribute("test", "123");
		return "user/edituser";
	}


	@RequestMapping(value = "/edituser.do")
	public String updateuser(@ModelAttribute("user") User user) {
		if(user!=null&&user.getUserid()!=null&&user.getUserid().length()>0){
			user.setStatus(1);
			usersService.updateuser(user);
		}else{
			user.setStatus(1);
			usersService.adduser(user);
		}
		return "redirect:userlist.do";
	}

	@RequestMapping(value = "/delete.do")
	public String delete(String userid) {
		usersService.delete(userid);
		return "redirect:userlist.do";
	}	
}
