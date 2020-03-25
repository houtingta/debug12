package com.ascending.learning.debug.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.ascending.learning.debug"})
public class AppBootstrap extends SpringBootServletInitializer {
    //private Logger logger = LoggerFactory.getLogger(getClass());
    public static void main(String[] args){
        SpringApplication.run(AppBootstrap.class, args);
    }
}
