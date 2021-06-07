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
	
	// 책 서비스(책 디테일,대여,반납,연장 서비스) 컨트롤러//////////////////////////////////////////////
	
	@RequestMapping("/book/bookDetail")//책 디테일 페이지.
	public String handleStep2Get(@RequestParam("book_id")Long book_id,
			Model model){  	
		List<Book> book=bookDao.selectBook(book_id);
		System.out.print("책 디테일 페이지 가는 값 :");
		System.out.println(book);
		List<Book> book_recommend=bookDao.recommend(book_id);
		
		
		model.addAttribute("recommend",book_recommend);//detail에 book 값 전달.
		model.addAttribute("detail",book);//detail에 book 값 전달.
		return "/book/bookDetail"; }

	
	@PostMapping("/book/bookLoan")//대출 서비스
	public  String loan(@RequestParam(value="id") String id,
			@RequestParam("book_id") Long book_id,
			Model model) {
	
		String loan=bookDao.loan(id, book_id);
		
		System.out.print("대여 서비스 확인 값 :");
		System.out.println(loan);
		
		model.addAttribute("loan",loan);//loan에 value값 전달.
		
		return "/book/bookLoan";
		
	}

	@RequestMapping("/book/bookReturn")//반납 서비스
	public String re_turn(@RequestParam("member_id") String member_id,
			@RequestParam("book_id") Long book_id,
			Model model) {
		
		
		String book_return=bookDao.turn(member_id,book_id);
		System.out.print("반납 확인 서비스 상태 : ");
		System.out.println(book_return);
		model.addAttribute("turn",book_return);
		model.addAttribute("member_id",member_id);//북에서 해당 Mypage로 돌아오기 위한 값 전달.
		
		return "/book/bookReturn";
	}
	

	@RequestMapping("/book/bookExtend")//연장 서비스
	public String extension(@RequestParam("book_id") Long book_id,
			@RequestParam("member_id") String member_id,
			Model model) {
		String value=bookDao.extension(member_id,book_id);
		model.addAttribute("extend",value);
		model.addAttribute("member_id",member_id);
		return "/book/bookExtend";
		
	}
	

}
