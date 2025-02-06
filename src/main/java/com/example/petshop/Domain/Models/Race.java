package com.example.petshop.Domain.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int maxAge;

    public Race(int id, String name, int maxAge) {
        this.id = id;
        this.name = name;
        this.maxAge = maxAge;
    }

    public Race() {

    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}