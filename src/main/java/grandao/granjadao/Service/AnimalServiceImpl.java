package grandao.granjadao.Service;

import grandao.granjadao.Model.Animal;
import grandao.granjadao.Repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(Integer id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado."));
    }

    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Integer id, Animal animal) {
        Animal animalUpdate = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado."));

        animalUpdate.setNombre(animal.getNombre());
        animalUpdate.setEspecie(animal.getEspecie());

        return animalRepository.save(animalUpdate);
    }

    @Override
    public void deleteById(Integer id) {
        Animal animalDelete = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado."));
        animalRepository.delete(animalDelete);
    }
}
