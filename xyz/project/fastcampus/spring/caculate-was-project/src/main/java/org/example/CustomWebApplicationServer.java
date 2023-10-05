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

                new Thread(new ClientRequestHandler(clientSocket)).start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
