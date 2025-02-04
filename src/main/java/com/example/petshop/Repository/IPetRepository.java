package com.example.petshop.Repository;

import com.example.petshop.Models.Animal;

public interface IPetRepository {
    Animal getAnimal(int id);
    Animal[] GetAllAnimals();


    void addAnimal(Animal animal);
    Animal updateAnimal(Animal animal);
    void deleteAnimal(int id);
    boolean exists(int id);
}
