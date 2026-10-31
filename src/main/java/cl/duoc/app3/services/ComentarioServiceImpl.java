package cl.duoc.app3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.app3.dto.ComentarioRequest;
import cl.duoc.app3.dto.ComentarioResponse;
import cl.duoc.app3.model.ComentarioEntity;
import cl.duoc.app3.repository.ComentarioRepository;
import cl.duoc.app3.repository.PublicacionRepository;

@Service 
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired 
    ComentarioRepository comentarioRepository;

    @Autowired
    PublicacionRepository publicacionRepository;

    @Override 
    public List<ComentarioResponse> getAllComentario() {
        return comentarioRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override 
    public ComentarioResponse getComentarioById(Long id) {
        return comentarioRepository.findById(id).map(this::toDTO).get();
    }

    @Override 
    public ComentarioResponse createComentario (ComentarioRequest nuevo) {
        ComentarioEntity comentario = toEntity(nuevo);
        comentario.setId(null);
        comentario.setPublicacion(publicacionRepository.findById(nuevo.getPublicacion_id()).get());
        return toDTO(comentarioRepository.saveAndFlush(comentario));
    }

    @Override 
    public ComentarioResponse updateComentario(ComentarioRequest nuevo) {
        return toDTO(comentarioRepository.saveAndFlush(toEntity(nuevo)));
    }

    @Override 
    public boolean deleteComentario(Long id) {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
            return true;
        }
        
        return false;
    }

    ComentarioResponse toDTO(ComentarioEntity Comentario) {
        return new ComentarioResponse (Comentario.getId(), Comentario.getUsername(), Comentario.getContenido(),
    Comentario.getPublicacion().getId());
    }

    ComentarioEntity toEntity(ComentarioRequest Comentario) {
        return new ComentarioEntity(Comentario.getId(), Comentario.getUsername(), Comentario.getContenido(), publicacionRepository.findById(
    Comentario.getPublicacion_id()).get());
    }
}