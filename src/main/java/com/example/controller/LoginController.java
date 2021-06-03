package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private MemberDao memberDao;
	

	@GetMapping("/login/login")
	public String loing(Model model) {
		model.addAttribute("error","");
		return "/login/login";
	}
	
	
	@PostMapping("/login/loginCheck")
	public String hello(
			@RequestParam(value="status",required=true) String status,
			@RequestParam(value = "member_id", required = true) String id,
			@RequestParam(value = "password", required = true) String pwd,Model model) {
		
		System.out.print(status+id+pwd);
		
		if(status.equals("normal")) {
			System.out.print("들어갔는지 확인하기");
			String memberlist= memberDao.ConfirmIDPWD(id, pwd);
			
				if (memberlist==null) {
						model.addAttribute("error","아이디와 비밀번호가 맞지 않습니다.");
						return "redirect:/login/login";
			
				}
				else {
					
					
					model.addAttribute("id", memberlist);
					System.out.print(memberlist);
					return "/login/loginCheck";
				}
		}else {
			System.out.print("else문임");
			//관리자 나중에 만들기.
			
		}
		
		return "/login/loginCheck";
	}
	@GetMapping("/login/logout")
	public String logout() {
		return "/login/logout";
	}

	@GetMapping("/index")
	public String index() {
		return "/index";
	}
}
