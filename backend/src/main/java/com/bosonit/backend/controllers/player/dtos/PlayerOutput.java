package com.bosonit.backend.controllers.player.dtos;

import com.bosonit.backend.domain.entities.Game.Game;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerOutput {
    int idPlayer;
    String user;
}
