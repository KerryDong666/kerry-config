package com.kerry.config.client.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author kerry dong
 * @date 2019/3/18
 */
public class HttpClient {

	private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

	private static HttpClient instance = new HttpClient();

	public static HttpClient getInstance() {
		return instance;
	}

	private HttpClient() {
	}

	public static String sendGetRequest(String url){
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder()
				.url(url)
				.build();
		Call call = okHttpClient.newCall(request);
		try {
			Response response = call.execute();
			if (response.isSuccessful()) {
				return response.body().toString();
			}
		} catch (IOException e) {
			logger.error("", e);
		}
		return null;
	}

	public static void main(String[] args) {
		String s = HttpClient.sendGetRequest("https://www.baidu.com");
		System.out.println(s);
	}
}
