package com.example.petshop.Data.Repository;

import com.example.petshop.Domain.Models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRaceRepository extends JpaRepository<Race,Integer> {
    Race findById(int id);
}
