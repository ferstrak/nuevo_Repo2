package cl.bancoxyz.transferencia.service;
import cl.bancoxyz.transferencia.model.Libro;
import cl.bancoxyz.transferencia.repository.libroRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private libroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro lib) {
        return libroRepository.guardar(lib);
    }

    public Libro updateLibro(Libro lib) {
        return libroRepository.actualizar(lib);
    }
    public String deleteLibro(Libro lib) {
        libroRepository.obtenerLibros().remove(lib);
        return "Libro eliminado";
    }
    public Libro getLibroId(int id) {
        return libroRepository.buscarporId(id);
    }
}
