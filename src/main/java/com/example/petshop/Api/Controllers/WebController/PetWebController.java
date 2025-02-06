package com.example.petshop.Api.Controllers.WebController;

import com.example.petshop.Domain.Models.Animal;
import com.example.petshop.Domain.Models.Cage;
import com.example.petshop.Domain.Services.Implementations.CageService;
import com.example.petshop.Domain.Services.Implementations.PetService;
import com.example.petshop.Domain.Services.Implementations.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PetWebController {
    private final PetService _petService;
    private final RaceService _raceService;
    private final CageService _cageService;
    @Autowired
    public PetWebController(PetService petservice, RaceService raceservice, CageService cageservice) {
        this._petService = petservice;
        this._raceService = raceservice;
        this._cageService = cageservice;
    }

    @GetMapping("/")
    public String getAnimals(Model model) {
        List<Animal> animals = _petService.GetAllAnimals();
        Map<Integer, String> raceNames = animals.stream()
                .collect(Collectors.toMap(
                        Animal::getRaceId,
                        animal -> _raceService.GetRaceById(animal.getRaceId()).getName(),
                        (existing, replacement) -> existing
                ));
        model.addAttribute("animals", animals);
        model.addAttribute("raceNames", raceNames);
        return "animal/animals";
    }

    @GetMapping("/add-animal")
    public String showAddForm(Model model) {
        model.addAttribute("cages", _cageService.GetAllCages());
        model.addAttribute("races", _raceService.GetAllRaces());
        return "animal/add-animal";
    }

    @PostMapping("/animals")
    public String addAnimal(@ModelAttribute Animal animal) {
        _petService.AddAnimal(animal);
        return "redirect:/";
    }

    @GetMapping("/stats")
    public String getAnimalStats(Model model) {
        Map<String, Long> animalCounts = _petService.GetAllAnimals().stream()
                .collect(Collectors.groupingBy(
                        animal -> _raceService.GetRaceById(animal.getRaceId()).getName(),
                        Collectors.counting()
                ));
        model.addAttribute("animalStats", animalCounts);
        return "animal/stats";
    }
    @GetMapping("/cages")
    public String getCageOverview(Model model) {
        List<Cage> cages = _cageService.GetAllCages();
        List<Animal> animals = _petService.GetAllAnimals();

        Map<Integer, List<String>> animalsInCages = animals.stream()
                .collect(Collectors.groupingBy(
                        Animal::getCageId,
                        Collectors.mapping(Animal::getName, Collectors.toList())
                ));

        Map<Integer, Double> cageOccupancy = cages.stream()
                .collect(Collectors.toMap(
                        Cage::getId,
                        cage -> {
                            long animalCount = animals.stream()
                                    .filter(a -> a.getCageId() == cage.getId())
                                    .count();
                            return (double) Math.round((animalCount * 100.0 / cage.getSize()) * 10) / 10;
                        }
                ));

        model.addAttribute("cages", cages);
        model.addAttribute("animalsInCages", animalsInCages);
        model.addAttribute("races", _raceService.GetAllRaces());
        return "cage/overview";
    }
    @PostMapping("/cages")
    public String addCage(@ModelAttribute Cage cage) {
        _cageService.AddCage(cage);
        return "redirect:/cages";
    }
}
