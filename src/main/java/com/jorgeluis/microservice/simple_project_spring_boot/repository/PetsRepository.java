package com.jorgeluis.microservice.simple_project_spring_boot.repository;

import com.jorgeluis.microservice.simple_project_spring_boot.model.DogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends CrudRepository<DogEntity,Integer > {

//    @Query("select p Form pets p like p.")
    List<DogEntity> findByNameLike(String name);

}
