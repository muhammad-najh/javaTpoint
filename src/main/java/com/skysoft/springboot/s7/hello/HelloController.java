package com.skysoft.springboot.s7.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
	
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String helloEnd() {
		return "Hello ! Man How are you ?";
	}
	
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "login";
	}

}
