package kr.co.ch06.repository.board;

import jakarta.transaction.Transactional;
import kr.co.ch06.entity.board.Article;
import kr.co.ch06.entity.board.Comment;
import kr.co.ch06.entity.board.File;
import kr.co.ch06.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;

    @Test
    void insertUserTest(){
        User user = User.builder()
                .userid("a102")
                .name("김춘추")
                .age(26).build();

        userRepository.save(user);
    }

    @Test
    void insertFileTest(){

        File file = File.builder()
                .oName("매출자료3.xls")
                .sName("akfal-asd-114kldf.xls")
                .ano(6)
                .build();
        fileRepository.save(file);
    }

    @Test
    public void insertArticleTest(){
        User user = User.builder()
                .userid("a101")
                .build();
        Article article = Article.builder()
                .title("제목 4")
                .content("내용 5")
                .user(user)
                .build();

        articleRepository.save(article);
    }

    @Test
    public void insertCommentTest(){
        Article article = Article.builder()
                .ano(2)
                .build();

        Comment comment = Comment.builder()
                .content("댓글333")
                .author("a104")
                .article(article)
                .build();

        commentRepository.save(comment);
    }

    @Test
    @Transactional // No Session 에러 처리
    void selectArticleAllTest(){
        List<Article> articles = articleRepository.findAll();
        System.out.println(articles);

        for (Article article : articles) {
            for (Comment comment : article.getCommentList()) {
                System.out.println(comment);
            }
        }
    }

    @Test
    @Transactional
    void selectArticle(){
        Optional<Article> article = articleRepository.findById(6);
        System.out.println(article);

        if (article.isPresent()){
            Article article1 = article.get();
            List<Comment> comments = article1.getCommentList();
            for (Comment comment : comments) {
                System.out.println(comment);
            }

            List<File> fileList = article1.getFileList();
            for (File file : fileList) {
                System.out.println(file);
            }
        }
    }

    @Test
    @Transactional // 엔티티 연관관계에서 한 번 이상의 SQL 처리가 이루어지기 때문에, 트랜잭션 처리 안 해주면 no Session 에러뜸
    void selectArtAndComment(){
        Optional<Article> article = articleRepository.findById(2);
        System.out.println(article);

        if (article.isPresent()){
            Article article1 = article.get();
            List<Comment> comments = article1.getCommentList();
            for (Comment comment : comments) {
                System.out.println(comment);
            }

            List<File> fileList = article1.getFileList();
            for (File file : fileList) {
                System.out.println(file);
            }
        }

    }
}