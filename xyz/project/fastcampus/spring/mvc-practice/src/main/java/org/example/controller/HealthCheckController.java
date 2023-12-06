package org.example.controller;

import org.example.annotation.Controller;
import org.example.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HealthCheckController {

    @RequestMapping("/healthCheck")
    public String home(HttpServletRequest request, HttpServletResponse response){
        String str = "healthCheck";

        return str;
    }
}
