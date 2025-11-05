package com.example.userapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor     // Generates a no-args constructor
@AllArgsConstructor     // Generates an all-args constructor
public class User {
    private Long id;
    private String name;
    private String email;
}

