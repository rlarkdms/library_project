package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MemberDao;
import com.example.data.Member;

@Controller
public class LoginController {
	
	private MemberDao memberDao;
	

	@GetMapping("/login/login")
	public String loing() {
		return "/login/login";
	}
	
	
	@GetMapping("/login/loginCheck")
	public String hello(
			@RequestParam(value="status",required=true) String status,
			@RequestParam(value = "member_id", required = true) String id,
			@RequestParam(value = "password", required = true) String pwd,Model model) {
		if(status.equals("normal")) {
		String memberlist= memberDao.ConfirmIDPWD(id, pwd);
		model.addAttribute("id", memberlist);
		}else {
			//관리자 나중에 만들기.
			
		}
		
		return "/login/loginCheck";
	}
}
