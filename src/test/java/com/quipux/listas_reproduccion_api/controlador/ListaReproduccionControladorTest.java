package com.quipux.listas_reproduccion_api.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quipux.listas_reproduccion_api.dto.ListaReproduccionDTO;
import com.quipux.listas_reproduccion_api.modelo.ListaReproduccion;
import com.quipux.listas_reproduccion_api.servicio.ListaReproduccionServicio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser(username = "usuarioTest", roles = {"USUARIO", "ADMIN"})
@WebMvcTest(ListaReproduccionControlador.class)
class ListaReproduccionControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListaReproduccionServicio servicio;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void crearLista_deberiaRetornar201() throws Exception {

        ListaReproduccionDTO dto = new ListaReproduccionDTO();
        dto.setNombre("Mi lista");
        dto.setDescripcion("Descripción");
        dto.setCanciones(new ArrayList<>());

        ListaReproduccion nuevaLista = new ListaReproduccion();
        nuevaLista.setId(1L);
        nuevaLista.setNombre("Mi lista");
        nuevaLista.setDescripcion("Descripción");
        nuevaLista.setCanciones(new ArrayList<>());

        Mockito.when(servicio.crearLista(any(ListaReproduccionDTO.class)))
                .thenReturn(nuevaLista);

        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("/lists")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Mi lista"))
                .andExpect(jsonPath("$.descripcion").value("Descripción"));
    }

    @Test
    void obtenerListas_deberiaRetornar200() throws Exception {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setId(1L);
        lista.setNombre("Mi lista");
        lista.setDescripcion("Descripción");
        lista.setCanciones(new ArrayList<>());

        List<ListaReproduccion> listas = List.of(lista);

        Mockito.when(servicio.obtenerListas())
                .thenReturn(listas);

        mockMvc.perform(get("/lists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Mi lista"))
                .andExpect(jsonPath("$[0].descripcion").value("Descripción"));
    }

    @Test
    void obtenerListaPorNombre_deberiaRetornar200() throws Exception {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setId(1L);
        lista.setNombre("Mi lista");
        lista.setDescripcion("Descripción");
        lista.setCanciones(new ArrayList<>());

        Mockito.when(servicio.obtenerListaPorNombre("Mi lista"))
                .thenReturn(lista);

        mockMvc.perform(get("/lists/Mi lista"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Mi lista"))
                .andExpect(jsonPath("$.descripcion").value("Descripción"));
    }

    @Test
    void eliminarListaPorNombre_deberiaRetornar204() throws Exception {
        Mockito.doNothing().when(servicio).eliminarListaPorNombre("Mi lista");
        mockMvc.perform(delete("/lists/Mi lista")
                        .with(csrf()))
                .andExpect(status().isNoContent());

    }
}
