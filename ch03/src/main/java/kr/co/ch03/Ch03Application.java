package kr.co.ch03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch03Application {

    public static void main(String[] args) {

        SpringApplication.run(Ch03Application.class, args);
        // 이거 실행하고 주소창에 localhost8080/ 치면
        // 처음으로 DispatcherServlet 실행

        System.out.println("Hello Spring Boot!");

    }

}
