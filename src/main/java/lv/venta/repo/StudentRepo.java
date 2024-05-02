package lv.venta.repo;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {

}
