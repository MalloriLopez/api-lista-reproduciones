package com.quipux.listas_reproduccion_api.global;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExcepcionSolicitudIncorrecta extends RuntimeException {
    public ExcepcionSolicitudIncorrecta(String mensaje) {
        super(mensaje);
    }
}

