package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.data.Notice;


public class NoticeDao {
	private JdbcTemplate jdbcTemplate;
	public NoticeDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Notice> selectAll() {
	List<Notice> results = jdbcTemplate.query("select * from notice",
	(ResultSet rs, int rowNum) -> {
		Notice notice = new Notice( rs.getString("Notice_title"), rs.getString("admin_id"),
	rs.getTimestamp("Notice_date").toLocalDateTime(),rs.getString("notice_content") );
	notice.setNotice_id(rs.getLong("notice_id"));
	return notice;
	});
	return results;
	}
//	public List<Notice> selectOne(String id){
//		List<Notice> results = jdbcTemplate.query("select * from notice",
//				(ResultSet rs, int rowNum) -> {
//					Notice notice = new Notice( rs.getString("Notice_title"), rs.getString("admin_id"),
//				rs.getTimestamp("Notice_date").toLocalDateTime(),rs.getString("notice_content") );
//				notice.setNotice_id(rs.getLong("notice_id"));
//				return notice;
//				});
//				return results;
//		
//		
//	
//		
//	}
//	
}
