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
@Table(name = "ProfessorTable")
@Entity
public class Professor extends Person{

    @Setter(value = AccessLevel.NONE)
    @Column(name = "Idp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idp;


    @Column(name = "Degree")
    @NotNull
    private Degree degree;

    @OneToOne(mappedBy = "professor")
    @ToString.Exclude
    private Course course;

    public Professor(String name, String surname, Degree degree){
        super(name,surname);
        setDegree(degree);
    }
}
