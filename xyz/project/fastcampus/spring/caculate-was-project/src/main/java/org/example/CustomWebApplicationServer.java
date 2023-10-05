package org.example;


import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {

    private final static Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
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
                 * step - 사용자 요청이 들어올 때마다 Threa를 새로 생성해서 사용자 요청을 처리하도록 한다. 
                 * => 메모리는 잡아 먹는 비싼 작업입니다. cpu contextswitching 발생 가능, 메모리 증가 가능
                 * => threadpool
                 */
                executorService.execute(new ClientRequestHandler(clientSocket));
                //new Thread(new ClientRequestHandler(clientSocket)).start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
