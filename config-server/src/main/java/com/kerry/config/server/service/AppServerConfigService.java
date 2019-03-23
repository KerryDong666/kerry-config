package com.kerry.config.server.service;

import com.alibaba.fastjson.JSONObject;
import com.kerry.config.core.util.BaseResult;
import com.kerry.config.server.dao.AppServerConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@Service
public class AppServerConfigService {

	@Autowired
	private AppServerConfigDao appServerConfigDao;

	public BaseResult<JSONObject> queryConfigByAppName(){
		return null;
	}
}
