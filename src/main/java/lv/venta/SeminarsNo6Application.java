package lv.venta;

import lv.venta.model.*;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeminarsNo6Application {

    public static void main(String[] args) {
        SpringApplication.run(SeminarsNo6Application.class, args);
    }
    @Bean
    public CommandLineRunner testDatabaseLayer(StudentRepo studRepo, IProfessorRepo profRepo, ICourseRepo icourseRepo, IGradeRepo grRepo){
        return new CommandLineRunner(){
            @Override
            public void run(String... args){
                Professor prof1 = new Professor("Daniels", "Balika", Degree.bsc);
                Professor prof2 = new Professor("Artjoms", "Kolupajevs", Degree.mg);
                Professor prof3 = new Professor("Arturs", "Orbidans", Degree.mg);
                profRepo.save(prof1);
                profRepo.save(prof2);
                profRepo.save(prof3);


                Student stud1 = new Student("Darijs", "Balika");
                Student stud2 = new Student("Mihails", "Kolupajevs");
                studRepo.save(stud1);
                studRepo.save(stud2);

                Course course1 = new Course("Matematika", 2, prof1);
                Course course2 = new Course("Fizika", 3, prof2);
                Course course3 = new Course("Operatajsistemas", 3, prof1, prof3);
                icourseRepo.save(course1);
                icourseRepo.save(course2);
                icourseRepo.save(course3);
                prof1.addCourse(course1);
                prof1.addCourse(course1);
                profRepo.save(prof1);

                prof2.addCourse(course2);
                profRepo.save(prof2);
                prof3.addCourse(course3);
                profRepo.save(prof3);


                Grade grade1 = new Grade(stud1, course1, 7);
                Grade grade2 = new Grade(stud2, course2, 8);
                grRepo.save(grade1);
                grRepo.save(grade2);
            }
        };
    }

}
