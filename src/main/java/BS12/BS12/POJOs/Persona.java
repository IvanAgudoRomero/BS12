package BS12.BS12.POJOs;

import BS12.BS12.DTOs.input.PersonaInputDTO;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    int id_persona;

    @NonNull
    @Column(name = "usuario")
    public String usuario;

    @NonNull
    @Column(name = "password")
    public String password;

    @NonNull
    @Column(name = "name")
    public String name;

    @NonNull
    @Column(name = "surname")
    public String surname;

    @NonNull
    @Column(name = "company_email")
    public String company_email;

    @NonNull
    @Column(name = "personal_email")
    public String personal_email;

    @NonNull
    @Column(name = "city")
    public String city;

    @NonNull
    @Column(name = "active")
    public boolean active;

    @NonNull
    @Column(name = "created_date")
    public Date created_date;

    @NonNull
    @Column(name = "imagen_url")
    public String imagen_url;

    @NonNull
    @Column(name = "termination_date")
    public Date termination_date;

    public Persona(PersonaInputDTO personaDTO) {
        setId_persona(personaDTO.getId_persona());
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.isActive());
        setCreated_date(personaDTO.getCreated_date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTermination_date());
    }

    public Persona() {
    }


}
