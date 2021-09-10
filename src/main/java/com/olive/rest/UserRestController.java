package com.olive.rest;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping("/home")
	public String showAll() {
		return "Welcome To Permit All !";
	}
	
	@GetMapping("/data")
	public String showData() {
		return "Welcome To Data Page After Login !";
	}
	
	@GetMapping("/user")
	public Authentication userDetails(Principal p) {
		            System.out.println("Class : " + p.getName());
		             System.out.println("Impl class :" + p.getClass().getName());
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}
