package BS12.BS12.DTOs.input;

import BS12.BS12.POJOs.Profesor;
import BS12.BS12.Repositorios.PersonaRepositorio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ProfesorInputDTO {
    @Autowired
    PersonaRepositorio personaRepositorio;

    private Integer id_profesor;
    private Integer id_persona;
    private String coments;
    private String branch;

    public Profesor profesor(){
        Profesor profesor = new Profesor();
        profesor.setId_profesor(this.getId_profesor());
        profesor.setPersona(personaRepositorio.getById(this.getId_persona()));//usando getById no da problemas en vez de findBy
        profesor.setComents(this.getComents());
        profesor.setBranch(this.getBranch());
        return profesor;
    }
}