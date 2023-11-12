package kr.ac.podoly.controller;

import kr.ac.podoly.domain.Article;
import kr.ac.podoly.service.PodolyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PodolyViewController {
    @Autowired
    PodolyService podolyService;

    @GetMapping("/articles")
    public ModelAndView getArticles() {
        ModelAndView mav=new ModelAndView();
        List<Article> articles=podolyService.findAll();
        mav.addObject("articels", articles);
        mav.setViewName("articleList");
        return mav;
    }
    @GetMapping("/articles/{id}")
    public ModelAndView getArticle(@PathVariable long id) {
        ModelAndView mav=new ModelAndView();
        Article article=podolyService.findOne(id);
        mav.addObject("article",article);
        mav.setViewName("article");
        return mav;
    }
    @GetMapping("/new-article")
    public String createArticle() {
        return "newArticle";
    }
}
