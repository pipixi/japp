package com.example;

import com.example.config.ConfigCloud;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class MainController {

    @Resource
    private ConfigCloud config;

    @GetMapping("/config")
    public String load() {
        return String.format( "%s  === %s", config.getFarewell(), config.getGreeting());
    }

    @GetMapping("")
    String hello(@Value("${spring.application.name}") String name) throws UnknownHostException {
        return name + ": " + Inet4Address.getLocalHost().getHostAddress()
                + "\n";
    }

    @GetMapping("/department/{departmentId}")
    Employee get(@PathVariable("departmentId")String departmentId) throws UnknownHostException {
        System.out.println("info: " + departmentId + "host: " + Inet4Address.getLocalHost().getHostAddress());
        return new Employee(10L,departmentId,200,Inet4Address.getLocalHost().getHostAddress());
    }

}
