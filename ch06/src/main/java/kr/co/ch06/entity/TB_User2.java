package kr.co.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User2DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_User2")
public class TB_User2 {
    @Id
    private String userId;
    private String name;
    private String hp;
    private String gender;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .userId(userId)
                .name(name)
                .hp(hp)
                .gender(gender)
                .build();
    }
}
