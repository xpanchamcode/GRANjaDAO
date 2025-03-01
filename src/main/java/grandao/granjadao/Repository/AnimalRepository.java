package grandao.granjadao.Repository;

import grandao.granjadao.Model.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<Animal, Integer> {
}
