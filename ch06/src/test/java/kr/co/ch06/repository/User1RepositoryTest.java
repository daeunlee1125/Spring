package kr.co.ch06.repository;

import kr.co.ch06.entity.Child;
import kr.co.ch06.entity.Parent;
import kr.co.ch06.entity.TB_User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findByUserId() {
        TB_User1 user1 = user1Repository.findByUserId("a101");
        System.out.println(user1);
    }

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ChildRepository childRepository;

    @Test
    void selectParentJoinChild(){
        Parent parent = Parent.builder()
                .pid("p101")
                .name("김유신")
                .age(34)
                .build();
        parentRepository.save(parent);

        Child child = Child.builder()
                .cid("c101")
                .pid("p101")
                .name("김철수")
                .age(12)
                .build();
        childRepository.save(child);

        List<Object[]> selectedParent = user1Repository.selectParentJoinChild("p101");
        System.out.println(selectedParent);
    }

    @Test
    void findUser1ByName() {
        List<TB_User1> user1 = user1Repository.findUser1ByName("이다은");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByNameNot() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByNameNot("이다은");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByUserIdAndName() {
        TB_User1 user1 = user1Repository.findTB_User1ByUserIdAndName("a101", "이다은");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByUserIdOrName() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByUserIdOrName("a102", "이다은");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByAgeGreaterThan() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByAgeGreaterThan(11);
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByAgeGreaterThanEqual() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByAgeGreaterThanEqual(11);
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByAgeLessThan() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByAgeLessThan(11);
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByAgeLessThanEqual() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByAgeLessThanEqual(23);
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByAgeBetween() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByAgeBetween(11, 33);
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByNameLike() {
        // 메서드 이름을 Like로 지으면
        // JPA가 메서드 이름 해석할 때 자동으로 % 와일드카드를 안 붙여줌
        // 그래서 내가 이% 이렇게 붙여줘야 함!
        List<TB_User1> user1 = user1Repository.findTB_User1ByNameLike("이%");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByNameContains() {
        // 근데 Contains는
        // 입력값 앞뒤로 %를 붙여서 like문에 바인딩함
        // 그래서 Hibernate 로그에는 둘 다 그냥 like문으로 나오는데 Contains 메서드에는 % 붙여줄 필요 없는 것!
        List<TB_User1> user1 = user1Repository.findTB_User1ByNameContains("다");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByNameStartsWith() {
        // 여기에도 와일드카드 붙여줄 필요 없죠?
        List<TB_User1> user1 = user1Repository.findTB_User1ByNameStartsWith("김");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByNameEndsWith() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByNameEndsWith("은");
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByOrderByName() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByOrderByName();
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByOrderByAgeAsc() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByOrderByAgeAsc();
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByOrderByAgeDesc() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByOrderByAgeDesc();
        System.out.println(user1);
    }

    @Test
    void findTB_User1ByAgeGreaterThanOrderByAgeDesc() {
        List<TB_User1> user1 = user1Repository.findTB_User1ByAgeGreaterThanOrderByAgeDesc(11);
        System.out.println(user1);
    }

    @Test
    void countTB_User1ByUserId() {
        int count = user1Repository.countTB_User1ByUserId("a101");
        System.out.println(count);
    }

    @Test
    void countTB_User1ByName() {
        int count = user1Repository.countTB_User1ByName("김춘추");
        System.out.println(count);
    }
}