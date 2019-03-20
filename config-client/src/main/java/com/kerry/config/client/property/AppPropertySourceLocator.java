package com.kerry.config.client.property;

import com.alibaba.fastjson.JSONObject;
import com.kerry.config.client.util.EnvUtil;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.Set;

/**
 * @author kerry dong
 * @date 2019/3/18
 */
public class AppPropertySourceLocator implements PropertySourceLocator {

	@Override
	public PropertySource<?> locate(Environment environment) {

		// 获取配置中心地址
		String url = environment.getProperty("spring.cloud.config.uri");

		// 获取应用名
		String applicationName = EnvUtil.getApplicationName(environment);
		// 应用运行环境
		String appMode = System.getenv("ENV_TYPE");

		//String s = HttpClient.sendGetRequest("https://www.baidu.com");

		// 远程拉取配置
		JSONObject properties = new JSONObject();
		properties.put("1111", "1111");
		properties.put("2222", "2222");
		properties.put("3333", "4444");
		properties.put("name", "huqing");
		// 判断本地是否有相同的key,如果有用本地覆盖远程配置
		Set<String> keySet = properties.keySet();
		keySet.stream().forEach(k -> {
			String property = environment.getProperty(k);
			if (property != null) {
				properties.put(k, property);
			}
		});
		AppPropertySource appPropertySource = new AppPropertySource("appPropertySource", properties);
		return appPropertySource;
	}

	public static void main(String[] args) {
		String java_home = System.getProperty("HADOOP_HOME");
		System.out.println(java_home);
		//String java_home1 = System.getenv("JAVA_HOME");
		//System.out.println(java_home1);
	}
}
