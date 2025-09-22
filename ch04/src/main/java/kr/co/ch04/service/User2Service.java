package kr.co.ch04.service;

import kr.co.ch04.dto.User2DTO;
import kr.co.ch04.mapper.User2Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User2Service {

    private final User2Mapper mapper;

    public List<User2DTO> findAll(){
        return mapper.selectAllUsers();
    }

    public User2DTO findById(String user_id){
        return mapper.selectUser(user_id);
    }

    public void register(User2DTO dto){
        mapper.insertUser(dto);
    }

    public void modify(User2DTO dto){
        mapper.updateUser(dto);
    }

    public void remove(String user_id){
        mapper.deleteUser(user_id);
    }

}
