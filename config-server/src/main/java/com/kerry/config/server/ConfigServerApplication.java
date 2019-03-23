package com.kerry.config.server;

import com.kerry.config.server.dao.AppServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigServerApplication {

	@Autowired
	private AppServiceDao appService;

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}


}
