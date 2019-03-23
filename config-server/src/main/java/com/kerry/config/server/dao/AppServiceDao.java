package com.kerry.config.server.dao;


import com.kerry.config.server.domain.AppBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author kerry dong
 * @date 2019/3/20
 */
public interface AppServiceDao extends JpaRepository<AppBaseInfo, Long>,JpaSpecificationExecutor<AppBaseInfo>,Serializable {



}
