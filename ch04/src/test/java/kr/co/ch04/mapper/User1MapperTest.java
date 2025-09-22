package kr.co.ch04.mapper;

import kr.co.ch04.dto.User1DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class User1MapperTest {

    @Autowired
    private User1Mapper user1Mapper;

    private String user_id = "abc1233";

    @Order(1)
    @DisplayName("등록 테스트")
    @Test
    void insert() {
        // Given - 테스트를 실행하기 위한 준비 단계
        User1DTO user1DTO = User1DTO.builder()
                .user_id(user_id)
                .name("김유신")
                .birth("1992-01-03")
                .age(21)
                .build();

        // When - 테스트 수행
        user1Mapper.insert(user1DTO);

        // Then - 테스트 결과를 검증
        User1DTO savedUser = user1Mapper.select(user1DTO.getUser_id());
        assertEquals(user1DTO.getUser_id(), savedUser.getUser_id());

    }

    @Order(2)
    @DisplayName("조회 테스트")
    @Test
    void select() {
        // Given
        // String user_id = "abc1234";

        // When
        User1DTO findUser = user1Mapper.select(user_id);

        // Then
        System.out.println(findUser);
    }

    @Order(5)
    @DisplayName("전체 조회 테스트")
    @Test
    void selectAll() {
        // given

        // when
        List<User1DTO> dtoList = user1Mapper.selectAll();

        // then
        System.out.println(dtoList);
        assertFalse(dtoList.isEmpty());
    }

    @Order(3)
    @DisplayName("수정 테스트")
    @Test
    void update() {
        // Given
        User1DTO user1DTO = User1DTO.builder()
                .user_id(user_id)
                .name("김영희")
                .birth("1992-01-03")
                .age(25)
                .build();

        // When
        user1Mapper.update(user1DTO);

        // Then
        User1DTO modifiedUser = user1Mapper.select(user1DTO.getUser_id());
        assertEquals(user1DTO, modifiedUser);
    }

    @Order(4)
    @DisplayName("삭제 테스트")
    @Test
    void delete() {
        // Given
        // String user_id = "abc1237";

        // When
        user1Mapper.delete(user_id);

        // Then
        User1DTO findUser = user1Mapper.select(user_id);
        assertNull(findUser);
    }
}