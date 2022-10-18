package com.example.kportfolio.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class JavaScriptController {
    @GetMapping("/javascript")
    public String showJs(){
        return"javascript1";
    }
}
