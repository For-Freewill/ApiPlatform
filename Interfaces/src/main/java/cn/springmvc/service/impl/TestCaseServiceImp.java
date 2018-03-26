package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.DeptMapper;
import cn.springmvc.dao.TestCaseMapper;
import cn.springmvc.model.Dept;
import cn.springmvc.model.DeptCriteria;
import cn.springmvc.model.TestCase;
import cn.springmvc.model.TestCaseCriteria;
import cn.springmvc.service.ITestCaseService;

@Service
public class TestCaseServiceImp implements ITestCaseService{
	
	@Autowired
	private TestCaseMapper testCaseMapper;
	
	@Autowired
	DeptMapper deptMapper;

	@Override
	public Map<String, Object> caselist(Integer pag, Integer pagesize) {
		if(pag==null){
			pag=1;
		}
		if(pagesize==null||pagesize==0){
			pagesize=10;
		}
		Map<String, Object> data=new HashMap<String, Object>();
	    PageHelper.startPage(pag, pagesize);
	    TestCaseCriteria example=new TestCaseCriteria();
		List<TestCase> list=testCaseMapper.selectByExampleWithBLOBs(example);
	    PageInfo<TestCase> pageInfo = new PageInfo<TestCase>(list);
		
		data.put("objs", pageInfo.getList());
		data.put("pag", pageInfo.getPageNum());
		data.put("total", pageInfo.getPages());
		data.put("pagesize", pageInfo.getPageSize());
		return data;
	}

	@Override
	public void delete(String caseId) {
		testCaseMapper.deleteByPrimaryKey(caseId);
	}
	
	
	@Override
	public void add(TestCase testcase) {
		testcase.setUuid(UUID.randomUUID().toString());
		testCaseMapper.insert(testcase);
	}

	
	@Override
	public TestCase getById(String caseId) {
		return testCaseMapper.selectByPrimaryKey(caseId);
	}

	@Override
	public int update(TestCase testCase) {
		return testCaseMapper.updateByPrimaryKeySelective(testCase);
	}

}
