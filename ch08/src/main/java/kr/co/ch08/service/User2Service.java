package kr.co.ch08.service;

import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.entity.User2;
import kr.co.ch08.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User2Service {
    private final User2Repository user2Repository;

    public User2DTO insert(User2DTO user2){
        return user2Repository.save(user2.toEntity()).toDTO();
    }

    public List<User2DTO> findAll(){
        List<User2> userList = user2Repository.findAll();
        List<User2DTO> dtoList = new ArrayList<>();
        for(User2 user : userList){
            dtoList.add(user.toDTO());
        }
        return dtoList;
    }

    public User2DTO findById(String userid){
        Optional<User2> user2 = user2Repository.findById(userid);
        if(user2.isPresent()){
            return user2.get().toDTO();
        }
        return null;
    }

    public User2DTO modify(User2DTO user2){
        if (user2Repository.existsById(user2.getUserid())){
            return user2Repository.save(user2.toEntity()).toDTO();
        }else{
            return null;
        }
    }

    public boolean delete(String userid){
        if (user2Repository.existsById(userid)){
            user2Repository.deleteById(userid);
            return true;
        }else{
            return false;
        }
    }

}
