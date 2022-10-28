package com.example.kportfolio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class JavaScriptController {
    @GetMapping("/JavaScript")
    public String showJs(){
        return"javascript1";
    }

    @GetMapping("JavaScript2")
    public String showJs2(){return "javascript2";}
}
