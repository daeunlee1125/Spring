package kr.co.ch06.service;

import kr.co.ch06.dto.User2DTO;
import kr.co.ch06.entity.TB_User2;
import kr.co.ch06.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class User2Service {
    private final User2Repository user2Repository;

    public void save(User2DTO user2) {
        user2Repository.save(user2.toEntity());
    }

    public User2DTO getUserById(String userId){
        Optional<TB_User2> user2Optional = user2Repository.findById(userId);
        if (user2Optional.isPresent()){
            return user2Optional.get().toDTO();
        }
        return null;
    }

    public List<User2DTO> getAllUsers(){
        List<TB_User2> list = user2Repository.findAll();
        List<User2DTO> dtoList = new ArrayList<>();
        for (TB_User2 tbUser2 : list){
            dtoList.add(tbUser2.toDTO());
        }
        return dtoList;
    }

    public void modify(User2DTO user2DTO){

        if (user2Repository.existsById(user2DTO.getUserId())){
            TB_User2 tbUser2 = user2DTO.toEntity();
            user2Repository.save(tbUser2);
        }
    }

    public void delete(String userId){
        user2Repository.deleteById(userId);
    }

}
