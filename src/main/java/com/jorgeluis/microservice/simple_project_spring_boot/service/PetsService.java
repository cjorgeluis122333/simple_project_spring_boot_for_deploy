package com.jorgeluis.microservice.simple_project_spring_boot.service;


import com.jorgeluis.microservice.simple_project_spring_boot.model.DogEntity;

import java.util.List;

public interface PetsService {

    List<DogEntity> getDogs();

    DogEntity getDogById(int id);

    DogEntity insertDog(DogEntity dog);

    DogEntity updateDog(DogEntity dog);

    DogEntity deleteDog(int id);

}
