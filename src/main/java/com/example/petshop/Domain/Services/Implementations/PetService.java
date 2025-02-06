package com.example.petshop.Domain.Services.Implementations;

import com.example.petshop.Data.Repository.IPetRepository;
import com.example.petshop.Domain.Models.Animal;
import com.example.petshop.Domain.Models.Cage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService{
    private final IPetRepository _petRepo;
    public PetService(IPetRepository petRepository) {
        this._petRepo = petRepository;
    }

    public Animal GetAnimalById(Integer id) {
        return null;
    }


    public Animal GetAnimalByName(String name) {
        return _petRepo.findByNameIgnoreCase(name);
    }


    public List<Animal> GetAllAnimals() {
        return _petRepo.findAll();
    }

    public void AddAnimal(Animal animal) {
        _petRepo.save(animal);
    }

    public void RemoveAnimal(Integer id) {
        _petRepo.deleteById(id);
    }
}
