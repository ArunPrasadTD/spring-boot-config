package com.example.springbootconfig;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${my.greeting: default}")
    private String greetingMessage;

    @Value("Direct Value")
    private String directValue;

    @Value("${my.list.values}")
    private List<String> myList;

//    @Value("#{${db.value}}")
//    private Map<String, String> dbValue;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){

        return dbSettings.getConnection();
    }
}
