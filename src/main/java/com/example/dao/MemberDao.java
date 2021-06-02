package com.example.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
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
    public Member selectByEmail(String email) { 
        List<Member> results = jdbcTemplate.query("select * from member where email=?",
        		(ResultSet rs, int rowNum)->new Member(rs.getString("member_id"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
        			rs.getString("NAME"),rs.getString("PHONE")),email);

        return results.isEmpty() ? null : results.get(0);
  }  

    public void insert(Member member) {
    	String sql="INSERT INTO member(member_id,password,name,email,phone)VALUES (?, ?, ?, ?, ?)";
    	this.jdbcTemplate.update(sql,member.getId(),member.getPassword(),member.getName(),member.getEmail(),member.getPhone());
    	
    }

}
