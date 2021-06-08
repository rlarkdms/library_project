package com.example;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dao.AdminDao;
import com.example.dao.BookDao;
import com.example.dao.MainDao;
import com.example.dao.MemberDao;
import com.example.dao.MemberRegisterService;
import com.example.dao.MyPageDao;
import com.example.dao.NoticeDao;

@Configuration
public class JavaConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
	DataSource ds = new DataSource();
	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	//내장 로컬 DB 사용.
	ds.setUrl("jdbc:mysql://localhost:3306/project?characterEncoding=utf8&serverTimezone=UTC");
	ds.setUsername("root");
	ds.setPassword("1234");
	ds.setInitialSize(2);
	ds.setMaxActive(10);
	ds.setTestWhileIdle(true);
	ds.setMinEvictableIdleTimeMillis(60000 * 3);
	ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
	return ds;
	}
	
	@Bean
	public MemberDao memberDao() { //MemberDao Bean 객체 등록.
	return new MemberDao(dataSource());
	}
	@Bean
	public NoticeDao noticeDao() { //NoticeDao Bean 객체 등록.
		return new NoticeDao(dataSource());
	}
    @Bean
    public MemberRegisterService memberRegSvc(){ //RegisterServiceDao Bean 객체 등록.
          return new MemberRegisterService(memberDao());
    }
    @Bean
    public BookDao bookDao() {   ////BookDao Bean 객체 등록.
    	return new BookDao(dataSource());
    }
    @Bean
    public AdminDao adminDao() {
    	return new AdminDao(dataSource());
    	
    }
    @Bean
    public MyPageDao mypageDao() {
    	return new MyPageDao(dataSource());
    }
    
    @Bean
    public MainDao mainDao() {
    	return new MainDao(dataSource());
    }
    
}
