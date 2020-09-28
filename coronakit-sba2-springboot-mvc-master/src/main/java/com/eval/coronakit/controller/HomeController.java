package com.eval.coronakit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index";

	}

	@RequestMapping(value = { "/home" })
	public String home() {
		return "main-menu";
	}

	@RequestMapping("/header")
	public String header() {
		return "header";

	}

	@RequestMapping("/footer")
	public String footer() {
		return "footer";

	}

}
