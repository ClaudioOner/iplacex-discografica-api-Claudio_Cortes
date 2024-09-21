package org.iplacex.proyectos.discografia.discos;

import org.iplacex.proyectos.discografia.artistas.IArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DiscoController {

    @Autowired
    private IDiscoRepository discoRepository;

    @SuppressWarnings("unused")
    @Autowired
    private IArtistaRepository artistaRepository;

   
    @PostMapping(value = "/disco", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Disco> handlePostDiscoRequest(@RequestBody Disco disco) {
        Disco savedDisco = discoRepository.save(disco);
        return new ResponseEntity<>(savedDisco, HttpStatus.CREATED);
    }

   
    @GetMapping(value = "/discos", produces = "application/json")
    public ResponseEntity<List<Disco>> handleGetDiscosRequest() {
        List<Disco> discos = discoRepository.findAll();
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }

 
    @GetMapping(value = "/disco/{id}", produces = "application/json")
    public ResponseEntity<Disco> handleGetDiscoRequest(@PathVariable String id) {
        Optional<Disco> disco = discoRepository.findById(id);
        return disco.map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   
    @GetMapping(value = "/artista/{id}/discos", produces = "application/json")
    public ResponseEntity<List<Disco>> handleGetDiscosByArtistaRequest(@PathVariable String id) {
        List<Disco> discos = discoRepository.findDiscosByIdArtista(id);
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }
}
