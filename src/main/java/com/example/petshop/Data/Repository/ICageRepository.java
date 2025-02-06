package com.example.petshop.Data.Repository;

import com.example.petshop.Domain.Models.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICageRepository extends JpaRepository<Cage, Integer> {
    @Query("SELECT c FROM Cage c WHERE c.size > (SELECT COUNT(a) FROM Animal a WHERE a.cageId = c.id)")
    List<Cage> findCagesWithAvailableSpace();
}
