package kr.co.ch4.controller;

import kr.co.ch4.dto.User2DTO;
import kr.co.ch4.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2/list")
    public String list(){
        return "user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){
        user2Service.register(user2DTO);
        return "redirect:/user2/list";
    }
}
