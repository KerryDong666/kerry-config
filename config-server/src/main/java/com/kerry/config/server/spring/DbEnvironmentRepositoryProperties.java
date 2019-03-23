package com.kerry.config.server.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.server.support.EnvironmentRepositoryProperties;
import org.springframework.core.Ordered;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@ConfigurationProperties("spring.cloud.config.server.db")
public class DbEnvironmentRepositoryProperties implements EnvironmentRepositoryProperties {

	private int order = Ordered.LOWEST_PRECEDENCE - 10;

	private String label = "master";

	private String configSourceType = "db";

	@Override
	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getConfigSourceType() {
		return configSourceType;
	}

	public void setConfigSourceType(String configSourceType) {
		this.configSourceType = configSourceType;
	}
}
