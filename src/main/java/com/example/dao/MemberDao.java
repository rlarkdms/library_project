package com.example.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.example.data.Member;


public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Member> selectAll() {
	List<Member> results = jdbcTemplate.query("select * from MEMBER",
	(ResultSet rs, int rowNum) -> {
	Member member = new Member(rs.getString("member_id"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
	rs.getString("NAME"),rs.getString("PHONE"));
	member.setId(rs.getString("member_ID"));
	return member;
	});
	return results;
	}	
    public Member selectByID(String id) { 
        List<Member> results = jdbcTemplate.query("select * from member where member_id=?",
        		(ResultSet rs, int rowNum)->new Member(rs.getString("member_id"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
        			rs.getString("NAME"),rs.getString("PHONE")),id);

        return results.isEmpty() ? null : results.get(0);
  }  

    public void insert(Member member) {

    	String sql="INSERT INTO member(member_id,password,name,email,phone,borrow_confirm)VALUES (?, ?, ?, ?,?,?)";
    	this.jdbcTemplate.update(sql,member.getId(),member.getPassword(),member.getName(),member.getEmail(),member.getPhone(),false);
    	
    }
    public String ConfirmIDPWD(String ID,String PWD) {
    	try {
        String result = jdbcTemplate.queryForObject ("select member_id from member where member_id=? and password=?",
        		String.class,ID,PWD);

        return result.isEmpty() ? null : result;
    	
    }catch(EmptyResultDataAccessException e) {
    	System.out.print("회원가입 실패");
    	return null;
    }
    
    }
   
    public String edit(String member_id,String password,String pwconfirm,String name,String email,String phone) {
    try {
    	
		String sql1="UPDATE member set password=? where member_id=?";
		this.jdbcTemplate.update(sql1,password,member_id);
		String sql2="UPDATE member set name=? where member_id=?";
		this.jdbcTemplate.update(sql2,name,member_id);
		String sql3="UPDATE member set email=? where member_id=?";
		this.jdbcTemplate.update(sql3,email,member_id);
		String sql4="UPDATE member set phone=? where member_id=?";
		this.jdbcTemplate.update(sql4,phone,member_id);

		
		
    	return "수정되었습니다.";
    }catch(Exception e) {
    	
    	System.out.print(e);
    	return "수정에 실패하였습니다.";
    }
    
    
    }

    public String leave(String member_id) {
    	try {
    	
    		String sql1="delete from member where member_id=?";
    		this.jdbcTemplate.update(sql1,member_id);
    		System.out.print("확인 여기까지 되나?");
    	return "탈퇴되었습니다.";
    	}catch(Exception e) {
    		System.out.print(e);
    		
    	return "빌린도서를 다 반납하세요.탈퇴에 실패하였습니다.";	
    	}
    }
}
