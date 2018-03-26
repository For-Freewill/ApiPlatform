package cn.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.TestResult;
import cn.springmvc.service.ITestResultService;

@Controller
@RequestMapping(value = "/report")
public class TestResultAction {
	
	@Autowired
	ITestResultService reportService;
	
	@ResponseBody
	@RequestMapping(value = "/result.do")
	public List<TestResult> getTestReulst(int pageSize){
		return reportService.getTestReuslt(pageSize);
	}

}
