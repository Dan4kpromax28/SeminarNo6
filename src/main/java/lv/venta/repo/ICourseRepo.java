package lv.venta.repo;

import lv.venta.model.Course;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ICourseRepo extends CrudRepository<Course, Long> {


    ArrayList<Course> findByGradesStudentIds(long id);

    ArrayList<Course> findByProfessorsIdp(long id);

    ArrayList<Course> findByCp(int cp);
}
