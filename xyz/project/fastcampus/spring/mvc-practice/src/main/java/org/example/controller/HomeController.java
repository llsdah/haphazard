package org.example.controller;


import org.example.annotation.Controller;
import org.example.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response){
        String str = "home";

        return str;
    }
}
