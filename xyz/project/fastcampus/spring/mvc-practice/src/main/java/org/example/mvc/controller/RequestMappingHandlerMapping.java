package org.example.mvc.controller;

import org.example.mvc.HandlerKey;
import org.example.mvc.HandlerMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RequestMappingHandlerMapping implements HandlerMapping {

    private static final Logger logger = LoggerFactory.getLogger(RequestMappingHandlerMapping.class);

    private Map<HandlerKey, Controller> map = new HashMap<>();

    public void init(){
        logger.info("RequestMappingHandlerMapping init");

        map.put(new HandlerKey(RequestMethods.GET,"/user"), new UserListController());
        map.put(new HandlerKey(RequestMethods.POST,"/user"), new UserCreateController());
        map.put(new HandlerKey(RequestMethods.GET,"/user/for"), new ForwardController("/user/for"));

    }

    public Controller findHanler(HandlerKey requestURI) {
        logger.info("findHandler start ");

        // 객체를 넣었기 때문에 객체간 비교가 필수입니다.
        return map.get(requestURI);
    }
}
