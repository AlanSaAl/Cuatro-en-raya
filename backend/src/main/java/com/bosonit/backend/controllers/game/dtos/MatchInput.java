package com.bosonit.backend.controllers.game.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchInput {
    int idGame;
    int idPlayerOne;
    int idPlayerTwo;
    int idWinner;
}
