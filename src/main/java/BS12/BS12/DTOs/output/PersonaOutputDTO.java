package BS12.BS12.DTOs.output;

import BS12.BS12.POJOs.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class PersonaOutputDTO {
    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public PersonaOutputDTO(Persona p){
        setId_persona(p.getId_persona());
        setUsuario(p.getUsuario());
        setPassword(p.getPassword());
        setName(p.getName());
        setSurname(p.getSurname());
        setCompany_email(p.getCompany_email());
        setPersonal_email(p.getPersonal_email());
        setCity(p.getCity());
        setActive(p.isActive());
        setCreated_date(p.getCreated_date());
        setImagen_url(p.getImagen_url());
        setTermination_date(p.getTermination_date());
    }
}
