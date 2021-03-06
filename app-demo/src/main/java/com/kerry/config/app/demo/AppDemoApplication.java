package com.kerry.config.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.kerry.config")
public class AppDemoApplication {

	//@Value("${name}")
	//private String name;
	//
	//@Value("${price}")
	//private String price;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppDemoApplication.class, args);
		AppDemoApplication bean = context.getBean(AppDemoApplication.class);
		//System.out.println(bean.price);
	}

	@RequestMapping("/get")
	public String test(){
		return "success";
	}

}
