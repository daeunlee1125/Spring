package kr.co.ch04.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataRedisTest
@Import(RedisService.class)
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    void setValue() {
        String key = "user1:a101:name";
        String value = "김유신";

        redisService.setValue(key, value);

        //then
        assertEquals(value, redisService.getValue(key));
    }

    @Test
    void getValue() {
    }

    @Test
    void addToListFromRight() {
    }

    @Test
    void addToListFromLeft() {
    }

    @Test
    void getFromList() {
    }

    @Test
    void getRangeFromList() {
    }

    @Test
    void addToSet() {
    }

    @Test
    void getFromSet() {
    }

    @Test
    void addToHash() {
    }

    @Test
    void getFromHash() {
    }
}