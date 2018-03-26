package cn.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testng.collections.Lists;

import com.beust.testng.TestNG;

import cn.springmvc.dao.DeptMapper;
import cn.springmvc.model.TestCase;
import cn.springmvc.service.IDeptService;
import cn.springmvc.service.ITestCaseService;
import cn.springmvc.utils.DeptCache;;


@Controller
@RequestMapping(value = "/case")
public class TestCaseAction {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ITestCaseService testCaseService;
	
	@Autowired
	private IDeptService deptService;
	
//	@Autowired
//	private ApiTest apiTest;
	
	@RequestMapping(value = "/caselist.do")
	public String caselist(Integer pag,Integer pagesize) {
		request.setAttribute("data", testCaseService.caselist(pag,pagesize));
		return "case/caseList";
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(String caseId){
		testCaseService.delete(caseId);
		return "redirect:caselist.do";
	}
	
	@RequestMapping(value = "/toaddCase.do")
	public String toaddcase(){
		request.setAttribute("data", DeptCache.getAllDept());
		return "case/addCase";
	}
	
	
	@RequestMapping(value = "/addcase.do")
	public String addcase(TestCase testCase) {
		testCaseService.add(testCase);
		return "redirect:caselist.do";
	}
	
	
	@RequestMapping(value = "/toupdate.do")
	public String toupdate(String caseId){
		request.setAttribute("data", testCaseService.getById(caseId));
		request.setAttribute("deptData", DeptCache.getAllDept());
		return "case/updateCase";
	}

	@RequestMapping(value = "/update.do")
	public String update(TestCase testCase){
		testCaseService.update(testCase);
		//页面从新加载刷新
		return "redirect:caselist.do";
	}
}
