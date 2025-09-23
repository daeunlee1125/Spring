package kr.co.ch06.repository;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.entity.TB_User1;
import kr.co.ch06.entity.Parent;
import kr.co.ch06.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // JpaRepository<1, 2> 1번에 entity, 2번에는 해당 Entity의 기본키 자료형
public interface User1Repository extends JpaRepository<TB_User1,String> {
    // 사용자 쿼리 메서드 정의
    public TB_User1 findByUserId(String userId);
    public List<TB_User1> findUser1ByName(String name);
    public List<TB_User1> findTB_User1ByNameNot(String name); // select * from TB_User1 where name !=?

    public TB_User1 findTB_User1ByUserIdAndName(String userId, String name);
    public List<TB_User1> findTB_User1ByUserIdOrName(String userId, String name);

    public List<TB_User1> findTB_User1ByAgeGreaterThan(int age);
    public List<TB_User1> findTB_User1ByAgeGreaterThanEqual(int age);
    public List<TB_User1> findTB_User1ByAgeLessThan(int age);
    public List<TB_User1> findTB_User1ByAgeLessThanEqual(int age);
    public List<TB_User1> findTB_User1ByAgeBetween(int low, int high);

    public List<TB_User1> findTB_User1ByNameLike(String name);
    public List<TB_User1> findTB_User1ByNameContains(String name);
    public List<TB_User1> findTB_User1ByNameStartsWith(String name);
    public List<TB_User1> findTB_User1ByNameEndsWith(String name);

    public List<TB_User1> findTB_User1ByOrderByName();
    public List<TB_User1> findTB_User1ByOrderByAgeAsc();
    public List<TB_User1> findTB_User1ByOrderByAgeDesc();
    public List<TB_User1> findTB_User1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countTB_User1ByUserId(String userId);
    public int countTB_User1ByName(String name);

    // JPQL(JPA SQL) 실습
    @Query("SELECT u1 FROM TB_User1 as u1 WHERE u1.age < 30")
    public List<TB_User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM TB_User1 as u1 WHERE u1.name =?1") // 1은 그냥 번호 의미한다는데?? 먼말이지
    public List<TB_User1> selectUser1WhereName();

    @Query("SELECT u1 FROM TB_User1 as u1 WHERE u1.birth = :birth") // 1은 그냥 번호 의미한다는데?? 먼말이지
    public List<TB_User1> selectUser1WhereBirth(@Param("birth") String birth);

    @Query("SELECT u1.userId, u1.name, u1.age FROM TB_User1 as u1 WHERE u1.userId = :userId") // 1은 그냥 번호 의미한다는데?? 먼말이지
    public List<Object[]> selectUser1WhereId(@Param("userId") String userId);

    @Query("SELECT p, c FROM Parent as p " +
            "JOIN Child as c ON p.pid = c.pid " +
            "WHERE p.pid = :pid")
    public List<Object[]> selectParentJoinChild(@Param("pid") String pid);

}
