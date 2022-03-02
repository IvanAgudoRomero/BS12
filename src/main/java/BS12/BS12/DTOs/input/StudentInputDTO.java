package BS12.BS12.DTOs.input;

import BS12.BS12.Excepciones.NotFoundException;
import BS12.BS12.POJOs.Student;
import BS12.BS12.Repositorios.*;
import lombok.Data;

import java.util.List;

@Data
public class StudentInputDTO{
    Integer id_student;
    Integer id_persona;
    Integer num_hours_week;
    String coments;
    Integer id_profesor;
    String branch;
    List estudios;
    PersonaRepositorio personaRepositorio;
    ProfesorRepositorio profesorRepositorio;

    public Student estudiante() throws NotFoundException {
        Student estudiante = new Student();
        estudiante.setId_student(this.getId_student());
        estudiante.setPersona(personaRepositorio.findById(getId_persona()).get());
        //estudiante.setPersona(personaServicio.buscarId(this.getId_persona()).orElseThrow(() -> new NotFoundException()));
        estudiante.setNum_hours_week(this.getNum_hours_week());
        estudiante.setComents(this.getComents());
        estudiante.setProfesor(profesorRepositorio.findById(getId_profesor()).get());
        //estudiante.setProfesor(profesorServicio.buscarId(this.getId_profesor()).orElseThrow(() -> new NotFoundException()));
        estudiante.setBranch(this.getBranch());
        estudiante.setEstudios(this.getEstudios());
        return estudiante;
        //recibir input dto por el controlador que solo tiene atributos primitivos no objetos
        //lo que se recibe en el controlador se mapea a un objeto de la capa de dominio si es profesor a partir de la id obtener el profesor entero y luego persistirlo
    }
}
/*
* Cómo hago para devolver una persona a partir de su id desde aquí?
* */