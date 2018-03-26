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
import cn.springmvc.model.Dept;
import cn.springmvc.model.DeptCriteria;
import cn.springmvc.service.IDeptService;
import cn.springmvc.utils.DeptCache;

@Service
public class DeptServiceImp implements IDeptService{
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public Map<String, Object> deptlist(Integer pag, Integer pagesize) {
		
		if(pag==null){
			pag=1;
		}
		if(pagesize==null||pagesize==0){
			pagesize=10;
		}
		Map<String, Object> data=new HashMap<String, Object>();
		
		
	    PageHelper.startPage(pag, pagesize);
	    DeptCriteria example=new DeptCriteria();
		List<Dept> list=deptMapper.selectByExample(example);
	    PageInfo<Dept> pageInfo = new PageInfo<Dept>(list);
		
		data.put("objs", pageInfo.getList());
		data.put("pag", pageInfo.getPageNum());
		data.put("total", pageInfo.getPages());
		data.put("pagesize", pageInfo.getPageSize());
		return data;
	}

	@Override
	public void delete(String deptId) {
		deptMapper.deleteByPrimaryKey(deptId);
		DeptCache.removeCache(deptId);
	}

	@Override
	public void add(Dept dept) {
		dept.setDeptid(UUID.randomUUID().toString());
		deptMapper.insert(dept);
		DeptCache.addCache(dept);
	}

	@Override
	public Dept getDeptById(String deptId) {
		return deptMapper.selectByPrimaryKey(deptId);
	}

	@Override
	public int update(Dept dept) {
		DeptCache.removeCache(dept.getDeptid());
		DeptCache.addCache(dept);
		return deptMapper.updateByPrimaryKeySelective(dept);
	}

	@Override
	public List<Dept> getAllDept() {
		DeptCriteria dept = new DeptCriteria();
		List<Dept> deptList = deptMapper.selectByExample(dept);
		return  deptList;
	}

}
