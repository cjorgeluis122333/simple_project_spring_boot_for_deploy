package com.jorgeluis.microservice.simple_project_spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetsController {
    @GetMapping("/")
    List<String> showPets() {
        return List.of("Dog", "Cat", "Cow", "Bird", "Fish");
    }

}
