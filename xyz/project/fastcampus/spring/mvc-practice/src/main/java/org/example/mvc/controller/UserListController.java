package org.example.mvc.controller;

import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Controller {

    @Override
    public String HandleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("user", UserRepository.findAll());

        return "/user/list";
    }
}
