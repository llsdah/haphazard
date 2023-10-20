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

    }
}
