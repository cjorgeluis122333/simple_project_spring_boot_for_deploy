package com.jorgeluis.microservice.simple_project_spring_boot.service;

import com.jorgeluis.microservice.simple_project_spring_boot.model.DogEntity;
import com.jorgeluis.microservice.simple_project_spring_boot.model.exception.UserNotFoundException;
import com.jorgeluis.microservice.simple_project_spring_boot.repository.PetsRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PetsServiceImpl implements PetsService {

    private final PetsRepository petsRepository;


    @Override
    @Transactional(readOnly = true)
    public List<DogEntity> getDogs() {
        return (List<DogEntity>) petsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DogEntity getDogById(int id) {
        val dog = petsRepository.findById(id);
        return dog.orElse(null);
    }

    @Override
    @Transactional
    public DogEntity insertDog(DogEntity dog) {
        return petsRepository.save(dog);
    }

    @Override
    @Transactional
    public DogEntity updateDog(DogEntity dog) throws UserNotFoundException {
        val temp = petsRepository.findById(dog.getId());
        if (temp.isPresent()) return petsRepository.save(dog);
        else throw new UserNotFoundException();
    }

    @Override
    @Transactional
    public DogEntity deleteDog(int id) {
        val temp = petsRepository.findById(id);
        if (temp.isPresent()) {
            petsRepository.delete(temp.get());
            return temp.get();
        } else
            return null;

    }

    @Override
    public List<DogEntity> getDogsLikeName(String name) {
        return petsRepository.findByNameLike(name);
    }
}
