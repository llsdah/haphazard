package org.example.mvc;

import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerAdaptor {

    /**
     * 핸들러의 지원 여부를 판단하는 것
     */
    boolean supports(Object handler);
    
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception;
}
