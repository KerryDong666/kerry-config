package com.kerry.config.server.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.NativeEnvironmentProperties;
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository;
import org.springframework.cloud.config.server.environment.SearchPathLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@Configuration
@EnableConfigurationProperties({DbEnvironmentRepositoryProperties.class})
@Profile("db")
@ConditionalOnMissingBean(EnvironmentRepository.class)
public class EnvironmentRepositoryAutoConfiguration {

	public EnvironmentRepositoryAutoConfiguration(){
		System.out.println("----------init EnvironmentRepositoryAutoConfiguration---------");
	}

	@Autowired
	private ConfigurableEnvironment environment;

	@Bean
	public SearchPathLocator searchPathLocator() {
		System.out.println(environment);
		return new NativeEnvironmentRepository(environment, new NativeEnvironmentProperties());
	}



	/*
	 * Primary与Order都是用来控制当有多个相同bean的实现时，选择哪一个。
	 * @Primary告诉容器该实现的优先级最高，作用与@Order(Ordered.HIGHEST_PRECEDENCE)相同，二选一即可
	 * 值得注意的是，如果Spring Cloud版本是Edgware.RELEASE，使用@Primary启动会报错，此时可以使用Order，
	 * 两者都不用似乎也可以
	 */
	//@Primary
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	public EnvironmentRepository openEnvironmentRepository(DbEnvironmentRepositoryProperties properties) {
		return new CustomerEnvironmentRepository(properties);
	}
}
