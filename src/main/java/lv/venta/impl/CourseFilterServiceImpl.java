package lv.venta.impl;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.StudentRepo;
import lv.venta.service.ICourseFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService {

    @Autowired
    private ICourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private IProfessorRepo professorRepo;

    @Override
    public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
        if (id <= 0 ) throw new Exception("Id should be positive");
        if (!studentRepo.existsById(id)) throw new Exception("There no student");
        ArrayList<Course> result = courseRepo.findByGradesStudentIds(id);
        if (result.isEmpty()) throw new Exception("Thre is no course");
        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
        if (id <= 0 ) throw new Exception("Id should be positive");
        if (!professorRepo.existsById(id)) throw new Exception("There no proffesor");
        ArrayList<Course> result = courseRepo.findByProfessorIdp(id);
        if(result.isEmpty()) throw new Exception("There is no courses");
        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
        if (cp < 0 || cp > 20) throw new Exception("Cp should be correct");
        ArrayList<Course> result = courseRepo.findByCp(cp);
        if(result.isEmpty()) throw new Exception("There is no courses");
        return result;
    }
}
