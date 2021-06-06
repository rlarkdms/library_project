package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.BookDao;
import com.example.dao.MemberDao;
import com.example.dao.NoticeDao;
import com.example.data.Book;

@Controller
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
//		System.out.print(bookList);git 
//		
//		return "/search/searchBook";
//	}
 
//	@GetMapping("/book/bookDetail")
//	public String Detail() {
//		return "/book/bookDetail";
//	}
//	
	@RequestMapping("/book/bookDetail")//책 디테일 페이지.
	public String handleStep2Get(@RequestParam("book_id")Long book_id,Model model)
	{  
		
		List<Book> book=bookDao.selectBook(book_id);
		System.out.print("이거 가고있음");
		System.out.print(book);
		
		model.addAttribute("detail",book);
		return "/book/bookDetail"; }

	    
	@GetMapping("/book/bookLoan")
	public String loan() {
		return "/book/bookLoan";
	}
	
	
	@PostMapping("/book/bookLoan")//대출 서비스
	public  String loan(@RequestParam("id") String id,
			@RequestParam("book_id") Long book_id,
			Model model) {
		
		String value=bookDao.loan(id, book_id);
		model.addAttribute("loan",value);
		
		System.out.print("loan 값 중에 하나");
		System.out.print(value);
		
		return "/book/bookLoan";
		
	}
    
	@GetMapping("/book/bookReturn")
	public String turn() {
		return "/book/bookReturn";
	}

	@PostMapping("/book/bookReturn")//반납 서비스
	public String turn(@RequestParam("id") String id,
			@RequestParam("book_id") Long book_id,
			Model model) {
		String value=bookDao.turn(id,book_id);
		model.addAttribute("turn",value);
		return "/book/bookReturn";
	}
	
	@PostMapping("/book/extension")
	public String extension(@RequestParam("book_id") Long Id,
			Model model) {
		String value=bookDao.extension(Id);
		model.addAttribute("extension",value);
		return "/book/extension";
		
	}

}
