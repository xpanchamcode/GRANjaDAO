package grandao.granjadao.Service;

import grandao.granjadao.Model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAll();

    Animal findById(Integer id);

    Animal save(Animal animal);

    Animal update(Integer id, Animal animal);

    void deleteById(Integer id);
}
