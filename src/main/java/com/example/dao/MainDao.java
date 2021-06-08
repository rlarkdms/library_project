package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.example.dto.Book;

@Controller
public class MainDao {

	private JdbcTemplate jdbcTemplate;
	public MainDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Book> bookbestSeller(){
	    List<Book> results = jdbcTemplate.query("SELECT * from book order by times DESC",
		        (ResultSet rs, int rowNum)->{
		        Book book=new Book(rs.getLong("book_id"), rs.getString("book_name"), rs.getString("writer"),
		        	rs.getString("publisher"),rs.getString("borrow_confirm"),rs.getLong("times"),rs.getString("genre"),rs.getString("story"),rs.getString("image"));
		        	book.setBook_id(rs.getLong("book_id"));
		        		return book;
		    });

		    return results;
		 	
		
	}
	public List<Book> newBooks(){
	    List<Book> results = jdbcTemplate.query("SELECT * from book where year(registrationdate) = year(now()) and month(registrationdate) = month(now()) order by book_id ASC",
		        (ResultSet rs, int rowNum)->{
		        Book book=new Book(rs.getLong("book_id"), rs.getString("book_name"), rs.getString("writer"),
		        	rs.getString("publisher"),rs.getString("borrow_confirm"),rs.getLong("times"),rs.getString("genre"),rs.getString("story"),rs.getString("image"));
		        	book.setBook_id(rs.getLong("book_id"));
		        		return book;
		    });

		    return results;
		 	
		
	}
}
