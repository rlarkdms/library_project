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
				rs.getString("publisher"),rs.getLong("times"),rs.getString("genre"),rs.getString("story"),rs.getString("image"));
		book.setBook_id(rs.getLong("book_id"));
	
	return book;

	});
	return results;
	}
	
	public List<Book> selectBook(Long id){
	    List<Book> results = jdbcTemplate.query("select * from book where book_id="+id+";",
	        (ResultSet rs, int rowNum)->{
	        Book book=new Book(rs.getLong("book_id"), rs.getString("book_name"), rs.getString("writer"),
	        	rs.getString("publisher"),rs.getLong("times"),rs.getString("genre"),rs.getString("story"),rs.getString("image"));
	        	book.setBook_id(rs.getLong("book_id"));
	        		return book;
	    });

	    return results;
	 	
	}
	
	public String loan(String id,Long book_id) {//대출 서비스.
		
		try {
		System.out.print("Loan 값이 들어오는지 확인");
		System.out.print(id);
		System.out.print(book_id);
		String results = jdbcTemplate.queryForObject("select borrow_confirm from Book where book_id=?",String.class,book_id);
        if (results.equals("대여중")) {
        	return "fail";
        }
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
	public String extension(Long Id) {
		try {
		       Calendar cal = Calendar.getInstance();
		        Date date = cal.getTime();
		        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

		        // 1일 더한다.
		        cal.add(Calendar.DATE, 7);
		        date = cal.getTime();
		        dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
	        
			String sql="UPDATE INTO borrow_list set book_return_date=? where Id=?";
			this.jdbcTemplate.update(sql,dateString);
			return "success";
		}catch(Exception e) {
			return "fail";
		}
	}
}
