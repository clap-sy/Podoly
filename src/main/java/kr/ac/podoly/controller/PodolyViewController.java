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

    @GetMapping("/main")
    public ModelAndView getMain(){
        ModelAndView mav=new ModelAndView();
        List<Article> main=podolyService.findAll();
        mav.addObject("articleList", main);
        mav.setViewName("articleList");
        return mav;
    }
    @GetMapping("/main/articles")
    public ModelAndView getArticles(){
        ModelAndView mav=new ModelAndView();
        List<Article> articles=podolyService.findAll();
//        mav.addObject("articles", articles);
        mav.setViewName("articleMain");
        return mav;
    }

    @GetMapping("/found/{id}")
    public ModelAndView getArticle(@PathVariable long id){
        ModelAndView mav=new ModelAndView();
        Article article=podolyService.findOne(id);
        mav.addObject("article",article);
        mav.setViewName("article");
        return mav;
    }

    @GetMapping("new-article")
    public String createArticle(){
        return "newArticle";
    }
    @GetMapping("/main/articles/modify/{id}")
    public ModelAndView modifyArticle(@PathVariable long id){
        ModelAndView mav=new ModelAndView();
        Article article=podolyService.findOne(id);

        mav.addObject("article",article);
        mav.setViewName("articleModify");
        return mav;
    }
    @GetMapping("/check")
    public String check() {
        return "check";
    }

    @GetMapping("/found")
    public ModelAndView showAllArticles() {
        ModelAndView mav = new ModelAndView();
        List<Article> articles = podolyService.findAll();
        mav.addObject("articles", articles);
        mav.setViewName("found");
        return mav;
    }

}