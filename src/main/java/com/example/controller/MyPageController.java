package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MyPageController {

	
	
    
	@GetMapping("/session/mypage")
	public String mypage() {
		return "/session/mypage";
	}
    
	@GetMapping("/session/edit")
	public String edit() {
		return "/session/edit";
	}
	
}
