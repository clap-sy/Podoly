package kr.ac.podoly.repository;

import kr.ac.podoly.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodolyRepository extends JpaRepository<Article,Long> {

}
