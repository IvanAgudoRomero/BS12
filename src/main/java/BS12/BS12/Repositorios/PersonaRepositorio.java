package BS12.BS12.Repositorios;

import BS12.BS12.POJOs.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {  //si el id es un int y yo pongo string pues evidentemente no funciona. Solucion: poner int o Integer
    //public ArrayList<Persona> findById(int id_persona);//poner mismo nombre que en el POJO
    public List<Persona> findByUsuario(String user);
    //el nombre del atributo puede ser el que sea pero el del nombre del metodo ha de coincidir con el campo del pojo, es decir, findBy{nombre del campo}
    //public void deleteById(int id_persona);

}
