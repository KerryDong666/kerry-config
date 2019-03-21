package com.kerry.config.core.domain;

import javax.persistence.Entity;

/**
 * @author kerry dong
 * @date 2019/3/15
 */
@Entity
public class AppServerConfig extends BaseDomain {

	private String env;

	private String key;

	private String value;

	private String remark;

	private Integer valid;

	private Integer version;

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
