package com.example.petshop.Database;

import com.example.petshop.Models.Animal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase {
    private static InMemoryDatabase instance;
    private final Map<Integer, Animal> animalData;

    // Private constructor for singleton pattern
    private InMemoryDatabase() {
        animalData = new ConcurrentHashMap<>();
    }

    // Singleton instance getter
    public static InMemoryDatabase getInstance() {
        if (instance == null) {
            instance = new InMemoryDatabase();
        }
        return instance;
    }

    // Database operations
    public Animal get(int id) {
        return animalData.get(id);
    }

    public Animal[] getAll() {
        return animalData.values().toArray(new Animal[0]);
    }

    public void add(Animal animal) {
        animalData.put(animal.getId(), animal);
    }

    public void update(Animal animal) {
        animalData.put(animal.getId(), animal);
    }

    public void delete(int id) {
        animalData.remove(id);
    }

    public boolean exists(int id) {
        return animalData.containsKey(id);
    }

    public void clear() {
        animalData.clear();
    }
}
