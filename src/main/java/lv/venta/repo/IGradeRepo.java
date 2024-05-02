package lv.venta.repo;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGradeRepo  extends CrudRepository<Grade, Long> {

    ArrayList<Grade> findByStudentIds(long id);

    ArrayList<Grade> findByGrvalueLessThan(int i);
    @Query(nativeQuery = true, value = "SELECT AVG(GRVALUE) FROM GRADE_TABLE WHERE IDC=?1")
    float calculateAVGForCourse(long id);
}
