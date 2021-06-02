package com.example;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dao.MemberDao;
import com.example.dao.MemberRegisterService;
import com.example.dao.NoticeDao;

@Configuration
public class JavaConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
	DataSource ds = new DataSource();
	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
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
	public MemberDao memberDao() {
	return new MemberDao(dataSource());
	}
	@Bean
	public NoticeDao noticeDao() {
		return new NoticeDao(dataSource());
	}
    @Bean
    public MemberRegisterService memberRegSvc() {
          return new MemberRegisterService(memberDao());
    }

}
