package kr.co.ch03.dto;

import lombok.*;


// lombok 기능이랭~~~
// DTO 만들고 이거 다 써주면 됨
@Getter // 이케 어노테이션 써주면 게터 메서드 내가 만들 필요 없고 자동생성됨!
@Setter
@ToString
@NoArgsConstructor // 파라미터 없는 생성자
@AllArgsConstructor // 모든 속성이 파라미터로 들어가는 생성자 (this.uid=uid 이케 초기화하는 놈)
@Builder
public class UserDTO {
    private String uid;
    private String name;
    private String birth;
    private int age;


}
