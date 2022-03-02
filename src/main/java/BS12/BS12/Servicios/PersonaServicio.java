package BS12.BS12.Servicios;

import BS12.BS12.DTOs.input.PersonaInputDTO;
import BS12.BS12.Excepciones.NotFoundException;
import BS12.BS12.Excepciones.UnprocessableEntityException;
import BS12.BS12.POJOs.Persona;
import BS12.BS12.Repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicio{
    @Autowired
    public PersonaRepositorio personaRepo;

    public Optional<Persona> buscarId(int id_persona){
        ArrayList usuarios = new ArrayList();
        Optional<Persona> p;
        p = personaRepo.findById(id_persona);  //vuelve a ser nulo
        if(p==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            System.out.println("Persona devuelta");
        }
        return p;
    }

    public List<Persona> buscarUsuario(String usuario){
        List<Persona> usuarios;
        usuarios = personaRepo.findByUsuario(usuario);
        if(usuarios==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            System.out.println("Usuarios devueltos");
        }
        return usuarios;
    }

    public void addPersona(PersonaInputDTO p)throws Exception{
        checkPersona(p);
        Persona persona = new Persona(p);
        personaRepo.save(persona);
        System.out.println("Persona guardada");
    }

    public void checkPersona(PersonaInputDTO p){
        if(p == null){
            throw new UnprocessableEntityException("La persona no puede ser nula");
        }
        if (p.getUsuario() == null) {
            throw new UnprocessableEntityException("Usuario no puede ser nulo");
        }
        if (p.getUsuario().length() > 10) {
            throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        if (p.getPassword() == null) {
            throw new UnprocessableEntityException("Password no puede ser nulo");
        }
        if (p.getName() == null) {
            throw new UnprocessableEntityException("name no puede ser nulo");
        }
        if (p.getCompany_email() == null) {
            throw new UnprocessableEntityException("company_email no puede ser nulo");
        }
        if (p.getPersonal_email() == null) {
            throw new UnprocessableEntityException("personal_email no puede ser nulo");
        }
        if (p.getCity() == null) {
            throw new UnprocessableEntityException("city no puede ser nulo");
        }
        if (p.getCreated_date() == null) {
            throw new UnprocessableEntityException("created_date no puede ser nulo");
        }
    }

    public ArrayList mostrarTodo(){
        ArrayList usuarios = new ArrayList(personaRepo.findAll());
        //ArrayList usuarios = (ArrayList) personaRepo.findAll();

        if(usuarios.isEmpty()){
            throw new NotFoundException("No hay usuarios");
        }
        return usuarios;
    }

    public void delete(int id_persona){
        Optional<Persona> p;
        p = buscarId(id_persona);
        if(p==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            personaRepo.deleteById(id_persona);
        }
    }

    public void updatePersona(int id_persona, Optional<Persona> p) throws Exception { //habría que poner un input DTO
        Optional<Persona> aux;
        aux = personaRepo.findById(id_persona);
        aux.get().setActive(p.get().isActive());
        aux.get().setId_persona(id_persona);
        aux.get().setCity(p.get().getCity());
        aux.get().setCompany_email(p.get().getCompany_email());
        aux.get().setCreated_date(p.get().getCreated_date());
        aux.get().setPersonal_email(p.get().getPersonal_email());
        aux.get().setImagen_url(p.get().getImagen_url());
        aux.get().setName(p.get().getName());
        aux.get().setPassword(p.get().getPassword());
        aux.get().setSurname(p.get().getSurname());
        aux.get().setTermination_date(p.get().getTermination_date());
        aux.get().setUsuario(p.get().getUsuario());

        personaRepo.save(aux.get());
    }
}
