package com.kerry.config.client.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kerry dong
 * @date 2019/3/18
 */
@Configuration
public class AppConfigBootstrapConfiguration {

	@Bean
	public AppPropertySourceLocator myPropertySourceLocator(){
		return new AppPropertySourceLocator();
	}
}
