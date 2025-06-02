package com.quipux.listas_reproduccion_api.dto;

import lombok.Data;

@Data
public class CancionDTO {
    private String titulo;
    private String artista;
    private String album;
    private String anno;
    private String genero;
}
