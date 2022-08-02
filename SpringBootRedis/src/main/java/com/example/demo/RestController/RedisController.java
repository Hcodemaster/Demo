package com.example.demo.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @GetMapping("/redis")
    public String redis()
    {
        return "redis" ;
    }

    @RequestMapping("/hello")
    public String Hello()
    {
        return "Hello World";
    }

}
