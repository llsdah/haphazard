package org.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;

public class HttpResponse {

    private static final Logger logger = LoggerFactory.getLogger(HttpResponse.class);

    private final DataOutputStream das;

    public HttpResponse(DataOutputStream das){
        this.das = das;
    }

    public void response200Header(String contentType, int lengthOfBodyContent){
        try{
            das.writeBytes("HTTP/1.1 200 OK \r\n");
            das.writeBytes("Content-Type: "+contentType + ";charset=utf-8\r\n");
            das.writeBytes("Content-Length: "+lengthOfBodyContent+"\r\n");
            das.writeBytes("\r\n");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
    public void responseBody(byte[] body){
        try{
            das.write(body, 0, body.length);
            das.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
            
        }
    }
}
