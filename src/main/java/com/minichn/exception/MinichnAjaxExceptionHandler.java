package com.minichn.exception;

import com.minichn.pojo.MinichnJSONResult;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class MinichnAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public MinichnJSONResult defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception {
		e.printStackTrace();
		return MinichnJSONResult.errorException(e.getMessage());
	}
}
