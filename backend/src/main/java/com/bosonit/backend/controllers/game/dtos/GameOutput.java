package com.bosonit.backend.controllers.game.dtos;

import com.bosonit.backend.domain.entities.Game.Match;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameOutput {
    int idGame;
    Match match;
}
