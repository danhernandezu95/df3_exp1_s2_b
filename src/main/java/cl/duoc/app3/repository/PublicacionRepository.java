package cl.duoc.app3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.app3.model.PublicacionEntity;

public interface PublicacionRepository extends JpaRepository<PublicacionEntity, Long> {
    
}