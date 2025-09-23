package kr.co.ch06.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User3DTO {
    private String usId;
    private String name;
    private int age;
    private String addr;

}
