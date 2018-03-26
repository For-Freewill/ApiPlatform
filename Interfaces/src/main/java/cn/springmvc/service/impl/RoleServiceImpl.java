package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.FuncroleMapper;
import cn.springmvc.dao.FunctionMapper;
import cn.springmvc.dao.RoleMapper;
import cn.springmvc.model.Dept;
import cn.springmvc.model.Funcrole;
import cn.springmvc.model.FuncroleCriteria;
import cn.springmvc.model.Function;
import cn.springmvc.model.FunctionCriteria;
import cn.springmvc.model.Role;
import cn.springmvc.model.RoleCriteria;
import cn.springmvc.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper rolemapper;

	@Autowired
	private FunctionMapper funcmapper;

	@Autowired
	private FuncroleMapper funcrolemapper;

	public int addrole(Role role, String aaa) {
		role.setRoleid(UUID.randomUUID().toString());
		rolemapper.insert(role);
		RoleCriteria example = new RoleCriteria();
		example.createCriteria().andRolenameEqualTo(role.getRolename())
				.andDescriptionEqualTo(role.getDescription());
		List<Role> roles = rolemapper.selectByExample(example);
		role = roles.get(0);
		String[] bbb = {};
		if (aaa != null && !aaa.equals("")) {
			if (aaa.length() > 0) {
				if (aaa.contains(",")) {
					bbb = aaa.split(",");
				} else {
					if (!aaa.contains(",")) {
						bbb[0] = aaa;
					}
				}
			}
		}
		if (bbb != null && bbb.length > 0) {
			for (String i : bbb) {
				Funcrole fr = new Funcrole();
				fr.setFuncroleid(UUID.randomUUID().toString());
				fr.setFuncid(i);
				fr.setRoleid(role.getRoleid());
				funcrolemapper.insert(fr);
			}
		}
		return 0;
	}

	public String checkname(String rolename) {
		RoleCriteria criteria = new RoleCriteria();
		criteria.createCriteria().andRolenameEqualTo(rolename);
		List<Role> objs = rolemapper.selectByExample(criteria);
		String s = "";
		if (objs.size() > 0) {
			s = "N";
		} else {
			s = "Y";
		}
		return s;
	}

	public int delete(String roleid) {
		return rolemapper.deleteByPrimaryKey(roleid);
	}

	public Map<String, Object> rolelist(Integer pag, Integer pagesize) {
		if(pag==null){
			pag=1;	
		}
		if (pagesize == null || pagesize == 0) {
			pagesize = 10;
		}
		 PageHelper.startPage(pag, pagesize);
		RoleCriteria example = new RoleCriteria();
		example.createCriteria();
		List<Role> roles = rolemapper.selectByExample(example);
		PageInfo<Role> pageInfo = new PageInfo<Role>(roles);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("roles", pageInfo.getList());
		data.put("total", pageInfo.getPages());
		data.put("pag", pageInfo.getPageNum());
		data.put("pagesize", pageInfo.getPageSize());
		return data;
	}

	public List<Function> toaddrole() {
		FunctionCriteria example = new FunctionCriteria();
		example.createCriteria();
		List<Function> objs = funcmapper.selectByExample(example);
		return objs;
	}

	public Map<String, Object> toupdaterole(String roleid) {
		Map<String, Object> data = new HashMap<String, Object>();
		FunctionCriteria example = new FunctionCriteria();
		example.createCriteria();
		List<Function> objs = funcmapper.selectByExample(example);
		Role role = (Role) rolemapper.selectByPrimaryKey(roleid);
		FuncroleCriteria example1 = new FuncroleCriteria();
		example1.createCriteria().andRoleidEqualTo(role.getRoleid());
		List<Funcrole> funs = funcrolemapper.selectByExample(example1);
		data.put("role", role);
		data.put("objs", objs);
		data.put("funs", funs);
		return data;
	}

	public int updaterole(Role role, String aaa) {
		Role oldrole = (Role) rolemapper.selectByPrimaryKey(role.getRoleid());
		String[] bbb = {};
		if (aaa != null && !aaa.equals("")) {
			if (aaa.length() > 0) {
				if (aaa.contains(",")) {
					bbb = aaa.split(",");
				} else {
					if (!aaa.contains(",")) {
						bbb[0] = aaa;
					}
				}
			}
		}
		oldrole.setDescription(role.getDescription());
		oldrole.setRolename(role.getRolename());
		FuncroleCriteria example = new FuncroleCriteria();
		example.createCriteria().andRoleidEqualTo(oldrole.getRoleid());
		List<Funcrole> objs = funcrolemapper.selectByExample(example);
		for (Funcrole o : objs) {
			funcrolemapper.deleteByPrimaryKey(o.getFuncroleid());
		}
		if (bbb != null && bbb.length > 0) {
			for (String i : bbb) {
				Funcrole fr = new Funcrole();
				fr.setFuncroleid(UUID.randomUUID().toString());
				fr.setFuncid(i);
				fr.setRoleid(oldrole.getRoleid());
				funcrolemapper.insert(fr);
			}
		}
		rolemapper.updateByPrimaryKey(oldrole);
		return 0;
	}
}