package kr.co.ch06.entity.board;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString(exclude = {"article"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ArticleComment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_increment
    private int cno;

    @ManyToOne(fetch = FetchType.LAZY) // 관계설정 (Comment-Article : many to one)
    @JoinColumn(name = "ano") // FK 이름 설정
    private Article article;

    private String content;
    private String author;

    @CreationTimestamp
    private LocalDateTime wdate;
}
