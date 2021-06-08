package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.dto.Book;
import com.example.dto.Book_List;

public class MyPageDao {
	private JdbcTemplate jdbcTemplate;
	public MyPageDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Book_List> selectReturnAll(String member_id) {//전부다 고르는거
		List<Book_List> results = jdbcTemplate.query(("select book.book_id,book.book_name,borrow_list.book_return_date,extend_confirm from borrow_list Inner join book on borrow_list.book_id=book.book_id where borrow_list.book_return_date>=CURDATE() and borrow_list.return_confrim=0 and borrow_list.member_id='"+member_id+"';"),
	(ResultSet rs, int rowNum) -> {
		Book_List turn=new Book_List(rs.getLong("book_id"),rs.getString("book_name"), rs.getString("book_return_date"), rs.getLong("extend_confirm"));
		turn.setBook_id(rs.getLong("book_id"));
	
	return turn;

	});
	return results;
	}

	
	public List<Book_List> selectexpiredAll(String member_id) {//연체된다 고르는거
	List<Book_List> results = jdbcTemplate.query(("select book.book_id,book.book_name,borrow_list.book_return_date,extend_confirm from borrow_list Inner join book on borrow_list.book_id=book.book_id where borrow_list.book_return_date<CURDATE() and borrow_list.return_confrim=0 and borrow_list.member_id='"+member_id+"';"),
	(ResultSet rs, int rowNum) -> {
		Book_List turn=new Book_List(rs.getLong("book_id"),rs.getString("book_name"), rs.getString("book_return_date"), rs.getLong("extend_confirm"));
		turn.setBook_id(rs.getLong("book_id"));
	
	return turn;

	});
	return results;
	}
	public String selectmemberName(String member_id) {
		try {
        String result = jdbcTemplate.queryForObject ("select name from member where member_id=?",
        		String.class,member_id);

        return result.isEmpty() ? null : result;
		}catch(Exception e) {
		
			System.out.print(e);
		return null; 
		}
	}
	public List<Book> history(String member_id){//히스토리 서비스
		
		
	    List<Book> results = jdbcTemplate.query("select * from borrow_list Inner join book on borrow_list.book_id=book.book_id where borrow_list.member_id='"+member_id+"';",
		        (ResultSet rs, int rowNum)->{
		        Book book=new Book(rs.getLong("book_id"), rs.getString("book_name"), rs.getString("writer"),
		        	rs.getString("publisher"),rs.getString("borrow_confirm"),rs.getLong("times"),rs.getString("genre"),rs.getString("story"),rs.getString("image"));
		        	book.setBook_id(rs.getLong("book_id"));
		        		return book;
		    });

		    return results;
		 	
		
	}
	
}
