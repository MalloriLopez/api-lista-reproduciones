package com.quipux.listas_reproduccion_api.controlador;

import com.quipux.listas_reproduccion_api.dto.ListaReproduccionDTO;
import com.quipux.listas_reproduccion_api.modelo.ListaReproduccion;
import com.quipux.listas_reproduccion_api.servicio.ListaReproduccionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class ListaReproduccionControlador {

    private final ListaReproduccionServicio servicio;

    @PostMapping
    public ResponseEntity<?> crearLista(@RequestBody ListaReproduccionDTO dto) {
        ListaReproduccion nuevaLista = servicio.crearLista(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLista);
    }

    @GetMapping
    public List<ListaReproduccion> obtenerListas() {
        return servicio.obtenerListas();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> obtenerListaPorNombre(@PathVariable String nombre) {
        ListaReproduccion lista = servicio.obtenerListaPorNombre(nombre);
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminarListaPorNombre(@PathVariable String nombre) {
        servicio.eliminarListaPorNombre(nombre);
        return ResponseEntity.noContent().build();
    }
}

