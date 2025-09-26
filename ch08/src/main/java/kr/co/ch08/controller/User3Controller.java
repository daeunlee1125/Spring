package kr.co.ch08.controller;

import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.entity.User3;
import kr.co.ch08.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service user3Service;

    @GetMapping("/user3")
    public ResponseEntity<List<User3DTO>> list(){
        List<User3DTO> dtos = user3Service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/user3")
    public ResponseEntity<User3DTO> insert(@RequestBody User3DTO user3DTO) {
        User3DTO user3 = user3Service.insert(user3DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user3);
    }

}
