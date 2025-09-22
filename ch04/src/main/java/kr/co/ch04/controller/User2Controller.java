package kr.co.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class User2Controller {

    @GetMapping("/user2/list")
    public String list(){
        return "user2/list";
    }

    @GetMapping("/user2/register")
    public String register(Model model){
        return "user2/register";
    }
}
