package kr.co.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
// 엔티티 관계설정에서, 엔티티의 toString() 호출 시 또다른 엔티티의 toString이 호출되기 때문에,
// 엔티티간의 toString 호출로 stackOverflow 에러 발생
// 엔티티의 어느 한쪽에서는 toString() 호출을 제외(exclude)에서 순환 참조 호출 방지
@ToString(exclude = {"commentList"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_increment
    private int ano;
    private String title;
    private String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private User user;

    // @OneToMany 관계설정에 반드시 mappedBy 속성은 양방향 관계에서 기준이 되는 속성, FK가 되는 속성
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article") // mappedBy : 양방향 처리
    private List<Comment> commentList; // Article 하나 당 여러 개 Comment니까 List 속성이겠죠?

    @OneToMany(fetch = FetchType.LAZY) // mappedBy 없으면 단방향
    @JoinColumn(name = "ano") // OneToMany에서 JoinColumn으로 File 엔티티에 ano FK 생성
    private List<File> fileList;

    @CreationTimestamp
    private LocalDateTime wdate; // JPA 현재 날짜시간 클래스로 @CreationTimeStamp 어노테이션으로 현재 날짜시간 처리
}
