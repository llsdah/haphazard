package org.example.controller;

import org.example.mvc.controller.Controller;
import org.example.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController implements Controller {

    @Override
    public String HandleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("user", UserRepository.findAll());

        return "/user/list";
    }
}
