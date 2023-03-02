package com.bosonit.backend.controllers.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinGameInput {
    private int idPlayer;

    private int idGame;
}
