package com.jorgeluis.microservice.simple_project_spring_boot.controller;

import com.jorgeluis.microservice.simple_project_spring_boot.model.DogEntity;
import com.jorgeluis.microservice.simple_project_spring_boot.model.exception.UserNotFoundException;
import com.jorgeluis.microservice.simple_project_spring_boot.service.PetsService;
import com.jorgeluis.microservice.simple_project_spring_boot.utili.RequestValidation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pets")
public class PetsController {

    private final PetsService petsService;

    @GetMapping({"/", "/pets"})
    ResponseEntity<List<DogEntity>> showPets() {
        return ResponseEntity.ok(petsService.getDogs());
    }

    @GetMapping("/{id}")
    ResponseEntity<DogEntity> showPet(@PathVariable int id) {
        val tempPet = petsService.getDogById(id);
        return tempPet != null ? ResponseEntity.ok(tempPet) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    ResponseEntity<?> createPet(@Valid @RequestBody DogEntity dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return RequestValidation.validation(bindingResult);
        return ResponseEntity.ok(petsService.insertDog(dog));
    }

    @PutMapping("/")
    ResponseEntity<?> updatePet(@Valid @RequestBody DogEntity dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return RequestValidation.validation(bindingResult);
        DogEntity tempPet;
        try {
            tempPet = petsService.updateDog(dog);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tempPet);
    }

    @DeleteMapping("/")
    ResponseEntity<?> deletePet(@RequestParam int id) {
        val tempResult = petsService.deleteDog(id);
        return tempResult != null ? ResponseEntity.ok(tempResult) : ResponseEntity.notFound().build();
    }


}


