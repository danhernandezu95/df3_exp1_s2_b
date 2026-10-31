package cl.duoc.app3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class ComentarioRequest {

    @PositiveOrZero (message = "debe ingresar comentario id")
    Long id;

    @NotBlank (message = "debe ingresar nombre de usuario")
    String username;

    @NotBlank (message = "debe ingresar contenido de comentario")
    String contenido;

    @PositiveOrZero (message = "debe ingresar publicacion id")
    Long publicacion_id;
    
}