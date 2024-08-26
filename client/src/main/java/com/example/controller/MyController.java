package com.example.controller;

import com.example.config.RestClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client-api")
public class MyController {

    @Value("${server.api-url}")
    private String baseUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello(){
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/public/hello")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}
