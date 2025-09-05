package com.jorgeluis.microservice.simple_project_spring_boot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dog")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int age;


    public DogEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
