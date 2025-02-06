package com.example.petshop.Api.Controllers;

import com.example.petshop.Domain.Models.Animal;
import com.example.petshop.Domain.Services.Implementations.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetsController {
    private final PetService _petService;

    @Autowired
    public PetsController(PetService petservice) {
        this._petService = petservice;
    }
    @GetMapping("")
    List<Animal> all() {
        return _petService.GetAllAnimals();
    }
    @GetMapping("/id/{id}")
    Animal GetAnimalById(@PathVariable int id) {
        return _petService.GetAnimalById(id);
    }

    @GetMapping("/name/{name}")
    Animal GetAnimalByName(@PathVariable String name) {
        return _petService.GetAnimalByName(name);
    }
    @PostMapping("")
    Animal AddAnimal(@RequestBody Animal animal) {
        _petService.AddAnimal(animal);
        return animal;
    }
    @DeleteMapping("/{id}")
    void DeleteAnimalById(@PathVariable int id) {
        _petService.RemoveAnimal(id);
    }
//    Animal UpdateAnimal(Animal animal) {
//        return _petService.updateAnimal(animal);
//    }


}
