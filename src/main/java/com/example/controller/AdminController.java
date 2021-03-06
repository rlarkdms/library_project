package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.AdminDao;
import com.example.dao.BookDao;
import com.example.dao.NoticeDao;
import com.example.dto.Book;
import com.example.dto.Member;
import com.example.dto.Notice;

@Controller
public class AdminController {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	//관리자 페이지 책 기능 (책 생성,수정,삭제)///////////////////////////////////////////////////////////////// 
	
	@RequestMapping("/admin/adminPage")
	public String adminPage(@RequestParam("admin_id") String admin_id,
			Model model) {
		List<Book> booklist=adminDao.selectAll();
		String admin_name=adminDao.selectadminName(admin_id);
		List<Notice> notice_list=noticeDao.selectAdmin(admin_id);
		List<Member> memberlist=adminDao.selectAllmember();
		System.out.print("관리자 책검색");
		System.out.print(booklist);
		System.out.print(memberlist);
		model.addAttribute("member",memberlist);
		model.addAttribute("book_list",booklist);
		model.addAttribute("admin_name",admin_name);
		model.addAttribute("notice_list",notice_list);
		return "admin/adminPage";
	}
	
	@GetMapping("/admin/bookInsert")//책 삽입 페이지
	public String bookInsert() {
		return "/admin/bookInsert";
	}

	@RequestMapping("/admin/bookInsertCheck")//책 삽입하는 액션 페이지
	public String bookInsertCheck(
			@RequestParam("admin_id") String admin_id,
			@RequestParam("book_name") String book_name,
			@RequestParam("writer") String writer,
			@RequestParam("publisher") String publisher,
			@RequestParam("genre") String genre,
			@RequestParam("story") String story,
			@RequestParam("image") String image_thing,Model model) {
        
		
		Book newbook = new Book((long)0,book_name,writer,publisher,"가능",(long) 0,genre,story,image_thing);
        
        String book_insert=adminDao.insert(newbook);
		
        model.addAttribute("insert", book_insert);
        model.addAttribute("admin_id", admin_id);
        
		return "/admin/bookInsertCheck";
	}
	
	
	@RequestMapping("/admin/bookDelete")//책 삭제 이벤트
	public String bookDelete(
			@RequestParam("admin_id") String admin_id,
			@RequestParam("book_id") Long book_id, Model model) {
		
		String delete_status=adminDao.delete(book_id);
		
		System.out.print(delete_status);
		model.addAttribute("delete",delete_status);
		model.addAttribute("admin_id",admin_id);
		
		
		
		return "/admin/bookDelete";
	}
	
}
