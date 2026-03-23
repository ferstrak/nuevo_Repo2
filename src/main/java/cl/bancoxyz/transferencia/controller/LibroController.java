package cl.bancoxyz.transferencia.controller;
import cl.bancoxyz.transferencia.model.Libro;
import cl.bancoxyz.transferencia.repository.libroRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

java.util.List; 
@RestController
@RequestMapping("/libros")

public class LibroController {
    @Autowired
    private libroRepository libroRepository;

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroRepository.obtenerLibros();
    }

    @GetMapping("/{id}")
    public Libro buscarporId(@PathVariable int id) {
        return libroRepository.buscarporId(id);
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarporIsbn(@PathVariable String isbn) {
        return libroRepository.buscarporIsbn(isbn);
    }

    @PostMapping
    public Libro guardar(@RequestBody Libro lib) {
        return libroRepository.guardar(lib);
    }

    @PutMapping
    public Libro actualizar(@RequestBody Libro lib) {
        return libroRepository.actualizar(lib);
    }
    @DeleteMapping
    public void eliminar(@RequestBody Libro lib) {
        libroRepository.obtenerLibros().remove(lib);
    }
}
