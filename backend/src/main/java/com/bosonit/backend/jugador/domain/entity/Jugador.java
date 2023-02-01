package com.bosonit.backend.jugador.domain.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue
    private int idJugador;
    private String name;
    private String password;

}
