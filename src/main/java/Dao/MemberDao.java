package Dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import Data.Member;
import java.sql.ResultSet;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<Member> selectAll() {
	List<Member> results = jdbcTemplate.query("select * from MEMBER",
	(ResultSet rs, int rowNum) -> {
	Member member = new Member( rs.getString("EMAIL"), rs.getString("PASSWORD"),
	rs.getString("NAME"),rs.getString("PHONE"), rs.getTimestamp("REGDATE").toLocalDateTime());
	member.setId(rs.getLong("ID"));
	return member;
	});
	return results;
	}
}
