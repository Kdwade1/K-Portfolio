package com.example.kportfolio.Controller;

import com.example.kportfolio.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaController {
    private final UserRepository userDao ;

    public JavaController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/java")
    public String viewJava(){
        return "java";
    }



}
