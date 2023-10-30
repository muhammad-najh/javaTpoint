package com.skysoft.springboot.s7.login;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Auth auth;
	
	
	
	
	public LoginController(Auth auth) {
		super();
		this.auth = auth;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
	
		if(auth.isAuth(name, password)) {
				model.put("name", name);
				model.put("password", password);
				
				return "welcome";
		}
	
//	logger.warn("username = "+name);
//	logger.warn("password = "+password);
//	logger.warn("auth = "+(auth.isAuth(name, password)));
	
				
		model.put("err", "OoOops Credintional invaild !");
		
		
				return "login";

	}

}
