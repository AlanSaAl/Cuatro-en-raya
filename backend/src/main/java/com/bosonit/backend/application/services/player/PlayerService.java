package com.bosonit.backend.application.services.player;

import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;

public interface PlayerService {
    PlayerOutput addPlayer(PlayerInput playerInput);
    PlayerOutput getPlayer(int idJugador);
    Iterable<PlayerOutput> getAllPlayers(int pageNumber, int pageSize);
    PlayerOutput updatePlayer(int idJugador, PlayerInput playerInput);
    void deletePlayerById(int idJugador);
    PlayerOutput getPlayerByCredentias(PlayerInput playerInput);
}
