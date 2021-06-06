package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MyPageController {

	
	
    
	@GetMapping("/session/mypage")
	public String mypage(@RequestParam(value="member_id",required=true) String id,Model model) {
	
		
		
	
		return "/session/mypage";
	}
    
	@GetMapping("/session/edit")
	public String edit() {
		return "/session/edit";
	}
	
}
