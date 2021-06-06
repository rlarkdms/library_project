package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.MemberDao;
import com.example.dao.MyPageDao;
import com.example.data.Return_List;



@Controller
public class MyPageController {

	@Autowired
	private MyPageDao mypageDao;
	
	@Autowired
	private MemberDao memberDao;
	
	
	@GetMapping("/session/mypage")
	public String page(@RequestParam(value="member_id",required=true) String member_id,Model model) {
	
		List<Return_List> turn = mypageDao.selectReturnAll(member_id);
		List<Return_List> expired = mypageDao.selectexpiredAll(member_id);
		System.out.print("확인");
		System.out.print(turn);
		System.out.print(expired);
		model.addAttribute("book",turn);
		model.addAttribute("expired",expired);
		return "/session/mypage";
	}
	
//    
//	@PostMapping("/session/mypage")
//	public String mypage(@RequestParam(value="member_id",required=true) String member_id,Model model) {
//	
//		List<Return_List> turn = mypageDao.selectReturnAll(member_id);
//		System.out.print("확인");
//		System.out.print(turn);
//		model.addAttribute("book",turn);
//		return "/session/mypage";
//	}

	@GetMapping("/session/edit")
	public String edit() {
		return "/session/edit";
	}
	@PostMapping("/session/editCheck")
	public String editCheck(@RequestParam(value="member_id",required=true) String member_id,
			@RequestParam(value="password",required=true) String password,
			@RequestParam(value="pwcomfirm",required=true)String pwcomfirm,
			@RequestParam(value="name",required=true) String name,
			@RequestParam(value="email",required=true)String email,
			@RequestParam(value="phone",required=true)String phone,Model model) {
		
	String status=memberDao.edit(member_id, password, pwcomfirm, name, email, phone);
		
	System.out.print("확인");
	System.out.print(status);
		model.addAttribute("edit",status);
		model.addAttribute("member_id",member_id);
		
		return "/session/editCheck";
	}
	@GetMapping("/session/leave")
	public String leave() {
		return "/session/leave";
	}
	
	@PostMapping("/session/leave")
	public String leave_check(@RequestParam(value="member_id",required=true)String member_id,Model model) {
		
		String status=memberDao.leave(member_id);
		
		model.addAttribute("leave",status);
		
		return "/session/leave";
	}
	
	
}
