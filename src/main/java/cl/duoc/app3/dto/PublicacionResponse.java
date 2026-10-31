package cl.duoc.app3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class PublicacionResponse {
    Long id;
    String username;
    String contenido;
}