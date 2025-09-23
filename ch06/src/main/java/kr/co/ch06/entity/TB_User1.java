package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User1DTO;
import lombok.*;

@Getter
// @Setter (Entity는 불변! setter 사용 X)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // Entity 객체 선언 어노테이션
@Table(name = "TB_User1")
public class TB_User1 {

    @Id // PK 컬럼 선언
    @Column(name="user_id")
    private String userId;

    @Column(name = "name") // 매킹 컬럼, 일반적으로 생략
    private String name;

    private String birth;
    private int age;

    // DTO 변환 메서드 정의
    public User1DTO toDTO(){
        return User1DTO.builder()
                .userId(userId)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }

}
