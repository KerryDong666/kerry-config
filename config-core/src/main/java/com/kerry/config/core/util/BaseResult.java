package com.kerry.config.core.util;

/**
 * @author kerry dong
 * @date 2019/3/15
 */
public class BaseResult<T> {

	private static final int SUCCESS = 200;

	private int code;

	private String msg;

	private T result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public void setCodeSuccess(){
		this.code = SUCCESS;
	}


}
