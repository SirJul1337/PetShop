package com.example.petshop.Domain.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Cages")
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int size;
    private int raceId;

    public Cage(int id, int size, int raceId) {
        this.id = id;
        this.size = size;
        this.raceId = raceId;
    }

    public Cage() {

    }

    // Getters and setters

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}