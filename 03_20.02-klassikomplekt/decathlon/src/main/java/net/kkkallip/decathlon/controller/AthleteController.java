package net.kkkallip.decathlon.controller;

import lombok.AllArgsConstructor;
import net.kkkallip.decathlon.entity.Athlete;
import net.kkkallip.decathlon.entity.Result;
import net.kkkallip.decathlon.repository.AthleteRepository;
import net.kkkallip.decathlon.service.AthleteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AthleteController {

    private AthleteRepository athleteRepository;
    private AthleteService athleteService;

    @GetMapping("athletes")
    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    @PostMapping("athletes")
    public List<Athlete> addAthlete(@RequestBody Athlete athlete) {
        athleteService.validateAthlete(athlete);
        athleteRepository.save(athlete);
        return athleteRepository.findAll();
    }

    @PostMapping("athletes/{id}/results")
    public Athlete addResult(@PathVariable Long id, @RequestBody Result result) {
        return athleteService.addResult(id, result);
    }

    @GetMapping("athletes/{id}/total")
    public Athlete getTotalPoints(@PathVariable Long id) {
        return athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sportlast ID-ga " + id + " ei leitud"));
    }
}