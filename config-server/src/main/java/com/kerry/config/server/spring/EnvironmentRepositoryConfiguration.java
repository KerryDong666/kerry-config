package com.kerry.config.server.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@Configuration
public class EnvironmentRepositoryConfiguration {

	class Maker{}

	@Bean
	public Maker enableEnvironmentRepositoryConfigurationMaker(){
		return new Maker();
	}


}
