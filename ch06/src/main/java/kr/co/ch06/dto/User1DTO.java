package kr.co.ch06.dto;

import kr.co.ch06.entity.TB_User1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {

    private String userId;
    private String name;
    private String birth;
    private int age;

    // Entity 변환 메서드
    public TB_User1 toEntity(){
        return TB_User1.builder()
                .userId(userId)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}
