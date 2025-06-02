package com.quipux.listas_reproduccion_api.controlador;

import com.quipux.listas_reproduccion_api.dto.CancionDTO;
import com.quipux.listas_reproduccion_api.dto.ListaReproduccionDTO;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDTOBuilder {
    private String nombre = "Mi lista";
    private String descripcion = "Descripción";
    private List<CancionDTO> canciones = new ArrayList<>();

    public ListaReproduccionDTOBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ListaReproduccionDTOBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ListaReproduccionDTOBuilder conCanciones(List<CancionDTO> canciones) {
        this.canciones = canciones;
        return this;
    }

    public ListaReproduccionDTO build() {
        ListaReproduccionDTO dto = new ListaReproduccionDTO();
        dto.setNombre(nombre);
        dto.setDescripcion(descripcion);
        dto.setCanciones(canciones);
        return dto;
    }
}

