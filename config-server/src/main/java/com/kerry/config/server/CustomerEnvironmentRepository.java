package com.kerry.config.server;

import com.alibaba.fastjson.JSONObject;
import com.kerry.config.core.util.BaseResult;
import com.kerry.config.server.service.AppServerConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义EnvironmentRepository
 * @author kerry dong
 * @date 2019/3/23
 */
public class CustomerEnvironmentRepository implements EnvironmentRepository{

	@Autowired(required = false)
	AppServerConfigService appServerConfigService;

	//private ApplicationContext ctx;

	public CustomerEnvironmentRepository() {
		//BaseResult<JSONObject> result = appServerConfigService.queryConfigByAppName();
		//System.out.println(JSONObject.toJSONString(result));
		//this.appServerConfigService = this
		System.out.println("#########begin load customer config#######------------");
	}

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 重写该方法,实现在数据库中查找配置
	 * @param application 应用名
	 * @param profile 环境 test pre prd
	 * @param label 分支
	 * @return org.springframework.cloud.config.environment.Environment
	 */
	@Override
	public Environment findOne(String application, String profile, String label) {
		BaseResult<JSONObject> result = appServerConfigService.queryConfigByAppName();
		//AppServerConfigService bean = ctx.getBean(AppServerConfigService.class);
		//BaseResult<JSONObject> result = bean.queryConfigByAppName();
		System.out.println(JSONObject.toJSONString(result));
		logger.debug("#########begin load customer config#######");
		Environment environment =new Environment(application, profile);
		List<PropertySource> propertySourceList = environment.getPropertySources();
		Map<String, String> map = new HashMap<>();
		map.put("name", "kerry");
		PropertySource propertySource = new PropertySource("map", map);
		propertySourceList.add(propertySource);
		return environment;
	}

	//@Override
	//public void setApplicationContext(ApplicationContext ctx) throws BeansException {
	//	this.ctx = ctx;
	//}
}