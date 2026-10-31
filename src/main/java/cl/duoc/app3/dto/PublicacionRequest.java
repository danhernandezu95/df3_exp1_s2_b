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
public class PublicacionRequest {

    @PositiveOrZero (message = "debe ingresar publicacion id")
    Long id;

    @NotBlank (message = "debe ingresar nombre de usuario")
    String username;

    @NotBlank (message = "debe ingresar contenido de publicacion")
    String contenido;
}