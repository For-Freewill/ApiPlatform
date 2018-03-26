package cn.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.aviator.AviatorEvaluator;
import com.jayway.jsonpath.JsonPath;

public class CheckPointUtils {
	
	public static boolean checkbyJsonPath(String json, String params) {
		if (params != null && !"".equals(params) && !"null".equals(params)) {
			String[] ps = params.split(";");
			for (String p : ps) {
				String[] values = p.split("=|>|<|>=|<=");
				//String totest = p.replace(values[0], "data");
				params = params.replace(values[0], "data");
				Map<String, Object> env = new HashMap<String, Object>();
				Object value = JsonPath.read(json, values[0]);
				if(value instanceof String) {
					System.out.println("----------"+ values[1]);
					params = params.replace(values[1], covertToAviatorString(values[1]));
					params = params.replace("=", "==");
				}
				env.put("data", value);
				System.out.println(" totest " + params + " value " + value);
				Boolean result = (Boolean) AviatorEvaluator.execute(params, env);
				return result;
			}
		}
		return true;
	}
	
	private static String covertToAviatorString(String value) {
		return "'"+value+"'";
	}

}
