package com.example.petshop.Domain.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private  int birthYear;
    private int raceId;
    private int cageId;


    public Animal(int id, String name, int birthYear, int raceId, int cageId) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.raceId = raceId;
        this.cageId = cageId;
    }
    public Animal() {}




    public String getName() { return name; }
    public int getAge() { return birthYear; }
    public int getRaceId() { return raceId; }
    public void setRaceId(int raceId) { this.raceId = raceId; }
    public int getCageId() { return cageId; }
    public void setCageId(int cageId) { this.cageId = cageId; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
