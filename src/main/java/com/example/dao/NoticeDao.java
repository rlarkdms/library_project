package com.example.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.dto.Member;
import com.example.dto.Notice;


public class NoticeDao {
	private JdbcTemplate jdbcTemplate;
	public NoticeDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List<Notice> selectAll(){
		List<Notice> results = jdbcTemplate.query("select * from notice",
				(ResultSet rs, int rowNum) -> {
					Notice notice = new Notice(rs.getLong("notice_id"), rs.getString("admin_id"),rs.getString("notice_title"),
							rs.getString("notice_date") ,rs.getString("notice_content") );
				notice.setNotice_id(rs.getLong("notice_id"));
		
				return notice;
				});
		return results;
	}
	
	public List<Notice> selectAdmin(String admin_id) {
	List<Notice> results = jdbcTemplate.query("select * from notice where admin_id='"+admin_id+"'",
	(ResultSet rs, int rowNum) -> {
		Notice notice = new Notice(rs.getLong("notice_id"), rs.getString("admin_id"),rs.getString("notice_title"),
				rs.getString("notice_date") ,rs.getString("notice_content") );
	notice.setNotice_id(rs.getLong("notice_id"));
	
	return notice;
	});
	return results;
	}
	public List<Notice> selectOne(Long notice_id){
		List<Notice> results = jdbcTemplate.query("select * from notice where notice_id='"+notice_id+"';",
				(ResultSet rs, int rowNum) -> {
					Notice notice = new Notice( rs.getLong("notice_id"), rs.getString("admin_id"),rs.getString("notice_title"),
							rs.getString("notice_date"),rs.getString("notice_content") );
				notice.setNotice_id(rs.getLong("notice_id"));
				return notice;
				});
				return results;
		
		
	
		
	}
	
    public String insert(Notice notice) {

    	try {
	       Calendar cal = Calendar.getInstance();
	        Date date = cal.getTime();
	        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

    	String sql="INSERT INTO notice(admin_id,notice_title,notice_date,notice_content)VALUES (?, ?, ?, ?)";
    	this.jdbcTemplate.update(sql,notice.getAdmin_id(),notice.getNotice_title(),dateString,notice.getNotice_content());
    	
    	return "???????????? ????????? ?????????????????????.";
    	}catch(Exception e) {
    		
    		System.out.print(e);
    		
    		return "???????????? ????????? ?????????????????????."; 
    	}
    	
    }
	public String delete(Long notice_id) {
		try {
	    	
    		String sql1="delete from notice where notice_id=?";
    		this.jdbcTemplate.update(sql1,notice_id);
    		System.out.print("?????? ??????");
    		
    	return "??????????????? ?????????????????????.";
    	}catch(Exception e) {
    		System.out.print(e);
    		
    	return "??????????????? ????????? ???????????????. ??????????????? ???????????????.";	
    	}
	}
    
}
