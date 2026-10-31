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

import cl.duoc.app3.dto.ComentarioRequest;
import cl.duoc.app3.dto.ComentarioResponse;
import cl.duoc.app3.services.ComentarioService;
import jakarta.validation.Valid;

@Controller 
@RequestMapping ("/foro/comentario")
public class ComentarioController {

    @Autowired 
    ComentarioService comentarioService;

    public ComentarioController() {}

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("prueba");
        return ResponseEntity.ok("prueba");
    }

    @GetMapping
    public ResponseEntity<List<ComentarioResponse>> getComentarios() {
        return ResponseEntity.ok(comentarioService.getAllComentario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioResponse> getComentarioById (@PathVariable Long id) {
        return ResponseEntity.ok(comentarioService.getComentarioById(id));
    }

    @PostMapping
    public ResponseEntity<ComentarioResponse> createComentario (@Valid @RequestBody ComentarioRequest comentario) {
        return ResponseEntity.ok(comentarioService.createComentario(comentario));
    }

    @PutMapping
    public ResponseEntity<ComentarioResponse> updateComentario (@Valid @RequestBody ComentarioRequest comentario) {
        return ResponseEntity.ok(comentarioService.updateComentario(comentario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComentario (@PathVariable Long id) {
        return ResponseEntity.ok(comentarioService.deleteComentario(id));
    }
    
}