package kr.co.ch08.controller;

import jakarta.validation.constraints.NotNull;
import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class User2Controller {
    private final User2Service user2Service;

    @GetMapping("/user2")
    public ResponseEntity<List<User2DTO>> list(){
        List<User2DTO> dtoList = user2Service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }
    @GetMapping("/user2/{userid}")
    public ResponseEntity<User2DTO> findUser2(@PathVariable String userid){
        User2DTO user2 = user2Service.findById(userid);
        return ResponseEntity.status(HttpStatus.OK).body(user2);
    }

    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@RequestBody User2DTO user2DTO){
        User2DTO user2 = user2Service.insert(user2DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user2);
    }

    @PutMapping("/user2")
    public ResponseEntity<User2DTO> update(@RequestBody User2DTO user2DTO){
        User2DTO user2 = user2Service.modify(user2DTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user2);
    }

    @DeleteMapping("/user2/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable String userid){
        boolean istrue = user2Service.delete(userid);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(istrue);
    }
}
