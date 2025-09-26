package kr.co.ch09.service;

import kr.co.ch09.dto.UserDTO;
import kr.co.ch09.entity.User;
import kr.co.ch09.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getUsers(){

        List<User> users = userRepository.findAll();
        return users.stream().map(User::toDTO).toList();

    }
    public UserDTO getUser(){
        return null;
    }
    public UserDTO save(UserDTO userDTO){
        String plain = userDTO.getPass();
        String encoded = passwordEncoder.encode(plain);
        userDTO.setPass(encoded);

        return userRepository.save(userDTO.toEntity()).toDTO();
    }
    public void modify(UserDTO userDTO){
        userRepository.save(userDTO.toEntity());
    }
    public void delete(String usid){}

}
