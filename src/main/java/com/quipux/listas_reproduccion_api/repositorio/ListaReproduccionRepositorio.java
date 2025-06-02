package com.quipux.listas_reproduccion_api.repositorio;

import com.quipux.listas_reproduccion_api.modelo.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaReproduccionRepositorio extends JpaRepository<ListaReproduccion, Long> {
    Optional<ListaReproduccion> findByNombre(String nombre);
    void deleteByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
