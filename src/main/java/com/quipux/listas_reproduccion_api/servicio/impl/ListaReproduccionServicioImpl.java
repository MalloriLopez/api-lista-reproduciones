package com.quipux.listas_reproduccion_api.servicio.impl;

import com.quipux.listas_reproduccion_api.dto.ListaReproduccionDTO;
import com.quipux.listas_reproduccion_api.global.ExcepcionRecursoNoEncontrado;
import com.quipux.listas_reproduccion_api.global.ExcepcionSolicitudIncorrecta;
import com.quipux.listas_reproduccion_api.modelo.Cancion;
import com.quipux.listas_reproduccion_api.modelo.ListaReproduccion;
import com.quipux.listas_reproduccion_api.repositorio.ListaReproduccionRepositorio;
import com.quipux.listas_reproduccion_api.servicio.ListaReproduccionServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListaReproduccionServicioImpl implements ListaReproduccionServicio {

    private final ListaReproduccionRepositorio repositorio;

    @Override
    public ListaReproduccion crearLista(ListaReproduccionDTO listaDTO) {
        if (listaDTO.getNombre() == null || listaDTO.getNombre().isBlank())
            throw new ExcepcionSolicitudIncorrecta("El nombre de la lista es obligatorio.");

        ListaReproduccion lista = ListaReproduccion.builder()
                .nombre(listaDTO.getNombre())
                .descripcion(listaDTO.getDescripcion())
                .canciones(listaDTO.getCanciones().stream()
                        .map(dto -> Cancion.builder()
                                .titulo(dto.getTitulo())
                                .artista(dto.getArtista())
                                .album(dto.getAlbum())
                                .anno(dto.getAnno())
                                .genero(dto.getGenero())
                                .build())
                        .collect(Collectors.toList()))
                .build();

        return repositorio.save(lista);
    }

    @Override
    public List<ListaReproduccion> obtenerListas() {
        return repositorio.findAll();
    }

    @Override
    public ListaReproduccion obtenerListaPorNombre(String nombre) {
        return repositorio.findByNombre(nombre)
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La lista de reproducción no existe."));
    }

    @Override
    @Transactional
    public void eliminarListaPorNombre(String nombre) {
        if (!repositorio.existsByNombre(nombre)) {
            throw new ExcepcionRecursoNoEncontrado("La lista de reproducción no existe.");
        }
        repositorio.deleteByNombre(nombre);
    }


    }

