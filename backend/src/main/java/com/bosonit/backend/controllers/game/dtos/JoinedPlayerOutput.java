package com.bosonit.backend.controllers.game.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class JoinedPlayerOutput {
    private int idPlayer;

    private String playerName;
}
