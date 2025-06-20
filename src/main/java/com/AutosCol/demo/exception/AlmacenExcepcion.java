package com.AutosCol.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class AlmacenExcepcion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlmacenExcepcion(String mensaje) {
        super(mensaje);
    }

    public AlmacenExcepcion(String mensaje, Throwable excepcion) {
        super(mensaje, excepcion);

        
    }
}
