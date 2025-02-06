package com.example.petshop.Domain.Services.Interfaces;

import com.example.petshop.Domain.Models.Animal;
import com.example.petshop.Domain.Models.Cage;

import java.util.List;

public interface IPetService {
    public Animal GetAnimalById(Integer id);
    public Animal GetAnimalByName(String name);
    public Animal[] GetAllAnimalsInCage(Integer cageId);
    public Animal[] GetAllAnimalsByRace(Integer raceId);
    public List<Animal> GetAllAnimals();
    public void AddAnimal(Animal animal);
    public void RemoveAnimal(Integer id);


    public Cage[] GetAllCages();
}
