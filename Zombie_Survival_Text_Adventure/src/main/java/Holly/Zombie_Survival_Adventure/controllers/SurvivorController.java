package Holly.Zombie_Survival_Adventure.controllers;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurvivorController {

    @Autowired
    SurvivorRepository survivorRepository;

    @GetMapping(value = "/survivors")
    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    @PostMapping(value = "/survivors")
    public ResponseEntity<Survivor> postSurvivor(@RequestBody Survivor survivor){
        survivorRepository.save(survivor);
        return new ResponseEntity<>(survivor, HttpStatus.CREATED);
    }
}
