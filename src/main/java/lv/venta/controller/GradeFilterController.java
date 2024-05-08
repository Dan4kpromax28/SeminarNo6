package lv.venta.controller;

import lv.venta.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("grade/filter")
public class GradeFilterController {
    @Autowired
    private IGradeFilterService gradeService;
    @GetMapping("/student") // localhost:8080/grade/filter/student?id=2
    public String getGradeFilterStudentById(@RequestParam("id") int id, Model model ){
        try {
            model.addAttribute("myobjs",gradeService.selectGradesByStudentId(id));
            model.addAttribute("mytitle", "Filtered by Student");
            return "show-all-grade-page";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/failed") // localhost:8080/grade/filter/failed
    public String getGradeFilterFailed(Model model ){
        try {
            model.addAttribute("myobjs",gradeService.selectFailedGrades());
            model.addAttribute("mytitle", "Filtered by Failed");
            return "show-all-grade-page";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/course") // localhost:8080/grade/filter/course?id=2
    public String getGradeFilterCourseById(@RequestParam("id") int id, Model model ){
        try {
            model.addAttribute("myobjs",gradeService.calculateAVGGradeInCourse(id));
            model.addAttribute("mytitle", "AVG by Course IDc");
            return "show-avg-grade";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "error-page";
        }
    }
}
