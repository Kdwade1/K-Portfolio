package com.example.kportfolio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSController {
    @GetMapping("/CSS")
    public String showCss(){
        return"css1";
    }
    @GetMapping("/CSS2")
    public String showCss2(){
        return "css2";
    }
    @GetMapping("/CSS3")
    public String showCss3() {
        return "css3";
    }
}
