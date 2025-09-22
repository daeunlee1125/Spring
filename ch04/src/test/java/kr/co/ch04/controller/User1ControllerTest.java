package kr.co.ch04.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class User1ControllerTest {

    @Autowired
    private MockMvc mockMvc; // MVC 테스트를 위한 가상 객체

    @Test
    void register() throws Exception {
        for (int i=0; i<100; i++) {
            mockMvc.perform(
                            post("/user1/register")
                                    .param("user_id", "a200"+i)
                                    .param("name", "홍길동")
                                    .param("birth", "1992-10-01")
                                    .param("age", "21")
                    )
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/user1/list"))
                    .andDo(print());
        }
    }

    @Test
    void list() throws Exception {
        mockMvc.perform(
                    get("/user1/list")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("user1/list"))
                .andDo(print());
    }

    @Test
    void modify() throws Exception {
        mockMvc.perform(
                    post("/user1/modify")
                            .param("user_id", "a2001")
                            .param("name", "김영희")
                            .param("birth", "1992-10-01")
                            .param("age", "21")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user1/list"))
                .andDo(print());
    }


    @Test
    void delete() throws Exception {
        mockMvc.perform(get("/user1/delete").param("user_id", "a2231"))
                .andExpect(redirectedUrl("/user1/list"))
                .andDo(print());
    }
}