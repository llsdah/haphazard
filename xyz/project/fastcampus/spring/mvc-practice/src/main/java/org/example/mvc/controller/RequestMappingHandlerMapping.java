package org.example.mvc.controller;

import org.example.annotation.RequestMapping;
import org.example.annotation.RequestMethod;
import org.example.controller.ForwardController;
import org.example.controller.RequestMethods;
import org.example.controller.UserCreateController;
import org.example.controller.UserListController;
import org.example.mvc.DispatcherServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RequestMappingHandlerMapping {

    private static final Logger logger = LoggerFactory.getLogger(RequestMappingHandlerMapping.class);

    private Map<HandlerKey, Controller> map = new HashMap<>();

    public void init(){

        map.put(new HandlerKey(RequestMethods.GET,"/"), new HomeController());
        map.put(new HandlerKey(RequestMethods.GET,"/user"), new UserListController());
        map.put(new HandlerKey(RequestMethods.POST,"/user"), new UserCreateController());
        map.put(new HandlerKey(RequestMethods.GET,"/user/for"), new ForwardController("/user/for"));

    }

    public Controller findHanler(HandlerKey requestURI) throws  Exception{
        logger.info("findHandler start ");

        // 객체를 넣었기 때문에 객체간 비교가 필수입니다.
        return map.get(requestURI);
    }
}
