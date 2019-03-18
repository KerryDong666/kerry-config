package com.kerry.config.core.domain;

/**
 * @author kerry dong
 * @date 2019/3/15
 */
public class AppServiceConfig {

	private String envType;

	private String key;

	private String value;

	private String remark;

	private Integer version;

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
