package com.kerry.config.client.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

	public Response sendGetRequest(String url) {
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(65L, TimeUnit.SECONDS).readTimeout(70L, TimeUnit.SECONDS).build();
		Request request = new Request.Builder()
				.url(url)
				.build();
		Call call = okHttpClient.newCall(request);
		Response response = null;
		try {
			response = call.execute();
			//if (response.isSuccessful()) {
			//	return response.body().toString();
			//}
		} catch (IOException e) {
			logger.error("", e);
		}
		return response;
	}

	public static void main(String[] args) {
		//String s = HttpClient.sendGetRequest("https://www.baidu.com");
		//System.out.println(s);
		HttpClient instance = HttpClient.getInstance();
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleWithFixedDelay(() ->{

			Response response = instance.sendGetRequest("http://localhost:8080/watch/pwd");

			if (response.code() == HttpURLConnection.HTTP_NOT_MODIFIED) {
				System.out.println("time : " + new Date().toLocaleString() + "配置没有变化");
			}
			if (response.code() == HttpURLConnection.HTTP_OK) {
				System.out.println("time : " + new Date().toLocaleString() + "配置变化了");
			}
			//System.out.println(response.code());
		}, 1, 1, TimeUnit.SECONDS);

	}
}
