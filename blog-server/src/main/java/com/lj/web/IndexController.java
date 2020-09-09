package com.lj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
//        int i = 9/0;
        String blog null;
        if(blog == null){
            return new NotFoundException();
        }
        return "index";
    }
}
