package cn.springmvc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.springmvc.model.TestCase;




public class PatternUtils {
	
	
	private static Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");
	
	public static void matcher(TestCase bean){
		    Matcher matcher = replaceParamPattern.matcher(bean.getUrl());
	        while (matcher.find()) {
	        	System.out.println(matcher.group());
	        	System.out.println("----------");
	        	System.out.println(matcher.group(1));
	        	
	        	String value = SaveParamsUtils.get(matcher.group(1)).toString();
	        	System.out.println("---"+value);
	        	String newUrl = bean.getUrl().replace(matcher.group(), value);
	        	System.out.println(newUrl);
	        	bean.setUrl(newUrl);
	        }
	}
}
