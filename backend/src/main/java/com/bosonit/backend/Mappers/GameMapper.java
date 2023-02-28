package com.bosonit.backend.Mappers;

import com.bosonit.backend.controllers.game.dtos.GameInput;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.domain.entities.Game.Game;
import org.mapstruct.factory.Mappers;

public interface GameMapper {
    GameMapper gMapper = Mappers.getMapper(GameMapper.class);

    Game gameInputToGame(GameInput gameInput);
    GameOutput gameToGameOutput(Game game);
}
