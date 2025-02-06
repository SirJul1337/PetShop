package com.example.petshop.Domain.Services.Implementations;

import com.example.petshop.Data.Repository.IPetRepository;
import com.example.petshop.Domain.Models.Animal;
import com.example.petshop.Domain.Models.Cage;
import com.example.petshop.Domain.Services.Interfaces.IPetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements IPetService {
    private final IPetRepository _petRepo;
    public PetService(IPetRepository petRepository) {
        this._petRepo = petRepository;
    }

    @Override
    public Animal GetAnimalById(Integer id) {
        return null;
    }

    @Override
    public Animal GetAnimalByName(String name) {
        return _petRepo.findByNameIgnoreCase(name);
    }

    @Override
    public Animal[] GetAllAnimalsInCage(Integer cageId) {
        return new Animal[0];
    }

    @Override
    public Animal[] GetAllAnimalsByRace(Integer raceId) {
        return new Animal[0];
    }

    @Override
    public List<Animal> GetAllAnimals() {
        return _petRepo.findAll();
    }

    @Override
    public void AddAnimal(Animal animal) {

    }

    @Override
    public void RemoveAnimal(Integer id) {

    }

    @Override
    public Cage[] GetAllCages() {
        return new Cage[0];
    }
}
