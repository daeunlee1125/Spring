package kr.co.ch4.dao;

import kr.co.ch4.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// @component의 역할!!
// 이 클래스의 객체를 생성해서 컨테이너에 등록한다!!
// 그 컴포넌트에 의미를 추가로 부여한 어노테이션들이
// @Controller @Service @Repository 이런 놈들
@Repository
@RequiredArgsConstructor
public class User1DAO {
    
    // 쿼리 실행해주는
    // Spring JDBC 객체
    private final JdbcTemplate jdbcTemplate;

    public void insert(User1DTO user1DTO) {
        String sql = "INSERT INTO TB_USER1 VALUES (?,?,?,?)";

        Object[] params = {
                user1DTO.getUser_id(),
                user1DTO.getName(),
                user1DTO.getBirth(),
                user1DTO.getAge()
        };

        jdbcTemplate.update(sql, params); // executeUpdate() 실행


    }

    public User1DTO select(String user_id) {

        String sql = "SELECT * FROM TB_USER1 WHERE USER_ID = ?";
        return jdbcTemplate.queryForObject(sql, new User1RowMapper(), user_id);

    }

    public List<User1DTO> selectAll(){

        String sql = "SELECT * FROM TB_USER1";
        return jdbcTemplate.query(sql, new User1RowMapper());

    }

    public void update(User1DTO user1DTO) {
        String sql = "Update TB_USER1 set NAME = ?, BIRTH = ?, AGE = ? where USER_ID = ?";

        Object[] params = {
                user1DTO.getName(),
                user1DTO.getBirth(),
                user1DTO.getAge(),
                user1DTO.getUser_id()
        };

        jdbcTemplate.update(sql, params);
    }

    public void delete(String user_id) {
        String sql = "DELETE FROM TB_USER1 WHERE USER_ID = ?";
        jdbcTemplate.update(sql, user_id);
    }

}
