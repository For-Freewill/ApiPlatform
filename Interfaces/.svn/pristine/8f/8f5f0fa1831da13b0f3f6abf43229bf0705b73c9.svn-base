package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.TestResultMapper;
import cn.springmvc.model.TestResult;
import cn.springmvc.model.TestResultCriteria;
import cn.springmvc.service.ITestResultService;

@Service
public class TestResultServiceImpl implements ITestResultService {
	
	@Autowired
	TestResultMapper testResultMapper;
	
	
	@Override
	public List<TestResult> getTestReuslt(int pagesize) {
		PageHelper.startPage(1, pagesize);
		TestResultCriteria example = new TestResultCriteria();
		example.setOrderByClause("runtime desc");
		List<TestResult> list = testResultMapper.selectByExample(example);
		PageInfo<TestResult> pageInfo = new PageInfo<TestResult>(list);
		List<TestResult> pagelist = pageInfo.getList();
		return pagelist;
	}
}
