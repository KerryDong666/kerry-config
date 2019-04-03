package com.kerry.config.server.util;

import com.kerry.config.core.util.HttpClient;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author kerry dong
 * @date 2019/4/3
 */
public class App {

	public static void main(String[] args) throws Exception{
		HttpClient client = HttpClient.getInstance();
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleWithFixedDelay(() -> {
			Response response = null;
			try {
				response = client.sendGetRequest("http://localhost:8089/watch/100", 75000L, 75000L);
			} catch (IOException e) {
				e.printStackTrace();
			}

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
