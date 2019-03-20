package com.kerry.config.client.util;

import org.springframework.core.env.Environment;

/**
 * @author kerry dong
 * @date 2019/3/18
 */
public class EnvUtil {

	private Environment environment;

	private static final String TEST_MODE = "test";
	private static final String PRE_MODE = "pre";
	private static final String PRD_MODE = "prd";
	private static final String APP_MODE_KEY = "ENV_TYPE";

	private static final String APPLICATION_NAME_KEY = "spring.application.name";

	public static String getApplicationName(Environment environment){
		String appName = environment.getProperty(APPLICATION_NAME_KEY);
		return appName;
	}

}
