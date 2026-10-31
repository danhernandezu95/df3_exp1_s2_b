package cl.duoc.app3.services;

import java.util.List;

import cl.duoc.app3.dto.PublicacionRequest;
import cl.duoc.app3.dto.PublicacionResponse;

public interface PublicacionService {
    List<PublicacionResponse> getAllPublicacion();
    PublicacionResponse getPublicacionById(Long id);
    PublicacionResponse createPublicacion(PublicacionRequest nuevo);
    PublicacionResponse updatePublicacion(PublicacionRequest nuevo);
    boolean deletePublicacion(Long publicacionId);
}