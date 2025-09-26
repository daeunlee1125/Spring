package kr.co.ch09.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        // CORS 설정 : API를 요청하는 외부 요청 Origin 설정
        
        registry.addMapping("/**") // 서버의 모든 엔드포인트에 대해 허용
                .allowedOriginPatterns("http://192.168.0.207:5500") // 서버의 요청을 허용할 Origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 메서드
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true) // 자격증ㅇ명 허요ㅛㅇㅇㅇㅇㅇㅇㅇ
                .maxAge(3600);
    }
}
