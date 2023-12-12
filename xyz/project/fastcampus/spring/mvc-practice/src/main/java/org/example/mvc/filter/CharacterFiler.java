package org.example.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 스프링 프레임워크 구동전 동작하는 부분입니다.
 */

@WebFilter("/*")
public class CharacterFiler implements Filter {

    private final static String ENCODING_TYPE="utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING_TYPE);
        response.setCharacterEncoding(ENCODING_TYPE);

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
