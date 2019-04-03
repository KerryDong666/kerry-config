package com.kerry.config.server.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kerry dong
 * @date 2019/4/3
 */
@ControllerAdvice
public class AsyncRequestTimeoutExceptionHandler {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 捕获到AsyncRequestTimeoutException异常直接返回304状态
	 *
	 */
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	@ResponseBody
	@ExceptionHandler(AsyncRequestTimeoutException.class)
	public void handleAsyncRequestTimeoutException(AsyncRequestTimeoutException e, HttpServletRequest request) {
		logger.debug("---handleAsyncRequestTimeoutException---");
	}


}
