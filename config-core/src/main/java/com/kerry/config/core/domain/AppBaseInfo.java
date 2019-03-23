package com.kerry.config.core.domain;

import com.alibaba.fastjson.JSONObject;

import javax.persistence.Entity;

/**
 * @author kerry dong
 * @date 2019/3/19
 */
@Entity
public class AppBaseInfo extends BaseDomain{

	private String name;

	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AppBaseInfo{");
		sb.append("name='").append(name).append('\'');
		sb.append(", remark='").append(remark).append('\'');
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
		json.put("name", this.getName());
		json.put("remark", this.getRemark());
		return json.toJSONString();
	}

}
