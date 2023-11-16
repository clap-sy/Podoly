package kr.ac.podoly.controller;


import kr.ac.podoly.domain.Article;
import kr.ac.podoly.dto.AddArticleRequest;
import kr.ac.podoly.dto.UpdateArticleRequest;
import kr.ac.podoly.service.PodolyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PodolyController {
    @Autowired
    private PodolyService podolyService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){

        Article savedArticle=podolyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> findAllArticle(){
        List<Article> articles=podolyService.findAll();
        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<Article> findArticle(@PathVariable long id){
        Article article=podolyService.findOne(id);
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        podolyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable long id,
            @RequestBody UpdateArticleRequest updateArticle){
        Article article=podolyService.update(id,updateArticle);
        return ResponseEntity.ok().body(article);
    }
}