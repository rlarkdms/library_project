package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.NoticeDao;
import com.example.dto.Book;
import com.example.dto.Member;
import com.example.dto.Notice;

@Controller
public class NoticeController {

	@Autowired
	private NoticeDao noticeDao;

//	@GetMapping("/noti1")
//	public String notice1(Model model) {
//	List<Notice> noticeList = noticeDao.selectAll();
//	model.addAttribute("notice", noticeList);//멤버 리스트를 다 주는 것.
//		return "noti1";
//	}

	@GetMapping(value = "/notice2")
	public String notice2(@RequestParam(value = "number") Long id, Model model) {
//여기서 부터 다시하기.		

		return "notice2";
	}
	@GetMapping("/admin/noticeInsert")
	public String notice_insert() {
		
		return "/admin/noticeInsert";
	}
	
	@RequestMapping("/admin/noticeInsertCheck")
	public String insert(@RequestParam("admin_id") String admin_id,
			@RequestParam("notice_title") String notice_title,
			@RequestParam("notice_content") String notice_content, Model model) {
		
		Notice notice=new Notice((long)0,admin_id,notice_title,notice_content, notice_content);
		
		String result=noticeDao.insert(notice);
		
		model.addAttribute("result", result);//멤버 리스트를 다 주는 것.
		model.addAttribute("admin_id", admin_id);
	
		return "/admin/noticeInsertCheck";
	}
	@RequestMapping("/admin/noticeDelete")
	public String delete(@RequestParam("admin_id") String admin_id,
			@RequestParam("notice_id") Long notice_id,Model model) {
		
		String delete_status=noticeDao.delete(notice_id);
		
		model.addAttribute("result",delete_status);
		model.addAttribute("admin_id",admin_id);
		
		
		return "/admin/noticeDelete";
	}
	@RequestMapping("/notice")//공지사항 디테일 페이지.
	public String notice_detail(@RequestParam("notice_id")Long notice_id,
			Model model){  	
		List<Notice> notice=noticeDao.selectOne(notice_id);
		System.out.print("책 디테일 페이지 가는 값 :");
		System.out.println(notice);
		
		model.addAttribute("notice",notice);//detail에 book 값 전달.
		return "/notice"; }
}
