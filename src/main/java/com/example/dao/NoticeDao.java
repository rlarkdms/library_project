package com.example.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.data.Member;
import com.example.data.Notice;


public class NoticeDao {
	private JdbcTemplate jdbcTemplate;
	public NoticeDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List<Notice> selectAll(String admin_id) {
	List<Notice> results = jdbcTemplate.query("select * from notice where admin_id='"+admin_id+"'",
	(ResultSet rs, int rowNum) -> {
		Notice notice = new Notice(rs.getLong("Notice_id"), rs.getString("Notice_title"), rs.getString("admin_id"),
	rs.getString("notice_content") );
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
    public String insert(Notice notice) {

    	try {
	       Calendar cal = Calendar.getInstance();
	        Date date = cal.getTime();
	        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

    	String sql="INSERT INTO notice(admin_id,notice_title,notice_date,notice_content)VALUES (?, ?, ?, ?)";
    	this.jdbcTemplate.update(sql,notice.getAdmin_id(),notice.getNotice_title(),dateString,notice.getNotice_content());
    	
    	return "공지사항 등록에 성공하였습니다.";
    	}catch(Exception e) {
    		
    		System.out.print(e);
    		
    		return "공지사항 등록에 실패하였습니다."; 
    	}
    	
    }
	public String delete(Long notice_id) {
		try {
	    	
    		String sql1="delete from notice where notice_id=?";
    		this.jdbcTemplate.update(sql1,notice_id);
    		System.out.print("삭제 완료");
    		
    	return "공지사항이 삭제되었습니다.";
    	}catch(Exception e) {
    		System.out.print(e);
    		
    	return "공지사항이 삭제가 안됐습니다. 관리자에게 문의하세요.";	
    	}
	}
    
}
