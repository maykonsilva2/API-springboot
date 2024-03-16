package com.example.springboot.controller;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
}
/*
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
    -With dependency injection configured, either via @Autowired or constructor injection, we can implement operations CRUD (@GetMapping, @PostMapping, @PutMapping, and @DeleteMapping)

-@PostMapping(“/products”): This annotation is used to map HTTP POST requests to the saveProduct method. When a POST
    request is made to the /products path, this method is invoked.
-@RequestBody: This annotation indicates that a method parameter should be bound to the HTTP request body. This means
    that the JSON or XML data sent in the request will be converted to a ProductRecordDto object.
-@Valid: This annotation is used to enable validation of properties noted within ProductRecordDto. If any field does not
    pass validation, an exception will be thrown and the request will not be processed.
-ResponseEntity<ProductModel>: This is the return type of the saveProduct method. ResponseEntity is a Spring class that
    allows you to manipulate complete HTTP response information, such as status, headers and body.
-BeanUtils.copyProperties(productRecordDto, productModel): This method is used to copy properties from one bean to another,
    in this case, from ProductRecordDto to ProductModel. This is useful for transferring data received in the request to the
     model that will be persisted in the database.
-ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel)): This line creates a ResponseEntity
    with HTTP status 201 (CREATED) and the body containing the ProductModel that was saved in the database. The productRepository's
        save method persists the productModel in the database and returns the persisted entity.

* */
