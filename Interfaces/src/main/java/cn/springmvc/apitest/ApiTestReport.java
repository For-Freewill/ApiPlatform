package cn.springmvc.apitest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;

import cn.springmvc.dao.TestResultDetailMapper;
import cn.springmvc.dao.TestResultMapper;
import cn.springmvc.mail.MailSender;
import cn.springmvc.model.TestCase;
import cn.springmvc.model.TestResult;
import cn.springmvc.model.TestResultDetail;

public class ApiTestReport  implements ITestListener, IReporter {
    private List<TestResultDetail> testPassed = Lists.newArrayList();
    private List<TestResultDetail> testFailed = Lists.newArrayList();
    private List<ErrorReport> errorList = Lists.newArrayList();
    
    
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    	System.out.println(" generateReport-------------- ");
        System.out.println("Passed Case: " + testPassed.size());
        System.out.println("testFailed Case: " + testFailed.size());
        Date date = new Date();
        TestResult result = new TestResult();
        result.setRuntime(date);
        result.setSucess(testPassed.size());
        result.setFail(testFailed.size());
        TestResultMapper testResultMapper = SpringContextUtils.getBean(TestResultMapper.class);
        testResultMapper.insertSelective(result);
        TestResultDetailMapper testResultDetailMapper = SpringContextUtils.getBean(TestResultDetailMapper.class);
        
        
        testPassed.addAll(testFailed);
        for (TestResultDetail testResultDetail : testPassed) {
        	testResultDetail.setRuntime(date);
        	 try{
        	  testResultDetailMapper.insertSelective(testResultDetail);
            }catch(Exception ex){
        		ex.printStackTrace();
            }
		}
//        MailSender mailSender = SpringContextUtils.getBean(MailSender.class);
//        if(!testFailed.isEmpty()){
//         HashMap<String,Object> map = new HashMap<String,Object>();
//		 map.put("runtime", date);
//		 map.put("reportlist", errorList);
//		 mailSender.send(map,"error.ftl");
//        }

    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object o=  result.getParameters()[0];
        TestCase testCase =(TestCase)o; 
        long start = result.getStartMillis();
        long end = result.getEndMillis();
        TestResultDetail resultDetail = new TestResultDetail();
        resultDetail.setCaseid(testCase.getUuid());
        resultDetail.setResult("Y");
        resultDetail.setTaketime(end-start);
        resultDetail.setSystem(testCase.getSystem());
        testPassed.add(resultDetail);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object o=  result.getParameters()[0];
        TestCase testCase =(TestCase)o; 
        long start = result.getStartMillis();
        long end = result.getEndMillis();
        
        TestResultDetail resultDetail = new TestResultDetail();
        resultDetail.setCaseid(testCase.getUuid());
        resultDetail.setResult("N");
        resultDetail.setTaketime(end-start);
        resultDetail.setSystem(testCase.getSystem());
        String msg = result.getThrowable().getMessage();
        System.out.println(msg);
        resultDetail.setDetailmsg(msg);
        testFailed.add(resultDetail);
        ErrorReport error = new ErrorReport();
        error.setCaseName(testCase.getCasename());
        error.setUrl(testCase.getUrl());
        error.setMsg(msg);
        errorList.add(error);
        System.out.println(error);
        result.getThrowable();
    }
    
       

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}

