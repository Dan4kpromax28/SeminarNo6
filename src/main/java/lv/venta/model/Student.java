package lv.venta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "StudentTable")
@Entity
public class Student {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "Ids")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ids;

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

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private Collection<Grade> grades;






    public Student(String name, String surname) {
        setName(name);
        setSurname(surname);
    }



}
