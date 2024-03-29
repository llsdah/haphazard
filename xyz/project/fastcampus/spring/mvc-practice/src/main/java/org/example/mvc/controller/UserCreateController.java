package org.example.mvc.controller;

import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {

    @Override
    public String HandleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //user 추가하느 고드 입니다.
        UserRepository.save(new User(request.getParameter("userId"),request.getParameter("name")));
        System.out.println("userID : "+request.getParameter("userId"));
        System.out.println("userID : "+request.getParameter("name"));
        return "redirect:/user";
    }
}
