package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MemberDao;
import com.example.data.Member;

@Controller
public class LoginController {
	
	private MemberDao memberDao;
	
	@RequestMapping("/login")
	public ModelAndView hello(ModelAndView mav,
			@RequestParam(value = "name", required = false) String name) {
		mav.setViewName("login");//login.jsp
		return mav;
	}
	@RequestMapping("/loginCheck")
	public String hello(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "pwd", required = true) String pwd,Model model) {
		List<Member> member= memberDao.ConfirmIDPWD(id, pwd);
		

		return "logincheck";
	}
}
