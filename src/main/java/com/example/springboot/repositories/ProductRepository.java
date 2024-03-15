package com.example.springboot.repositories;

import com.example.springboot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
/* The JpaRepository is a SpringData JPA interface that contains the API for basic CRUD operations and also the JPA API
for pagination and sorting. When you extend  JpaRepository,  you inherit several ready-to-use methods, such as save(),
findOne(), findAll, count(), delete(), among others, which can be directly used in your application without the need to implement each one of them.

    The @Repository annotation is Springboot is used to indicate that a class acts as a data repository, that is, it is responsible
    for accessing and manipulating data in the database or other external data source. This allows Springboot to provide
    additional repository-specific features.
*/
