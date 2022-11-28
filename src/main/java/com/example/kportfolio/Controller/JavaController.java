package com.example.kportfolio.Controller;

import com.example.kportfolio.Repository.JPostRepository;
import com.example.kportfolio.Repository.UserRepository;
import com.example.kportfolio.model.JPost;
import com.example.kportfolio.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JavaController {
    private final UserRepository userDao ;
    private final JPostRepository JPostDao;
    @Value()
    private String fileApi;

    public JavaController(UserRepository userDao, JPostRepository jPostDao) {
        this.userDao = userDao;
        JPostDao = jPostDao;
    }

    @GetMapping("/java")
    public String viewJava(Model model){
        List<JPost> all =JPostDao.findAll();
        model.addAttribute("Jpost",all);
        try{
            User currentUser=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("currentUser",currentUser);

        }catch(Exception e){
            return "java";
        }
        return"java";

        }





    @GetMapping("/JPost/create")
    public String showCreationPost(Model model){
        model.addAttribute("jpost",new JPost());
        model.addAttribute("fileApi",fileApi);

        return"create-JPost";}



}
