package cl.bancoxyz.transferencia.controller;
import cl.bancoxyz.transferencia.dto.ClientRequest;
import cl.bancoxyz.transferencia.model.Libro;
import cl.bancoxyz.transferencia.repository.libroRepository;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public ResponseEntity<?> agregarLibro(@Valid @RequestBody ClientRequest request, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(libroRepository.saveLibro(LibroMapper.toModel(request)));
    }
    

    @PutMapping
    public Libro actualizar(@RequestBody Libro lib) {
        return libroRepository.actualizar(lib);
    }
    @DeleteMapping
    public void eliminar(@RequestBody Libro lib) {
        libroRepository.obtenerLibros().remove(lib);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        Libro lib = libroRepository.buscarporId(id);
        libroRepository.obtenerLibros().remove(lib);
    }
}
