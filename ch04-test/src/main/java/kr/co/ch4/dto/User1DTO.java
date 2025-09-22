package kr.co.ch4.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {
    String user_id;
    String name;
    String birth;
    int age;


}
