package cn.springmvc.apitest;


import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testng.TestNG;
import org.testng.collections.Lists;


@Component
public class ScheduledApiTest {
	
	//@Scheduled(cron = "0 0/5 * * * ?") //每天凌晨两点执行 (0 0 2 * * ?)
    void doSomethingWith(){
		System.out.println("doSomethingWith---------");
    	TestNG testng = new TestNG();
    	List suites = Lists.newArrayList();
    	String path = System.getProperty("Interfaces.root");
    	System.out.println(path);
    	suites.add(path+"/WEB-INF/classes/testng.xml");//path to xml..
    	testng.setTestSuites(suites);
    	testng.run();
   }
	
}
