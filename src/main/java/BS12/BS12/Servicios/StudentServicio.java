package BS12.BS12.Servicios;

import BS12.BS12.DTOs.input.StudentInputDTO;
import BS12.BS12.Excepciones.NotFoundException;
import BS12.BS12.Excepciones.UnprocessableEntityException;
import BS12.BS12.POJOs.Student;
import BS12.BS12.Repositorios.PersonaRepositorio;
import BS12.BS12.Repositorios.ProfesorRepositorio;
import BS12.BS12.Repositorios.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicio {
    @Autowired
    StudentRepositorio studentRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    PersonaRepositorio personaRepositorio;

    public Optional<Student> buscarId(int id_student){
        Optional<Student> estudiante = studentRepositorio.findById(id_student);
        return estudiante;
    }

    public List<Student> mostrarTodo(){
        List<Student> students = studentRepositorio.findAll();
        if(students.isEmpty()){
            throw new NotFoundException("No hay usuarios");
        }
        return students;
    }

    public void addStudent(StudentInputDTO student)throws Exception{
        if(student==null){
            throw new UnprocessableEntityException("El estudiante es nulo");
        }else{
            student.setPersonaRepositorio(this.personaRepositorio);
            student.setProfesorRepositorio(this.profesorRepositorio); //de lokos si funciona
            Student st = new Student(student);
            studentRepositorio.save(st);
            System.out.println("Estudiante guardado");
        }
    }

    public void delete(int id_student) {
        Optional<Student> s;
        s = buscarId(id_student);
        if(s==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            studentRepositorio.deleteById(id_student);
        }
    }

    public void updateStudent(int id_student, StudentInputDTO s) throws Exception{

        Optional<Student> aux;
        aux = studentRepositorio.findById(id_student);
        aux.get().setProfesor(profesorRepositorio.findById(s.getId_profesor()).get());
        aux.get().setPersona(personaRepositorio.findById(s.getId_persona()).get());
        aux.get().setId_student(id_student);
        aux.get().setBranch(s.getBranch());
        aux.get().setComents(s.getComents());
        aux.get().setEstudios(s.getEstudios());
        aux.get().setNum_hours_week(s.getNum_hours_week());

        studentRepositorio.save(aux.get());
    }
}
