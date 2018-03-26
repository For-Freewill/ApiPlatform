package cn.springmvc.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.springmvc.model.Dept;
import cn.springmvc.service.IDeptService;
import cn.springmvc.utils.DeptCache;

public class CacheLilter implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		IDeptService deptService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(IDeptService.class);
		List<Dept> deptList = deptService.getAllDept();
		for (Dept dept : deptList) {
			DeptCache.addCache(dept);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
