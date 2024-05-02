package lv.venta.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity
public class Grade {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idg")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idg;

    @Column(name = "Grvalue")
    private int grvalue;

    @ManyToOne
    @JoinColumn(name = "Idc") // saite uz kollonu
    private Course course;

    @ManyToOne
    @JoinColumn(name = "Ids")
    private Student student;

    public Grade(Student student, Course course, int grvalue){
        setStudent(student);
        setCourse(course);
        setGrvalue(grvalue);
    }

}
