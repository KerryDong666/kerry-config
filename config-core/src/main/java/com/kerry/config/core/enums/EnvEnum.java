package com.kerry.config.core.enums;

/**
 * @author kerry dong
 * @date 2019/3/21
 */
public enum EnvEnum {

	TEST("test"),
	PRE("pre"),
	PRD("prd");

	EnvEnum(String msg) {
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
