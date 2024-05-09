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
@Table(name = "CourseTable")
@Entity
public class Course {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idc")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idc;

    @NotNull
    @Size(min = 4, max = 50)
    @Pattern(regexp = "[A-Za-z :]+")
    @Column(name = "Title")
    private String title;

    @NotNull
    @Column(name = "Cp")
    private int cp;

    @OneToMany(mappedBy ="course")
    private Collection<Grade> grades;

    @ManyToMany
    @JoinTable(name = "CourseProffesorTable",joinColumns = @JoinColumn(name = "Idc"), inverseJoinColumns = @JoinColumn(name = "Idp"))
    @JoinColumn(name = "Idp") // otras klases kolonna
    private Collection<Professor> professors = new ArrayList<Professor>();

    public Course(String title, int cp, Professor ... professor){
        setTitle(title);
        setCp(cp);
        for (Professor tempP : professors){
            addProfessor(tempP);
        }
    }

    public void addProfessor(Professor professor){
        if (!professors.contains(professor)){
            professors.add(professor);
        }
    }

    public void deleteProffesor(Professor professor){
        if (professors.contains(professor)){
            professors.remove(professor);
        }
    }
}
