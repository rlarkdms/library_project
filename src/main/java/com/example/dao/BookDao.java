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
	List<Book> results = jdbcTemplate.query("select * from Book where book_name like '%?%' or writer like '%?%' or publisher like '%?%' ",
	(ResultSet rs, int rowNum) -> new Book(rs.getLong("notice_id"), rs.getString("admin_id"), rs.getString("notice_title"),
			rs.getTimestamp("REGDATE").toLocalDateTime(),rs.getString("notice_content")),keyword,keyword,keyword);
	
	return results;
	}	
}
