package kr.co.ch4.mapper;

import kr.co.ch4.dto.User2DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User2Mapper {
    public void insertUser(User2DTO dto);
    public void updateUser(User2DTO dto);
    public List<User2DTO> selectAllUsers();
    public User2DTO selectUser(String user_id);
    public void deleteUser(String user_id);

}
