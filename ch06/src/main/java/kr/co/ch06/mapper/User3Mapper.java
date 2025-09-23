package kr.co.ch06.mapper;

import kr.co.ch06.dto.User3DTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User3Mapper {
    public void insert3(User3DTO user);
}
