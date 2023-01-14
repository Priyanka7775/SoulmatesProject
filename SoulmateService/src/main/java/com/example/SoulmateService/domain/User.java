package com.example.SoulmateService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Id
    private String email;
    private String name;
    private int age;
    private String gender;
    private String city;
    private String password;

}
