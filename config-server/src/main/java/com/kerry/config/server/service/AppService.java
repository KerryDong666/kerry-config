package com.kerry.config.server.service;

import com.kerry.config.server.AppBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author kerry dong
 * @date 2019/3/20
 */
public interface AppService extends JpaRepository<AppBaseInfo, Long> ,JpaSpecificationExecutor<AppBaseInfo>,Serializable {



}
