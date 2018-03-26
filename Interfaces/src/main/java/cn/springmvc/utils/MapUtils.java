package cn.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	public static Map<String, Object> covertStringToMp(String params, String regx) {
		Map<String, Object> paramsMp = null;
		if (params != null) {
			paramsMp = new HashMap<String, Object>();
			String[] strp = params.split(regx);
			for (int i = 0; i < strp.length; i++) {
				String singleparms = strp[i];
				String[] key_values = singleparms.split("=");
				paramsMp.put(key_values[0], key_values[1]);
			}
		}
		return paramsMp;
	}

	public static Map<String, Object> covertStringToMp(String params) {
		return covertStringToMp(params, ";");
	}

}
