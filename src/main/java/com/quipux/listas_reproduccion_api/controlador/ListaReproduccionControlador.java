package com.quipux.listas_reproduccion_api.controlador;

import com.quipux.listas_reproduccion_api.dto.ListaReproduccionDTO;
import com.quipux.listas_reproduccion_api.modelo.ListaReproduccion;
import com.quipux.listas_reproduccion_api.servicio.ListaReproduccionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

