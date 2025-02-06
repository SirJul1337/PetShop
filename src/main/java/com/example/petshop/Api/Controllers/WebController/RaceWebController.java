package com.example.petshop.Api.Controllers.WebController;

import com.example.petshop.Domain.Models.Race;
import com.example.petshop.Domain.Services.Implementations.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class RaceWebController {
    private final RaceService _raceService;
    public RaceWebController(RaceService raceService) {
        _raceService = raceService;
    }

    @GetMapping("/species")
    public String getSpecies(Model model) {
        List<Race> races = _raceService.GetAllRaces();

        model.addAttribute("races", races);
        return "race/overview";
    }

    @GetMapping("/add-species")
    public String addSpecies(Model model) {
        return "race/add-species";
    }
    @PostMapping("/species")
    public String addRace(@ModelAttribute Race race) {
        _raceService.AddRace(race);
        return "redirect:/species";
    }
}
