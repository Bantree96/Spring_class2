package kr.inhatc.spring.configuration;

import java.io.IOException;

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
	
	@Bean
	public DataSource dataSource() throws Exception {
		// 데이터 소스를 만들때 hikariConfig()에 접근해 받아온다
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("=================>"+ dataSource.toString());
		return dataSource;
	}
	
	// sql문을 보관하기 위한 sql팩토리 생성
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		// mapper연결 : mapper란? 예를들어 마이바티스라고 치면 마이바티스의 위치정보?
//		sqlSessionFactoryBean.setMapperLocations(
//				// **은 뭐가 올지 모름
//				appContext.getResources("classpath:/mapper/**/sql-*.xml")
//				);
		
		// .getObject로 하면 sessionfactory로 리턴
		return sqlSessionFactoryBean.getObject();
		
	}
	
	// sql던지는걸 도와줌
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
