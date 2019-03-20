package com.kerry.config.server;

import javax.persistence.*;

/**
 * @author kerry dong
 * @date 2019/3/20
 */
@Entity
public class AppBaseInfo {

	@Id
	@GeneratedValue
	private Long id;

	private String appName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}
