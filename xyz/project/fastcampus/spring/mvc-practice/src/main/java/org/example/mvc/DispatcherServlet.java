package org.example.mvc;

import org.example.mvc.controller.RequestMethods;
import org.example.mvc.controller.RequestMappingHandlerMapping;
import org.example.mvc.controller.SimpleHadlerAdaptor;
import org.example.mvc.view.JspViewResolver;
import org.example.mvc.view.ModelAndView;
import org.example.mvc.view.View;
import org.example.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/") // 모든 요청에 대해 받는다.
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    private List<HandlerMapping> handlerMappings;

    private List<HandlerAdaptor> handlerAdaptorList;
    private List<ViewResolver> viewResolverList;

    @Override
    public void init() throws ServletException {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();

        AnnotationHandlerMapping annotationHandlerMapping = new AnnotationHandlerMapping("org.example");
        annotationHandlerMapping.initialize();

        handlerMappings = List.of(requestMappingHandlerMapping, annotationHandlerMapping);

        handlerAdaptorList = List.of(new SimpleHadlerAdaptor(), new AnnotationHandlerAdaptor());
        viewResolverList = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        logger.info("start dispathcerSevlet ");
        String requestURI = request.getRequestURI();
        RequestMethods requestMethods = RequestMethods.valueOf(request.getMethod());

        try{
            logger.info("look for ["+requestMethods+","+requestURI+"]");
            // 해당 요청이 어떤것인지 확인
           Object handler = handlerMappings.stream()
                           .filter(hm -> hm.findHanler(new HandlerKey(requestMethods,requestURI)) != null)
                   .map(hmp -> hmp.findHanler(new HandlerKey(requestMethods,requestURI)))
                   .findFirst()
                   .orElseThrow(() -> new ServletException("No handler for ["+requestMethods+","+requestURI+"]"));

           //findHanler(new HandlerKey(RequestMethods.valueOf(request.getMethod()),request.getRequestURI())
           //String viewName = handler.HandleRequest(request, response);

           HandlerAdaptor handlerAdaptor = handlerAdaptorList.stream()
                   .filter(hand -> hand.supports(handler))
                   .findFirst()
                           .orElseThrow(() -> new ServletException("No adapter handler ["+handler+"]"));

           ModelAndView modelAndView = handlerAdaptor.handle(request,response,handler);

           logger.info("view name [{}]",modelAndView.getViewName());
           for(ViewResolver viewResolver : viewResolverList){

               View view = viewResolver.resolverView(modelAndView.getViewName());
               view.rander(modelAndView.getModel(), request, response);

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
