package com.example.kportfolio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSController {
    @GetMapping("/css")
    public String showcss(){
        return"css1";
    }
}
