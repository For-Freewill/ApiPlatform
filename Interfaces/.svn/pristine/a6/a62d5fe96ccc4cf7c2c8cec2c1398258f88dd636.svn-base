package cn.springmvc.test;


import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.DeptMapper;
import cn.springmvc.model.Dept;
import cn.springmvc.model.DeptCriteria;


public class UserTest {
	private DeptMapper admimMapper;

	@Before
    public void before(){                                                                    
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        admimMapper = (DeptMapper) context.getBean(DeptMapper.class);
    }
     
    @Test
    public void addUser(){
    	 System.out.println("addUser---------------");
    	 PageHelper.startPage(1, 2);
    	 DeptCriteria example = new DeptCriteria();
    	 List<Dept> list = admimMapper.selectByExample(example);
    	 PageInfo<Dept> pageInfo = new PageInfo<Dept>(list);
    	 System.out.println(pageInfo.getList());
         
    }
    
}
