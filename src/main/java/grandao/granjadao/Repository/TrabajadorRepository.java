package grandao.granjadao.Repository;

import grandao.granjadao.Model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository <Trabajador, String> {
}
