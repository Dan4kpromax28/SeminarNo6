package lv.venta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "idc")
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

    @OneToOne
    @JoinColumn(name = "idp") // otras klases kolonna
    private Professor professor;

    public Course(String title, int cp, Professor professor){
        setTitle(title);
        setCp(cp);
        setProfessor(professor);
    }
}
