package com.kerry.config.core.domain;

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

}
