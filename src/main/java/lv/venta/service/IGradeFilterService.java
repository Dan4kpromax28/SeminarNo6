package lv.venta.service;

import lv.venta.model.Grade;

import java.util.ArrayList;

public interface IGradeFilterService {

    public abstract ArrayList<Grade> selectGradesByStudentId(long id) throws Exception;

    public abstract ArrayList<Grade> selectFailedGrades() throws Exception;
    public abstract float calculateAVGGradeInCourse(long id) throws Exception;
}
