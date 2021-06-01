package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Dao.MemberDao;

@Configuration
public class JavaConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
	DataSource ds = new DataSource();
	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost/project?characterEncoding=utf8&serverTimezone=UTC");
	ds.setUsername("spring5");
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
}
