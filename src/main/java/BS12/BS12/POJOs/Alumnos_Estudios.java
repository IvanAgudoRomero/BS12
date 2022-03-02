package BS12.BS12.POJOs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "estudios")
@Getter
@Setter
public class Alumnos_Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_study;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profesor_id")
    Profesor profesor;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_student")
    Student student;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;

    public Alumnos_Estudios(Alumnos_Estudios alumnos_estudios){
        setId_study(alumnos_estudios.getId_study());
        setProfesor(alumnos_estudios.getProfesor());
        setStudent(alumnos_estudios.getStudent());
        setAsignatura(alumnos_estudios.getAsignatura());
        setComment(alumnos_estudios.getComment());
        setInitial_date(alumnos_estudios.getInitial_date());
        setFinish_date(alumnos_estudios.getFinish_date());
    }

    public Alumnos_Estudios() {
    }
}
