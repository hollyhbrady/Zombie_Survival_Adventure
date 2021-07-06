package Holly.Zombie_Survival_Adventure.controllers;

import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class SurvivorLevelController {

    @Autowired
    SurvivorLevelRepository survivorLevelRepository;

//    @GetMapping(value = "/survivorLevels")
//    public ResponseEntity <List<SurvivorLevel>> getAllSurvivorLevels() {
//        return new ResponseEntity<>(survivorLevelRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/survivorLevels/{id}")
    public ResponseEntity getSurvivorLevelById(@PathVariable Long id) {
        return new ResponseEntity<>(survivorLevelRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/survivorLevels", method = RequestMethod.GET)
    public List<SurvivorLevel> home(Model model) {
        List<SurvivorLevel> enums = Arrays.asList(SurvivorLevel.values());
        model.addAttribute("enums",enums);
        System.out.println(enums.size());
        return enums;
    }
}
