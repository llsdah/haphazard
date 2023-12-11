package org.example.mvc;

import org.example.controller.RequestMethods;
import org.example.mvc.controller.Controller;
import org.example.mvc.controller.HandlerKey;
import org.example.mvc.controller.RequestMappingHandlerMapping;
import org.example.view.JspViewResolver;
import org.example.view.View;
import org.example.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private List<ViewResolver> viewResolverList;

    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();

        viewResolverList =Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        logger.info("start dispathcerSevlet ");

        try{
            // 해당 요청이 어떤것인지 확인
           Controller handler = requestMappingHandlerMapping.findHanler(
                   new HandlerKey(RequestMethods.valueOf(request.getMethod()),
                           request.getRequestURI())
           );
           String viewName = handler.HandleRequest(request, response);
           logger.info("view name [{}]",viewName);
           for(ViewResolver viewResolver : viewResolverList){

               View view = viewResolver.resolverView(viewName);
               view.rander(new HashMap<>(), request, response);

           }

           // 기존 코드 입니다.
           //RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);
           //requestDispatcher.forward(request,response);

            logger.info("end dispathcerSevlet ");

        } catch (Exception e){
            logger.error("error [{}]",e.getMessage());
            throw new ServletException(e);
        }

    }



}
