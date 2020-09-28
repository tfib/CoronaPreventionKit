package com.eval.coronakit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GolbalExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception exp) {
		return new ModelAndView("errPage", "errMsg", exp.getMessage());
	}
}
