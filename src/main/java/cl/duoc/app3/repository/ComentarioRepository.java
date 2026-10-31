package cl.duoc.app3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.app3.model.ComentarioEntity;

public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Long> {
    
}