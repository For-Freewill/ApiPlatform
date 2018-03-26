package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Role;
import cn.springmvc.service.IRoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

	/**
	 * Controller Method
	 */

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private HttpServletRequest request;

	public RoleController(){}
	
	@RequestMapping(value = "/checkname.do")
	@ResponseBody
	public String checkname(String rolename){
		return roleService.checkname(rolename);
	}
	
	@RequestMapping(value = "/rolelist.do")
	public String rolelist(Integer pag,Integer pagesize) {
		request.setAttribute("data", roleService.rolelist(pag,pagesize));
		return "role/RoleList";
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(String roleid){
		roleService.delete(roleid);
		return "redirect:rolelist.do";
	}
	
	@RequestMapping(value = "/toaddrole.do")
	public String toaddrole(){
		request.setAttribute("objs", roleService.toaddrole());
		return "role/addrole";
	}
	
	@RequestMapping(value = "/addrole.do")
	public String addrole(@ModelAttribute("role")Role role,String aaa){
		roleService.addrole(role, aaa);
		return "redirect:rolelist.do";
	}
	
	@RequestMapping(value = "/toupdaterole.do")
	public String toupdaterole(String roleid){
		request.setAttribute("data", roleService.toupdaterole(roleid));
		return "role/updaterole";
	}
	
	@RequestMapping(value = "/updaterole.do")
	public String updaterole(@ModelAttribute("role")Role role,String aaa){
		roleService.updaterole(role, aaa);
		return "redirect:rolelist.do";
	}	
	
	
}
