package com.example.petshop.Domain.Services.Implementations;

import com.example.petshop.Data.Repository.ICageRepository;
import com.example.petshop.Domain.Models.Cage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CageService {
    private final ICageRepository _cageRepository;
    public CageService(ICageRepository cageRepository) {
        _cageRepository = cageRepository;
    }
    public List<Cage> GetAllCages() {
        return _cageRepository.findAll();
    }
    public void AddCage(Cage cage) {
        _cageRepository.save(cage);
    }
    public List<Cage> GetAllCagesWithSpace(){
        return _cageRepository.findCagesWithAvailableSpace();
    }
}
