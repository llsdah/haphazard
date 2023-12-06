package org.example.mvc.controller;

import ch.qos.logback.classic.net.SMTPAppender;

import java.util.*;

public class RequestMappingHandlerMapping {

    private Map<String, Controller> map = new HashMap<>();

    public void init(){
        map.put("/", new HomeController());
    }

    public Controller findHanler(String requestURI) throws  Exception{

        return map.get(requestURI);
    }
}
