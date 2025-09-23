package kr.co.ch06.controller;

import kr.co.ch06.dto.User2DTO;
import kr.co.ch06.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User2Controller {
    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model){
        model.addAttribute("dtoList", service.getAllUsers());
        return "user2/list";

    }

    @GetMapping("/user2/register")
    public String register(){
        return "user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        service.save(dto);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(Model model, String userId){
        model.addAttribute("dto", service.getUserById(userId));
        return "user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO dto){
        service.modify(dto);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String userId){
        service.delete(userId);
        return "redirect:/user2/list";
    }


}
