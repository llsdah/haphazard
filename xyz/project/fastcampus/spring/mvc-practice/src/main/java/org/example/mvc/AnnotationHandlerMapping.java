package org.example.mvc;


import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.controller.RequestMethods;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class AnnotationHandlerMapping implements  HandlerMapping{
    private static final Logger logger = LoggerFactory.getLogger(AnnotationHandlerMapping.class);

    private final Object[] basePackage;

    private Map<HandlerKey,AnnotationHandler> handlers =  new HashMap<>();

    public AnnotationHandlerMapping(Object ...basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public Object findHanler(HandlerKey handlerKey) {
        logger.info("AnnotationHandlerMapping findHanler");
        return handlers.get(handlerKey);
    }

    public void initialize() {

        logger.info("initailize AnnotationHandlerMapping");
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> clazzContollerAnnotation =  reflections.getTypesAnnotatedWith(Controller.class);

        // requestmapping 어노테이션 다 추출
        clazzContollerAnnotation.forEach(clazz -> {
            Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
                RequestMapping requestMapping = declaredMethod.getDeclaredAnnotation(RequestMapping.class);
                logger.info("RequestMapping [{}]",requestMapping.value());
            Arrays.stream(getRequestMethods(requestMapping))
                    .forEach(requestMethod -> handlers.put(
                            new HandlerKey(requestMethod, requestMapping.value()), new AnnotationHandler(clazz, declaredMethod)
                    ));
            });
        });
    }

    private RequestMethods[] getRequestMethods(RequestMapping requestMapping) {
        return requestMapping.method();
    }

    ;
}
