package kr.ac.podoly.controller;


import kr.ac.podoly.domain.Article;
import kr.ac.podoly.dto.AddArticleRequest;
import kr.ac.podoly.dto.UpdateArticleRequest;
import kr.ac.podoly.service.PodolyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PodolyController {
    @Autowired
    private PodolyService podolyService;

    @GetMapping("/api/main")
    public String mainPage(){
        return "main";
    }

    @PostMapping("/api/found")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        request.setArticleType(Article.ArticleType.FOUND);
        Article savedArticle=podolyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
    @PostMapping("/api/get")
    public ResponseEntity<Article> addFoundItem(@RequestBody AddArticleRequest request){
        request.setArticleType(Article.ArticleType.GET);
        Article savedArticle = podolyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
//    @GetMapping("/api/main/articles")
//    public ResponseEntity<List<Article>> findAllArticle(){
//        List<Article> articles=podolyService.findAll();
//        return ResponseEntity.ok().body(articles);
//    }
//    @GetMapping("/api/main/articles/{id}")
//    public ResponseEntity<Article> findArticle(@PathVariable long id){
//        Article article=podolyService.findOne(id);
//        return ResponseEntity.ok().body(article);
//    }
    @GetMapping("/api/found")
    public ResponseEntity<List<Article>> findAllLostItems(){
        List<Article> articles = podolyService.findAllFound();
        return ResponseEntity.ok().body(articles);
    }
    @GetMapping("/api/get")
    public ResponseEntity<List<Article>> findAllFoundItem(){
        List<Article> articles = podolyService.findAllGet();
        return ResponseEntity.ok().body(articles);
    }

    @DeleteMapping("/api/found/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        podolyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/found/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable long id,
            @RequestBody UpdateArticleRequest updateArticle){
        Article article=podolyService.update(id,updateArticle);
        return ResponseEntity.ok().body(article);
    }
}
