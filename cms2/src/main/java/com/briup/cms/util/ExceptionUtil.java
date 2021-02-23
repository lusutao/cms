package com.briup.cms.util;

import com.briup.cms.exception.ServiceException;

/**
 * 异常工具类
 */
public class ExceptionUtil {
	/**
	 * 从异常中，获取Controller的返回结果Result
	 */
	public static Result getResult(Exception e) {
		Result result = null;
		if(e instanceof ServiceException) {
			result = Result.failure(((ServiceException) e).getResultCode());
		}
		else {
			result = Result.failure(500, "服务器意外错误："+e.getMessage());
		}
		return result;
	}
	
}
