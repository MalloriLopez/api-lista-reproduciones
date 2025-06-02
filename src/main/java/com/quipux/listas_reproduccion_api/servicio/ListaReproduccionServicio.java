package com.quipux.listas_reproduccion_api.servicio;

import com.quipux.listas_reproduccion_api.dto.ListaReproduccionDTO;
import com.quipux.listas_reproduccion_api.modelo.ListaReproduccion;

import java.util.List;

public interface ListaReproduccionServicio {
    ListaReproduccion crearLista(ListaReproduccionDTO lista);
    List<ListaReproduccion> obtenerListas();
    ListaReproduccion obtenerListaPorNombre(String nombre);
    void eliminarLista(String nombre);
}