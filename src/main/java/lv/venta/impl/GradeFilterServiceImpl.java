package lv.venta.impl;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.StudentRepo;
import lv.venta.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService {
    @Autowired
    private IGradeRepo gradeRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ICourseRepo courseRepo;
    @Override
    public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
        if (id < 0) throw new Exception("Id is incorrect");
        if (!studentRepo.existsById(id)) throw new Exception("There is no student");
        ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
        if (result.isEmpty()) throw new Exception("This is empty");
        return result;
    }

    @Override
    public ArrayList<Grade> selectFailedGrades() throws Exception {
        if (gradeRepo.count() == 0) throw new Exception("No one grade");
        ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
        if (result.isEmpty()) throw new Exception("There is no failed grade");
        return result;
    }

    @Override
    public float calculateAVGGradeInCourse(long id) throws Exception {
        if (id < 0) throw new Exception("Id is incorrect");
        if (!courseRepo.existsById(id)) throw new Exception("There is no course");
        float result = gradeRepo.calculateAVGForCourse(id);
        return result;
    }
}
