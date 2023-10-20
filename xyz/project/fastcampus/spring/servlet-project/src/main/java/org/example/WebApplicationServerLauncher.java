package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServerLauncher {

    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static void main(String[] args) throws Exception {

        String webApplicationDirLocation ="webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);;

        tomcat.addWebapp("/", new File(webApplicationDirLocation).getAbsolutePath());
        logger.info("configuring app with basedir: {} ", new File(webApplicationDirLocation).getAbsolutePath());
        tomcat.start();
        logger.info("start ??");
        tomcat.getServer().await();
    }
}