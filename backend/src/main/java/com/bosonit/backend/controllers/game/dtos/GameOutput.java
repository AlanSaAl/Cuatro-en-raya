package com.bosonit.backend.controllers.game.dtos;

import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameOutput {
    private int idGame;

    //private List<PlayerOutput> playersOutput;

    private int idWinner;
}
