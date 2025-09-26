package kr.co.ch08.service;

import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.entity.User3;
import kr.co.ch08.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User3Service {
    private final User3Repository user3Repository;

    public User3DTO insert(User3DTO user3){
        return user3Repository.save(user3.toEntity()).toDTO();
    }

    public User3DTO update(User3DTO user3){
        if (user3Repository.existsById(user3.getUserid())){
            return user3Repository.save(user3.toEntity()).toDTO();
        }
        return null;
    }

    public List<User3DTO> findAll(){
        List<User3DTO> list = new ArrayList<>();
        List<User3> user3s = user3Repository.findAll();

        for (User3 user3 : user3s){
            list.add(user3.toDTO());
        }
        return list;
    }

    public User3DTO findById(String userid){
        Optional<User3> user3 = user3Repository.findById(userid);
        if (user3.isPresent()){
            return user3.get().toDTO();
        }
        return null;
    }

    public boolean delete(String userid){
        if (user3Repository.existsById(userid)){
            user3Repository.deleteById(userid);
            return true;
        }
        return false;
    }
}
