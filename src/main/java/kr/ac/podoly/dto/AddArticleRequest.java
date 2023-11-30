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
    private LocalDate date;

    public Article toEntity() {
        Article article=new Article(title, itemName, content, description, lat,lng, date);
        return article;
    }
}
