package com.example.dto;

import java.sql.Date;

public class Book_List {

	private Long book_id;
	private String book_name;
	private String return_date;
	private Long extend_confirm;
	
	public Book_List(Long book_id,String book_name,String return_date,Long extend_confirm) {
		this.book_id=book_id;
		this.book_name=book_name;
		this.return_date=return_date;
		this.extend_confirm=extend_confirm;
		
	}
	

	public Long getBook_id() {
		return book_id;
	}


	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}



	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public Long getExtend_confirm() {
		return extend_confirm;
	}

	public void setExtend_confirm(Long extend_confirm) {
		this.extend_confirm = extend_confirm;
	}
	
	
	
}
