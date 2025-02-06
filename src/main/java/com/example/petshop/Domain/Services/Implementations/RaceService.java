package com.example.petshop.Domain.Services.Implementations;

import com.example.petshop.Data.Repository.ICageRepository;
import com.example.petshop.Data.Repository.IRaceRepository;
import com.example.petshop.Domain.Models.Race;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {
    private final IRaceRepository _raceRepository;
    public RaceService(IRaceRepository raceRepository) {
        _raceRepository = raceRepository;
    }
    public List<Race> GetAllRaces() {
        return _raceRepository.findAll();
    }
    public Race GetRaceById(int id) {
        return _raceRepository.findById(id);
    }
    public void AddRace(Race race) {
        _raceRepository.save(race);
    }
}
