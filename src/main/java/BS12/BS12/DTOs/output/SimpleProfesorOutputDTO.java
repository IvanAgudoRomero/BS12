package BS12.BS12.DTOs.output;

import BS12.BS12.POJOs.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleProfesorOutputDTO {
    private Integer id_profesor;
    private String coments;
    private String branch;
    private ProfesorOutputDTO profesor;

    public SimpleProfesorOutputDTO(Profesor profesor){
        this.coments = profesor.getComents();
        this.branch = profesor.getBranch();
    }
}
