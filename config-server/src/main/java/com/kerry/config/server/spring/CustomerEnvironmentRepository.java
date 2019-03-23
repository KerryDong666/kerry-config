package com.kerry.config.server.spring;

import com.kerry.config.server.service.AppServerConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;

/**
 * 自定义EnvironmentRepository
 * @author kerry dong
 * @date 2019/3/23
 */
public class CustomerEnvironmentRepository implements EnvironmentRepository{

	@Autowired
	private AppServerConfigService appServerConfigService;

	private String configSourceType;

	private String label;

	private int order;

	private final Logger logger = LoggerFactory.getLogger(getClass());


	public CustomerEnvironmentRepository(DbEnvironmentRepositoryProperties properties) {
		this.order = properties.getOrder();
		this.label = properties.getLabel();
		this.configSourceType = properties.getConfigSourceType();
		this.order = properties.getOrder();
	}

	/**
	 * 重写该方法,实现在数据库中查找配置
	 * @param application 应用名
	 * @param profile 环境 test pre prd
	 * @param label 分支
	 * @return org.springframework.cloud.config.environment.Environment
	 */
	@Override
	public Environment findOne(String application, String profile, String label) {
		logger.info("###begin load customer environment repository###");
		switch (configSourceType) {
			case "db":
				return appServerConfigService.queryConfigByAppName(application, profile, label);
			default:
				return null;
		}
	}

}