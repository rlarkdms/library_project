package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.BookDao;
import com.example.dao.MemberDao;
import com.example.dao.NoticeDao;
import com.example.data.Book;

public class BookController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BookDao bookDao;
//	@PostMapping("/search/searchBook")
//	public String book(@RequestParam("keyword") String keyword, Model model) {
//		System.out.print("값이오는지"+keyword);
//		List<Book> bookList = bookDao.selectAll(keyword);
//		System.out.print("제대로 오고 있음");
//		model.addAttribute("book", bookList);//멤버 리스트를 다 주는 것.
//		System.out.print(bookList);
//		
//		return "/search/searchBook";
//	}
 
	@GetMapping("/book/bookDetail")
	public String handleStep2Get()
	{  return "/book/bookDetail"; }

	    
	
	@PostMapping("/search/loan")//대출 서비스
	public  String loan(@RequestParam("id") String id,
			@RequestParam("book_id") Long book_id,
			Model model) {
		
		String value=bookDao.loan(id, book_id);
		model.addAttribute("loan",value );
		
		return "/search/loan";
		
	}
	@PostMapping("/book/return")//반납 서비스
	public String turn(@RequestParam("id") String id,
			@RequestParam("book_id") Long book_id,
			Model model) {
		String value=bookDao.turn(id,book_id);
		model.addAttribute("turn",value);
		return "/book/return";
	}
	
//	@PostMapping("/book/extension")
//	public String extension(@RequestParam("") String id,
//			@RequestParam("book_id") Long book_id,
//			Model model) {
//		String value=bookDao.extension(id,book_id);
//		model.addAttribute("extension",value);
//		return "/book/extension";
//		
//	}

}
