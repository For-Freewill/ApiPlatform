package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.Function;


public interface IFunctionService {
	
	
	public Map<String,Object> functionlist(Integer pag,Integer pagesize);
	public int addfunc(Function func);
	public List<Function> toaddfunc();
	public Map<String,Object> toupdatefunc(String funcid);
	public int updatefunc(Function func);
	public int delete(String funcid);
	public String checkname(String funcname);
}
