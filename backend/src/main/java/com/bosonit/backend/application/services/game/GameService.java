package com.bosonit.backend.application.services.game;

import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Player.Player;
import org.springframework.data.util.Pair;

import java.util.Optional;

public interface GameService {
    GameOutput crearJuego(PlayerInput playerInput);
    Player checkWinner(int idGame);
    GameOutput getGame(int idGame);
    Iterable<GameOutput> getAllGames(int pageNumber, int pageSize);
    void deleteGameById(String idGame);
    Pair<Player, Optional<Integer>> joinGame(int idGame, int idPlayer) throws Exception;
}
