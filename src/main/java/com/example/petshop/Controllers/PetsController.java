package com.example.petshop.Controllers;

import com.example.petshop.Models.Animal;
import com.example.petshop.Repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetsController {
    private final IPetRepository _repository;

    @Autowired
    public PetsController(IPetRepository repository) {
        this._repository = repository;
    }
    @GetMapping("")
    Animal[] all() {
        return _repository.GetAllAnimals();
    }
    @GetMapping("/{id}")
    Animal GetAnimalById(@PathVariable int id) {
        return _repository.getAnimal(id);
    }
    @PostMapping("")
    Animal AddAnimal(@RequestBody Animal animal) {
        _repository.addAnimal(animal);
        return animal;
    }
    @DeleteMapping("/{id}")
    void DeleteAnimalById(@PathVariable int id) {
        _repository.deleteAnimal(id);
    }
    Animal UpdateAnimal(Animal animal) {
        return _repository.updateAnimal(animal);
    }


}
