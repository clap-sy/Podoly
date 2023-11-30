package kr.ac.podoly.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "item_name", nullable = false)
    private String itemName;  // 분실물명

    @Column(name = "lat")
    private double lat;  // 위도

    @Column(name = "lng")
    private double lng;  // 경도

    @Column(name = "description")
    private String description;  // 상세정보

    @Column(name = "date")
    private LocalDate date;  // 연도-월-일

    @Builder
    public Article(String itemName, String description, double lat, double lng, LocalDate date) {
        this.itemName = itemName;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.date = date;
    }

    public void update(String itemName, String description, double lat, double lng, LocalDate date) {
        this.itemName = itemName;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.date = date;
    }

    public String getFormattedDate() {
        if (date == null) {
            return "";
        }
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(pattern);
    }
}