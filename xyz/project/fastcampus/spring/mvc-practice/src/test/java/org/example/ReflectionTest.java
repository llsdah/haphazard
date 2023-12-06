package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 컨트롤러 어노테이션이 있는 클래스를 모두 찾는다.
 */

public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan(){

        Set<Class<?>> beans = getTypeAnnotationWith(List.of(Controller.class, Service.class));

        logger.debug("beans [{}]",beans);
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructs: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));

        logger.debug("User all declared method: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));

    }

    @Test
    void name() throws ClassNotFoundException {
        // 힙역영에 로드되어 있는 클래스 타입의 객체 가져오는 법 1,2,3
        Class<User> clazz = User.class;

        User user = new User("id","pass");
        Class<? extends User> clazz2 = user.getClass();

        Class<?> clazz3 = Class.forName("org.example.model.User");

        logger.debug("class : [{}]",clazz);
        logger.debug("class2 : [{}]",clazz2);
        logger.debug("class3 : [{}]",clazz3);

        assertThat(clazz == clazz2).isTrue();
        assertThat(clazz3 == clazz2).isTrue();
        assertThat(clazz3 == clazz).isTrue();
    }

    private Set<Class<?>> getTypeAnnotationWith(List<Class<? extends Annotation>> annotaions) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotaions.forEach( annotaion -> beans.addAll(reflections.getTypesAnnotatedWith(annotaion)));

        return beans;
    }
}
