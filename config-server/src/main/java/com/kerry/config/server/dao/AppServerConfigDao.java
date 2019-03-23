package com.kerry.config.server.dao;

import com.kerry.config.core.domain.AppServerConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
@Mapper
public interface AppServerConfigDao {

	List<AppServerConfig> queryAppConfig(@Param("appName") String appName, @Param("deployType") String deployType);

}
