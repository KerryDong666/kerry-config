package com.kerry.config.server;

import com.kerry.config.server.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ConfigServerApplication {

	@Autowired
	private AppService appService;

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@RequestMapping("findAll")
	public List<AppBaseInfo> get(){
		return appService.findAll();
	}


}
