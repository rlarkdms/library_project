package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MemberDao;
import com.example.data.Member;

@Controller
public class LoginController {
	
	private MemberDao memberDao;
	

	@GetMapping("/login/login")
	public String loing(Model model) {
		model.addAttribute("error","");
		return "/login/login";
	}
	
	
	@PostMapping("/login/loginCheck")
	public String hello(
			@RequestParam(value="status",required=false) String status,
			@RequestParam(value = "member_id", required = true) String id,
			@RequestParam(value = "password", required = true) String pwd,Model model) {
		
		System.out.print(status+id+pwd);
		
		if(status=="normal") {
			String memberlist= memberDao.ConfirmIDPWD(id, pwd);
				if (memberlist.equals(null)) {
						model.addAttribute("error","아이디와 비밀번호가 맞지 않습니다.");
						return "redirect:/login/login";
			
				}
				else {
					model.addAttribute("id", memberlist);
				}
		}else {
			//관리자 나중에 만들기.
			
		}
		
		return "/login/loginCheck";
	}

}
