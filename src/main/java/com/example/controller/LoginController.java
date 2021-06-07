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

import com.example.dao.AdminDao;
import com.example.dao.MemberDao;
import com.example.data.Member;

@Controller
public class LoginController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private AdminDao adminDao;

	//로그인 세션 로그인,로그아웃,로그인 체크 기능 존재 컨트롤러/////////////////////////////////////
	
	@GetMapping("/login/login")//로그인 컨트롤러
	public String loing(Model model) {
		model.addAttribute("error","");
		return "/login/login";
	}
	
	
	@PostMapping("/login/loginCheck")//로그인 체크 컨트롤러
	public String hello(
			@RequestParam(value="status",required=true) String status,//관리자인지 일반 사용자인지 확인
			@RequestParam(value = "member_id", required = true) String id, //멤버 or 관리자 아이디
			@RequestParam(value = "password", required = true) String pwd,Model model) { //멤버 or 관리자 비밀번호 모델.
		

		if(status.equals("normal")) {
			System.out.println("일반 이용자 접속");
			String memberlist= memberDao.ConfirmIDPWD(id, pwd);//아이디 대비 비밀번호가 맞는지 확인.

				if (memberlist==null) {//만약 NULL값이 오면 뭔가 잘못된거
						model.addAttribute("error","아이디와 비밀번호가 맞지 않습니다.");
						return "redirect:/login/login";
			
				}
				else {
					
					
					model.addAttribute("id", memberlist);
					System.out.print(memberlist);
					return "/login/loginCheck";
				}
		}else {

			System.out.print("관리자 이용자 접속\n");
			
			String adminlist=adminDao.ConfirmIDPWD(id,pwd);
				if (adminlist==null) {
					model.addAttribute("error","아이디와 비밀번호가 맞지 않습니다.");
					return "redirect:/login/login";
	
				}
				else {
			
					System.out.print(adminlist);
					model.addAttribute("admin", adminlist);
					return "/login/loginCheck";
				}
			
		}
		
	}
	@GetMapping("/login/logout")//로그아웃
	public String logout() {
		return "/login/logout";
	}

	@GetMapping("/index")//메인 페이지
	public String index() {
		return "/index";
	}
}
