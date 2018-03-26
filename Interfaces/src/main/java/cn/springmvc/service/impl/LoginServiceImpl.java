package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.FuncroleMapper;
import cn.springmvc.dao.FunctionMapper;
import cn.springmvc.dao.RoleMapper;
import cn.springmvc.dao.UserMapper;
import cn.springmvc.model.Funcrole;
import cn.springmvc.model.FuncroleCriteria;
import cn.springmvc.model.Function;
import cn.springmvc.model.FunctionCriteria;
import cn.springmvc.model.Role;
import cn.springmvc.model.RoleCriteria;
import cn.springmvc.model.User;
import cn.springmvc.model.UserCriteria;
import cn.springmvc.service.ILoginService;
import cn.springmvc.utils.MD5CryptUtil;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private FunctionMapper funcMapper;
	
	@Autowired
	private FuncroleMapper funcroleMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	

	@Override
	public String checkUser(HttpServletRequest request, User user) {
		UserCriteria example=new UserCriteria();
		String password = user.getPassword();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		List<User> objs=userMapper.selectByExample(example);
		if(objs.size()>0){
			User dbUser  = objs.get(0);
			String mysalt=MD5CryptUtil.getSalts(dbUser.getPassword());
			String pas=Md5Crypt.md5Crypt(password.getBytes(),mysalt);
			if(!pas.equals(dbUser.getPassword())){
				request.setAttribute("error", "密码错误!");
				return "index";
			}else{
				request.getSession().setAttribute("user", dbUser);
				RoleCriteria r=new RoleCriteria();
				r.createCriteria().andRoleidEqualTo(dbUser.getRoleid());
				List<Role> roles=roleMapper.selectByExample(r);
				if(roles.size()>0){
					request.getSession().setAttribute("sessionrole", roles.get(0));
				}
				return "main";
			}
		}else{
			request.setAttribute("error", "用户不存在!");
			return "index";
		}
	}
	
	@Override
	public void loginout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
	}

	
	public List<Function> mune(HttpServletRequest request) {
		List<Function> parentList = new ArrayList<Function>();
		User user=(User)request.getSession().getAttribute("user");
		FuncroleCriteria example=new FuncroleCriteria();
		example.createCriteria().andRoleidEqualTo(user.getRoleid());
		List<Funcrole> objs1=funcroleMapper.selectByExample(example);
		FunctionCriteria example1=new FunctionCriteria();
		example1.setOrderByClause("func_order");
		List<Function> objs2 = funcMapper.selectByExample(example1);
		for(Function f:objs2){
			for(Funcrole o:objs1){
				if(o.getFuncid().equals(f.getFuncid())){
					parentList.add(f);
				}
			}
		} 
		return parentList;
	}
	
	

}
