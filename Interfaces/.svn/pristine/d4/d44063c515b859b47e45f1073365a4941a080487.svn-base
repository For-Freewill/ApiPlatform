package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;

import cn.springmvc.model.Function;
import cn.springmvc.model.Role;


public interface IRoleService {
	
	public String checkname(String rolename);
	public Map<String,Object> rolelist(Integer pag,Integer pagesize) ;
	public int delete(String roleid);
	public List<Function> toaddrole();
	public int addrole(@ModelAttribute("role")Role role,String aaa);
	public Map<String,Object> toupdaterole(String roleid);
	public int updaterole(@ModelAttribute("role")Role role,String aaa);
}
