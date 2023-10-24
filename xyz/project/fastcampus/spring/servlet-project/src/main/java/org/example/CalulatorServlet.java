package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calculate")
public class CalulatorServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CalulatorServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * url 인코딩 주의 = 퍼센트 인코딩!
         * url로 서용할 수 없는 단어 인코딩되는 값을 넣고 수행
         * + => %2D
         * 인코딩 문자는 3개가 한세트
         */

        logger.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        int operand2 = Integer.parseInt(request.getParameter("operand2"));
        String operator = request.getParameter("operator");

        int result = Calculator.calculate(new PositiveNumber(operand1),operator,new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);

    }
}
