package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.BookDao;
import com.example.dao.MemberDao;
import com.example.dao.NoticeDao;
import com.example.data.Book;
import com.example.data.Member;
import com.example.data.Notice;

@Controller
public class MainController {
	
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private BookDao bookDao;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String list(Model model) {
	List<Notice> noticeList = noticeDao.selectAll();
	model.addAttribute("notice", noticeList);//멤버 리스트를 다 주는 것.
	return "index";
	}
	
	@RequestMapping(value = "/search/searchBook", method=RequestMethod.POST)
	public String book(@RequestParam("keyword") String keyword, Model model) {
		List<Book> bookList = bookDao.selectAll(keyword);
		model.addAttribute("book", bookList);//멤버 리스트를 다 주는 것.
		return "/search/searchbook";
	}

}
