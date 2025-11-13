package com.devops.javaapp;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@SpringBootApplication
@RestController
public class DevopsJavaApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(DevopsJavaApplication.class, args);
    }
 
    /**
     * This method handles HTTP GET requests to the root URL ("/").
     * @return A simple string that will be displayed in the browser.
     */
    @GetMapping("/")
    public String hello() {
        // You can customize this message
        return "<h1>Hello, DevOps World!</h1><p>Your Java application was successfully deployed via Jenkins and Ansible.</p>";
    }
}
