package lv.venta.repo;

import lv.venta.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface IProfessorRepo extends CrudRepository<Professor, Long> {
}
