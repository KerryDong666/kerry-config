package com.kerry.config.client;

import com.kerry.config.core.util.HttpClient;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class ConfigClientApplication {

	//@Value("${db.url}")
	//private String url;
	//@Value("${db.port}")
	//private int port;
	//@Value("${db.username}")
	//private String username;

	@Value("${3333}")
	private String test;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ConfigClientApplication.class, args);
		ConfigClientApplication bean = context.getBean(ConfigClientApplication.class);
		//System.out.println(bean.url);
		//System.out.println(bean.port);
		System.out.println(bean.test);
		HttpClient instance = HttpClient.getInstance();
		Response response = instance.sendGetRequest("http://www.baidu.com");
		System.out.println(response.code());
	}

}
