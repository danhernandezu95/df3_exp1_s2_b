package cl.duoc.app3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="PUBLICACION")
@NoArgsConstructor 
@AllArgsConstructor 
public class PublicacionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publicacion_gen")
    @SequenceGenerator(
        name = "publicacion_gen", 
        sequenceName = "SEQ_PUBLICACION_ID", 
        allocationSize = 1
    )
    @Column(name ="ID_PUBLICACION")
    Long id;

    @Column(name ="USERNAME")
    String username;

    @Column(name ="CONTENIDO")
    String contenido;
}
