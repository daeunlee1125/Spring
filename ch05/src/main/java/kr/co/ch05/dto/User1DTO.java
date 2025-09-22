package kr.co.ch05.dto;

import lombok.*;

@Data // getter setter toString 대신해서 쓸 수 있다!
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {
    private String uid;
    private String name;
    private String birth;
    private int age;
}
