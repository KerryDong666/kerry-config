package com.kerry.config.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * DeferredResult 属性
 * @author kerry dong
 * @date 2019/3/20
 */
@RestController
public class DeferredResultController {



	private static int cacheVersion = 100;

	private static volatile boolean flag = false;
	/**
	 * 模拟长轮询,该接口一直被客户端调用
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/watch/{config}", method = RequestMethod.GET, produces = "text/html")
	public DeferredResult<String> watch(@PathVariable("config") String config) {
		DeferredResult<String> deferredResult = new DeferredResult<>();
		//当deferredResult完成时（不论是超时还是异常还是正常完成），移除watchRequests中相应的watch key
		deferredResult.onCompletion(() -> {
			//System.out.println("被调用成功,移除配置:" + config);
			//watchRequests.remove(config, deferredResult);
			if (flag){
				cacheVersion ++;
			}
			System.out.println("cerson = " + cacheVersion);
		});
		//watchRequests.put(cacheVersion, deferredResult);
		return deferredResult;


	}

	/**
	 * 模拟发布config配置
	 * @return
	 */
	@RequestMapping(value = "/publish/{version}", method = RequestMethod.GET, produces = "text/html")
	public Object publishConfig(@PathVariable("version") int version) {
		//if (watchRequests.containsKey(config)) {
		//	Collection<DeferredResult<String>> deferredResults = watchRequests.get(config);
		//	Long time = System.currentTimeMillis();
		//	//通知所有watch这个config变更的长轮训配置变更结果
		//	for (DeferredResult<String> deferredResult : deferredResults) {
		//		deferredResult.setResult(config + " 被改变, 时间:" + new Date().toLocaleString());
		//	}
		//}
		//if (version > cacheVersion){
		//	flag = true;
		//	Collection<DeferredResult<String>> deferredResults = watchRequests.get(cacheVersion);
		//	for (DeferredResult<String> deferredResult : deferredResults) {
		//				deferredResult.setResult(cacheVersion + " 被改变, 时间:" + new Date().toLocaleString());
		//			}
		//}else {
		//	flag = false;
		//}
		return "success";
	}
	// 参数 : name env key value
	// 更新后, 对比key的value是否改变,如果改变,将新的value设置进去


	// 项目启动是查询配置, 放在一个缓存中

	// 发布配置之后,查询到最新的配置与就得不同,





	public DeferredResult<String> watchConfig(){
		DeferredResult<String> deferredResult = new DeferredResult<>();
		deferredResult.onCompletion(new Runnable() {
			@Override
			public void run() {
				System.out.println("调用成功");
			}
		});
		return deferredResult;
	}

}