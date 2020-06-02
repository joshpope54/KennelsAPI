package dev.joshpope.Kennels.API.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }


    @GetMapping("/animals/{id}")
    public Animal getUsersById(@PathVariable(value = "id") Long userId) {
        return animalRepository.findById(userId)
                .orElseThrow(() -> new AnimalException(userId));
    }

    @PostMapping("/animals")
    public Animal newCustomer(@RequestBody Animal newAnimal) {
        return animalRepository.save(newAnimal);
    }
}