package com.example.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.ResultSet;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.data.Member;


public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Member> selectAll() {
	List<Member> results = jdbcTemplate.query("select * from MEMBER",
	(ResultSet rs, int rowNum) -> {
	Member member = new Member( rs.getString("EMAIL"), rs.getString("PASSWORD"),
	rs.getString("NAME"),rs.getString("PHONE"));
	member.setId(rs.getString("member_ID"));
	return member;
	});
	return results;
	}
}
