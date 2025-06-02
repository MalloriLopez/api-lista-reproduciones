package com.quipux.listas_reproduccion_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListaReproduccionDTO {
    private String nombre;
    private String descripcion;
    private List<CancionDTO> canciones;
}
