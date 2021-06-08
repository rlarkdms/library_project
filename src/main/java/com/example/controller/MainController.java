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
import com.example.dao.MainDao;
import com.example.dao.MemberDao;
import com.example.dao.NoticeDao;
import com.example.dto.Book;
import com.example.dto.Member;
import com.example.dto.Notice;

@Controller
public class MainController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private MainDao mainDao;
	
	
	@RequestMapping("/")
	public String notice_list(Model model) {

		System.out.print("공지사항 되는지 확인1");
		List<Notice> notice=noticeDao.selectAll();
		model.addAttribute("notice", notice);

		System.out.print("공지사항 되는지 확인2");
	return "/index";
	}
	@GetMapping("/index")
	public String index() {


	return "/index";
	}
	
	@PostMapping("/search/searchBook")
	public String searchBook(@RequestParam("keyword") String keyword, Model model) {
		System.out.print("값이오는지"+keyword);
		List<Book> bookList = bookDao.selectAll(keyword);
		System.out.print("제대로 오고 있음");
		model.addAttribute("book", bookList);//도서 리스트를 다 주는 것.
		System.out.print(bookList);
		
		return "/search/searchBook";
	}

	//book_id book_name writer
	
	@RequestMapping("/bestSeller")
		public String bestSeller(Model model) {
		
		List<Book> book_list=mainDao.bookbestSeller();
		
		model.addAttribute("bestSeller", book_list);
		
		return "/bestSeller";
	}
	
	@RequestMapping("/newBooks")
	public String newBooks(Model model) {
	
		List<Book> book_list=mainDao.newBooks();
		model.addAttribute("newBooks", book_list);
	return "/newBooks";
}
}
