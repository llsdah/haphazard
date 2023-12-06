package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.RequestMappingHandlerMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Override
    public void init() throws ServletException {
        requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        logger.info("start dispathcerSevlet ");

        try{
           Controller handler = requestMappingHandlerMapping.findHanler(request.getRequestURI());
           String viewName = handler.HandleRequest(request, response);
           RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewName);
           requestDispatcher.forward(request,response);
           logger.info("end dispathcerSevlet ");

        } catch (Exception e){
            logger.error("error [{}]",e.getMessage());
            throw new ServletException(e);
        }

    }



}
