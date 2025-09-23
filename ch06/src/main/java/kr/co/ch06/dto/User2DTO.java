package kr.co.ch06.dto;

import kr.co.ch06.entity.TB_User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {
    private String userId;
    private String name;
    private String hp;
    private String gender;

    public TB_User2 toEntity(){
        return TB_User2.builder()
                .userId(userId)
                .name(name)
                .hp(hp)
                .gender(gender)
                .build();
    }
}
