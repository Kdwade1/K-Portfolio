package com.example.kportfolio.Controller;

import com.example.kportfolio.Repository.UserRepository;
import com.example.kportfolio.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String showHome(){
        return "index";
    }
    @GetMapping("/register")
    public String register(Model model) {
        try{
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("currentUser",currentUser);
            return "redirect:/index";
        }catch(Exception e){
            model.addAttribute("newUser",new User());
            return "register";
        }

    }
}
