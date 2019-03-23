package com.kerry.config.server.dao;


import com.kerry.config.core.domain.AppBaseInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kerry dong
 * @date 2019/3/20
 */
@Mapper
public interface AppServerDao {

	/**
	 *
	 * @param id
	 * @return
	 */
	AppBaseInfo queryById(Long id);

}
