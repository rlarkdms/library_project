package com.example.dao;

import java.sql.ResultSet;
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
	public List<Book> selectAll(String keyword) {
	List<Book> results = jdbcTemplate.query(("select * from Book where book_name like '%"+keyword+"%' or writer like '%"+keyword+"%' or publisher like '%"+keyword+"%' "),
	(ResultSet rs, int rowNum) -> {
		Book book=new Book(rs.getLong("book_id"), rs.getString("book_name"), rs.getString("writer"),
				rs.getString("publisher"),rs.getLong("times"),rs.getString("genre"));
		book.setBook_id(rs.getLong("book_id"));
	
	return book;

	});
	return results;
	}
}
