package com.risc.hackaton_capes_backend.common;

import java.util.Locale;

public class Utils {

	private Utils() {
	}

	public static String transformUpper(String str) {
		Locale locale = new Locale("pt");
		String result = str.trim();
		result = result.toUpperCase(locale);

		return result;
	}
}
