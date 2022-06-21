package com.example;

import com.example.config.ConfigCloud;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class IndexController {

    @Resource
    private ConfigCloud config;

    @Resource
    private EmployeeClient employeeClient;

    @GetMapping("/config")
    public String load() {
        return String.format(config.getFarewell() + " === " +  config.getGreeting(), "", "");
    }

    @GetMapping("userinfo")
    public String usInfo(){
        return employeeClient.findByDepartment("test").toString();
    }

    @RequestMapping()
    String hello(@Value("${spring.application.name}") String name) throws UnknownHostException {
        return name + ": " + Inet4Address.getLocalHost().getHostAddress()
                + "\n";
    }

}
