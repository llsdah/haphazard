package org.example;


import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {

    private final static Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
    private final int port;

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    /**
     * GET /calculate?operand1=11&operator=*&operand2=1 HTTP/1.1
     */

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("[CustomWebApplicationServer] started {} port", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] wait for client ");
            while((clientSocket = serverSocket.accept())!=null){
                logger.info("[CustomWebApplicationServer] client connected ");

                /**
                 * 1. 사용자 요청을 메인 thread가 처리한다.
                 */

                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream das = new DataOutputStream(out);

                    HttpRequest httpRequest = new HttpRequest(br);

                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        int operand1 =  Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                        int result = Calculator.calculate(new PositiveNumber(operand1),operator,new PositiveNumber(operand2));

                        byte[] body = String.valueOf(result).getBytes();
                        HttpResponse response = new HttpResponse(das);
                        response.response200Header("application/json",body.length);
                        response.responseBody(body);
                        logger.info("result : {}",result);
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
