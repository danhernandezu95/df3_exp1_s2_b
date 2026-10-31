package cl.duoc.app3.services;

import java.util.List;

import cl.duoc.app3.dto.ComentarioRequest;
import cl.duoc.app3.dto.ComentarioResponse;

public interface ComentarioService {
    List<ComentarioResponse> getAllComentario();
    ComentarioResponse getComentarioById(Long id);
    ComentarioResponse createComentario(ComentarioRequest nuevo);
    ComentarioResponse updateComentario(ComentarioRequest nuevo);
    boolean deleteComentario(Long comentarioId);
}