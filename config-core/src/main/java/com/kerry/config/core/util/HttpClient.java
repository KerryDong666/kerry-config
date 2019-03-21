package com.kerry.config.core.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Http client util base by okhttp3
 *
 * @author kerry dong
 * @date 2019/3/18
 */
public class HttpClient {

	private static HttpClient instance = new HttpClient();

	public static HttpClient getInstance() {
		return instance;
	}

	private HttpClient() {
	}

	public Response sendGetRequest(String url, Long connectTimeout, Long readTimeout) throws IOException{
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(connectTimeout, TimeUnit.SECONDS)
				.readTimeout(readTimeout, TimeUnit.SECONDS).build();
		Request request = new Request.Builder()
				.url(url)
				.build();
		Call call = okHttpClient.newCall(request);
		return call.execute();
	}

	public Response sendGetRequest(String url) throws IOException{
		return sendGetRequest(url, 10000L, 10000L);
	}

	public static void main(String[] args) {
		//String s = HttpClient.sendGetRequest("https://www.baidu.com");
		//System.out.println(s);
		HttpClient instance = HttpClient.getInstance();
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleWithFixedDelay(() -> {

			Response response = null;

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
