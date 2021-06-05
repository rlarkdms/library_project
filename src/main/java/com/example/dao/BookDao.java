package com.example.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.data.Book;
import com.example.data.Member;

public class BookDao {
	private JdbcTemplate jdbcTemplate;
	public BookDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Book> selectAll(String keyword) {//전부다 고르는거
	List<Book> results = jdbcTemplate.query(("select * from Book where book_name like '%"+keyword+"%' or writer like '%"+keyword+"%' or publisher like '%"+keyword+"%' "),
	(ResultSet rs, int rowNum) -> {
		Book book=new Book(rs.getLong("book_id"), rs.getString("book_name"), rs.getString("writer"),
				rs.getString("publisher"),rs.getLong("times"),rs.getString("genre"));
		book.setBook_id(rs.getLong("book_id"));
	
	return book;

	});
	return results;
	}
	
	public String loan(String id,Long book_id) {//대출 서비스.
		
		try {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

        // 1일 더한다.
        cal.add(Calendar.DATE, 7);
        date = cal.getTime();
        dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
    	String sql="INSERT INTO borrow_list (member_id,book_id,book_return_date,extend_confirm,return_confirm)VALUES (?, ?, ?, ?, ?,?)";
    	this.jdbcTemplate.update(sql,id,book_id,dateString,false,false);
    	
    	return "success";
		}catch(Exception e) {
			return "fail";
		}
	}
	public String turn(String id,Long book_id) {//반납 서비스.
		try {
			
		String sql="UPDATE INTO borrow_list set return_confirm=true where id=? and book_id";
		this.jdbcTemplate.update(sql,id,book_id);
			
		return "success";
		}catch(Exception e) {
			
			return "fail";
		}
		
	}
//	public String extension(String id,Long book_id) {
//		try {
//	        String result = jdbcTemplate.queryForObject ("select member_id from member where member_id=? and password=?",
//	        		String.class,id,book_id);
//			
//	        
//			String sql="UPDATE INTO borrow_list set return_confirm=true where id=? and book_id=?"
//			this.jdbcTemplate.update(sql,)
//			return "success";
//		}catch(Exception e) {
//			return "fail";
//		}
//	}
}
