package cl.duoc.app3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="COMENTARIO")
@NoArgsConstructor 
@AllArgsConstructor 
public class ComentarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_gen")
    @SequenceGenerator(
        name = "comentario_gen", 
        sequenceName = "SEQ_COMENTARIO_ID", 
        allocationSize = 1
    )
    @Column(name ="ID_COMENTARIO")
    Long id;

    @Column(name ="USERNAME")
    String username;

    @Column(name ="CONTENIDO")
    String contenido;

    @ManyToOne
    @JoinColumn(name ="PUBLICACION_FK", nullable = false)
    PublicacionEntity publicacion;
}
