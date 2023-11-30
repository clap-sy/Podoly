package kr.ac.podoly.dto;

import kr.ac.podoly.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;
    private String location;
    private Date date;

    public Article toEntity() {
        Article article=new Article(title,content,location,date);
        return article;
    }
}
