package com.example.petshop.Data.Repository;

import com.example.petshop.Domain.Models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Animal,Integer> {
    Animal findByNameIgnoreCase(String name);
}
