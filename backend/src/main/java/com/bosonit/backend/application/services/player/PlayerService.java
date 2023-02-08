package com.bosonit.backend.application.services.player;

import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;

public interface PlayerService {
    PlayerOutput addJugador(PlayerInput playerInput);
    PlayerOutput getJugador(int idJugador);
    Iterable<PlayerOutput> getAllJugadores(int pageNumber, int pageSize);
    PlayerOutput updateJugador(int idJugador, PlayerInput playerInput);
    void deleteJugadorById(int idJugador);
}
