package kr.ac.podoly.dto;

import kr.ac.podoly.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class AddArticleRequest {
    private String title;
    private String itemName;
    private String content;
    private String description;
    private double lat;
    private double lng;
    private String address;
    private LocalDate date;
    private Article.ArticleType articleType;

    public void setArticleType(Article.ArticleType articleType) {
        this.articleType = articleType;
    }
    public Article toEntity() {
        Article article=new Article(title, itemName, content, description, lat,lng,address, date, articleType);
        return article;
    }
}
