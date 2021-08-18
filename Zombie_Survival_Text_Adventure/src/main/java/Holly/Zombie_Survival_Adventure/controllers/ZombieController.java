package Holly.Zombie_Survival_Adventure.controllers;

import Holly.Zombie_Survival_Adventure.models.Zombie;
import Holly.Zombie_Survival_Adventure.repositories.ZombieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZombieController {

    @Autowired
    ZombieRepository zombieRepository;

    @GetMapping(value = "/zombies")
    public List<Zombie> getAllZombies() {
        return zombieRepository.findAll();
    }
}
