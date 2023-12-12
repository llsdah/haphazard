package org.example.mvc.controller;

import org.example.mvc.HandlerAdaptor;
import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHadlerAdaptor implements HandlerAdaptor {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
        String viewName = ((Controller) Handler).HandleRequest(request, response);
        return (new ModelAndView(viewName));
    }
}
