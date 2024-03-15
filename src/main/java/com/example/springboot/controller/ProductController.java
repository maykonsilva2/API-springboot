package com.example.springboot.controller;

import com.example.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
}
/*
stopped: https://youtu.be/wlYvA2b1BWI?t=3185 53:05
    when you use @RestController on a class in Springboot, you are telling Spring: "Hey, this class here will handle requests
    coming in from the internet". So, if someone asks for something from your application,
    like information about a product, @RestController will take care of understanding that request and giving the right answer.

    Here are the key points about @RestController:
    -Automates serialization: Methods in a class annotated with @RestController automatically serialize JSON or XML return objects to the HTTP response.

    -Request handling: It is common to use other annotations along with @RestController to handle different types of HTTP requests, such as
    @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping.


* The @Autowired annotation is used for automatic dependency  injection in SpringBoot.
* What this means is that Springboot will automatically look for a matching bean(an object managed by Springboot) that matches
* the type of the property where @Autowired is placed. If a matching bean is found, it is injected into the property,
* eliminating the need to manually instantiate or search for the bean
* */
