package kr.co.ch4.controller;

import kr.co.ch4.dto.User1DTO;
import kr.co.ch4.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j // logger
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service service;

    @GetMapping("/user1/register")
    public String register(){
        return "user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){

        System.out.println(user1DTO);
        service.save(user1DTO);


        return "redirect:/user1/list";
    }

    @GetMapping("/user1/list")
    public String list(Model model){

        List<User1DTO> dtoList = service.getUsers();

        model.addAttribute("dtoList",dtoList);

        return "user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(Model model, @RequestParam String user_id){

        User1DTO user1DTO = service.getUser(user_id);
        model.addAttribute(user1DTO);

        return "user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        service.update(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(@RequestParam String user_id){
        service.delete(user_id);
        return "redirect:/user1/list";
    }






}
