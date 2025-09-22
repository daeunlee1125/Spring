package kr.co.ch02.config;

import kr.co.ch02.sub1.Hello;
import kr.co.ch02.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy // Spring AOP 활성화
@Configuration // con/com 두 개 어노테이션은 기본으로 추가!
@ComponentScan(basePackages = {"kr.co.ch02"})
public class AppConfig {
    
    // 스프링 컨테이너 빈(객체) 등록
    // new랑 같은 거임
    @Bean
    public Hello hello() {
        return new Hello();
    }

    // 이름이 길 경우 이렇게 짧게 줄일 수도!
    @Bean(name="wc")
    public Welcome welcome() {
        return new Welcome();
    }
}
