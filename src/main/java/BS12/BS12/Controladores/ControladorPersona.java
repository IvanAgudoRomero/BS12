package BS12.BS12.Controladores;

import BS12.BS12.DTOs.input.PersonaInputDTO;
import BS12.BS12.DTOs.output.PersonaOutputDTO;
import BS12.BS12.POJOs.Persona;
import BS12.BS12.Servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET,RequestMethod.POST})
public class ControladorPersona {
    @Autowired
    PersonaServicio personaServicio;

    @GetMapping("persona/buscarId/{id_persona}")//hay que llamar al parametro de la url igual que la variable que se declara en la signatura del método
    public ArrayList buscaId(@PathVariable int id_persona){
        System.out.println("La id recogida en la URL es esta: "+id_persona);
        ArrayList usuarios = new ArrayList();
        Optional<Persona> p;
        p = personaServicio.buscarId(id_persona);
        return (ArrayList) usuarios.stream()
                .map(i -> new PersonaOutputDTO((Persona) i))
                .collect(Collectors.toList());
    }

    @GetMapping("persona/buscarNombre/{usuario}")
    public List<Persona> buscaNombre(@PathVariable String usuario){
        System.out.println("El nombre recogido en la URL es este: "+usuario);
        List<Persona> usuarios;
        usuarios = personaServicio.buscarUsuario(usuario);
        return (ArrayList) usuarios.stream()
                .map(i -> new PersonaOutputDTO((Persona) i))
                .collect(Collectors.toList());
    }
    @GetMapping("persona/showAll")
    public ArrayList mostrarTodo(){
        ArrayList usuarios = personaServicio.mostrarTodo();
        return (ArrayList) usuarios.stream()
                .map(i -> new PersonaOutputDTO((Persona) i))
                .collect(Collectors.toList());
    }

//    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("persona/addPersona")
    public void addPersona(@RequestBody PersonaInputDTO p) throws Exception {
        System.out.println(p.toString());
        personaServicio.addPersona(p);
    }

    @DeleteMapping("persona/deletePersona/{id_persona}")
    public void deletePersona(@PathVariable int id_persona){
        personaServicio.delete(id_persona);
    }

    @PutMapping("persona/updatePersona/{id_persona}")
    public void updatePersona(@PathVariable int id_persona, @RequestBody Optional<Persona> p) throws Exception {
        personaServicio.updatePersona(id_persona, p);
    }
}
