package lv.venta.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")
@Entity
public class Professor {

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idp;

    @Column(name = "Name")
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za]{1}[a-z]+")
    private String name;

    @Column(name = "Surname")
    @NotNull
    @Size(min = 2, max = 40)
    @Pattern(regexp = "[A-Za]{1}[a-z]+")
    private String surname;

    @Column(name = "Degree")
    @NotNull
    private Degree degree;

    @ManyToMany(mappedBy = "professors")
    @ToString.Exclude
    private Collection<Course> courses = new ArrayList<Course>();

    public Professor(String name, String surname, Degree degree){
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }

    public void addCourse(Course course){
        if (!courses.contains(course)){
            courses.add(course);
        }
    }

    public void deleteCourse(Course course){
        if (courses.contains(course)){
            courses.remove(course);
        }
    }

}
