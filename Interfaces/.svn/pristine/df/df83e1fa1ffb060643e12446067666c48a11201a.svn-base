package cn.springmvc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.springmvc.model.Dept;

public class DeptCache {
	
	private static Map<String,Dept> map =new HashMap<String,Dept>();
	
	public static void addCache(Dept dept){
		map.put(dept.getDeptid(), dept);
	}
	
	public static Dept get(String key){
		if(map.containsKey(key)){
			return  map.get(key);
		}
		return null;
	}
	
	public static void removeCache(String key){
		if(map.containsKey(key)){
			map.remove(key);
		}
	}
	
	public static List<Dept> getAllDept() {
		List<Dept> list = new ArrayList<Dept>();
		Set<String> set = map.keySet();
		for (String key : set) {
			list.add(map.get(key));
		}
		return list;
	}
	
	

}
