package com.bosonit.backend.controllers.game.dtos;

import com.bosonit.backend.domain.entities.Player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class JoinGameOutput {
    private JoinedPlayerOutput joinedPlayer;

    private int firstPlayerId;

    public JoinGameOutput(Player firstPlayer, Optional<Integer> oFirstPlayerId) {
        this.joinedPlayer = new JoinedPlayerOutput(firstPlayer.getIdPlayer(), firstPlayer.getUserName());
        this.firstPlayerId = oFirstPlayerId.orElse(-1);
    }
}
