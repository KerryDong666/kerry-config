package com.kerry.config.server.dao;

import com.kerry.config.core.domain.AppServerConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author kerry dong
 * @date 2019/3/23
 */
public interface AppServerConfigDao extends JpaRepository<AppServerConfig, Long>,JpaSpecificationExecutor<AppServerConfig>,Serializable {

}
