package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@RequestMapping("/")
	public String list(Model model) {

		System.out.print("공지사항 되는지 확인1");
		List<Notice> notice=noticeDao.selectAll();
		model.addAttribute("notice", notice);

		System.out.print("공지사항 되는지 확인2");
	return "/index";
	}
//	@GetMapping("/index")
//	public String index(Model model) {
//
//
//	return "/index";
//	}
	
	@PostMapping("/search/searchBook")
	public String book(@RequestParam("keyword") String keyword, Model model) {
		System.out.print("값이오는지"+keyword);
		List<Book> bookList = bookDao.selectAll(keyword);
		System.out.print("제대로 오고 있음");
		model.addAttribute("book", bookList);//멤버 리스트를 다 주는 것.
		System.out.print(bookList);
		
		return "/search/searchBook";
	}

	//book_id book_name writer
	
	@GetMapping("/bestSeller")
		public String bestSeller(Model model) {
		
		List<Book> book_list=bookDao.bookbestSeller();
		
		model.addAttribute("bestSeller", book_list);
		
		return "/bestSeller";
	}
	
	@GetMapping("/newBooks")
	public String newBooks() {
	
	return "/newBooks";
}
}
