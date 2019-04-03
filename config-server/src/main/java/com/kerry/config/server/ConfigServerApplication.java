package com.kerry.config.server;

import com.kerry.config.core.util.BaseResult;
import com.kerry.config.server.dao.AppServerDao;
import com.kerry.config.server.service.AppServerService;
import com.kerry.config.server.spring.CustomerEnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微服务配置中心服务端starter
 * @author kerry dong
 */
@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigServerApplication {

	@Autowired
	AppServerDao appServerDao;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ConfigServerApplication.class, args);
		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment);
		CustomerEnvironmentRepository bean = context.getBean(CustomerEnvironmentRepository.class);
		System.out.println(bean);
		Environment one = bean.findOne("order", "test", "master");
		System.out.println(one);
	}

	@Autowired
	private AppServerService appServerService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public BaseResult test(){
		appServerDao.queryById(100L);
		return appServerService.queryById(100L);
	}

}
