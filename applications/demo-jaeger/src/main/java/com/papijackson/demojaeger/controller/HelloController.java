package com.papijackson.demojaeger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "hello")
    String hello(@RequestParam String who) {
        return "Hello " + who;
    }

    @GetMapping("/path1")
    public ResponseEntity path1() {

        String response = restTemplate.getForObject("http://localhost:8090/path2", String.class);
        return ResponseEntity.ok("response from /path1 + " + response);
    }

    @GetMapping("/path2")
    public ResponseEntity path2() {
        return ResponseEntity.ok("response from /path2 ");
    }

}
