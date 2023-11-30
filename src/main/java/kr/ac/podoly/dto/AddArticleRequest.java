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
    private String itemName;
    private String description;
    private double lat;
    private double lng;
    private LocalDate date;

    public Article toEntity() {
        return Article.builder()
                .itemName(itemName)
                .description(description)
                .lat(lat)
                .lng(lng)
                .date(date)
                .build();
    }
}
