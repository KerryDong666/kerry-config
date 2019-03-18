package com.kerry.config.client.property;

import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.lang.Nullable;

import java.util.Map;

/**
 * @author kerry dong
 * @date 2019/3/18
 */
public class AppPropertySource extends EnumerablePropertySource<Map<String,Object>> {

	public AppPropertySource(String name, Map<String, Object> source) {
		super(name, source);
	}

	/**
	 * 获取所有属性的key
	 * @return
	 */
	@Override
	public String[] getPropertyNames() {
		return source.keySet().toArray(new String[source.size()]);
	}

	/**
	 * 根据配置返回对应的属性
	 * @param name
	 * @return
	 */
	@Nullable
	@Override
	public Object getProperty(String name) {
		return source.get(name);
	}
}
