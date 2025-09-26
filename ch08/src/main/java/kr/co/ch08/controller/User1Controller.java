package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController // 해당 컨트롤러의 요청 메서드의 반환값을 View로 출력하지 않고 응답객체 Response body로 출력, JSON 출력
public class User1Controller {

    private final User1Service user1Service;


    @GetMapping("/user1")
    public ResponseEntity<List<User1DTO>> list(){
        List<User1DTO> dtoList = user1Service.getUserAll();

        // 다양한 결과 정보를 출력하기 위해 ResponseEntity로 데이터 전송
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    @GetMapping("/user1/{userid}")
    // @PathVariable은 받아온 파라미터를 변수에 매핑해줌
    public ResponseEntity<User1DTO> user1(@PathVariable("userid") String userid){
        log.info("user1 ==> userid={}", userid);
        User1DTO dto = user1Service.getUser(userid);

        return ResponseEntity
                .status(HttpStatus.FOUND).body(dto);
    }

    @PostMapping("/user1")
    // @RequestBody는 post 요청으로 받은 Json을 DTO 형식으로 변환해줌
    public ResponseEntity<User1DTO> register(@Valid @RequestBody User1DTO user1DTO){
        log.info("user1DTO={}",user1DTO);
        User1DTO savedUser1 = user1Service.save(user1DTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser1);
    }

    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO user1DTO){
        // @RequestBody : 요청 객체 body로 전송되는 JSON 데이터 수신
        log.info("user1DTO={}",user1DTO);
        User1DTO modifiedUser1 = user1Service.modify(user1DTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser1);
    }

    @DeleteMapping("/user1/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid){
        log.info("user1 ==> userid={}", userid);
        boolean isSuccess = user1Service.delete(userid);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
