package com.jorgeluis.microservice.simple_project_spring_boot.repository;

import com.jorgeluis.microservice.simple_project_spring_boot.model.DogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends CrudRepository<DogEntity,Integer > {

}
