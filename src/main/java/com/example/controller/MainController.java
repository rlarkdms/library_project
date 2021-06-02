package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.MemberDao;
import com.example.data.Member;

@Controller
public class MainController {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model) {
	List<Member> memberList = memberDao.selectAll();
	model.addAttribute("members", memberList);//멤버 리스트를 다 주는 것.
	return "list";
	}
	
//	@RequestMapping(value = "/noti1", method=RequestMethod.GET)
//	public String notice1() {
//		return "noti1";
//	}

}
