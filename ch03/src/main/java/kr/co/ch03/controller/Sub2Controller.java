package kr.co.ch03.controller;

import kr.co.ch03.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sub2Controller {

    @GetMapping("/sub2/register")
    public String register(){
        return "/sub2/register";
    }

    @PostMapping("/sub2/register")
    public String register(UserDTO userDTO){
        // 스프링에서 req.getparameter 이런 건 이 컨트롤러가 안 해줘도 됨
        // 그 앞단의 DispatcherServlet이 해준다!
        // @RequestParam("uid") String uid 여기서 param 이름이랑 변수 이름이 같은 게 규칙
        // 어차피 같으니까 사실 ("uid")는 안 적어줘도 됨
        // 그리고 사실 매개변수로 속성들 다 선언할 필요도 없음......
        // 그냥 매개변수 칸에 UserDTO 하나 선언해주면 끝///^^///
        
        
        System.out.println(userDTO.toString());
        
        // redirect 시작 문자열로 처리
        return "redirect:/index";
    }
}
