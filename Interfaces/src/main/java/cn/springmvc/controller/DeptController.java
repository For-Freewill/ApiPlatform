package cn.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.model.Dept;
import cn.springmvc.model.Function;
import cn.springmvc.service.IDeptService;


@Controller
@RequestMapping(value = "/dept")
public class DeptController {

	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping(value = "/deptlist.do")
	public String deptlist(Integer pag,Integer pagesize) {
		request.setAttribute("data", deptService.deptlist(pag,pagesize));
		return "dept/deptList";
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(String deptId){
		deptService.delete(deptId);
		return "redirect:deptlist.do";
	}
	
	@RequestMapping(value = "/toaddDept.do")
	public String toaddDept(){
		//request.setAttribute("objs", funcService.toaddfunc());
		return "dept/addDept";
	}
	
	
	@RequestMapping(value = "/addDept.do")
	public String addDept(Dept dept) {
		deptService.add(dept);
		return "redirect:deptlist.do";
	}
	
	
	@RequestMapping(value = "/toupdate.do")
	public String toupdate(String deptId){
		request.setAttribute("data", deptService.getDeptById(deptId));
		return "dept/updateDept";
	}

	@RequestMapping(value = "/update.do")
	public String update(Dept dept){
		deptService.update(dept);
		//页面从新加载刷新
		return "redirect:deptlist.do";
	}
}
