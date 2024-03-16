package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @NotNull  BigDecimal value) {

}

/*
* `record` is used to define a special type of class intended primarily for storing data in a concise and immutable form.
* Since Java 16, `record` are an efficient  way to represent simple data transfers, such as DTOs(Data Transfer Objects),
* without the need to write repetitive code, such as getters, setters.
*   - Here's what a record does:
*       -Concise Declaration: You can declare a `record` with a single line, specifying the field names and types.
*       -Final Fields: All fields in `record` are `final` by default, which means they are immutable after the object is constructed.
*       - Automatically Generated Methods: The compiler automatically generates access methods for each field, in addition
*         to the `equals()`, ``hashCode()`` and `toString()` methods based on the ``record`` fields.
*       -Constructors: Records come with a default public constructor that accepts all fields as parameters.
*        You can also define a custom constructor if you need additional validation or logic.
*
*  public record ProductRecordDto(@NotBlank String name, @NotNull  BigDecimal value) these are the fields created in the Database ( the same inside model class)
*       @NotBlank -> This annotation is used in text fields(String) and guarantees that the values is not null, empty or consists only of white spaces.
*                   It's useful when you want to ensure that a text
*       @NotNull - > This annotation is used to ensure that the field is not null. Can be applied to any field type, including BigDecimal.
* They are used to validate the fields of a record or a class in java, ensuring that the data meets certain criteria before being processed or persisted in the database.
*
* */