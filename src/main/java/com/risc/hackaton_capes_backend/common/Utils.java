package com.risc.hackaton_capes_backend.common;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class Utils {

	private Utils() {
	}

	public static String transformUpper(String str) {
		Locale locale = new Locale("pt");
		String result = str.trim();
		result = result.toUpperCase(locale);

		return result;
	}

	public static String transformLower(String str) {
		Locale locale = new Locale("pt");
		String result = str.trim();
		result = result.toLowerCase(locale);

		return result;
	}

	public static String transformTextToCamel(String str) {
		if (StringUtils.isBlank(str))
			return str;
		
		String result = "";
		boolean init = true;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (init) {
				result = result + c;
				init = false;
			} else if (c == ' ') {
				result = result + ' ';
				init = true;
			} else {
				result = result + Character.toLowerCase(c);
			}
		}

		return result;
	}
}
