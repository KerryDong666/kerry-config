package com.kerry.config.core.domain;

import com.alibaba.fastjson.JSONObject;

import javax.persistence.Entity;

/**
 * 应用服务配置
 *
 * @author kerry dong
 * @date 2019/3/15
 */
@Entity
public class AppServerConfig extends BaseDomain {

	/**
	 * appId
	 */
	private Long appId;

	/**
	 * 对应springboot项目中的spring.application.name属性值
	 */
	private String appName;

	/**
	 * 部署环境, test/pre/prd
	 */
	private String deployType;
	/**
	 * 配置name,如@Value("${age}")中的age
	 */
	private String key;
	/**
	 * 配置value
	 */
	private String value;
	/**
	 * 备注说明
	 */
	private String remark;
	/**
	 * 是否生效
	 */
	private Integer effective;
	/**
	 * 版本号
	 */
	private Integer version;

	public AppServerConfig() {
		this.version = 0;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getDeployType() {
		return deployType;
	}

	public void setDeployType(String deployType) {
		this.deployType = deployType;
	}

	public Integer getEffective() {
		return effective;
	}

	public void setEffective(Integer effective) {
		this.effective = effective;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AppServerConfig{");
		sb.append("appId=").append(appId);
		sb.append(", appName='").append(appName).append('\'');
		sb.append(", deployType='").append(deployType).append('\'');
		sb.append(", key='").append(key).append('\'');
		sb.append(", value='").append(value).append('\'');
		sb.append(", remark='").append(remark).append('\'');
		sb.append(", effective=").append(effective);
		sb.append(", version=").append(version);
		sb.append('}');
		return sb.toString();
	}

	public String getJsonString(){
		JSONObject json = new JSONObject();
		json.put("id", super.getId());
		json.put("creator", super.getCreator());
		json.put("modifier", super.getModifier());
		json.put("gmtModifier", super.getGmtModifier());
		json.put("gmtCreator", super.getGmtModifier());
		json.put("appId", this.getAppId());
		json.put("appName", this.getAppName());
		json.put("deployType", this.getDeployType());
		json.put("key", this.getKey());
		json.put("value", this.getValue());
		json.put("remark", this.getRemark());
		json.put("effective", this.getEffective());
		json.put("version", this.getVersion());
		return json.toJSONString();
	}
}
