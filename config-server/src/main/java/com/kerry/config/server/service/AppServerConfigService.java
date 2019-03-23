package com.kerry.config.server.service;

import com.alibaba.fastjson.JSON;
import com.kerry.config.core.domain.AppServerConfig;
import com.kerry.config.server.dao.AppServerConfigDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.context.EnvironmentAware;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@Service
@RestController
public class AppServerConfigService implements EnvironmentAware {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AppServerConfigDao appServerConfigDao;

	private org.springframework.core.env.Environment env;

	private static final String CONFIG_SERVER = "config_server";

	@RequestMapping("env")
	public org.springframework.cloud.config.environment.Environment queryConfigByAppName(String appName, String deployType, String label) {
		logger.debug("begin load config by db");
		List<AppServerConfig> configs = appServerConfigDao.queryAppConfig(appName, deployType);
		Map<String, Object> propertyMap = new HashMap<>(16);
		for (AppServerConfig config : configs) {
			propertyMap.put(config.getKey(), config.getValue());
		}
		PropertySource propertySource = new PropertySource(CONFIG_SERVER, propertyMap);
		Environment environment = new Environment(appName, deployType, label, "1.0", null);
		environment.add(propertySource);
		logger.info("load environment success, msg:{}", JSON.toJSONString(environment));
		return environment;
	}

	@Override
	public void setEnvironment(org.springframework.core.env.Environment environment) {
		this.env = environment;
	}
}
