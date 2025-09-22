package kr.co.ch04.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {
    String user_id;
    String name;
    String birth;
    String age;
}
