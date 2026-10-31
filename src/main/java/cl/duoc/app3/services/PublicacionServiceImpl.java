package cl.duoc.app3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.app3.dto.PublicacionRequest;
import cl.duoc.app3.dto.PublicacionResponse;
import cl.duoc.app3.model.PublicacionEntity;
import cl.duoc.app3.repository.PublicacionRepository;

@Service 
public class PublicacionServiceImpl implements PublicacionService {
    @Autowired 
    PublicacionRepository publicacionRepository;

    @Override 
    public List<PublicacionResponse> getAllPublicacion() {
        return publicacionRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override 
    public PublicacionResponse getPublicacionById(Long id) {
        return publicacionRepository.findById(id).map(this::toDTO).get();
    }

    @Override 
    public PublicacionResponse createPublicacion (PublicacionRequest nuevo) {
        PublicacionEntity publicacion = toEntity(nuevo);
        publicacion.setId(null);
        return toDTO(publicacionRepository.saveAndFlush(publicacion));
    }

    @Override 
    public PublicacionResponse updatePublicacion(PublicacionRequest nuevo) {
        return toDTO(publicacionRepository.saveAndFlush(toEntity(nuevo)));
    }

    @Override 
    public boolean deletePublicacion(Long id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
            return true;
        }
        
        return false;
    }

    PublicacionResponse toDTO(PublicacionEntity publicacion) {
        return new PublicacionResponse (publicacion.getId(), publicacion.getUsername(), publicacion.getContenido());
    }

    PublicacionEntity toEntity(PublicacionRequest Publicacion) {
        return new PublicacionEntity(Publicacion.getId(), Publicacion.getUsername(), Publicacion.getContenido());
    }
}