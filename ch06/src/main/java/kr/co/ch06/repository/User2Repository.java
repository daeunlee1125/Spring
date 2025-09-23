package kr.co.ch06.repository;

import kr.co.ch06.entity.TB_User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User2Repository extends JpaRepository<TB_User2, String> {
    public TB_User2 findUser2ByNameNot(String name);
}
