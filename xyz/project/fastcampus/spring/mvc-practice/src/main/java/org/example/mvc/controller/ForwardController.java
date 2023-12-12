package org.example.mvc.controller;

import org.example.mvc.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {
    private String forwardUrlPath;

    public ForwardController(String forwardUrlPath) {
        this.forwardUrlPath = forwardUrlPath;
    }

    @Override
    public String HandleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwardUrlPath;
    }
}
