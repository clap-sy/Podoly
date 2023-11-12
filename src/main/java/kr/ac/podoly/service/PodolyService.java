package kr.ac.podoly.service;

import jakarta.transaction.Transactional;
import kr.ac.podoly.domain.Article;
import kr.ac.podoly.dto.AddArticleRequest;
import kr.ac.podoly.dto.UpdateArticleRequest;
import kr.ac.podoly.repository.PodolyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodolyService {
    @Autowired
    private PodolyRepository podolyRepository;
    public Article save(AddArticleRequest request) {
        return podolyRepository.save(request.toEntity());
    }
    public List<Article> findAll() {
        List<Article> articles=podolyRepository.findAll();
        return articles;
    }
    public Article findOne(long id) {
        Article article=podolyRepository.findById(id).orElseThrow();
        return article;
    }
    public void delete(long id {
        podolyRepository.deleteById(id);
    }
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article=podolyRepository.findById(id).orElseThrow();
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
