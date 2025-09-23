package kr.co.ch06.entity.board;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
// 엔티티 관계설정에서, 엔티티의 toString() 호출 시 또다른 엔티티의 toString이 호출되기 때문에,
// 엔티티간의 toString 호출로 stackOverflow 에러 발생
// 엔티티의 어느 한쪽에서는 toString() 호출을 제외(exclude)에서 순환 참조 호출 방지
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_User")
public class User {
    @Id
    private String userid;
    private String name;
    private int age;
}
