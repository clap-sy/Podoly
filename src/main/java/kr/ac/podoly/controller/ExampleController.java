package kr.ac.podoly.controller;

import kr.ac.podoly.dto.Person;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
public class ExampleController {
    @GetMapping("/example")
    public String example(Model model) {
        Person examplePerson=new Person();
        examplePerson.setId(1l);
        examplePerson.setName("포돌이");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("운동", "영화"));

        model.addAttribute("person", examplePerson);
        model.addAttribute("today", LocalDate.now());

        return "example";
    }
}
