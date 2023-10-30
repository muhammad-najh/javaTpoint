package com.skysoft.springboot.s7.login;

import org.springframework.stereotype.Service;

@Service
public class Auth {

	
	private String mUsername = "ahmed";
	private String mPassword = "dumypass";


	public boolean isAuth(String username,String pass) {
	
		if (mUsername.equals(username) && mPassword.equals(pass)) {
			return true;
		}
		
		else {
			return false;
		}
	   
	}
	
	
}
