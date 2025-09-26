package kr.co.ch09.jwt;

import io.jsonwebtoken.Claims;
import kr.co.ch09.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;


@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .usid("a101")
                .pass("1234")
                .name("홍길동")
                .role("ADMIN")
                .age(23)
                .build();
        String token = jwtProvider.createToken(user, 1);
        System.out.println(token);

    }

    @Test
    void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkYWV1bmxlZTExMjVAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYyODc2LCJleHAiOjE3NTg4NDkyNzYsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.6Sq_risqh8U5VrO3CxARZtKG6_I0KcTz_x1-qfa-KuY";
        jwtProvider.getClaims(token);

        Claims claims = jwtProvider.getClaims(token);
        System.out.println(claims);

    }

    @Test
    void getAuthentication() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkYWV1bmxlZTExMjVAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYyODc2LCJleHAiOjE3NTg4NDkyNzYsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.6Sq_risqh8U5VrO3CxARZtKG6_I0KcTz_x1-qfa-KuY";

        Authentication authentication = jwtProvider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        System.out.println(user);
    }

    @Test
    void validateToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkYWV1bmxlZTExMjVAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYyODc2LCJleHAiOjE3NTg4NDkyNzYsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.6Sq_risqh8U5VrO3CxARZtKG6_I0KcTz_x1-qfa-KuY";
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkYWV1bmxlZTExMjVAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYzNTk2LCJleHAiOjE3NTg2NzcxOTYsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.dyKWj81z3lGedhqj7oNmFu3tGytraeZGMqTrVJGmVaY";
        // 날짜 지난 토큰 검증하면 expired 예외 발생

        try {
            jwtProvider.validateToken(token); // void형이죠? 이상 있으면 예외 발생
            System.out.println("토큰 이상 없음...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}