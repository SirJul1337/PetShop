package com.example.petshop.Data.Repository;

import com.example.petshop.Domain.Models.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICageRepository extends JpaRepository<Cage, Integer> {
}
