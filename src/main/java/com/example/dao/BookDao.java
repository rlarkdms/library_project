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
		
		int zero_num=0;
		try {

		String results = jdbcTemplate.queryForObject("select borrow_confirm from Book where book_id=?",String.class,book_id);
        System.out.print(results);
		if (results.equals("대여중")) {
        	return "이미 대여중이라 대여가 불가능합니다.";
        }
		Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

        System.out.println("여기까지 되는지 확인");

        // 1일 더한다.
        cal.add(Calendar.DATE, 7);
        date = cal.getTime();
        dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
		System.out.print(id);
		System.out.print(book_id);
        String sql="INSERT INTO borrow_list (member_id,book_id,book_return_date) VALUES (?, ?, ?)";
    	this.jdbcTemplate.update(sql,id,book_id,dateString);
    	System.out.print("이거 되는지 확인");
    	
		String sql_update1="UPDATE book set borrow_confirm='대여중' where book_id=?";

		this.jdbcTemplate.update(sql_update1,book_id);
    	
    	
    	return "대여가 완료되었습니다.";
		}catch(Exception e) {
			System.out.print(e);
			return "fail";
		}
	}
	public String turn(String member_id,Long book_id) {//반납 서비스.
		try {
		
	
		System.out.print("turn 확인");
		System.out.print(member_id);
		
		System.out.print(book_id);
		
		String sql1="UPDATE borrow_list set return_confrim=1 where member_id=? and book_id=? and return_confrim=0";
		this.jdbcTemplate.update(sql1,member_id,book_id);
		
		String sql2="UPDATE book set borrow_confirm='가능' where book_id=?";
		this.jdbcTemplate.update(sql2,book_id);
			
		return "반납에 성공했습니다.";
		}catch(Exception e) {
			System.out.print(e);
			return "반납에 실패하였습니다. 관리자에게 문의해주세요";
		}
		
	}
	public String extension(String member_id,Long book_id) {
		try {
			int results = jdbcTemplate.queryForObject("select extend_confirm from borrow_list where member_id=? and book_id=? and return_confrim=0",int.class,member_id,book_id);
			if(results==1) {
				return "이미 연장을 한번 하셨습니다.";
			}
		       Calendar cal = Calendar.getInstance();
		        Date date = cal.getTime();
		        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

		        // 1일 더한다.
		        cal.add(Calendar.DATE, 7);
		        date = cal.getTime();
		        dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
	        
			String sql="UPDATE borrow_list set book_return_date=? where member_id=? and book_id=? and return_confrim=0 and extend_confirm=0";
			this.jdbcTemplate.update(sql,dateString,member_id,book_id);
			return "연장되었습니다.";
		}catch(Exception e) {
			System.out.print(e);
			return "연장에 실패하였습니다. 관리자에게 문릐해주세요.";
		}
	}
}
