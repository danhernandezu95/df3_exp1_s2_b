package cl.duoc.app3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.duoc.app3.dto.PublicacionRequest;
import cl.duoc.app3.dto.PublicacionResponse;
import cl.duoc.app3.services.PublicacionService;
import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/foro/publicacion")
public class PublicacionController {

    @Autowired 
    PublicacionService publicacionService;

    public PublicacionController() {}

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("prueba");
        return ResponseEntity.ok("prueba");
    }

    @GetMapping
    public ResponseEntity<List<PublicacionResponse>> getPublicacions() {
        return ResponseEntity.ok(publicacionService.getAllPublicacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionResponse> getPublicacionById (@PathVariable Long id) {
        return ResponseEntity.ok(publicacionService.getPublicacionById(id));
    }

    @PostMapping
    public ResponseEntity<PublicacionResponse> createPublicacion (@Valid @RequestBody PublicacionRequest publicacion) {
        return ResponseEntity.ok(publicacionService.createPublicacion(publicacion));
    }

    @PutMapping
    public ResponseEntity<PublicacionResponse> updatePublicacion (@Valid @RequestBody PublicacionRequest publicacion) {
        return ResponseEntity.ok(publicacionService.updatePublicacion(publicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublicacion (@PathVariable Long id) {
        return ResponseEntity.ok(publicacionService.deletePublicacion(id));
    }
    
}