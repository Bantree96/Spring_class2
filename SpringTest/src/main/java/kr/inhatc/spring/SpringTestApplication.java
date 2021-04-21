package kr.inhatc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

// 실제로는 얘가 도는거임
// 원래 스프링에서 파일관련해서 Multipart라는애가 담당함.
// exclude부분 : 첨부파일과 관련된 자동 구성을 사용하지 않도록 설정한다. -> WebMvcConfiguration.java에서 따로 만들어 줬기 때문
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class SpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

}
