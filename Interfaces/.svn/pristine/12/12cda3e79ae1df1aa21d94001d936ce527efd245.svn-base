package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.DeptMapper;
import cn.springmvc.dao.RoleMapper;
import cn.springmvc.dao.UserMapper;
import cn.springmvc.model.Dept;
import cn.springmvc.model.DeptCriteria;
import cn.springmvc.model.Role;
import cn.springmvc.model.RoleCriteria;
import cn.springmvc.model.User;
import cn.springmvc.model.UserCriteria;
import cn.springmvc.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper usermapper;

	@Autowired
	private DeptMapper deptmapper;

	@Autowired
	private RoleMapper rolemapper;
	
	
	public int adduser(User user) {
		if(user==null){
		user.setUserid(UUID.randomUUID().toString());
		}
		user.setPassword(Md5Crypt.md5Crypt(user.getPassword().getBytes()));
		return usermapper.insert(user);
	}

	public String checkname(String username) {
		UserCriteria example = new UserCriteria();
		example.createCriteria().andUsernameLike(username);
		List<User> objs = usermapper.selectByExample(example);
		String s = "";
		if (objs != null && objs.size() > 0) {
			s = "N";
		} else {
			s = "Y";
		}
		return s;
	}

	public int delete(String userid) {
		return usermapper.deleteByPrimaryKey(userid);
	}


	public Map<String, Object> toedituser(String userid) {
		Map<String, Object> data = new HashMap<String, Object>();
		if(userid!=null&&userid.length()>0){
			User user = usermapper.selectByPrimaryKey(userid);
			data.put("user", user);
		}

		RoleCriteria rexample = new RoleCriteria();
		rexample.createCriteria();
		List<Role> objs = rolemapper.selectByExample(rexample);
		data.put("objs", objs);
		//data.put("depts", depts);
		
		return data;
	}

	public int updateuser(User user) {
		User olduser = usermapper.selectByPrimaryKey(user.getUserid());
		olduser.setAddr(user.getAddr());
		olduser.setDescription(user.getDescription());
		olduser.setName(user.getName());
		olduser.setRoleid(user.getRoleid());
		olduser.setSex(user.getSex());
		olduser.setUsername(user.getUsername());
		//olduser.setDeptid(user.getDeptid());
		olduser.setBianhao(user.getBianhao());
		olduser.setPassword(Md5Crypt.md5Crypt(user.getPassword().getBytes()));
		return usermapper.updateByPrimaryKey(olduser);
	}

	public Map<String, Object> userlist(Integer pag, Integer pagesize) {
		if(pag==null){
			pag=1;	
		}
		if (pagesize == null || pagesize == 0) {
			pagesize = 10;
		}
		
		PageHelper.startPage(pag, pagesize);
		UserCriteria example = new UserCriteria();
		List<User> objs=usermapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<User>(objs);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("objs", pageInfo.getList());
		data.put("total", pageInfo.getPages());
		data.put("pag", pageInfo.getPageNum());
		data.put("pagesize", pageInfo.getPageSize());
		return data;
	}

	@Override
	public User getUser(String userid) {
		return usermapper.selectByPrimaryKey(userid);
	}


	
	
	
	
	

}
