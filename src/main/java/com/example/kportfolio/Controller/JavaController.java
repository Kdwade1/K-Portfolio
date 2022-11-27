package com.example.kportfolio.Controller;

import com.example.kportfolio.Repository.UserRepository;
import com.example.kportfolio.model.JPost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaController {
    private final UserRepository userDao ;
    @Value()
    private String fileApi;

    public JavaController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/java")
    public String viewJava(){
        return "java";
    }

    @GetMapping("/JPost/create")
    public String showCreationPost(Model model){
        model.addAttribute("jpost",new JPost());
        model.addAttribute("fileApi",fileApi);

        return"create-JPost";}



}
