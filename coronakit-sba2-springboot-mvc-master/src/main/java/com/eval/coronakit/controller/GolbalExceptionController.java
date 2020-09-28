package com.eval.coronakit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.exception.CoronaException;

@ControllerAdvice
public class GolbalExceptionController {

	@ExceptionHandler(CoronaException.class)
	public ModelAndView handleContactException(CoronaException exp) {
		return new ModelAndView("show-all-item-admin", "errMsg", exp.getMessage());
	}
}
