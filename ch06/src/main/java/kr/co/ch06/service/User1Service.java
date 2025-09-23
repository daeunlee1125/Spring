package kr.co.ch06.service;

import jakarta.persistence.Entity;
import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.entity.TB_User1;
import kr.co.ch06.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void save(User1DTO user1DTO){
        user1Repository.save(user1DTO.toEntity());
    }

    public List<User1DTO> getUsers(){
        List<TB_User1> list =  user1Repository.findAll();

        // DTO list로 변환해줘야겠죵!?
        // 위의 for문 변환이랑 아래의 stream 변환이랑 의미적으로 같은 거임
        // 암거나 써도 댐~~

        /*
        List<User1DTO> dtoList = new ArrayList<>();
        for (TB_User1 user : list){
            dtoList.add(user.toDTO());
        }
         */
        List<User1DTO> dtoList  = list.stream()
                .map(Entity -> Entity.toDTO())
                .collect(Collectors.toList());


        return dtoList;
    }

    public User1DTO getUser(String user_id){
        /*
            findById() : JPA 기본 select 메서드, 반환값은 Option 타입
            Optional<엔티티> 타입은 null 체크 검증을 안전하게 처리하기 위한 JPA 반환 타입
         */
        Optional<TB_User1> optUser1 = user1Repository.findById(user_id);
        // 해당 사용자 Entity가 존재하면 안전하게 처리
        // 옵셔널 박스에서 get으로 엔티티를 꺼내어 쓴당
        if (optUser1.isPresent()){
            TB_User1 user1 = optUser1.get();
            // Entity를 DTO로 변환해준다!
            return user1.toDTO();
        }
        // 사용자 Entity 존재하지 않으면 null 반환
        return null;
    }

    public void modify(User1DTO user1DTO){
        // 수정 대상 Entity 존재 확인
        if (user1Repository.existsById(user1DTO.getUserId())){
            // DTO를 Entity로 변환
            TB_User1 user = user1DTO.toEntity();

            // 기존 Entity값을 save로 수정
            user1Repository.save(user); 
        }

    }

    public void delete(String user_id){
        // JPA 기본 삭제 메서드
        user1Repository.deleteById(user_id);
    }
}
