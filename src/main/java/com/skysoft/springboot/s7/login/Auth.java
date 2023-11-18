package com.skysoft.springboot.s7.login;

import org.springframework.stereotype.Service;

@Service
public class Auth {

	
	private String mUsername = "hama";
	private String mPassword = "123";


	public boolean isAuth(String username,String pass) {
	
		if (mUsername.equals(username) && mPassword.equals(pass)) {
			return true;
		}
		
		else {
			return false;
		}
	   
	}
	
	
}
