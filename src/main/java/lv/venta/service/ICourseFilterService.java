package lv.venta.service;

import lv.venta.model.Course;

import java.util.ArrayList;

public interface ICourseFilterService {

    public abstract ArrayList<Course> selectCoursesByStudentId(long id) throws Exception;

    public abstract ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;

    public abstract ArrayList<Course> selectCoursesByCP(int cp) throws Exception;
}
