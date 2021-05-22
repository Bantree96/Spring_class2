package kr.inhatc.spring.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 설정과 관련된건 @configuration으로 설정파일 선언
@Configuration
// DB세팅을 사용하기 위해 application.properties에 접근 경로를 잡아줌
@PropertySource("classpath:/application.properties")
public class DataBaseConfiguration {

	@Autowired
	private ApplicationContext appContext;
	
	// 메모리가 시작되는순간 Bean으로된 애들은 자동으로 올라옴
	@Bean
	// 편의성을 위한 접두어 설정
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	// DB하고 hikari를 연결하기 위해 dataSource를 사용
	@Bean
	public DataSource dataSource() throws Exception {
		// 데이터 소스를 만들때 hikariConfig()에 접근해 받아온다
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("=================>"+ dataSource.toString());
		return dataSource;
	}
	
	/**
	 * JPA 설정
	 * JPA 설정 Bean 등록
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.jpa")
	public Properties hibernateConfig() {
		return new Properties();
	}
	
}
