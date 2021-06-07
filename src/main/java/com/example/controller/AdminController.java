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
import com.example.data.Book;
import com.example.data.Member;

@Controller
public class AdminController {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AdminDao adminDao;
	
	//관리자 페이지 책 기능 (책 생성,수정,삭제)///////////////////////////////////////////////////////////////// 
	
	@RequestMapping("/admin/adminPage")
	public String adminPage(@RequestParam("admin_id") String admin_id,
			Model model) {
		List<Book> booklist=adminDao.selectAll();
		String admin_name=adminDao.selectadminName(admin_id);
		System.out.print("관리자 책검색");
		System.out.print(booklist);
		model.addAttribute("book_list",booklist);
		model.addAttribute("admin_name",admin_name);
		
		return "admin/adminPage";
	}
	
	@GetMapping("/admin/bookInsert")
	public String bookInsert() {
		return "/admin/bookInsert";
	}
	
	@RequestMapping("/admin/bookInsertCheck")
	public String bookInsert(
			@RequestParam("admin_id") String admin_id,
			@RequestParam("book_name") String book_name,
			@RequestParam("writer") String writer,
			@RequestParam("publisher") String publisher,
			@RequestParam("genre") String genre,
			@RequestParam("story") String story,
			@RequestParam("image") String image_thing,Model model) {
        
		System.out.print(admin_id);
		System.out.print(book_name);
		System.out.print(writer);
		System.out.print(publisher);
		System.out.print(genre);
		System.out.print(story);
		System.out.print(image_thing);
		
		Book newbook = new Book((long)0,book_name,writer,publisher,(long) 0,genre,story,image_thing);
        
        String book_insert=adminDao.insert(newbook);
		
        model.addAttribute("book", book_insert);
        model.addAttribute("admin_id", admin_id);
        
		return "/admin/bookInsertCheck";
	}
	
	
	@RequestMapping("/admin/bookDelete")
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
