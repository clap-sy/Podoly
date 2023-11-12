package kr.ac.podoly.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
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
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content){
        this.title=title;
        this.content=content;
    }
    public void update(String title, String content) {
        this.title=title;
        this.content=content;
    }

    public String getFormattedCreateDate() {
        if (createdAt==null) {
            return "";
        }
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdAt.format(pattern);
    }
}
