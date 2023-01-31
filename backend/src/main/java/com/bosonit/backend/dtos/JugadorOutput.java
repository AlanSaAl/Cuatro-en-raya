package com.bosonit.backend.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JugadorOutput {
    private int idJugador;
    private String name;
    private String password;
}
