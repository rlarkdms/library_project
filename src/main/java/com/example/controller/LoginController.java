package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MemberDao;

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
	public ModelAndView hello(ModelAndView mav,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "pwd", required = false) String pwd) {
		//login check
		if (id.equals("gaeun")&&pwd.equals("1234")) {
			mav.addObject("LOGIN_OK","welcome "+id);
			
		}else{mav.addObject("LOGIN_OK","Wrond ID/Password");}
		mav.setViewName("loginCheck");//loginCheck.jsp
		return mav;
	}
}
