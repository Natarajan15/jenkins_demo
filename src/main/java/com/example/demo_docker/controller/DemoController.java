package com.example.demo_docker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${message:This is the default message}")
    private String message;



    @GetMapping("/docker")
    public ResponseEntity<String> getDockerMessage(){
        return ResponseEntity.ok("Welcome to Docker ");
    }

    @GetMapping("/kubernetes")
    public ResponseEntity<String> getKubernetesMessage(){
        return ResponseEntity.ok("Welcome to Kubernetes ");
    }

    @GetMapping("/jenkins")
    public ResponseEntity<String> getJenkinsMessage(){
        return ResponseEntity.ok("Welcome to jenkins");
    }


    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok(message);
    }
}
