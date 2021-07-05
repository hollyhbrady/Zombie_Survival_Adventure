package Holly.Zombie_Survival_Adventure.controllers;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurvivorLevelController {

    @Autowired
    SurvivorLevelRepository survivorLevelRepository;

    @GetMapping(value = "/survivorLevels")
    public List<SurvivorLevel> getAllSurvivorLevels() {
        return survivorLevelRepository.findAll();
    }
}
