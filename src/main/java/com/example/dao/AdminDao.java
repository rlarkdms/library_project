package com.example.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.data.Book;
import com.example.data.Member;

public class AdminDao {
	private JdbcTemplate jdbcTemplate;
	public AdminDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
    public String ConfirmIDPWD(String ID,String PWD) {
    	try {
        String result = jdbcTemplate.queryForObject ("select Admin_id from admin where Admin_id=? and password=?",
        		String.class,ID,PWD);

        return result.isEmpty() ? null : result;
    	
    	}catch(EmptyResultDataAccessException e) {
    	System.out.print(e);
    	return null;
    	}
    }
    
    
    public String insert(Book book) {
    	try {
    	Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);


    	String sql="INSERT INTO book(book_id,book_name,writer,publisher,times,genre,borrow_confirm,registrationdate,story,image)VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
    	this.jdbcTemplate.update(sql,book.getBook_id(),book.getBook_name(),book.getWriter(),book.getPublisher(),book.getTimes(),book.getGenre(),"가능",dateString,book.getStory(),book.getImage());
    	
    	return "책 등록에 성공하였습니다.";
    }catch(Exception e) {
    	System.out.print(e);
    	return "책의 같은 아이디번호가 있어 등록에 실패하였습니다.";
    }
    
    }
}
