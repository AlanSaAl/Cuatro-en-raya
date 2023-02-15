package com.bosonit.backend.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {
    Date timestamp;
    int HttpCode;
    String mensaje;

    public CustomError(Date timestamp, int httpCode, String mensaje) {
        this.timestamp = timestamp;
        HttpCode = httpCode;
        this.mensaje = mensaje;
    }
}
