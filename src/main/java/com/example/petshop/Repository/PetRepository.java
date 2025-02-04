package com.example.petshop.Repository;

import com.example.petshop.Models.Animal;
import com.example.petshop.Database.InMemoryDatabase;

public class PetRepository implements IPetRepository {
    private final InMemoryDatabase db;

    public PetRepository() {
        this.db = InMemoryDatabase.getInstance();
    }

    public Animal getAnimal(int id) {
        return db.get(id);
    }

    public Animal[] GetAllAnimals() {
        return db.getAll();
    }

    // Additional repository methods that use the database
    public void addAnimal(Animal animal) {
        db.add(animal);
    }

    public Animal updateAnimal(Animal animal) {
        if (db.exists(animal.getId())) {
            db.update(animal);
        }
        return animal;
    }

    public void deleteAnimal(int id) {
        db.delete(id);
    }

    public boolean exists(int id) {
        return db.exists(id);
    }
}
