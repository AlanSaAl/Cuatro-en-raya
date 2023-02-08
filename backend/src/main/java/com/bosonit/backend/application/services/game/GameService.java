package com.bosonit.backend.application.services.game;


import com.bosonit.backend.controllers.game.dtos.GameInput;
import com.bosonit.backend.controllers.game.dtos.GameOutput;

public interface GameService {
    GameOutput getGame(int idGame);
    Iterable<GameOutput> getAllGames(int pageNumber, int pageSize);
    void deleteGameById(int idGame);
    
}
