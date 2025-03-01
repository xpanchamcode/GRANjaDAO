package grandao.granjadao.Controller;

import grandao.granjadao.Model.Animal;
import grandao.granjadao.Service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animales")
@CacheConfig(cacheNames = {"animales"})
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Cacheable
    @GetMapping
    public ResponseEntity<?> getAllAnimales() {
        List<Animal> listaAnimales = animalService.getAll();
        return ResponseEntity.ok().body(listaAnimales);
    }

    @Cacheable
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable Integer id) {
        try{
            Animal animal = animalService.findById(id);
            return ResponseEntity.ok().body(animal);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addAnimal(@Valid @RequestBody Animal animal) {
        try{
            Animal animalSave = animalService.save(animal);
            return ResponseEntity.status(201).body(animalSave);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable Integer id, @Valid @RequestBody Animal animal) {
        try{
            Animal animalUpdate = animalService.update(id, animal);
            return ResponseEntity.ok().body(animalUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Integer id) {
        try{
            animalService.deleteById(id);
            return ResponseEntity.ok().body("Animal con id "+id+" eliminado correctamente.");
        } catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
