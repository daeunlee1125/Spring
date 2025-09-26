package kr.co.ch08.dto;

import kr.co.ch08.entity.User3;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User3DTO {
    private String userid;
    private String name;
    private String role;
    private String regDate;

    public User3 toEntity(){
        return User3.builder()
                .userid(userid)
                .name(name)
                .role(role)
                .build();
    }
}
