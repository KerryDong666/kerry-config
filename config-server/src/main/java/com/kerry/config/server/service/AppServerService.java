package com.kerry.config.server.service;

import com.kerry.config.core.domain.AppBaseInfo;
import com.kerry.config.core.util.BaseResult;
import com.kerry.config.server.dao.AppServerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@Service
public class AppServerService {

	@Autowired
	private AppServerDao appServerDao;

	public BaseResult<AppBaseInfo> queryById(Long id){
		BaseResult<AppBaseInfo> result = new BaseResult<>();
		AppBaseInfo baseInfo = appServerDao.queryById(id);
		result.setSuccess(baseInfo);
		return result;
	}
}
